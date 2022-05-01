import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

    public class GenerateBill extends JFrame implements ActionListener
    {
        JLabel l1, l2;
        JTextArea t1;
        JButton b1;
        Choice c2;
        JPanel p1;
        String meter_no;

        GenerateBill(String meter_no)
        {
            this.meter_no = meter_no;
            setSize(500, 675);
            setLayout(new BorderLayout());

            p1 = new JPanel();

            l1 = new JLabel("Generate Bill");

            l2 = new JLabel("meter");

            c2 = new Choice();
            c2.add("January");
            c2.add("February");
            c2.add("March");
            c2.add("April");
            c2.add("May");
            c2.add("June");
            c2.add("July");
            c2.add("August");
            c2.add("September");
            c2.add("October");
            c2.add("November");
            c2.add("December");

            t1 = new JTextArea(50, 15);
            t1.setText("\n\n\t------- Click on the -------\n\t Generate Bill Button to get\n\tthe bill of the Selected Month\n\n");
            JScrollPane jsp = new JScrollPane(t1);
            t1.setFont(new Font("Senserif", Font.ITALIC, 18));

            b1 = new JButton("Generate Bill");

            p1.add(l1);
            p1.add(l2);
            p1.add(c2);

            add(p1, "North");
            add(jsp, "Center");
            add(b1, "South");

            b1.addActionListener(this);

            setLocation(450, 50);
        }

        public void actionPerformed(ActionEvent ae)
        {
            try
            {
                Conn c = new Conn();
                String month = c2.getSelectedItem();
                t1.setText("\tXYZ Power Limited\nELECTRICITY BILL FOR THE MONTH OF " + month + " ,2021\n\n\n");

                ResultSet rs = c.s.executeQuery("select * from customer where meter_no='" + meter_no + "'");
                if (rs.next())
                {
                    t1.append("\n    Customer Name:" + rs.getString("name"));
                    t1.append("\n    Meter Number:  " + rs.getString("meter"));
                    t1.append("\n    Address:            " + rs.getString("address"));
                    t1.append("\n    State:                 " + rs.getString("state"));
                    t1.append("\n    City:                   " + rs.getString("city"));
                    t1.append("\n    Email:                " + rs.getString("email"));
                    t1.append("\n    Phone Number  " + rs.getString("phone"));
                    t1.append("\n-------------------------------------------------------------");
                    t1.append("\n");
                }

                rs = c.s.executeQuery("select * from Meter_Info where meter_no ='" + meter_no + "'");
                if (rs.next())
                {
                    t1.append("\n    Meter Location:" + rs.getString("meter_location"));
                    t1.append("\n    Meter Type:      " + rs.getString("meter_type"));
                    t1.append("\n    Phase Code:    " + rs.getString("phase_code"));
                    t1.append("\n    Bill Type:         " + rs.getString("bill_type"));
                    t1.append("\n");
                }

                rs = c.s.executeQuery("select * from Tax");
                if (rs.next())
                {
                    t1.append("---------------------------------------------------------------");
                    t1.append("\n\n");
                    t1.append("\n Cost per Unit:             Rs" + rs.getString("cost_per_unit"));
                    t1.append("\n Meter Rent:                Rs" + rs.getString("meter_rent"));
                    t1.append("\n Service Tax:               Rs" + rs.getString("service_tax"));
                    t1.append("\n Fixed Charges:               Rs" + rs.getString("fixed_charges"));
                    t1.append("\n GST:        Rs" + rs.getString("gst"));
                    t1.append("\n");
                }

                rs = c.s.executeQuery("select * from Bill where meter=" + meter_no + " AND month = '" + c2.getSelectedItem() + "'");
                if (rs.next())
                {
                    t1.append("\n    Current Month :\t" + rs.getString("month"));
                    t1.append("\n    Units Consumed:\t" + rs.getString("units"));
                    t1.append("\n    Total Charges :\t" + rs.getString("total_bill"));
                    t1.append("\n---------------------------------------------------------------");
                    t1.append("\n    TOTAL PAYABLE :\t" + rs.getString("total_bill"));
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        public static void main(String[] args)
        {
            new GenerateBill("").setVisible(true);
        }
    }



