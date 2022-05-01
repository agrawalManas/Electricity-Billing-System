import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

    public class ViewInformation extends JFrame implements ActionListener
{
    String meter_no;
    ViewInformation (String meter_no)
    {
        this.meter_no = meter_no;
        setLayout(null);
        setBounds(600,250,850,650);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("View Information");
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        add(title);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(70,80,100,20);
        add(l1);

        JLabel l2 = new JLabel();
        l2.setBounds(180,80,100,20);
        add(l2);

        JLabel l3 = new JLabel("Meter Number");
        l3.setBounds(70,140,100,20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(180,140,100,20);
        add(l4);

        JLabel l5 = new JLabel("Phone Number");
        l5.setBounds(70,200,100,20);
        add(l5);

        JLabel l6 = new JLabel();
        l6.setBounds(180,200,100,20);
        add(l6);

        JLabel l7 = new JLabel("Email ID");
        l7.setBounds(70,260,100,20);
        add(l7);

        JLabel l8 = new JLabel();
        l8.setBounds(180,260,100,20);
        add(l8);

        JLabel l9 = new JLabel("Address");
        l9.setBounds(180,300,100,20);
        add(l9);

        JLabel l10 = new JLabel();
        l10.setBounds(180,300,100,20);
        add(l1);

        JLabel l11 = new JLabel("City");
        l11.setBounds(70,360,100,20);
        add(l11);

        JLabel l12 = new JLabel();
        l12.setBounds(180,300,100,20);
        add(l12);

        JLabel l13 = new JLabel("State");
        l13.setBounds(70,360,100,20);
        add(l13);

        JLabel l14 = new JLabel();
        l14.setBounds(180,360,100,20);
        add(l14);

        try
        {
            Conn c = new Conn();
            ResultSet rs;
            rs = c.s.executeQuery("select * from customer");
            while (rs.next())
            {
                l2.setText(rs.getString("name"));
                l4.setText(rs.getString("meter_no"));
                l6.setText(rs.getString("phone"));
                l8.setText(rs.getString("email"));
                l10.setText(rs.getString("address"));
                l12.setText(rs.getString("city"));
                l14.setText(rs.getString("state"));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JButton b1 = new JButton("Back");
        b1.setBounds(350,340,100,25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        b1.addActionListener(this);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/vinfo.jpg"));
        Image i1 = i.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);

        JLabel l15 = new JLabel(i2);
        add(l15);
        l15.setBounds(20,350,600,300);

    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
     this.setVisible(false);
    }
    public void main(String[] args)
    {
        new ViewInformation("").setVisible(true);
    }
}
