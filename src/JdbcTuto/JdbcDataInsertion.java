package JdbcTuto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDataInsertion {
    public static void main(String[] args) {
        int roll = 0;
        int marks = 0;
        String name = null;
        String sirname = null;
        Connection con = null;
        Statement st = null;
        int count = 0;
        String query = null;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter student roll no = ");
            roll = sc.nextInt();
            System.out.println("Enter student name = ");
            name = sc.next();
            System.out.println("Enter student sirname = ");
            sirname = sc.next();
            System.out.println("Enter student marks = ");
            marks = sc.nextInt();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");
            query = "insert into student_info(roll,name,sirname,marks)" + "values('" + roll + "','" + name + "','" + sirname + "','" + marks + "')";
            if (con != null) {
                st = con.createStatement();
            }
            if (st != null) {
                count = st.executeUpdate(query);
            }
            if (count != 0) {
                System.out.println("Record inserted successfully");
            } else {
                System.out.println("Record not inserted");
            }
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {


            try {
                if (con != null)
                    con.close();

                if (st != null) {
                    st.close();
                }
            }
             catch(SQLException sqle){
                sqle.printStackTrace();
            }
        }
    }
}
