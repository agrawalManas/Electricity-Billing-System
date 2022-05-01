import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.sql.*;
import java.util.*;

    public class NewCustomer extends JFrame
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton b1,b2;
    JPanel p1,p2;

    NewCustomer()
    {
        l8 = new JLabel("Meter Number");
        l1 = new JLabel("Customer Name");
        l2 = new JLabel("Phone Number");
        l3 = new JLabel("Email ID");
        l4 = new JLabel("Address");
        l5 = new JLabel("City");
        l6 = new JLabel("State");

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource(""));
        Image im = i.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        l7 = new JLabel(new ImageIcon(im));

        t1 = new JTextField(12);
        t2 = new JTextField(12);
        t3 = new JTextField(12);
        t4 = new JTextField(12);
        t5 = new JTextField(12);
        t6 = new JTextField(12);

        p1 = new JPanel();
        p2 = new JPanel();
        setLayout(new BorderLayout());

        Random ran = new Random();
        long first = (ran.nextLong() % 1000000); //Unique meter number
        l9.setText(""+Math.abs(first));

        add(l7,BorderLayout.WEST);
        p1.add(l8);
        p1.add(l9);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        p1.add(l4);
        p1.add(t4);
        p1.add(l5);
        p1.add(t5);
        p1.add(l6);
        p1.add(t6);
        add(p1,BorderLayout.CENTER);

        b1 = new JButton("Next");
        b2 = new JButton("Cancel");
        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(new Handler2());
        b1.addActionListener(new Handler2());

        getContentPane().setBackground(Color.WHITE);

        p2.add(b1);
        p2.add(b2);
        add(p2,BorderLayout.SOUTH);
        p1.setBackground(new Color(21,126,98));
        p2.setBackground(new Color(21,126,98));
    }
}

    class Handler2 implements ActionListener
    {
        NewCustomer nc = new NewCustomer();
        Meter_Info mi = new Meter_Info("");
        public void actionPerformed(ActionEvent xy) {
            if (xy.getSource() == nc.b1) {
                String a = nc.t1.getText();
                String b = nc.t2.getText();
                String c = nc.t3.getText();
                String d = nc.t4.getText();
                String e = nc.t5.getText();
                String f = nc.t6.getText();
                String q = "insert into customer value('" + a + "','" + b + "','" + c + "','" + d + "','" + e + "','" + f + "')";
                try
                {
                    Conn c1 = new Conn();
                    c1.s.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Customer Created");
                }
                catch (Exception ee)
                {
                    System.out.println("Error:" + ee.getMessage());
                }
                mi.setVisible(true);
            }
                else
                {
                nc.setVisible(false);
                }
        }
        public static void main (String[] args)
        {
            NewCustomer nc1 = new NewCustomer();
            nc1.setVisible(true);
            nc1.setSize(700,500);
            nc1.setLocation(600,200);
        }
        }
