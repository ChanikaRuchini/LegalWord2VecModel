import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vindula Jayawaradana
 */
public class DBConnection {

    private Connection connection;
    private static DBConnection dBConnection;
    private static String host = "jdbc:mysql://127.0.0.1:3306/oblie";
    private static String uname = "root";
    private static String pword = "";
    public DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(host, uname, pword);
    }

    public static String getUser() {
        return host;
    }

    public static String getPassword() {

        return pword;
    }

    public Connection getConnectionToDB() {
        return connection;
    }

    public static DBConnection getDBConnection() throws ClassNotFoundException, SQLException {
        if (dBConnection == null) {
            try {
                dBConnection = new DBConnection();
            }
            catch (Exception e){
                System.out.println( e.getMessage());
            }
        }

        return dBConnection;
    }



}
