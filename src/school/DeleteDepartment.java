package school;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class DeleteDepartment extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4;
    JButton bt1, bt2;
    JTextField tf1, tf2;
    JFrame f;
     DeleteDepartment()
    {
        f = new JFrame("Delete Department Details");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        f.setLocation(1, 1);
        
        l1=new JLabel();
        l1.setBounds(0,0,840,600);
        l1.setLayout(null);
        l1.setLocation(1, 1);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource(""));
        Image i1 = img.getImage().getScaledInstance(750, 450, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);
        
        l2=new JLabel("Delete Department Details");
        l2.setBounds(230, 50, 500, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        f.add(l1);
        
        l3=new JLabel("ID");
        l3.setBounds(150, 150, 150, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(Color.BLACK);
        l1.add(l3);
        
        
        tf1 = new JTextField();
        tf1.setFont(new Font("Arial", Font.BOLD, 20));
        tf1.setBounds(200, 150, 150, 30);
        l1.add(tf1);

        l4 = new JLabel("Department");
        l4.setBounds(460, 150, 200, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);

        tf2 = new JTextField();
        tf2.setFont(new Font("Arial", Font.BOLD, 20));
        tf2.setBounds(600, 150, 150, 30);
        l1.add(tf2);
        
        
        bt1 = new JButton("Delete");
        bt2 = new JButton("Back");

        bt1.setForeground(Color.BLACK);
        bt2.setForeground(Color.BLACK);

        bt1.setBounds(250, 300, 150, 30);
        bt2.setBounds(450, 300, 150, 30);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        l1.add(bt1);
        l1.add(bt2);

       
        f.setVisible(true);
        f.setSize(840, 600);
        f.setLocation(300, 100);
        
    
         
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bt1){
            try
            {
                int id=Integer.parseInt(tf1.getText());
                String department=tf2.getText();
                ConnectionClass obj=new ConnectionClass();
                String p = "SELECT * FROM Department WHERE id = ? AND department = ?";
                PreparedStatement Stm = obj.con.prepareStatement(p);
                Stm.setInt(1, id);
                Stm.setString(2, department);
                ResultSet r = Stm.executeQuery();
                if(r.next())
                {
                    String D = "DELETE FROM Department WHERE id = ? AND department = ?";
                    PreparedStatement deleteStmt = obj.con.prepareStatement(D);
                    deleteStmt.setInt(1, id);
                    deleteStmt.setString(2, department);
                    int delete = deleteStmt.executeUpdate();
                   if(delete >= 0){
                       JOptionPane.showMessageDialog(null, "Department details Delete successfully!");
                   }
                   else 
                    
                    {
                        JOptionPane.showMessageDialog(null, "No department found with the given ID.");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No department found with the given ID.");
                }
                f.setVisible(false);
                   
                    
                }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer for ID.");
            }
            catch (SQLException e)
            {
                JOptionPane.showMessageDialog(null, "Error updating department details.");
                e.printStackTrace();
            } 
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == bt2) 
        {
            f.dispose();
        }
    }

   // public static void main(String[] args) 
  // {
   //   new DeleteDepartment();
 //  }
}
 