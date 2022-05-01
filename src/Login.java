import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import java.sql.*;

    public class Login extends JFrame implements ActionListener
{
    JLabel  l1;
    JLabel l2;
    JLabel l3,l4;
    JTextField t1;
    JPasswordField pf;
    JButton b1;
    JButton b2;
    JButton b3;
    Choice c1 = new Choice();

        Login()
    {
    super("Login Page");
    setLayout(null);
    setBounds(450,250,500,290);
    getContentPane().setBackground(Color.WHITE);

    ImageIcon i1= new ImageIcon("icons/man.jpg");
    Image i2 = i1.getImage().getScaledInstance(230,170,Image.SCALE_DEFAULT);
    l3 = new JLabel(new ImageIcon(i2));
    l3.setBounds(10,0,150,250);
    add(l3);

    l1 = new JLabel("Username");
    l1.setBounds(200,50,100,30);
    add(l1);

    t1= new JTextField();
    t1.setBounds(330,50,120,20);
    add(t1);

    l2 = new JLabel("Password");
    l2.setBounds(200,80,100,30);
    add(l2);

    pf = new JPasswordField();
    pf.setBounds(330,80,120,20);
    add(pf);

    l4 = new JLabel("Logging in as ");
    l4.setBounds(200,110,120,30);
    add(l4);

    c1.add("Admin");
    c1.add("Customer");
    c1.setBounds(330,110,80,30);
    add(c1);

    ImageIcon i4 = new ImageIcon("icons/ilogin.png");
    Image i5 = i4.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
    b1 = new JButton("Login",new ImageIcon(i5));
    b1.setBounds(200,170,120,23);
    add(b1);

    ImageIcon i6 = new ImageIcon("icons/cancel.jpg");
    Image i7 = i6.getImage().getScaledInstance(12,12,Image.SCALE_DEFAULT);
    b2 = new JButton("Cancel", new ImageIcon(i7));
    b2.setBounds(330,170,120,23);
    add(b2);

    ImageIcon i8 = new ImageIcon("icons/sign.png");
    Image i9 = i8.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
    b3 = new JButton("Sign Up", new ImageIcon(i9));
    b3.setBounds(260,210,120,24);
    add(b3);

    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
{
    if (e.getSource()==b3)
    {
        this.setVisible(false);
        Signup sg = new Signup();
        sg.setVisible(true);
    }
    else if (e.getSource()==b2)
    {
        this.setVisible(false);
    }
    else
        {
        try
        {
            Conn c = new Conn();
            String a = t1.getText();
            String b = pf.getText();
            String q = "select * from Login where username=" + a + "and password=" + b;
            ResultSet rs;
            rs = c.s.executeQuery(q);
            String meter = rs.getString("meter_no");
            rs = c.s.executeQuery(q);
            if (rs.next())
            {
                Project pr = new Project("","");
                pr.setVisible(true);
            }
            else
                {
                JOptionPane.showMessageDialog(null, "Invalid Login");
                t1.setText("");
                pf.setText("");
                }
        }
        catch (Exception ee)
        {
            System.out.println("Error" + ee);
        }
        }
    }
    public static void main(String[] args)
{
    Login ln = new Login();
    ln.setVisible(true);
}
}
