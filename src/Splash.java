import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash
{
    public static void main(String[] args)
    {
        fframe f = new fframe();
        f.setVisible(true);
        int i, x = 0;
        for (i = 2; i <= 544; i += 2, x+= 1)
        {
            f.setLocation(750 - ((i + x) / 2), 400 - (i / 2));
            f.setSize(i + x, i);
            try
            {
                Thread.sleep(13);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

class fframe extends JFrame implements Runnable
{
    Thread t;
    fframe()
    {
        super("Electricity Billing System");
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon("icons/splash.jpg");
        Image i = c1.getImage().getScaledInstance(830,500,Image.SCALE_DEFAULT);
        JLabel l1 = new JLabel(new ImageIcon(i));
        add(l1);

        Thread t = new Thread(this);
        t.start();
    }
        @Override
        public void run()
        {
            try
            {
                Thread.sleep(7000);
                this.setVisible(false);
                Login ln = new Login();
                ln.setVisible(true);
            }
            catch (Exception e)
            {
                e.printStackTrace();

            }
        }
 }


