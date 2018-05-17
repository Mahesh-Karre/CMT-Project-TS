package cmt;
import java.sql.*;
public class Database {
  public final static String uname = "root";
  public final static String password = "root";
  public final static String driver="com.mysql.jdbc.Driver";
  public final static String url="jdbc:mysql://localhost:3306/cmt";
    
  public static Connection getConnection()
  {
   try
   {            
    Class.forName( driver);
    Connection con = DriverManager.getConnection(url,uname,password);
    return con;
   }
   catch(Exception ex)
   {
       System.out.println(ex.getMessage());
       return null;
   }
  }
  
  public static void clean(Connection con, Statement st)
  {
      try
      {
          st.close();
          con.close();
      }
      catch(Exception ex) {}
  }     
}