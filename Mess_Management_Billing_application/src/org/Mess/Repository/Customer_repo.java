package org.Mess.Repository;
import org.Database.DB_config;
import org.Mess.Model.CustomerModel;
import org.Mess.Model.Menu_model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Customer_repo extends DB_config
{
	 List<CustomerModel>al=new ArrayList<CustomerModel>();
	
	  public boolean isAddCustomer(CustomerModel cmodel)
	  {
		 
		  try
		  {
				 stmt=conn.prepareStatement("insert into customer values('0',?,?,?,?,?,?)");
				 stmt.setString(1,cmodel.getCustomername());
				 stmt.setString(2,cmodel.getMob());
				 stmt.setString(3,cmodel.getEmail());
				 stmt.setInt(4, cmodel.getDeposit());
				 stmt.setInt(5,cmodel.getHtime());
				 stmt.setString(6,cmodel.getCpassword());
				 //System.out.println(cmodel.getHtime());
				 int val=stmt.executeUpdate();
				 return val>0?true:false;
	
		 }
		  catch(Exception exp)
		  {
			  System.out.println("Exception is:"+exp);
			  return false;
		  }		  
		  
	  }
	  
	  public List<CustomerModel> viewData()
	  {
		  try
		  {
			  stmt=conn.prepareStatement("select *from customer");
			  rs=stmt.executeQuery();
			  while(rs.next())
			  {
				  CustomerModel cmodel=new CustomerModel();
				  cmodel.setCustomerid(1);
				  cmodel.setCustomername(rs.getString(2));
				  cmodel.setMob(rs.getString(3));
				  cmodel.setCpassword(rs.getString(3));
				  cmodel.setDeposit(rs.getInt(5));
				  cmodel.setEmail(rs.getString(4));
				  cmodel.setHtime(rs.getInt(6));
				  cmodel.setCpassword(rs.getString(7));
				  al.add(cmodel);
			  }
			  return al.size()>0?al:null;
			     
		  }
		  catch(Exception exp)
		  {
			  System.out.println("Exception is:"+exp);
			  return null;
		  }
		    
	  }
	  
	 public int Login(CustomerModel model)
	 {
		 try
		 {
			 stmt=conn.prepareStatement("select *from customer where email=? and password=?");
			 stmt.setString(1,model.getEmail());
			 stmt.setString(2,model.getCpassword());
			 rs=stmt.executeQuery();
			 if(rs.next())
			 {
				 rs.getString(1);
				 rs.getString(2);
				 return 1;
			 }
			 else
			 {
				 return 0;
			 }
		 }
		 catch(Exception exp)
		 {
			 System.out.println("Exception is:"+exp);
			 
		 }
		return 0;
	 }
	 
	public List<CustomerModel> checkData(CustomerModel model)
	{
		try
		{
			List<CustomerModel>list=new ArrayList<CustomerModel>();
			stmt=conn.prepareStatement("select customername, deposit, htime from customer where email=? and password=?");
			CustomerModel ml=new CustomerModel();
			stmt.setString(1,model.getEmail());
			stmt.setString(2,model.getCpassword());
		    rs=stmt.executeQuery();
			if(rs.next())
			{ 
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getInt(2));
//				System.out.println(rs.getInt(3));
				model.setCustomername(rs.getString(1));
				model.setDeposit(rs.getInt(2));
				model.setHtime(rs.getInt(3));
				list.add(model);
				return list;
			}
			else
			{
				return null;
			}
			
		   
			
		}
		catch(Exception exp)
		{
			System.out.println("Exception is:"+exp);
			return null;
		}
		
	}
	 
	
    
	  
}
