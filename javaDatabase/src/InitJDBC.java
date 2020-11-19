import com.mysql.cj.jdbc.Driver;
import java.util.Scanner;
import java.sql.*;

public class InitJDBC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 初始化变量
        String uri = "jdbc:mysql://39.97.162.48:3306/school";
        String uriParam = "?useSSL=false&characterEncoding=utf-8&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root";

        System.out.print("WAIT FOR PASSWD: ");
        String passwd = input.nextLine();

        // 建立连接
        Connect conn = new Connect(uri + uriParam, user, passwd);
        conn.connect();

        // 执行语句
        conn.execute("UPDATE teachers SET LastName = 'Kai' WHERE FirstName = 'Liu'");
        // conn.execute("DELETE FROM teachers WHERE LastName = 'Er'");
        // conn.execute("UPDATE teachers SET LastName = 'Er' WHERE LastName = 'Qi'");

        // 关闭连接
        conn.closeConn();
    }
}
