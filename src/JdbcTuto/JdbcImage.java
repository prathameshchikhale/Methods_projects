package JdbcTuto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcImage {
    public static void main(String[] args) {
        int id =0;
        String name = null;
        int age =0;
        String domain =null;
        Connection con =null;
        String picture =null;
        PreparedStatement psmt =null;
        String query = null;
        int count =0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name = ");
        name =sc.next();
        System.out.println("Enter age = ");
        age = sc.nextInt();
        System.out.println("Enter Domain = ");
        domain =sc.next();
        System.out.println("Enter Image Path = ");
        picture = sc.next();
        File f = new File(picture);
        System.out.println("The file length is = " +f.length());
        try {
            FileInputStream fis = new FileInputStream(f);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_img", "root", "");
            query = "insert into images(name, age, domain, picture) values(?,?,?,?)";
            if (con != null) {
                psmt = con.prepareStatement(query);
            }
            if (psmt != null) {
                psmt.setString(1, name);
                psmt.setInt(2, age);
                psmt.setString(3, domain);
                psmt.setBlob(4, fis);
            }
            if (psmt != null) {
                count = psmt.executeUpdate();
            }
            if (count != 0) {
                System.out.println("Record Inserted Succesfully");
            } else {
                System.out.println("Issues in Record Insertion");
            }
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
            }
        catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(con!=null){
                    con.close();
                 //   System.out.println("C:\\Users\\Prathamesh\\Downloads\\pic.jpeg");
                }
                if(psmt!=null){
                    psmt.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
