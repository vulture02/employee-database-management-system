package school;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LoginPag extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5;
    Choice ch1;
    JTextField tf1;
    JPasswordField ps;
    JButton bt1, bt2;

    LoginPag() {
        f = new JFrame("Login page");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 750, 450);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("school/imageicon/student.jpg"));
        Image i1 = img.getImage().getScaledInstance(750, 450, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);

        l2 = new JLabel("Login account");
        l2.setBounds(300, 132, 500, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
       // f.add(l1);

        l3 = new JLabel("Account :");
        l3.setBounds(280, 200, 150, 50);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(Color.BLACK);
        l1.add(l3);

        ch1 = new Choice();
        ch1.add("Admin");
        ch1.setBounds(480, 200, 150, 30);
        ch1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.add(ch1);

        l4 = new JLabel("username :");
        l4.setBounds(280, 245, 150, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);

        tf1 = new JTextField();
        tf1.setFont(new Font("Arial", Font.BOLD, 20));
        tf1.setBounds(480, 245, 150, 30);
        l1.add(tf1);

        l5 = new JLabel("Password:");
        l5.setBounds(280, 295, 150, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 20));
        l5.setForeground(Color.BLACK);
        l1.add(l5);

        ps = new JPasswordField();
        ps.setFont(new Font("Arial", Font.BOLD, 20));
        ps.setBounds(480, 295, 150, 30);
        l1.add(ps);

        bt1 = new JButton("Login");
        bt2 = new JButton("Exit");
        bt1.setFont(new Font("Arial", Font.BOLD, 20));
        bt2.setFont(new Font("Arial", Font.BOLD, 20));
        bt1.setBounds(280, 350, 150, 40);
        bt2.setBounds(480, 350, 150, 40);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        l1.add(bt1);
        l1.add(bt2);
        
        f.add(l1);
        f.setVisible(true);
        f.setSize(750, 460);
        f.setLocation(300, 100);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bt1) {
            try {
                ConnectionClass obj = new ConnectionClass();
                String username = tf1.getText();
                String password = new String(ps.getPassword());
                String account = ch1.getSelectedItem();
                String q = "select * from admin where username='" + username + "' and password='" + password + "'";
                ResultSet rest = obj.Stm.executeQuery(q);
                if (rest.next()) {
                  if(account.equals("Admin"))
                    {
                    new Depart(account).setVisible(true); 
                    f.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You have entered wrong username and password");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (ae.getSource() == bt2) {
            f.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new LoginPag();
    }
}


