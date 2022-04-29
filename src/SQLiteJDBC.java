 import java.sql.*;

public class SQLiteJDBC {
    public static void main(String args[]) {
        connectDB();
        createDB();
        //insertDB("ABC", "123", "Teacher");
        //selectDB("ABC", "123");
        //updateDB();
        //deleteDB();
    }

    public static void connectDB() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:LangWay.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public static void createDB() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:LangWay.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS users" +
                    "(ID INTEGER PRIMARY KEY autoincrement," +
                    " userName VARCHAR NOT NULL, " +
                    " passWord VARCHAR NOT NULL, " +
                    " userType VARCHAR NOT NULL, " +
                    " date_added datetime)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public static boolean insertDB(String name, String pwd, String type) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:LangWay.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();

            String sql = "INSERT INTO users (userName,passWord,userType,date_added) " +
                    "VALUES ('" + name + "','" + pwd + "','" + type + "', datetime());";

            /*PreparedStatement stmt = c.prepareStatement(sql);

            stmt.setString(1, userName);
            stmt.setString(2, password);
            stmt.setString(3, userType);
*/

            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();

            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");

        return false;
    }

    public static boolean selectDB(String name, String pwd) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:LangWay.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE userName like '%" + name + "%' and  passWord like '%" + pwd + "%'");
            while (rs.next()) {
                int id = rs.getInt("id");
                name = rs.getString("userName");
                pwd = rs.getString("passWord");
                String type = rs.getString("userType");
                String date_added = rs.getString("date_added");
                System.out.println("ID : " + id);
                System.out.println("Name : " + name);
                System.out.println("Message : " + pwd);
                System.out.println("Date Added : " + date_added);
                System.out.println();

                return true;
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");

        return false;
    }

    public static void updateDB() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:LangWay.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "UPDATE users set passWord = 'This is updated by updateDB()' where ID=1;";
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery("SELECT * FROM users;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("userName");
                String pwd = rs.getString("passWord");
                String date_added = rs.getString("date_added");
                System.out.println("ID : " + id);
                System.out.println("Name : " + name);
                System.out.println("Message : " + pwd);
                System.out.println("Date Added : " + date_added);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public static void deleteDB() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:LangWay.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "DELETE from users where ID=1;";
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery("SELECT * FROM users;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("userName");
                String pwd = rs.getString("passWord");
                String date_added = rs.getString("date_added");
                System.out.println("ID : " + id);
                System.out.println("Name : " + name);
                System.out.println("Message : " + pwd);
                System.out.println("Date Added : " + date_added);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}