import java.sql.*;

public class sql {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url="jdbc:mysql://127.0.0.1";
        String zhanghao="root";
        String mima="123";
        try {
            Connection connection= DriverManager.getConnection(url,zhanghao,mima);
            System.out.println(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}