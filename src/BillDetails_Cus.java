import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

    public class BillDetails_Cus extends JFrame
    {
        JTable t1;
        JScrollPane jsp;
        JButton b;
        String meter_no;

        BillDetails_Cus(String meter_no)
        {
            this.meter_no = meter_no;
            setLayout(new BorderLayout());

            String x[] = {"Meter_No", "Month", "Units_Consumed", "Total_Bill", "Status"};
            x = new String[5];
            String[][] y = new String[20][20];

            t1 = new JTable(y, x);
            t1.setFont(new Font("Senserif",Font.BOLD,18));
            getContentPane().setBackground(Color.WHITE);
            jsp = new JScrollPane(t1);
            add(t1);

            b = new JButton("Print");
            add(b, "SOUTH");
            b.addActionListener(new Handler7());

            try {
                Conn c = new Conn();
                ResultSet rs;
                String str = "select * from Bill where meter_no='" + meter_no + "'";
                rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
        class Handler7 implements ActionListener
        {
            BillDetails_Cus bdc = new BillDetails_Cus("");

            public void actionPerformed(ActionEvent ae)
            {
                try
                {
                    bdc.t1.print();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
                public static void main(String[] args)
                {
                    BillDetails_Cus bdc = new BillDetails_Cus("");
                    bdc.setSize(700,650);
                    bdc.setLocation(600,550);
                    bdc.setVisible(true);
                }
            }



