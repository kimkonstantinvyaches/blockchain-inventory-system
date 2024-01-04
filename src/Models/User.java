package Models;

public class User {
    private String userId;
    private String userName;
    private String userPass;
    private String userEmail;
    private String userRole;
    public static enum UserRoles {MANAGER, STAFF, SUPPLIER};
    public static User currentUser;

    public User() {}

    public User(String userId, String userName, String userPass, String userEmail, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.userEmail = userEmail;
        this.userRole = userRole;
    }

    public User(String userName, String userPass, String userEmail, String userRole) {
        this.userName = userName;
        this.userPass = userPass;
        this.userEmail = userEmail;
        this.userRole = userRole;
    }

    public User(String userName, String userPass) {
    	this.userName = userName;
    	this.userPass = userPass;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return this.userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", userName='" + getUserName() + "'" +
            ", userPass='" + getUserPass() + "'" +
            ", userEmail='" + getUserEmail() + "'" +
            ", userRole='" + getUserRole() + "'" +
            "}";
    }
}
