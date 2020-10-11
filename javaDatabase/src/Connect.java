import com.mysql.cj.jdbc.Driver;
import java.util.Scanner;
import java.sql.*;

public class Connect {

    private String uri;
    private String user;
    private String passwd;
    private Connection conn = null;

    public Connect(String uri, String user, String passwd) {
        this.uri = uri;
        this.user = user;
        this.passwd = passwd;
    }

    public void connect () throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(uri, user, passwd);
        } catch(ClassNotFoundException e) {
            System.out.println(e);
        } catch(SQLException e) {
            System.out.println(e);
        }
    }

    public Connection getConn() {
        return conn;
    }
}
