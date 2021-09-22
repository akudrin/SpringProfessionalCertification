package DAO Pattern;

public class UserApplicationJPA {

    private static Dao<User> jpaUserDao;

    // standard constructors
    
    public static void main(String[] args) {
        User user1 = getUser(1);
        System.out.println(user1);
        updateUser(user1, new String[]{"Jake", "jake@domain.com"});
        saveUser(new User("Monica", "monica@domain.com"));
        deleteUser(getUser(2));
        getAllUsers().forEach(user -> System.out.println(user.getName()));
    }
    
    public static User getUser(long id) {
        Optional<User> user = jpaUserDao.get(id);
        
        return user.orElseGet(
          () -> new User("non-existing user", "no-email"));
    }
    
    public static List<User> getAllUsers() {
        return jpaUserDao.getAll();
    }
    
    public static void updateUser(User user, String[] params) {
        jpaUserDao.update(user, params);
    }
    
    public static void saveUser(User user) {
        jpaUserDao.save(user);
    }
    
    public static void deleteUser(User user) {
        jpaUserDao.delete(user);
    }
}