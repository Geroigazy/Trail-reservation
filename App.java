import java.sql.*;
import java.util.Scanner;

public class App {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void printFlight(String start, String finish, String date) { //this method needs to looking for flights with  (start city, finish city and date)
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234"); // there i connect DBMS
            st = con.prepareStatement("select * from ticket where ticket.date like '%" + date + "%' AND ticket.start like '%"
                                        + start.toUpperCase() + "%' AND ticket.finish like '%" + finish.toUpperCase() + "%'"); //this is sql query to looking for flights
            rs = st.executeQuery();
            System.out.println("****************************************          Results          *****************************************");
            System.out.println("ID\tStart\t\t\t\t\t\t\t\tFinish\t\t\t\t\t\t\t\tDate\t\t\t\t\tPrice");
            while (rs.next()) { // there prints result of searching
                System.out.println(rs.getInt(5) + "\t" + rs.getString(1) + "\t"
                        + rs.getString(2) + "\t" + rs.getString(4) + "\t" + rs.getString(3));
                setId(rs.getInt(5));
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void register(int price) { //this method needs to save data about customer
        Scanner cin = new Scanner(System.in);
        Customer cus = new Customer();
        Validator v = new Validator(); // we create obj validator to check age, password number of customer
        System.out.print("Your name: ");
        String name = cin.next();
        cus.setName(name);
        System.out.print("Your lastname: ");
        String lname = cin.next();
        cus.setLastName(lname);
        System.out.print("Your age: ");
        int age = cin.nextInt();
        v.checkAge(age);
        if(v.checkAge(age))
            cus.setAge(age);
        else {
            System.out.println("You can't buy ticket, you  are not 16");
            return;
        }

        boolean t=true;
        while (t) {
            System.out.print("Your phone number: (+77006665544) ");
            String tel = cin.next();
            if (v.checkNum(tel)) {
                t=false;
                cus.setTel(tel);
            }
            else
                System.out.println("Incorrect data");
        }
        boolean p = true;
        while (p) {
            System.out.print("Enter password: ");
            String pass = cin.next();
            if (v.checkPassword(pass)) {
                cus.setPassword(pass);
                p=false;
            }
            else
                System.out.print("Password must to contain at least 1 uppercase letter, 1 lowercase letter, 1 digit," +
                        " 1 special symbol(@,$,!,^) and length more or equal to 8.");
        }
            try {
                Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
                PreparedStatement st = con.prepareStatement("insert into customers(name, lname, password, age, phone, ticket, price)values (?,?,?,?,?,?,?)"); //there i insert data to DBMS with PrepareStatement
                st.setString(1,cus.getName());
                st.setString(2,cus.getLastName());
                st.setString(3,cus.getPassword());
                st.setInt(4,cus.getAge());
                st.setString(5,cus.getTel());
                st.setInt(6, getId());
                st.setInt(7,price);
                st.executeUpdate();
                st.close();
                System.out.println("Successfully added");
            } catch (Exception e){
                System.out.println(e);
            }
    }

    public void display(String phone, String password) { //this method needs for display customers data and his ticket id
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            st = con.prepareStatement("select * from customers where phone like '%" + phone + "%' AND password like '%" + password + "%'"); //there we search from DBMS customers account with his phone and password
            rs = st.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
                        + rs.getString(3) + "\t" + rs.getString(5) + "\t" +
                        rs.getString(6) + "\t" + rs.getString(4) + "\t" + rs.getString(7));
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void returnTicket(String phone, String password) { //with this method we can return our ticket
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            st = con.prepareStatement("update customers set ticket = 0 where phone like '%" + phone + "%' AND password like '%" + password + "%'");
            st.executeUpdate();
            System.out.println("Successfully returned");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
