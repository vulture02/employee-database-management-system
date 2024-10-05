package school;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Adddepartmentdetails extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4;
    JButton bt1, bt2;
    JTextField tf1, tf2;
    JFrame f;

    Adddepartmentdetails() {
        f = new JFrame("Add department details");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0,0,840,600);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource(""));
        Image i1 = img.getImage().getScaledInstance(750, 450, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);

        l2 = new JLabel("Add Department details");
        l2.setBounds(230,50,500,50);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
      //  f.add(l1);

        l3 = new JLabel("ID");
        l3.setBounds(150,150,150,30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(Color.BLACK);
        l1.add(l3);

        tf1 = new JTextField();
        tf1.setFont(new Font("Arial", Font.BOLD, 20));
        tf1.setBounds(200,150,150,30);
        l1.add(tf1);

        l4 = new JLabel("Department");
        l4.setBounds(460,150,200,30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);

        tf2 = new JTextField();
        tf2.setFont(new Font("Arial", Font.BOLD, 20));
        tf2.setBounds(600,150,150,30); 
        l1.add(tf2);

        bt1 = new JButton("Save");
        bt2 = new JButton("Back");

        bt1.setForeground(Color.BLACK);
        bt2.setForeground(Color.BLACK);

        bt1.setBounds(250,300,150,30);
        bt2.setBounds(450,300,150,30);

        bt1.addActionListener(this); 
        bt2.addActionListener(this);

        l1.add(bt1);
        l1.add(bt2);

        f.add(l1);
        f.setVisible(true);
        f.setSize(840, 600);
        f.setLocation(300,100);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bt1) {
            try {
                int id = Integer.parseInt(tf1.getText());
                String department = tf2.getText();
              
                ConnectionClass obj = new ConnectionClass();
                String q = "INSERT INTO Department (id, department) VALUES (" + id + ", '" + department + "')";
                obj.Stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Department details saved successfully!");
                f.setVisible(false);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer for ID.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error saving department details.");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == bt2) {
            f.dispose();
        }
    }

    //public static void main(String[] args) {
     //   new Adddepartmentdetails();
   // }
}
