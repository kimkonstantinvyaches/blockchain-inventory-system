package db_connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Helper.DatabaseConnection;

public class MySqlStatement {
    DatabaseConnection dbconn;

    public MySqlStatement() { 
        dbconn = new DatabaseConnection(); 
    }

    public void createSql() {
        String sqlQuery = "INSERT INTO users VALUES (3, 'kok', 'kok1234')";
        try {
            Statement st = dbconn.connect().createStatement();
            st.executeUpdate(sqlQuery);
            System.out.println("Insert successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbconn.disconnect();
        }
    }

    public void updateSql() {
        String sqlQuery = "UPDATE users SET user_name = ?, user_pass = ? WHERE user_id = ?";
        try {
            PreparedStatement st = dbconn.connect().prepareStatement(sqlQuery);
            st.setString(1, "kokok");
            st.setString(2, "lim1234");
            st.setInt(3, 3);
            st.executeUpdate();
            System.out.println("Update Successful!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbconn.disconnect();
        }
    }

    public void readSql() {
        String sqlQuery = "SELECT * FROM users";
        try {
            PreparedStatement st = dbconn.connect().prepareStatement(sqlQuery);
            ResultSet rs = st.executeQuery();

            System.out.println("Id\tUsername Password");
            while (rs.next()) {
                System.out.println(rs.getString("user_id") + " \t" + rs.getString("user_name") 
                    + " \t" + rs.getString("user_pass"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbconn.disconnect();
        }
    }

    public void deleteSql() {
        String sqlQuery = "DELETE FROM users WHERE user_id = ?";
        try {
            PreparedStatement st = dbconn.connect().prepareStatement(sqlQuery);
            st.setString(1, "3");
            st.executeUpdate();
            System.out.println("Delete Successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
