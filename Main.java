import com.mysql.cj.xdevapi.SqlDataResult;

import java.sql.*;

public class Main {

    static void showData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/juniv?useTimezone=true&serverTimezone=UTC";
            String userName = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, userName, password);
            if (con.isClosed()) {
                System.out.println("not connected");
            }
            else {
                System.out.println("connected");
            }

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("student_id") + " " + resultSet.getInt("registration_no") + " " + resultSet.getString(7));
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void insertData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/juniv?useTimezone=true&serverTimezone=UTC";
            String userName = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO student (student_id, registration_no, class_roll, exam_roll, name, mobile, email) values (3143, 123458, 346, 314160, 'Hemal Rahman', '01755555555', 'hahahihi@gmail.com')");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insertData();
        showData();
    }
}