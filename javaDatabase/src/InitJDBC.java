import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class InitJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String uri = "jdbc:mysql://localhost:3306/school";
        String uriParam = "?useSSL=false&characterEncoding=utf-8&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root";
        String passwd = "1647";
        Connection conn = null;

        try{
            conn = DriverManager.getConnection(uri + uriParam, user, passwd);
            System.out.println("数据库打开");

            Statement sql = conn.createStatement();
            ResultSet rs = sql.executeQuery("SELECT * FROM teachers");
            while(rs.next()) {
                System.out.print("ID: " + rs.getString(1)); // 下标从1开始
                System.out.print(", FN: " + rs.getString(2));
                System.out.println(", LN: " + rs.getString(3));
            }

            conn.close();
            System.out.println("数据库已关闭");
        } catch (SQLException e) {
            conn.close();
            System.out.println("数据库已关闭");
            System.out.println(e);
        }

    }

}
