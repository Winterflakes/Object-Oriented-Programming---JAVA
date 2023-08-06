import java.lang.System.Logger.Level;
import java.sql.*;
import java.util.logging.Logger;
public class jdbc {
    public static void main(String[] args){

        Connection con = null;
        Statement s = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionUrl ="jdbc:mysql://localhost:3306/demo";
            con = DriverManager.getConnection(connectionUrl,"root","root");
            s = (Statement) con.createStatement();
            s.execute("select * from department"); // execute query in table student
            ResultSet rs = s.getResultSet(); // get any Result that came from our query

            while (rs.next()){

            System.out.println("Department_ID" + rs.getString(1) + " Enrollnment "
            +rs.getString("Department_Name"));
            
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                s.close();
                con.close();
            } 
            catch (SQLException ex) {
                Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}