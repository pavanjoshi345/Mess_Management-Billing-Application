package org.Mess.Service;
import java.util.*;

import org.Mess.Model.Menu_model;
import org.Mess.Repository.Menu_repository;
import java.sql.*;
public class Menu_service
{
	Menu_repository mrepo=new Menu_repository();
	Menu_model model=new Menu_model();
	public boolean isAddMenu(Menu_model mmodel) throws SQLException
	{
		return mrepo.isAddMenu(mmodel);
	}
	
	public List<Menu_model> Viewmenu() throws SQLException
	{
	    return mrepo.Viewmenu();
	}
	
	public boolean DeleteMenu(Menu_model mmodel)
	{
		return mrepo.DeleteMenu(mmodel);
	}
	
	public boolean UpdateMenu(Menu_model mmodel)
	{
		return mrepo.UpdateMenu(mmodel);
	}
	
	public int Checkmenu(Menu_model model)
	{ 
		return mrepo.Checkmenu(model);
	}
//
//    public List<Menu_model> menucheck()
//    {
//    return mrepo.menucheck();
//    }
//	
}
