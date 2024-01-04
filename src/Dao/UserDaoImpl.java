package Dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Models.User;
import Helper.DatabaseConnection;
import Helper.IdGenerator;

public class UserDaoImpl implements UserDao {

    DatabaseConnection dbConnect;

    Logger logger = Logger.getLogger(UserDaoImpl.class.getName());

    public UserDaoImpl() {
        dbConnect = new DatabaseConnection();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> fetchUsers = new ArrayList<User>();
        String sqlQuery = "SELECT * FROM users";
        try {
            PreparedStatement st = dbConnect.connect().prepareStatement(sqlQuery);
            ResultSet rs = st.executeQuery();
            logger.log(Level.INFO, "Fetching [users] lists from DB.");

            // Extracting data from resultset and mapping onto User object
            while (rs.next()) {
                User user = new User(rs.getString(1), // user_id
                        rs.getString(2), // user_name
                        rs.getString(3), // user_pass
                        rs.getString(4), //user_email
                        rs.getString(5) // user_role
                );
                fetchUsers.add(user);
            }
            return fetchUsers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            dbConnect.disconnect();
        }
    }

    @Override
    public User getUser(String username) {
        String sqlQuery = "SELECT * FROM users WHERE user_username = ?";
        try {
            User user = null;
            PreparedStatement st = dbConnect.connect().prepareStatement(sqlQuery);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            logger.log(Level.INFO, "Fetching [users] " + username + " from DB.");

            // Extracting data from resultset and mapping onto User object
            while (rs.next()) {
                user = new User(rs.getString(1), // user_id
                        rs.getString(2), // user_name
                        rs.getString(3), // user_pass
                        rs.getString(4), // user_email
                        rs.getString(5) // user_role
                );
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            dbConnect.disconnect();
        }
    }

    @Override
    public User getUserWithID(String userId) {
        String sqlQuery = "SELECT * FROM users WHERE user_id = ?";
        try {
            User user = null;
            PreparedStatement st = dbConnect.connect().prepareStatement(sqlQuery);
            st.setString(1, userId);
            ResultSet rs = st.executeQuery();
            logger.log(Level.INFO, "Fetching [users] " + userId + " from DB.");

            // Extracting data from resultset and mapping onto User object
            while (rs.next()) {
                user = new User(rs.getString(1), // user_id
                        rs.getString(2), // user_name
                        rs.getString(3), // user_pass
                        rs.getString(4), // user_email
                        rs.getString(5) // user_role
                );
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            dbConnect.disconnect();
        }
    }

    public String hash(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        return bytesToHex(messageDigest.digest(password.getBytes(StandardCharsets.UTF_8)));
    }

    public String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    @Override
    public boolean createUser(User user) {
        String sqlQuery = "INSERT INTO users (user_id, user_username, user_password, user_email, user_role) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            boolean duplicateResult = chkDuplicateUser(user.getUserName());
            if (!duplicateResult) {
                // resetIdCount();
                PreparedStatement st = dbConnect.connect().prepareStatement(sqlQuery);
                st.setString(1, "US" + IdGenerator.generateUUID());
                st.setString(2, user.getUserName());

                // st.setString(2, user.getUserPass());
                st.setString(3, hash(user.getUserPass()));

                st.setString(4, user.getUserEmail());
                st.setString(5, user.getUserRole());

                int row = st.executeUpdate(); // Executeupdate would return the number of rows successfully inserted
                logger.log(Level.INFO, "Insert [users] new user " + user.getUserName() + " to DB.");

                System.out.println("Affected rows: " + row);
                if (row > 0)
                    return true;
                else
                    return false;
            } else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            dbConnect.disconnect();
        }
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public boolean deleteUser(String userName) {
        String sqlQuery = "DELETE FROM users WHERE user_username = ?";
        try {
            PreparedStatement st = dbConnect.connect().prepareStatement(sqlQuery);
            st.setString(1, userName);
            int row = st.executeUpdate();

            if (row > 0)
                return true;
            else
                return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            dbConnect.disconnect();
        }
    }

    @Override
    public boolean authUser(User user) {
        // * UPGRADE: Add hashing and encryption to param before comparing db result
        String sqlQuery = "SELECT * FROM users WHERE user_username = ? AND user_password = ?";
        try {
            PreparedStatement st = dbConnect.connect().prepareStatement(sqlQuery);
            st.setString(1, user.getUserName());
            System.out.println(hash(user.getUserPass()));
            st.setString(2, hash(user.getUserPass()));
            ResultSet rs = st.executeQuery();
            logger.log(Level.INFO, "Authenticating [users] " + user.getUserName() + " credential.");

            if (rs.next())
                return true;
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            dbConnect.disconnect();
        }
    }

    // Reset auto_increment counter for user_id
    private void resetIdCount() {
        String sqlQuery = "ALTER TABLE users AUTO_INCREMENT = 1";
        try {
            PreparedStatement st = dbConnect.connect().prepareStatement(sqlQuery);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.disconnect();
        }
    }

    public boolean chkDuplicateUser(String username) {
        String sqlQuery = "SELECT * FROM users WHERE user_username = ?";
        try {
            PreparedStatement st = dbConnect.connect().prepareStatement(sqlQuery);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            logger.log(Level.INFO, "Auth duplicated username found.");

            //Return true if username exist, Return false if username is unique
            if (rs.next()) {
                return true;
            } else
                return false;

        } catch (Exception e) {
            e.printStackTrace();
            return true;
        } finally {
            dbConnect.disconnect();
        }
    }

}
