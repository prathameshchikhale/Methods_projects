package JdbcTuto;

import java.sql.*;

public class JdbcDataRetriving {
    public static void main(String[] args) {
        Connection con =null;
        Statement st = null;
        ResultSet rs= null;
        String query = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");
            query = "select * from student_info";
            if (con != null) {
                st = con.createStatement();
            }
            if (st != null) {
                rs = st.executeQuery(query);
            }
            if (rs != null) {
                while (rs.next()) {
                    System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"+"|"+rs.getString(3)+"|"+rs.getInt(4));
                }
            }
        }
            catch(SQLException sqle){
            sqle.printStackTrace();
            }
        catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(con!=null){
                    con.close();
                }
                if(st!=null){
                    st.close();
                }
            }
            catch(SQLException sqle){
                sqle.printStackTrace();
            }
        }
    }
}
