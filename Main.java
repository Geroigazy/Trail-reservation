import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws ParseException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            PreparedStatement st = con.prepareStatement("select * from ticket");
            ResultSet rs = st.executeQuery();
            while (rs.next()) // there code print all flights
                System.out.println(rs.getString(5) + " " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(4) + " " + rs.getString(3));
        } catch (Exception e){
            System.out.println(e);
        }
        Scanner cin = new Scanner(System.in);

        System.out.println("**************************"); //this is menu
        System.out.println("\tWelcome to Railway\n");
        System.out.println( "1.Start app\n" +
                            "2.Contact us\n" +
                            "3.Return ticket");
        int com = cin.nextInt();
        switch (com){
            case 1:
                System.out.println("**************************");
                System.out.println("\tWelcome to Railway\n");
                System.out.println("Enter start city: "); //there customer search flight
                String start = cin.next();
                System.out.println("Enter finish city: ");
                String finish = cin.next();
                System.out.println("Enter date:(yyyy-mm-dd) ");
                String date = cin.next();
                App app = new App();
                app.printFlight(start, finish, date); // if it's available code prints it
                if(app.getId()==0) {
                    System.out.println("There no train to this flight!");
                    return;
                }
                System.out.println("Would you buy ticket?\n"+"1.Yes\t 2.No");
                int buy = cin.nextInt();
                Ticket ticket = new Ticket();
                if(buy==1) {
                    System.out.println("Choose type of wagon:\n 1.Kupe-7500tg\t 2.Simple-5000tg\t 3.Seat-3000tg\t 4.Luxe-10000tg");
                    int type = cin.nextInt();
                    if (type == 1) {
                        ticket.setPrice(7500); //there we change price of ticket due to his type
                    } else if (type == 2) {
                        ticket.setPrice(5000);
                    } else if (type == 3){
                        ticket.setPrice(3000);
                    }else if(type==4) {
                        ticket.setPrice(10000);
                    }else
                        System.out.println("Error 404");
                    System.out.println("Total cost: "+ ticket.getPrice());
                    System.out.println("1.Sign in\t 2.Registration");
                    int b = cin.nextInt();
                    if(b==1) {
                        System.out.print("Enter your phone: ");
                        String phone = cin.next();
                        System.out.print("Enter your password: ");
                        String password = cin.next();
                        app.sign(phone, password);
                    } else if(b==2)
                    app.register(ticket.getPrice()); //there customer enter his data
                    System.out.println("Would you look another flight?\n 1.Yes\t 2.No"); //there customer can buy another flight
                    int a = cin.nextInt();
                    if(a==1)
                        Main.main(args);
                    else if(a==2)
                        break;
                    else
                        System.out.println("Error 404");
                }
                else if(buy==2) {
                    System.out.println("Would you look another flight?\n 1.Yes\t 2.No");
                    int a = cin.nextInt();
                    if(a==1)
                        Main.main(args);
                    else if(a==2)
                        break;
                    else
                        System.out.println("Error 404");
                }
                else
                    System.out.println("Error 404");

                break;
            case 2:
                System.out.println("Telephone number: 44-44-44");
                System.out.println("Phone number: 87073025594"); // there contact of developer if you have some questions
                System.out.println("Email: 201221@astanait.edu.kz");
                System.out.println("Instagram: @geroigazy");
                break;
            case 3:
                App app1 = new App();
                System.out.print("Your phone number (+77006665544): ");
                String phone = cin.next();
                System.out.print("Enter your password: ");
                String password = cin.next();
                app1.display(phone,password);
                System.out.println("Would you like to return?\n 1.Yes\t 2.No"); //there we call returnTicket method
                int re = cin.nextInt();
                if(re==1) {
                    app1.returnTicket(phone, password);
                }else if(re==2)
                    System.out.println("OK. Goodbye");
                else
                    System.out.println("Error 404!!!");
                break;
            default:
                System.out.println("Error 404!!!");
        }

    }
}

