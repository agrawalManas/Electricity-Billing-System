import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class UpdateInformation extends JFrame
{
    String meter_no;
    JLabel l1,l2,l3,l4,l5,l7,l9,l11,l13;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    UpdateInformation(String meter_no)
    {
        this.meter_no = meter_no;

        setLayout(null);
        setBounds(600, 250, 850, 650);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("Update your Credentials");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(title);

        l1 = new JLabel("Name");
        l1.setBounds(70, 80, 100, 20);
        add(l1);

        l2 = new JLabel();
        l2.setBounds(180, 80, 100, 20);
        add(l2);

        l3 = new JLabel("Meter Number");
        l3.setBounds(70, 140, 100, 20);
        add(l3);

        l4 = new JLabel();
        l4.setBounds(180, 140, 100, 20);
        add(l4);

        l5 = new JLabel("Phone Number");
        l5.setBounds(70, 200, 100, 20);
        add(l5);

        t1 = new JTextField();
        t1.setBounds(180, 200, 100, 20);
        add(t1);

        l7 = new JLabel("Email ID");
        l7.setBounds(70, 260, 100, 20);
        add(l7);

        t2 = new JTextField();
        t2.setBounds(180, 260, 100, 20);
        add(t2);

        l9 = new JLabel("Address");
        l9.setBounds(180, 300, 100, 20);
        add(l9);

        t3 = new JTextField();
        t3.setBounds(180, 300, 100, 20);
        add(t3);

        l11 = new JLabel("City");
        l11.setBounds(70, 360, 100, 20);
        add(l11);

        t4 = new JTextField();
        t4.setBounds(180, 300, 100, 20);
        add(t4);

        l13 = new JLabel("State");
        l13.setBounds(70, 360, 100, 20);
        add(l13);

        t5 = new JTextField();
        t5.setBounds(180, 360, 100, 20);
        add(t5);

        try
        {
            Conn c = new Conn();
            ResultSet rs;
            rs = c.s.executeQuery("select * from customer where meter_no='" + meter_no + "'");
            while (rs.next())
            {
                l2.setText(rs.getString("Name"));
                l4.setText(rs.getString("Meter_No"));
                t1.setText(rs.getString("Phone"));
                t2.setText(rs.getString("Email"));
                t3.setText(rs.getString("Address"));
                t4.setText(rs.getString("City"));
                t5.setText(rs.getString("State"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        ImageIcon i = new ImageIcon("icons/unifo.png");
        Image i1 = i.getImage().getScaledInstance(160, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);

        JLabel l15 = new JLabel(i2);
        add(l15);

        JButton b1 = new JButton("Update");
        b1.setBounds(180, 340, 100, 25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        b1.addActionListener(new myHandler());

        JButton b2 = new JButton("Back");
        b2.setBounds(350, 340, 100, 25);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        b2.addActionListener(new myHandler());
    }
}
    class myHandler implements ActionListener
    {
     UpdateInformation ui = new UpdateInformation("");
     @Override
     public void actionPerformed(ActionEvent ae)
        {
            if (ae.getSource() == ui.b2)
            {
            ui.setVisible(false);
            }
            else
            {
                String s1 = ui.l2.getText();
                String s2 = ui.l4.getText();
                String s3 = ui.t1.getText();
                String s4 = ui.t2.getText();
                String s5 = ui.t3.getText();
                String s6 = ui.t4.getText();
                String s7 = ui.t5.getText();

                try
                {
                    Conn c = new Conn();
                    ResultSet rs;
                    String q = "update customer set phone='"+s3+"',email='"+s4+"',address='"+s5+"',city='"+s6+"',state='"+s7+"'where meter_no='"+ui.l4.getText()+"'";
                    c.s.executeUpdate(q);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                ui.setVisible(false);
            }
        }
        public void main(String[] args)
        {
             ui.setVisible(true);
        }
    }

