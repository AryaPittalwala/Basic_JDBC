import java.sql.*;
import java.util.Scanner;

public class Dynamic_inputs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "911GT3RS");
            String query;
            while (true) {
                System.out.println("enter 1 to insert data");
                System.out.println("enter 2 to update data");
                System.out.println("enter 3 to delete data");
                System.out.println("enter 4 to view data");
                System.out.println("enter 5 to exit");
                int value = sc.nextInt();
                sc.nextLine();
                switch (value) {

                    case 1:
                        query = "insert into ap(name,age) values(?,?)";

                        System.out.println("enter name to insert in db");
                        String name = sc.nextLine();
                        System.out.println("enter age to insert in db");
                        int age = sc.nextInt();
                        PreparedStatement p = c.prepareStatement(query);
                        p.setString(1, name);
                        p.setInt(2, age);
                        p.executeUpdate();
                        System.out.println("DATA INSERTED....");
                        break;


                    case 2:

                        query = "update ap set name=? ,age =? where id=?";
                        System.out.println("enter id of user where you want to update data");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("enter new name:");
                        String new_name = sc.nextLine();
                        System.out.println("enter new age");
                        String new_age = sc.nextLine();

                        PreparedStatement p1 = c.prepareStatement(query);
                        p1.setInt(3, id);
                        p1.setString(1, new_name);
                        p1.setString(2, new_age);
                        int update = p1.executeUpdate();
                        System.out.println("ROWS UPDATED: " + update);
                        System.out.println("press 4 to see data");
                        break;
                    case 3:
                        query = "delete from ap where id=?";
                        System.out.println("enter the id of user that you want to delete");
                        int d_id = sc.nextInt();
                        PreparedStatement p2 = c.prepareStatement(query);
                        p2.setInt(1, d_id);
                        int delete = p2.executeUpdate();
                        System.out.println("ROWS DELETED: " + delete);
                        System.out.println("press 4 to see data");
                        break;

                    case 4:
                        query = "select * from ap";
                        Statement s = c.createStatement();
                        ResultSet r1 = s.executeQuery(query);
                        System.out.println("the data is as follows: ");
                        while (r1.next()) {
                            int s_id = r1.getInt(1);
                            String s_name = r1.getString(2);
                            int s_age = r1.getInt(3);

                            System.out.println(s_id + "  " + s_name + "  " + s_age);

                        }
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("INVALID INPUT");
                }
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
