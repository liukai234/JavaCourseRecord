import com.mysql.cj.jdbc.Driver;
import java.util.Scanner;
import java.sql.*;

public class InitJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner input = new Scanner(System.in);

        String uri = "jdbc:mysql://39.97.162.48:3306/school";
        String uriParam = "?useSSL=false&characterEncoding=utf-8&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root";

        System.out.print("WAIT FOR PASSWD: ");
        String passwd = input.nextLine();

        Connect conn = new Connect(uri + uriParam, user, passwd);
        conn.connect();

        try{
            Statement sql = conn.getConn().createStatement();
            ResultSet rs = sql.executeQuery("SELECT * FROM teachers");
            while(rs.next()) {
                System.out.print("ID: " + rs.getString(1)); // 下标从1开始
                System.out.print(", LastName: " + rs.getString(2));
                System.out.print(", FirstName: " + rs.getString(3));
                System.out.print(", Address: " + rs.getString(4));
                System.out.println(", City: " + rs.getString(5));
            }

            conn.getConn().close();
            System.out.println("数据库已关闭");
        } catch (SQLException e) {
            conn.getConn().close();
            System.out.println("异常后数据库已关闭");
            System.out.println(e);
        }
    }
}
