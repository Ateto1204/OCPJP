package build;

class User {
    private int id;
    private String username;
    private String email;

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

interface UserDao {
    void addUser(User user);
    User getUserById(int id);
    void updateUser(User user);
    void deleteUser(int id);
}

class UserDaoImple implements UserDao {
    @Override
    public void addUser(User user) {
        System.out.println("Adding user to database: " + user.getUsername());
    }

    @Override
    public User getUserById(int id) {
        User user = new User();
        user.setId(id);
        user.setUsername("John");
        user.setEmail("john@example.com");
        return user;
    }

    @Override
    public void updateUser(User user) {
        System.out.println("Updating user in database: " + user.getUsername());
    }

    @Override
    public void deleteUser(int id) {
        System.out.println("Deleting user from database with id: " + id);
    }
}

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImple();
        
        User user = new User();
        user.setId(1);
        user.setUsername("Alice");
        user.setEmail("alice@example.com");

        userDao.addUser(user);

        User fetchUser = userDao.getUserById(1);
        System.out.println("Fetch user: " + fetchUser.getUsername());

        fetchUser.setEmail("alice_updated@example.com");
        userDao.updateUser(fetchUser);

        userDao.deleteUser(1);
    }
}
