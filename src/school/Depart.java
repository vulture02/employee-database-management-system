package school;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Depart extends JFrame implements ActionListener
{
    JLabel l1;
    Font f, f1, f2;
    JPanel p1;
    String id, account1;

    Depart(String account)
    {
        this.setTitle("Management System");
        setLocation(0, 0);
        setSize(750, 450);

        account1 = account;
        f = new Font("Arial", Font.BOLD, 20);
        f1 = new Font("Arial", Font.BOLD, 18);
        f2 = new Font("Arial", Font.BOLD, 15);

        l1 = new JLabel();
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("school/imageicon/login.jpg")); 
        Image i1 = img.getImage().getScaledInstance(750, 450, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);

        JMenuBar m1 = new JMenuBar();
        JMenu menu1 = new JMenu("Department");
        JMenu menu2 = new JMenu("Employee");

        JMenuItem ment1 = new JMenuItem("Add Department");
        JMenuItem ment2 = new JMenuItem("Update Department");
        JMenuItem ment3 = new JMenuItem("View Department");
        JMenuItem ment4 = new JMenuItem("Delete Department");

        menu1.add(ment1);
        menu1.add(ment2);
        menu1.add(ment3);
        menu1.add(ment4);

        JMenuItem ment5 = new JMenuItem("Add Employee");
        JMenuItem ment6 = new JMenuItem("Update Employee");
        JMenuItem ment7 = new JMenuItem("View Employee");
        JMenuItem ment8 = new JMenuItem("Delete Employee");

        menu2.add(ment5);
        menu2.add(ment6);
        menu2.add(ment7);
        menu2.add(ment8);

        m1.add(menu1);
        m1.add(menu2);

        menu1.setFont(f1);
        menu2.setFont(f1);

        ment1.setFont(f2);
        ment2.setFont(f2);
        ment3.setFont(f2);
        ment4.setFont(f2);
        ment5.setFont(f2);
        ment6.setFont(f2);
        ment7.setFont(f2);
        ment8.setFont(f2);

        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);
        ment5.addActionListener(this);
        ment6.addActionListener(this);
        ment7.addActionListener(this);
        ment8.addActionListener(this);

        setJMenuBar(m1);
        add(l1);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String command = ae.getActionCommand();
        if (command.equals("Add Department")) {      
             new Adddepartmentdetails().setVisible(true);
        } else if (command.equals("Update Department")) {            
            new UpdateDepartment().setVisible(true);
        } else if (command.equals("View Department")) {          
            new viewdepartment().setVisible(true);
        } else if (command.equals("Delete Department")) {      
            new DeleteDepartment().setVisible(true);
        } else if (command.equals("Add Employee")) {
           
             new AddEmployee().setVisible(true);
        } else if (command.equals("Update Employee")) {
            new UpdateEmployee().setVisible(true);
        } else if (command.equals("View Employee")) {
            new ViewEmployee().setVisible(true);
        } else if (command.equals("Delete Employee")) {
             new DeleteEmployee().setVisible(true);
        }
    }

   // public static void main(String[] args)
    //{
     //   new Depart("Amith").setVisible(true);
  // }
}
