package org.Mess.Service;

import java.util.List;

import org.Mess.Model.Walking_model;
import org.Mess.Repository.Walking_repo;

public class Walking_service 
{
	Walking_repo wrepo=new Walking_repo();
	public boolean isAdCustomer(Walking_model model)
	{
		return wrepo.isAddCustomer(model);
	}
	
	public List<Walking_model>WalkingVisit()
	{
		return wrepo.WalkingVisit();
	}
	
	public boolean isAddAmt(Walking_model model)
	{
		return wrepo.isAddAmt(model);
	}
}
