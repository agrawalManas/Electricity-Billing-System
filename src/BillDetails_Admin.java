import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

    public class BillDetails_Admin extends JFrame
    {
        JTable t1;
        JScrollPane sp;
        JLabel l1,l2;
        JTextField tf1;
        JButton b1,b2;
        Choice c1;

        BillDetails_Admin()
        {
            String x[] = {"Meter Number", "Month", "Units Consumed", "Total Bill", "Status"};
            x = new String[7];
            String y[][] = new String[20][5];
            int i = 0;
            int j = 0;

            setLayout(null) ;
            getContentPane().setBackground(Color.WHITE);
            t1 = new JTable();
            sp = new JScrollPane(t1);
            sp.setBounds(0,100,700,650);
            add(sp);
            l1 = new JLabel("Meter Number");
            l1.setBounds(20,20,150,20);
            add(l1);
            tf1 = new JTextField();
            tf1.setBounds(180,20,150,20);
            add(tf1);
             l2 = new JLabel("Month");
            l2.setBounds(400,20,100,20);
            add(l2);

            c1 = new Choice();
            c1.add("January");
            c1.add("May");
            c1.add("February");
            c1.add("March");
            c1.add("April");
            c1.add("June");
            c1.add("July");
            c1.add("August");
            c1.add("September");
            c1.add("October");
            c1.add("November");
            c1.add("December");
            c1.setBounds(520,20,150,20);
            add(c1);

            b1 = new JButton("Search");
            b2 = new JButton("Print");
            b2.setBounds(120,70,80,20);
            b1.setBounds(20,70,80,20);
            b1.addActionListener(new Handler4());
            b2.addActionListener(new Handler4());

        }
    }
        class Handler4 implements ActionListener
        {
            BillDetails_Admin bda = new BillDetails_Admin();

            public void actionPerformed(ActionEvent ae)
            {
                if (ae.getSource() == bda.b2)
                {
                    try
                    {
                        boolean print = bda.t1.print();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                    {
                    String meter_no = bda.tf1.getText();
                    String str = "select * from Bill where meter_no='" + meter_no + "',AND month='" + bda.c1.getSelectedItem() + "'";
                    try
                    {
                        Conn c = new Conn();
                        ResultSet rs;
                        rs = c.s.executeQuery(str);
                        bda.t1.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                    }
            }
               public static void main(String[] args)
            {
            BillDetails_Admin bda = new BillDetails_Admin();
            bda.setSize(700,750);
            bda.setLocation(600,150);
            bda.setVisible(true);
            }
        }