import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

        public class Project extends JFrame implements ActionListener
        {
        String meter_no;
        Project(String meter_no, String person)
        {
        super("Electricity Billing System");
        this.meter_no= meter_no;
        setSize(1920,1030);
        getContentPane().setBackground(new Color(20,26,50));

        /* Adding background image */
        ImageIcon ic = new ImageIcon(("icons/project1.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1100, 650,Image.SCALE_DEFAULT);
        ImageIcon icc3 =new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3,JLabel.CENTER);
        add(l1);

        /* Column */
        JMenuBar mb = new JMenuBar();
        JMenu master = new JMenu("Master");
        JMenuItem m1 = new JMenuItem("New Customer");
        JMenuItem m2 = new JMenuItem("Customer Details");
        JMenuItem m3 = new JMenuItem("Deposit Details");
        JMenuItem m4 = new JMenuItem("Calculate Bill");
        master.setForeground(Color.BLUE);
        master.setFont(new Font("Times New Roman",Font.BOLD,12));

        /* ---- New Customer  ---- */
        m1.setFont(new Font("Times New Roman",Font.BOLD,12));
        ImageIcon icon1 =new ImageIcon(ClassLoader.getSystemResource(""));
        Image image1 = icon1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m1.setIcon(new ImageIcon(image1));
        m1.setBackground(Color.WHITE);

        /* ---- Customer Details ---- */
        m2.setFont(new Font("Times New Roman",Font.BOLD,12));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource(""));
        Image image2 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m2.setIcon(new ImageIcon(image2));
        m2.setBackground(Color.WHITE);

        /* ---- Deposit Details, Bill Details-Admin ----- */
        m3.setFont(new Font("Times New Roman",Font.BOLD,12));
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource(""));
        Image image3 = icon3.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m3.setIcon(new ImageIcon(image3));
        m3.setBackground(Color.WHITE);

        /* ---- Calculate Bill ----*/
        m4.setFont(new Font("Times New Roman",Font.BOLD,12));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource(""));
        Image image5 = icon5.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m4.setIcon(new ImageIcon(image5));
        m4.setBackground(Color.WHITE);

        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);

        /* Column */
        JMenu info = new JMenu("Information");
        JMenuItem info1 = new JMenuItem("Update Information");
        JMenuItem info2 = new JMenuItem("View Information");
        info.setForeground(Color.RED);
        info.setFont(new Font("New Times Roman",Font.BOLD,12));

        /* Update Information*/
        info1.setFont(new Font("Times New Roman",Font.BOLD,12));
        ImageIcon icon6 =new ImageIcon(ClassLoader.getSystemResource(""));
        Image image6 = icon1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        info1.setIcon(new ImageIcon(image1));
        info.setBackground(Color.WHITE);

        /* View Information*/
        info2.setFont(new Font("Times New Roman",Font.BOLD,12));
        ImageIcon icon7 =new ImageIcon(ClassLoader.getSystemResource(""));
        Image image7 = icon1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        info2.setIcon(new ImageIcon(image1));
        info2.setBackground(Color.WHITE);

        info1.addActionListener(this);
        info2.addActionListener(this);

            /*Column */
        JMenu user = new JMenu("User");
        JMenuItem u1 = new JMenuItem("Pay Bill");
        JMenuItem u2 = new JMenuItem("Bill Details");
        JMenuItem u3 = new JMenuItem("Generate Bill");
        user.setForeground(Color.RED);
        user.setFont(new Font("New Times Roman",Font.BOLD,12));


            /* ---- Pay Bill ---- */
        u1.setFont(new Font("Times New Roman",Font.BOLD,12));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource(""));
        Image image4 = icon4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        u1.setIcon(new ImageIcon(image4));
        u1.setBackground(Color.WHITE);

        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);

            /* ---- Bill Details-Customer ----*/
        u2.setFont(new Font("Times New Roman",Font.BOLD,12));
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource(""));
        Image image10 = icon5.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m3.setIcon(new ImageIcon(image3));
        m3.setBackground(Color.WHITE);

            /* ---- Generate Bill ---- */
        u3.setFont(new Font("Times New Roman",Font.BOLD,12));
        ImageIcon icon11 =new ImageIcon(ClassLoader.getSystemResource(""));
        Image image11 = icon7.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        u3.setIcon(new ImageIcon(image7));
        u3.setBackground(Color.WHITE);

            /*Column*/
        JMenu utility = new JMenu("Utility");
        JMenuItem ut1 = new JMenuItem("Notepad");
        JMenuItem ut2 = new JMenuItem("Calculator");
        utility.setForeground(Color.RED);
        utility.setFont(new Font("New Times Roman",Font.BOLD,12));


            /* ---- Notepad ----*/
        ut1.setFont(new Font("Times New Roman",Font.BOLD,12));
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource(""));
        Image image8 = icon8.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ut1.setIcon(new ImageIcon(image8));
        ut1.setBackground(Color.WHITE);

            /* ---- Calculator ---- */
        ut2.setFont(new Font("Times New Roman",Font.BOLD,12));
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource(""));
        Image image9 = icon9.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ut2.setIcon(new ImageIcon(image9));
        ut2.setBackground(Color.WHITE);

        ut1.addActionListener(this);
        ut2.addActionListener(this);

        /*Fifth Column */
        JMenu exit = new JMenu("Logout");
        JMenuItem ex = new JMenuItem("Logout");
        exit.setForeground(Color.BLUE);

        /* ---- Exit ---- */
        ex.setFont(new Font("Times New Roman",Font.BOLD,12));
        ImageIcon icon13 =new ImageIcon(ClassLoader.getSystemResource(""));
        Image image13 = icon11.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(image11));
        ex.setBackground(Color.WHITE);

        ex.addActionListener(this);

        master.add(m1);
        master.add(m2);
        master.add(m3);
        master.add(m4);

        info.add(info1);
        info.add(info2);

        user.add(u1);
        user.add(u3);
        user.add(u2);

        utility.add(ut1);
        utility.add(ut2);

        exit.add(ex);

        if(person.equals("Admin"))
        {
        mb.add(master);
        }
        else
        {
        mb.add(info);
        mb.add(user);
        }
        mb.add(utility);
        mb.add(exit);

        setJMenuBar(mb);

        setFont(new Font("Times New Roman",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
        }

        public void actionPerformed(ActionEvent ae)
        {
        String msg=ae.getActionCommand();

            if(msg.equals("Customer Details"))
            {
                new CustomerDetails().setVisible(true);
            }
            else if(msg.equals("New Customer"))
            {
                new NewCustomer().setVisible(true);
            }
            else if(msg.equals("Calculate Bill"))
            {
                new CalculateBill().setVisible(true);
            }
            else if(msg.equals("Pay Bill"))
            {
                new PayBill(meter_no).setVisible(true);
            }
            else if(msg.equals("Notepad"))
            {
                try
                {
                Runtime.getRuntime().exec("notepad.exe");
                }
                    catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else if(msg.equals("Calculator"))
            {
                try
                {
                    Runtime.getRuntime().exec("calc.exe");
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else if(msg.equals("Logout"))
            {
            this.setVisible(false);
            new Login().setVisible(true);
            }
            else if(msg.equals("Generate Bill"))
            {
                new GenerateBill(meter_no).setVisible(true);
            }
            else if(msg.equals("Deposit Details"))
            {
                new BillDetails_Admin().setVisible(true);
            }
            else if(msg.equals("View Information"))
            {
                new ViewInformation(meter_no).setVisible(true);
            }
            else if(msg.equals("Update Information"))
            {
                new UpdateInformation(meter_no).setVisible(true);
            }
            else if(msg.equals("Bill Details"))
            {
                new BillDetails_Cus(meter_no).setVisible(true);
            }
        }

            public static void main(String[] args)
            {
            Project pr = new Project("","");
            pr.setVisible(true);
            }
        }
