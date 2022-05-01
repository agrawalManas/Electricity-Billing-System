import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

    public class Meter_Info extends JFrame
    {
        JLabel l1, l2, l3, l4, l5, l6, l7, l8;
        Choice c1, c3, c2, c4, c5;
        JButton b1, b2;
        JLabel title;
        String meter_no;

        Meter_Info(String meter_no)
        {
            this.meter_no = meter_no;
            JPanel p = new JPanel();
            p.setBackground(new Color(130, 81, 49));

            setLayout(new BorderLayout());
            getContentPane().setBackground(Color.WHITE);

            title = new JLabel("Meter Information");
            title.setFont(new Font("Tahoma", Font.BOLD, 24));
            p.add(title);

            l1 = new JLabel("Meter Number");
            p.add(l1);

            l7 = new JLabel();
            p.add(l7);

            l2 = new JLabel("Meter Location");
            p.add(l2);

            c1 = new Choice();
            c1.add("Outside");
            c1.add("Inside");
            p.add(c1);

            l3 = new JLabel("Meter Type");
            p.add(l3);

            c2 = new Choice();
            c2.add("Electric Meter");
            c2.add("Solar Meter");
            c2.add("Smart Meter");
            p.add(c2);

            l4 = new JLabel("Phase Code");
            p.add(l4);

            c3 = new Choice();
            c3.add("011");
            c3.add("022");
            c3.add("033");
            c3.add("044");
            c3.add("055");
            p.add(c3);

            l5 = new JLabel("Bill Type");
            p.add(l5);

            c4 = new Choice();
            c4.add("Domestic");
            c4.add("Industrial");
            p.add(c4);

            l6 = new JLabel("Note: Be smart customer by paying your each month's bill and avoid penalties");
            l6.setFont(new Font("Senserif", Font.ITALIC, 16));
            l6.setForeground(Color.RED);
            p.add(l6);

            b1 = new JButton("Submit");
            b2 = new JButton("Cancel");
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            p.add(b1);

            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.WHITE);
            p.add(b2);

            add(p);

            b1.addActionListener(new Handler6());
            b2.addActionListener(new Handler6());
        }
    }
    class Handler6 implements ActionListener
    {
        Meter_Info mi = new Meter_Info("");

        public void actionPerformed(ActionEvent ae)
        {
            String meter_no = mi.l7.getText();
            String meter_location = mi.c1.getSelectedItem();
            String meter_type = mi.c2.getSelectedItem();
            String phase_code = mi.c3.getSelectedItem();
            String bill_type = mi.c4.getSelectedItem();
            String q = "insert into Meter_Info('"+meter_no+"','"+meter_location+"','"+meter_type+"','"+phase_code+"','"+bill_type+"')";

            try
            {
                Conn c = new Conn();
                ResultSet rs;
                c.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Meter Information added successfully");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
            public static void main(String[] args)
            {
                Meter_Info mi;
                mi = new Meter_Info("");
                mi.setLocation(600,750);
                mi.setVisible(true);
            }
    }
