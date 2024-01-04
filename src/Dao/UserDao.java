package Dao;
import java.util.List;
import Models.User;

public interface UserDao {
    public List<User> getAllUsers();
    public User getUser(String username);
    public User getUserWithID(String userId);
    public boolean createUser(User user);
    public void updateUser(User user);
    public boolean deleteUser(String user);
    public boolean authUser(User user);
    public boolean chkDuplicateUser(String username);
}
