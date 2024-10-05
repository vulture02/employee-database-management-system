package school;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JButton bt1, bt2;
    JTextField tf1, tf2, tf3, tf4;
    JFrame f;

    UpdateEmployee() {
        f = new JFrame("Update Employee Details");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 840, 600); 
        l1.setLayout(null);

      
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource(""));
        Image i1 = img.getImage().getScaledInstance(840, 600, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);

        
        l2 = new JLabel("Update Employee Details");
        l2.setBounds(230, 50, 500, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setForeground(Color.BLACK);
        l1.add(l2);

        
        l3 = new JLabel("ID");
        l3.setBounds(100, 150, 100, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(Color.BLACK);
        l1.add(l3);

        tf1 = new JTextField();
        tf1.setFont(new Font("Arial", Font.BOLD, 20));
        tf1.setBounds(250, 150, 150, 30);
        l1.add(tf1);

       
        l4 = new JLabel("Name");
        l4.setBounds(450, 150, 100, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);

        tf2 = new JTextField();
        tf2.setFont(new Font("Arial", Font.BOLD, 20));
        tf2.setBounds(550, 150, 200, 30);
        l1.add(tf2);

        l5 = new JLabel("Department");
        l5.setBounds(100, 200, 150, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 20));
        l5.setForeground(Color.BLACK);
        l1.add(l5);

        tf3 = new JTextField();
        tf3.setFont(new Font("Arial", Font.BOLD, 20));
        tf3.setBounds(250, 200, 150, 30);
        l1.add(tf3);

        l6 = new JLabel("Salary");
        l6.setBounds(450, 200, 100, 30);
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        l6.setForeground(Color.BLACK);
        l1.add(l6);

        tf4 = new JTextField();
        tf4.setFont(new Font("Arial", Font.BOLD, 20));
        tf4.setBounds(550, 200, 200, 30);
        l1.add(tf4);

        bt1 = new JButton("Update");
        bt1.setForeground(Color.BLACK);
        bt1.setBounds(250, 300, 150, 30);
        bt1.addActionListener(this);
        l1.add(bt1);

        bt2 = new JButton("Back");
        bt2.setForeground(Color.BLACK);
        bt2.setBounds(450, 300, 150, 30);
        bt2.addActionListener(this);
        l1.add(bt2);

        f.add(l1);
        f.setVisible(true);
        f.setSize(840, 600);
        f.setLocation(300, 100);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bt1) {
            try {
                int id = Integer.parseInt(tf1.getText());
                String name = tf2.getText();
                String department = tf3.getText();
                double salary = Double.parseDouble(tf4.getText());

                ConnectionClass obj = new ConnectionClass();
                String q = "SELECT COUNT(*) FROM employee WHERE id = " + id;
                ResultSet rs = obj.Stm.executeQuery(q);
                rs.next();
                int count = rs.getInt(1);

                if (count > 0) {
                   
                    q = "UPDATE employee SET name = '" + name + "', department = '" + department + "', salary = " + salary + " WHERE id = " + id;
                    obj.Stm.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Employee details updated successfully!");
                } else {
                    
                    q = "INSERT INTO employee (id, name, department, salary) VALUES (" + id + ", '" + name + "','" + department + "','" + salary + "')";
                    obj.Stm.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Employee details saved successfully!");
                }

                f.setVisible(false);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for ID and Salary.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error saving employee details: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == bt2) {
            f.dispose();
        }
    }
    //public static void main(String[] args) {
      //  new UpdateEmployee();
    //}
}
