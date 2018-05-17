package  cmt;
import java.sql.*;
import java.util.*;

public class UserBean
{
    private  String uname,pwd,fullname;
  
    public  void setPwd(String pwd)
    { this.pwd= pwd; }

    public String getPwd()
    {  return pwd; }

    public boolean login()
    {
     Connection con = null;
     PreparedStatement ps = null;
     boolean logged = false;
     try
     {
      con = Database.getConnection();
      ps = con.prepareStatement("select fullname from users where uname = ? and pwd= ?");
      ps.setString(1,uname);
      ps.setString(2,pwd);
      ResultSet rs = ps.executeQuery();
      if ( rs.next())
      {
	    fullname = rs.getString("fullname");
            logged = true;
      }
  }
  catch(Exception ex)
  {
      System.out.println( ex.getMessage());
  }
  finally
  {
      Database.clean(con,ps);
  }
  return logged;
 } // end of login

 
  public String getUname() {
      return uname;
  }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

}
