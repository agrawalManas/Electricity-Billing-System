import java.sql.*;
public class Conn
{
    Connection c;
    Statement s;
    public Conn()
    {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","password");
                s = c.createStatement();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


    }
}
