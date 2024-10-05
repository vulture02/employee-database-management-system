
package school;

import java .sql.*;
public class ConnectionClass {
    Connection con;
    Statement Stm;
    
    ConnectionClass(){
        try
        {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Am!th@2004");
           Stm=con.createStatement();
           if(con.isClosed()){
               System.out.println("Y");
           }
           else{
               System.out.println("n");
           }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        
    }
    public static void main(String args[]){
       new ConnectionClass();
    }

    class connection {

        public connection() {
        }
    }
}

    

