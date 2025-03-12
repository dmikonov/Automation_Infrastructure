package utilities;

import java.sql.DriverManager;

public class ManageDB extends CommonOps {

    public static void openConnection(String dbURL) {
        try {
            //.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(dbURL);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error occurred while Connecting to DB, See details: " + e);
        }
    }

    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error occurred while Closing DB, See details: " + e);
        }
    }
}
