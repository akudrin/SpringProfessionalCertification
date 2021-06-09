package con.akudrin.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.akudrin.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		//

		try {
			// start transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			// display students
			displayStudents(theStudents);

			// query students: lastname="Doe"
			theStudents = session.createQuery("from Student s where s.lastName='Duck'").getResultList();

			// display students
			System.out.println("\n\nStudents who have last name of Duck");
			displayStudents(theStudents);

			// query students: lastname="Duck" or firstName="Andy"
			theStudents = session.createQuery("from Student s where s.lastName='Duck' OR s.firstName='Andy'")
					.getResultList();
			// display students
			System.out.println("\n\nStudents who have last name of Duck or first name Andy");
			displayStudents(theStudents);

			// query students where email ends with "%luv2code.com"
			theStudents = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").getResultList();

			// display students
			System.out.println("\n\nStudents where email ends with '%luv2code.com'");
			displayStudents(theStudents);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
