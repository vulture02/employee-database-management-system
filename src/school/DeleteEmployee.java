package school;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class DeleteEmployee extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5;
    JButton bt1, bt2;
    JTextField tf1, tf2, tf3, tf4;
    JFrame f;

    DeleteEmployee() {
        f = new JFrame("Delete Employee Details");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 840, 600);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource(""));
        Image i1 = img.getImage().getScaledInstance(840, 600, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);

        l2 = new JLabel("Delete Employee Details");
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

        l4 = new JLabel("Department");
        l4.setBounds(100, 200, 150, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);

        tf2 = new JTextField();
        tf2.setFont(new Font("Arial", Font.BOLD, 20));
        tf2.setBounds(250, 200, 150, 30);
        l1.add(tf2);

        bt1 = new JButton("Delete");
        bt1.setForeground(Color.BLACK);
        bt1.setBounds(250, 250, 150, 30);
        bt1.addActionListener(this);
        l1.add(bt1);

        bt2 = new JButton("Back");
        bt2.setForeground(Color.BLACK);
        bt2.setBounds(450, 250, 150, 30);
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
                String department = tf2.getText();

                ConnectionClass obj = new ConnectionClass();

                
                String p = "SELECT * FROM employee WHERE id = ? AND department = ?";
                PreparedStatement pstmt = obj.con.prepareStatement(p);
                pstmt.setInt(1, id);
                pstmt.setString(2, department);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                   
                    String q = "DELETE FROM employee WHERE id = ? AND department = ?";
                    PreparedStatement deleteStmt = obj.con.prepareStatement(q);
                    deleteStmt.setInt(1, id);
                    deleteStmt.setString(2, department);
                    int delete = deleteStmt.executeUpdate();

                    if (delete > 0) {
                        JOptionPane.showMessageDialog(null, "Employee details deleted successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to delete employee details.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No employee found with the given ID and Department.");
                }

                f.setVisible(false);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer for ID.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error deleting employee details: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == bt2) {
            f.dispose();
        }

    }

    //public static void main(String[] args) {
      //  new DeleteEmployee();
   // }
}
