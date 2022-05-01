import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

    public class CalculateBill extends JFrame
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    Choice c1,c2,c3;
    JButton b1,b2;
    JPanel p;
    JTextField t1,t2;

    CalculateBill()
    {
        p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(21, 126, 98));

        l1 = new JLabel("Calculate Electricity Bill");
        l1.setBounds(80, 10, 400, 30);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));

        l2 = new JLabel("Meter Number");
        l2.setBounds(60, 70, 100, 30);
        p.add(l2);

        l3 = new JLabel("Customer Name");
        l2.setBounds(60, 120, 100, 30);
        p.add(l3);

        l4 = new JLabel("Address");
        l2.setBounds(60, 170, 100, 30);
        p.add(l4);

        l5 = new JLabel("Units Consumed");
        l5.setBounds(60, 220, 100, 30);
        p.add(l6);

        l6 = new JLabel("Month");
        l2.setBounds(60, 270, 100, 30);
        p.add(l6);

        c1 = new Choice();
        c1.setBounds(200, 270, 200, 20);
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
        p.add(c1);

        t1 = new JTextField();
        t1.setBounds(200, 70, 200, 20);
        t2 = new JTextField();
        t2.setBounds(200, 220, 200, 20);
        p.add(t1);
        p.add(t2);

        l7 = new JLabel();
        l7.setBounds(200, 120, 200, 20);
        p.add(l7);

        l8 = new JLabel();
        l8.setBounds(200, 170, 200, 20);
        p.add(l8);

        try
        {
            Conn c = new Conn();
            ResultSet rs;
            rs = c.s.executeQuery("select * from customer where meter_no='"+t1.getText()+"'");
                while(rs.next())
                {
                    l7.setText(rs.getString("name"));
                    l8.setText(rs.getString("address"));
                }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        b1 = new JButton("Submit");
        b1.setBounds(100,350,100,25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        p.add(b1);
        b1.addActionListener(new Handler5());

        b2 = new JButton("Cancel");
        b2.setBounds(100,400,100,25);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        p.add(b2);
        b2.addActionListener(new Handler5());

        getContentPane().setBackground(Color.WHITE);
    }
}
        class Handler5 implements ActionListener
        {
            CalculateBill cb = new CalculateBill();
            public void actionPerformed(ActionEvent ae)
            {
                if (ae.getSource() == cb.b2)
                {
                    cb.setVisible(false);
                }
                else
                {
                    String meter_no = cb.t1.getText();
                    String units = cb.t2.getText();
                    String month = cb.c1.getSelectedItem();
                    int total = 0;

                    try
                    {
                      Conn c = new Conn();
                      ResultSet rs;
                      rs = c.s.executeQuery("select * from Tax");
                      int q = (Integer.parseInt(rs.getString("cost_per_unit")));
                      while (rs.next())
                        {
                            total = Integer.parseInt(units) * q;
                            total = total+Integer.parseInt(rs.getString("meter_rent"));
                            total = total+Integer.parseInt(rs.getString("service_tax"));
                            total = total+Integer.parseInt(rs.getString("fixed_charges"));
                            total = total+Integer.parseInt(rs.getString("gst"));
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                       String q ="insert into Bill values('"+meter_no+"','"+month+"','"+units+"','"+total+"')";
                    try
                    {
                        Conn c1 = new Conn();
                        c1.s.executeUpdate(q);
                        JOptionPane.showMessageDialog(null,"Bill Updated Successfully");
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            public static void main(String[] args)
            {
                CalculateBill cb = new CalculateBill();
                cb.setSize(750,500);
                cb.setLocation(550,220);
                cb.setVisible(true);
            }
        }
