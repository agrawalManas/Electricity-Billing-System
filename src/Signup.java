import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
public class Signup extends JFrame implements ActionListener
{
    JLabel l6, l1, l2, l3, l4, l5;
    JTextField t1, t2, t3,t5;
    JButton b1, b2;
    Choice c1;

    Signup()
    {
        super("Sign In");
        setLayout(null);
        setBounds(600, 250, 700, 400);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon bimg = new ImageIcon("icons/bimg1.jpeg");
        Image i = bimg.getImage().getScaledInstance(700,400,Image.SCALE_DEFAULT);
        JLabel l = new JLabel(new ImageIcon(i),JLabel.CENTER);
        l.setBounds(0,0,700,400);
        add(l);

        l1 = new JLabel("Username");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
        l1.setBounds(280, 90, 100, 20);
        l.add(l1);

        t1 = new JTextField();
        t1.setBounds(460, 90, 150, 20);
        t1.setFont(new Font("Tahoma",Font.BOLD,12));
        l.add(t1);

        l2 = new JLabel("Name");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma", Font.BOLD, 18));
        l2.setBounds(280, 130, 100, 20);
        l.add(l2);

        t2 = new JTextField();
        t2.setBounds(460, 130, 150, 20);
        t2.setFont(new Font("Tahoma",Font.BOLD,12));
        l.add(t2);

        l3 = new JLabel("Password");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Tahoma", Font.BOLD, 18));
        l3.setBounds(280, 170, 100, 20);
        l.add(l3);

        t3 = new JPasswordField();
        t3.setBounds(460, 170, 150, 20);
        t3.setFont(new Font("Tahoma",Font.BOLD,12));
        l.add(t3);

        l4 = new JLabel("Create Account as ");
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Tahoma", Font.BOLD, 18));
        l4.setBounds(280, 210, 170, 20);
        l.add(l4);

        c1 = new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(460, 210, 100, 20);
        l.add(c1);

        l5 = new JLabel("Meter Number");
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("Tahoma", Font.BOLD, 18));
        l5.setBounds(280, 250, 170, 20);
        l.add(l5);

        t5 = new JTextField();
        t5.setBounds(460, 250, 150, 20);
        t5.setFont(new Font("Tahoma",Font.BOLD,12));
        l.add(t5);

        l5.setVisible(false);
        t5.setVisible(false);

        b1 = new JButton("Create Account");
        b1.setBackground(Color.CYAN);
        b1.setForeground(Color.BLACK);
        b1.setBounds(350, 300, 150, 30);
        b1.setFont(new Font("Senserif",Font.BOLD,14));
        b1.addActionListener(this);
        l.add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.CYAN);
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Senserif",Font.BOLD,14));
        b2.setBounds(520, 300, 150, 30);
        b2.addActionListener(this);
        l.add(b2);

        ImageIcon i1 = new ImageIcon(".jpg");
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l6 = new JLabel(i3);
        l6.setBounds(450, 30, 250, 250);
        l.add(l6);

        c1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                String user = c1.getSelectedItem();
                if (user.equals("Customer"))
                {
                    l5.setVisible(true);
                    t5.setVisible(true);
                }
                else
                    {
                    l5.setVisible(false);
                    t5.setVisible(false);
                    }

            }
        });
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == b2) {
            this.setVisible(false);
            Login ln = new Login();
            ln.setVisible(true);
        }
        else
            {
            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            String user = c1.getSelectedItem();
            try {
                Conn c = new Conn();
                if (user.equals("Admin"))
                {
                    String str = "insert into Login values('" + "NA" + "', '" + username + "', '" + name + "', " + password + "', '" + user + "')";
                    c.s.executeQuery(str);
                    JOptionPane.showMessageDialog(null, "Account created successfully");
                    new Signup().setVisible(false);
                    new Login().setVisible(true);
                }
                else if (user.equals("Customer"))
                {
                    String str = "insert into Login values('"+ t5.getText() + "', '" + username + "', '" + name + "', " + password + "', '" + user + "')";
                    ResultSet rs = c.s.executeQuery(str);
                    JOptionPane.showMessageDialog(null, "Account created successfully");
                    new Signup().setVisible(false);
                    new Login().setVisible(true);
                }
            }
               catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
    }
        public static void main(String []args)
        {
            Signup sg = new Signup();
            sg.setBounds(500, 250, 700, 400);
        }
}





