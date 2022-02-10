package JdbcTuto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDataInsertion {
    public static void main(String[] args) {
        Scanner sc = null;
        String name = null;
        int marks = 0;
        String sirname = null;
        int roll = 0;
        Connection con = null;
        Statement st = null;
        String query = null;
        int count = 0;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter student roll no = ");
            roll = sc.nextInt();
            System.out.println("Enter Student name = ");
            name = sc.next();
            System.out.println("Enter Student Sirname = ");
            sirname = sc.next();
            System.out.println("Enter Student marks = ");
            marks = sc.nextInt();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");
            query = "insert into student_info(roll,name,sirname,marks)" + "values('" + roll + "','" + name + "','" + sirname + "','" + marks + "')";
            if (con != null)
                st = con.createStatement();
            if (st != null)
                count = st.executeUpdate(query);
            if (count != 0) {
                System.out.println("Record Inserted Successfully");
            } else {
                System.out.println("Error while updating records");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(st!=null){
                    st.close();
                }
                if(con!=null){
                    con.close();
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
