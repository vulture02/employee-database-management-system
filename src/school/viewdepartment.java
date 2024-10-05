
package school;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;


public class viewdepartment extends JFrame
{
    String x[]={"ID","DEPARTMENT"};
    String y[][]=new String[50][2];
    int i=0,j=0;
    JTable t;
    Font f;
    viewdepartment()
    {
        super("deparment details");
        setSize(1000,500);
        setLocation(1,1);
        f=new Font("Arial",Font.BOLD,15);
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="select * from department";
            ResultSet rest=obj.Stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString("id");
                y[i][j++]=rest.getString("department");
                i++;
                j=0;
                        
            }
            t=new JTable(y,x);
            t.setFont(f);
            t.setBackground(Color.BLACK);
            t.setForeground(Color.WHITE);
            JScrollPane sp=new JScrollPane(t);
            add(sp);
        }
        catch (Exception ex) {
                ex.printStackTrace();
            }
    }
  // public static void main(String [] args)
 //  {
  //    new viewdepartment().setVisible(true);
  //}
    
}
