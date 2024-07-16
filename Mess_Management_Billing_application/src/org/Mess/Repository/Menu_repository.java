package org.Mess.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.Database.DB_config;
import org.Mess.Model.Menu_model;

public class Menu_repository extends DB_config {
	List<Menu_model> list = new ArrayList<Menu_model>();

	public boolean isAddMenu(Menu_model mmodel) throws SQLException {
		try {
			stmt = conn.prepareStatement("insert into menu values('0',?,?)");
			stmt.setString(1, mmodel.getMenuname());
			stmt.setInt(2, mmodel.getPrice());
			int val = stmt.executeUpdate();
			return val > 0 ? true : false;
		} catch (Exception exp) {
			System.out.println("Exception is:" + exp);
			return false;
		}

	}

	public List<Menu_model> Viewmenu() throws SQLException {

		try {
			stmt = conn.prepareStatement("select *from menu");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Menu_model mmodel = new Menu_model();
				mmodel.setMenuid(rs.getInt(1));
				mmodel.setMenuname(rs.getString(2));
				mmodel.setPrice(rs.getInt(3));
				list.add(mmodel);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception exp) {
			System.out.println("Exception is:" + exp);

		}
		return null;

	}

	public boolean DeleteMenu(Menu_model mmodel) {
		try {
			stmt = conn.prepareStatement("delete from menu where menuid=?");
			stmt.setInt(1, mmodel.getMenuid());
			int val = stmt.executeUpdate();
			return val > 0 ? true : false;
		} catch (Exception exp) {
			System.out.println("Exception is:" + exp);
			return false;
		}
	}

	public boolean UpdateMenu(Menu_model mmodel)
	{
		try {
			stmt = conn.prepareStatement("update menu set menuname=?, Price=? where menuid=?");
			stmt.setString(1, mmodel.getMenuname());
			stmt.setInt(2, mmodel.getPrice());
			stmt.setInt(3, mmodel.getMenuid());
			int val = stmt.executeUpdate();
			return val > 0 ? true : false;
		} catch (Exception exp) {
			System.out.println("Exception is:" + exp);
		}
		return false;
	}
	
    public int Checkmenu(Menu_model model)
    {
    	try
    	{
    		  stmt=conn.prepareStatement("select price from menu where menuname=? or  menuname=?");
    		  stmt.setString(1,model.getMenuname());
    		  stmt.setString(2,model.getMenuname());
    		  rs=stmt.executeQuery();
    		  if(rs.next())
    		  {
    			  return rs.getInt(1);
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
	

     
	}



