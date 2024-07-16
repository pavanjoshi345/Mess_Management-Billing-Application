package org.Mess.Service;

import java.util.List;

import org.Mess.Model.CustomerModel;
import org.Mess.Repository.Customer_repo;

public class Customer_service 
{
	Customer_repo crepo=new Customer_repo();
    public boolean isAddCustomer(CustomerModel cmodel)
    {
    	return crepo.isAddCustomer(cmodel);
    }
    
    public List<CustomerModel>viewData()
    {
    	return crepo.viewData();
    }
    
    public int Login(CustomerModel model)
    {
    	return crepo.Login(model);
    }
 
    public List<CustomerModel>checkData(CustomerModel model)
    {
    	return crepo.checkData(model);
    }
    
    
   
}
