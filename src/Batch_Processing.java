import java.sql.*;
import java.util.Scanner;

public class Batch_Processing {
    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(System.in);
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "911GT3RS");
            String query = "Insert into ap(name,age) values(?,?)";
            PreparedStatement p = c.prepareStatement(query);
            while (true) {
                System.out.println("enter the details: ");
                System.out.println("enter the name: ");
                String name = sc.nextLine();
                System.out.println("enter age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.println("enter more data (Y/N)");
                String choice = sc.nextLine();
                p.setString(1, name);
                p.setInt(2, age);
                p.addBatch();

                if (choice.toUpperCase().equals("N")) {
                    System.out.println("Data Inserted Successfully");
                    break;
                }


            }

            int[] arr = p.executeBatch();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    System.out.println("Query " + i + " is not executed");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
