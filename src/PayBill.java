import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.sql.*;
import java.util.*;

    public class PayBill extends JFrame
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton b1,b2;
    Choice c1;
    JLabel title;
    String meter_no;

    PayBill(String meter_no)
    {
        setLayout(null);

        title = new JLabel("Your Bill");
        title.setFont(new Font("Senserif",Font.BOLD,24));
        title.setBounds(120,5,400,30);
        add(title);

        l1 = new JLabel("Meter Number");
        l1.setBounds(30,80,200,200);
        add(l1);

        l2 = new JLabel();
        l2.setBounds(130,80,200,200);
        add(l2);

        l3 = new JLabel("Name");
        l3.setBounds(30,140,200,200);
        add(l3);

        l4 = new JLabel();
        l4.setBounds(130,140,200,200);
        add(l4);

        l5 = new JLabel("Phone Number");
        l1.setBounds(30,200,200,200);
        add(l5);

        l6 = new JLabel();
        l6.setBounds(130,200,200,200);
        add(l6);

        l7 = new JLabel("Month");
        l7.setBounds(30,260,200,200);
        add(l7);

        c1 = new Choice();
        c1.add("January");
        c1.add("February");
        c1.add("March");
        c1.add("April");
        c1.add("May");
        c1.add("June");
        c1.add("July");
        c1.add("August");
        c1.add("September");
        c1.add("October");
        c1.add("November");
        c1.add("December");
        c1.setBounds(130,260,200,200);
        add(c1);

        l9 = new JLabel("Units Consumed");
        l9.setBounds(30,300,200,200);
        add(l9);

        l10 = new JLabel();
        l10.setBounds(130,300,200,200);
        add(l10);

        l11 = new JLabel("Total Bill");
        l11.setBounds(30,360,200,200);
        add(l11);

        l12 = new JLabel();
        l12.setBounds(130,360,200,200);
        add(l12);

        l13 = new JLabel("Status");
        l13.setBounds(30,420,200,200);
        add(l13);

        l8 = new JLabel();
        l8.setBounds(130,420,200,200);
        add(l8);


        ImageIcon i= new ImageIcon(ClassLoader.getSystemResource(""));
        Image i1 = i.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);

        JLabel l14 = new JLabel(new ImageIcon(i1));
        l14.setBounds(400,120,600,300);
        add(l14);

        b1 = new JButton("Pay");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLUE);
        b1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(b1);
        b1.addActionListener(new Handler8());

        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        b2.addActionListener(new Handler8());

        try
        {
            Conn c = new Conn();
            ResultSet rs;
            String s1 = "select * from Bill where meter_no='"+meter_no+"'AND month='"+c1.getSelectedItem()+"'";
            String s2 = "select * from Customer where meter_no='"+l2.getText()+"'";

            rs = c.s.executeQuery(s2);
            while (rs.next())
            {
                l4.setText(rs.getString("name"));
                l6.setText(rs.getString("phone"));
            }

            rs = c.s.executeQuery(s1);
            while (rs.next())
            {
                l10.setText(rs.getString("units_consumed"));
                l12.setText(rs.getString("total_bill"));
                l8.setText(rs.getString("status"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if (l8.getText() == "paid" || l8.getText() == "PAID")
        {
            l8.setForeground(Color.green);
            b1.setVisible(false);
        }

        else
        {
            setForeground(Color.RED);
        }
        c1.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                try
                {
                    Conn c = new Conn();
                    ResultSet rs;
                    String str = "select * from Bill where meter_no='"+l2.getText()+"'AND month='"+c1.getSelectedItem()+"'";

                    rs = c.s.executeQuery(str);
                    while(rs.next())
                    {
                        l8.setText(rs.getString("status"));
                        l10.setText(rs.getString("units_consumed"));
                        l12.setText(rs.getString("total_bill"));
                    }
                }
                catch (Exception ee)
                {
                    ee.printStackTrace();
                }

            }
        });
    }
}

        class Handler8 extends Thread implements ActionListener
        {
            PayBill pb = new PayBill("");

            public void actionPerformed(ActionEvent ae)
            {
                Thread t1 = new Thread(this);
                if (ae.getSource() == pb.b2)
                {
                    pb.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please wait while we receive your payment");
                    try
                    {
                        Thread.sleep(5000);
                        t1.start();
                        JOptionPane.showMessageDialog(null, "Payment Received Successfully,/n Your Bill Staus has been Updated");
                        Conn c = new Conn();
                        String s = "update Bill set status='Paid' where meter_no='" + pb.l2.getText() + "' AND month='" + pb.c1.getSelectedItem() + "'";
                        c.s.executeUpdate(s);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            public static void main(String []args)
            {
                PayBill pb = new PayBill("");
                pb.setSize(550,220);
                pb.setLocation(900,600);
                pb.setVisible(true);
            }
        }
