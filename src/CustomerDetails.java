import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

        public class CustomerDetails extends JFrame
    {
        int i,j;
        JTable t1;
        JButton b1 = new JButton("Print");

        CustomerDetails()
        {
            getContentPane().setBackground(Color.WHITE);

            String y[][] = new String[10][7];
            String x[] = {"Meter Number", "Customer Name", "Phone Number", "Email ID", "Address", "City", "State"};
            x = new String[7];
            JScrollPane jsp = new JScrollPane();
            try
            {
                Conn c = new Conn();
                ResultSet rs;
                String s = "select * from customer";
                rs = c.s.executeQuery(s);
                while (rs.next())
                {
                    i = 0;

                    y[i][j] = rs.getString("Meter_no");
                    y[i][j++] = rs.getString("Name");
                    y[i][j++] = rs.getString("Phone");
                    y[i][j++] = rs.getString("Email");
                    y[i][j++] = rs.getString("Address");
                    y[i][j++] = rs.getString("City");
                    y[i][j++] = rs.getString("State");
                    i++;
                    j = 0;
                }
                t1 = new JTable(y,x);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            t1.setBackground(Color.WHITE);
            t1.setFont(new Font("Senserif",Font.BOLD,16));
            setLayout(new FlowLayout());
            add(t1);

            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            b1.addActionListener(new Handler3());

            add(b1,"SOUTH");
            add(jsp);
        }
    }
    class Handler3 implements ActionListener
    {
        CustomerDetails cd = new CustomerDetails();
        public void actionPerformed(ActionEvent ae)
        {
            try
            {
                boolean print = cd.t1.print();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        public static void main(String args[])
        {
            CustomerDetails cd1 = new CustomerDetails();
            cd1.setSize(700,760);
            cd1.setLocation(250,250);
            cd1.setVisible(true);
        }
    }
