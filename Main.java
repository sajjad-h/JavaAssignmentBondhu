
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.util.*;
import java.sql.*;
import java.util.Date;

class User {
    private int userId;
    private int userName;
    private int password;

    private String first;
    private String last;
    private Date birthOfDate;
    private String mobile;
    private String email;

    void showUser() {
        System.out.println(" - Name: " + first + " " + last);
        System.out.println(" - Date of Birth: " + birthOfDate.toString());
        System.out.println(" - Mobile Number: " + mobile);
        System.out.println(" - E-mail: " + email);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserName() {
        return userName;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class Page {
    static String welcomeMessage = "Welcome to bondhu app";
    static void showPage() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(welcomeMessage);
        System.out.println("------------------------------------------------------------------------------");
    }
}

class Message {
    int msgId;
    String msg;
    boolean status;
    static void printMessage (String s) {
        System.out.println(s);
    }
}

class Notification extends Message {
    static void printNotification(String s) {
        System.out.println(s);
    }
}

class LogIn extends Page {

}

class SignUp extends Page {
    static void showPage() {
        User user = new User();
        Scanner sc = new Scanner(System.in);
        String s;
        int x, y, z;
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(welcomeMessage);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Fill up the form: ");

        System.out.print(" * First Name? - ");
        s = sc.next();
        user.setFirst(s);

        System.out.print(" * Last Name? - ");
        s = sc.next();
        user.setLast(s);

        System.out.println(" * Birth of Date - ");
        System.out.print("   * Date? - ");
        x = sc.nextInt();
        System.out.print("   * Month? - ");
        y = sc.nextInt();
        System.out.print("   * Year? - ");
        z = sc.nextInt();
        Date tmp = new Date(z - 1900, y - 1, x);
        user.setBirthOfDate(tmp);

        sc.nextLine();
        System.out.print(" * Mobile Number? - ");
        s = sc.next();
        user.setMobile(s);

        sc.nextLine();

        System.out.print(" * E-mail? - ");
        s = sc.next();
        user.setEmail(s);

        System.out.println()

        user.showUser();
    }
}

class HomePage extends Page {
    static void showPage() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(welcomeMessage);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Select Option:");
        System.out.println("1. Log in");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
        int op;
        Scanner sc = new Scanner(System.in);
        op = sc.nextInt();
        if (op == 1) {
            LogIn login = new LogIn();
        }
        else if (op == 2) {
            SignUp signup = new SignUp( );
            signup.showPage();
        }
        else if (op != 3) {
            Notification.printNotification("Wrong choice! Try again. Thank you.");
        }
        else {
            Notification.printNotification("Thanks for using the application");
            return ;
        }
        showPage();
    }

}

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world!");
        HomePage page = new HomePage();
        HomePage.showPage();
    }
}