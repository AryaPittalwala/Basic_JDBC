import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Basic_jdbc {
    public static void main(String[] args) {
        try {
           // Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","911GT3RS");
//            String query = "select* from ap";
//            Statement st = c.createStatement();
//            ResultSet r = st.executeQuery(query);
//            while (r.next()){
//                int age =r.getInt(2);
//                String name =r.getString(1);
//                System.out.println(name+" "+age);
//            }


            //for update
//            String query ="update ap set name='aryoo' where age=19 ";
//            Statement st = c.createStatement();
//            int update = st.executeUpdate(query);
//            System.out.println("ROWS UPDATED: "+update);


//            //for delete
//            String query="delete from ap where name='aryoo'";
//            Statement s = c.createStatement();
//            int delete = s.executeUpdate(query);
//            System.out.println("ROWS DELETED: "+delete);


            //for insert
            //for delete
//            String query="insert into ap(name,age) values('arya',20)";
//            Statement s = c.createStatement();
//            int delete = s.executeUpdate(query);
//            System.out.println("ROWS inserted: "+delete);


        } catch (Exception e) {
            e.getMessage();
        }
    }
    }
