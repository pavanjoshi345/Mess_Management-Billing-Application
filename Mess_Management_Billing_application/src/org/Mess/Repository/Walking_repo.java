package org.Mess.Repository;
import java.sql.ResultSet;
import java.util.*;
import org.Database.DB_config;
import org.Mess.Model.Walking_model;
public class Walking_repo extends DB_config
{
    List<Walking_model> list=new ArrayList<Walking_model>();
   public boolean isAddCustomer(Walking_model model)
   {
	   try
	   {
		   stmt=conn.prepareStatement("insert into walking values('0',?) ");
		   stmt.setString(1, model.getName());
		   int val=stmt.executeUpdate();
		   return val>0?true:false;
	   }
	   catch(Exception exp)
	   {
		   System.out.println("Exception is:"+exp);
		   return false;
	   }
   }
   
   public List<Walking_model>WalkingVisit()
   {
	   try
	   {
		   stmt=conn.prepareStatement("select wcid from walking");
		   rs=stmt.executeQuery();
		   while(rs.next())
		   {
			   Walking_model model=new Walking_model();
			   model.setWcid(rs.getInt(1));
			   list.add(model);
		   }
		   return list.size()>0?list:null;
	   }
	   catch(Exception exp)
	   {
		   System.out.println("Exception is:"+exp);
		   return null;
	   }
   }
  
   public boolean isAddAmt(Walking_model model)
   {
      try
      {
    	  stmt=conn.prepareStatement(" update walking set bill=? where wcid=8 ");
    	  stmt.setInt(1, model.getBill());
    	  int value=stmt.executeUpdate();
    	  return value>0?true:false;
      }
      catch(Exception exp)
      {
    	  System.out.println("Exception is:"+exp);
    	  return false;
      }
   }
	
}
