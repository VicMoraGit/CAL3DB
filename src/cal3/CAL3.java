
package cal3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CAL3 {

    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = null;
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "postgres");
            Statement st = connection.createStatement();
            System.out.println("Connection established");
        
            
            
            
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.toString());
        }
    
    }
    
}
