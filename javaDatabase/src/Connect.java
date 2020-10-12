import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.result.SqlDateValueFactory;

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

    // 连接
    public void connect () {
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
    public void closeConn() {
        try {
            conn.close();
            System.out.println("Database has Disconnected");
        } catch (SQLException e) {
            System.out.println("e");
        }
    }
    // 输出全部
    public void printAll(String table) {
        try {
            String stringQuery = "SELECT * FROM " + table;
            PreparedStatement sql = conn.prepareStatement(stringQuery);

            ResultSet rs = sql.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "    ");
                if (i == columnCount) System.out.println();
            }

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "    "); // 下标从1开始
                    if (i == columnCount) System.out.println();
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // 事务执行语句
    public void commit(String ... args) {
        try {
            // 使用事务即一个事务中有多个sql语句但必须执行commit操作才会执行所有更改
            conn.setAutoCommit(false); // 关闭自动提交 为true时打开自动提交
            for (String sqlUpdateStr : args) {
                PreparedStatement sql = conn.prepareStatement(sqlUpdateStr);
                sql.executeUpdate();
            }

            conn.commit(); // 直到commit才会提交
            conn.setAutoCommit(true); // 恢复自动提交
        } catch (SQLException e) {
            System.out.println("e");
        }
    }

    // 普通执行语句
    public void execute(String ... args) {
        try {
            for (String sqlUpdateStr : args) {
                PreparedStatement sql = conn.prepareStatement(sqlUpdateStr);
                sql.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("e");
        }
    }
}
