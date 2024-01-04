package Controller;

import java.util.List;

import Dao.UserDao;
import Dao.UserDaoImpl;
import Models.User;

public class UserController {
    UserDao userDao = new UserDaoImpl();

    //! TODO: Remeber to convert all the return methods accordingly
    
    public User getUserDataWithID(String userId) {
        User user  = userDao.getUserWithID(userId);
        if (userId == null) {
        	return null;
        } else {
        	if (user != null)  
                return user;
            else
                return null;
        }
    }

    public User getUserData(String userName) {
        User user  = userDao.getUser(userName);
        if (userName == null) {
        	return null;
        } else {
        	if (user != null)  
                return user;
            else
                return null;
        }
    }

    public List<User> getAllUserData() {
    	return userDao.getAllUsers();
    }

    public User authUser(User user) {
        boolean authResult = userDao.authUser(user);
        if (authResult) {
            User authUser = userDao.getUser(user.getUserName());
        	System.out.println("Correct Credential");
        	return authUser;
        }
        else {
        	System.out.println("Incorrect Credential");
        	return null;
        }
    }

    public void createNewUser(String userName, String userPass, String userEmail, String userRole) {
        boolean insertResult = userDao.createUser(new User(userName, userPass, userEmail, userRole));
        if (insertResult)
            System.out.println("Inserted successfully!");
        else
            System.out.println("Inserted failed");
    }

    public void deleteUser(String userName) {
        boolean deleteResult = userDao.deleteUser(userName);
        if (deleteResult)
            System.out.println("User: " + userName + " deleted successfully!");
        else
            System.out.println("User: " + userName + " Failed to delete!");
    }

    public boolean chkDuplicateUser(String userName) {
    	return userDao.chkDuplicateUser(userName);
    }

}
