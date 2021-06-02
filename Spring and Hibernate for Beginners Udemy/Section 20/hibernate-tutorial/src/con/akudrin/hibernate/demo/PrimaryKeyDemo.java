package con.akudrin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.akudrin.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		//

		try {
			// use the session object to save Java object

			// create 3 student objectc
			System.out.println("Creating new student object...");
			Student tempStudent1 = new Student("Andy", "Ball", "dream@love.com");
			Student tempStudent2 = new Student("Don", "Carnilo", "fear@love.com");
			Student tempStudent3 = new Student("Sector", "Brit", "sent@love.com");
			// start transaction
			session.beginTransaction();
			// save the student object
			System.out.println("Saving the student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
