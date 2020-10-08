import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InitJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String uri = "jdbc:mysql://localhost:3306/School";
        String uriParam = "?useSSL=false&characterEncoding=utf-8&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root";
        String passwd = "1647";

        try{
            Connection conn = DriverManager.getConnection(uri + uriParam, user, passwd);
            System.out.println("数据库打开");
            conn.close();
            System.out.println("数据库已关闭");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
