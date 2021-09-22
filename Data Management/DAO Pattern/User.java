package DAO Pattern;
//use Hibernate as the JPA default implementation
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String name;
    private String email;
    
    // standard constructors / setters / getters
}