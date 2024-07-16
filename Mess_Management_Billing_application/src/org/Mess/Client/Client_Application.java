package org.Mess.Client;
import java.util.*;
import org.Mess.Model.CustomerModel;
import org.Mess.Model.Menu_model;
import org.Mess.Model.Walking_model;
import org.Mess.Service.Customer_service;
import org.Mess.Service.Menu_service;
import org.Mess.Service.Walking_service;

import java.sql.*;
public class Client_Application {

	public static void main(String[] args) throws SQLException 

	{
		Scanner sc=new Scanner(System.in);
	  System.out.println(":---------------------------******------------------------------:");
	  System.out.println("\t WELCOME TO MESS MANAGEMENT & BELLING APPLICATION");
	  System.out.println(":---------------------------******------------------------------:");
	  int sum=0;
	  int cng=0;
	  String username;
	  int qty;
	  String menuname;
	  int choice;
	  String email;
	  String custpass;
	  String password;
	  int cc=0;
	  int ch;
	  int qtycount=1;
	 
	  Walking_model wcmodel=new Walking_model();
      Walking_service wcserv=new Walking_service();
	  Menu_service mserv=new Menu_service();
	  Menu_model menum=new Menu_model();
	  Customer_service scc=new Customer_service();
	  CustomerModel model=new CustomerModel();
	  List<Menu_model> list=new ArrayList<Menu_model>();
	  ArrayList<Integer> al = new ArrayList<>();
	  do
	  {
		 int war;
		
		 System.out.println("Enter the your choice....");
		 System.out.println("=====================================================================");
		 System.out.println("\t1: Login Admin");
		 System.out.println("\t2: Add Monthly Customer");
		 System.out.println("\t3: For Eating Customer...");
		 System.out.println("\t4: View All Regular Customer Data");
		 System.out.println("\t5: Show Upcoming Menus");
		 System.out.println("\t6: Calculate Monthly Bill of Monthly Candidate");
		 System.out.println("\t7: Find Visitors In Monthly");
		 System.out.println("\t8: Find Total Bill of Monthly Members");
		 System.out.println("\t9: Find Total Bill of Walking Customers");
		 System.out.println("\t10: Exit");
		 System.out.println("=====================================================================");
		 ch=sc.nextInt();
		 System.out.println("Your Choice is:"+ch);
		switch(ch)
		 {
		    
		 case 1:
			 System.out.println("Enter Username and Password of Admin");
			   sc.nextLine();
			  username=sc.nextLine();
			  password=sc.nextLine();
			  if(username.equals("messadmin") && password.equals("admin9900"))
			  {
				  System.out.println("Login Successfully..........");
			    do
			    {
				   int choice3;
				   System.out.println("Enter the your choice");
				   System.out.println("1: Add new Menus");
				   System.out.println("2: View All Menus");
				   System.out.println("3: Delete Menus");
				   System.out.println("4: Update Menus");
				   System.out.println("0 For Back");
				   choice=sc.nextInt();
				   System.out.println("Your Choice is :"+choice);
				   switch(choice)
				   {
				     case 1:
					 int menuid;
					 String name;
					 int price;
					 System.out.println("Enter the  Name of Menu and Price of per Plate");
					 sc.nextLine();
					 name=sc.nextLine();
					 price=sc.nextInt();
					 menum.setMenuname(name);
					 menum.setPrice(price);
					 boolean b=mserv.isAddMenu(menum);
					 if(b)
					 {
						 System.out.println("Menus Add Successfully.......");
					 }
					 else
					 {
						 System.out.println("Menuse Not Add Success..");
					 }
					 break;
					
				     case 2:
				      List<Menu_model> list1=mserv.Viewmenu();
				      System.out.println("===============================================================");
				      System.out.println("\tMenuId\t\t Name\t\t\tPrice");
				      System.out.println("================================================================");
				      for(Menu_model ms:list1)
				      {
				    	  System.out.println("\t"+ms.getMenuid()+"\t\t"+ms.getMenuname()+"\t\t"+ms.getPrice());
				      }
				      System.out.println("================================================================");
				      break;
				     case 3:
				      int mid;
				     System.out.println("Enter the MenuId for Delete menu");
				     mid=sc.nextInt();
				     menum.setMenuid(mid);
				     b=mserv.DeleteMenu(menum);
				     if(b)
				     {
				    	 System.out.println("Menus Deleted Successfully..........");
				     }
				     else
				     {
				    	 System.out.println("Menus Not Deleted Successfully.........");
				     }
				     	 
				   break;
				  
		 case 4:
				    int uid;
				    System.out.println("Enter the menuid where we have update data");
				    uid=sc.nextInt();
				    sc.nextLine();
				    String mname;
				    int uprice;
				    System.out.println("Enter the new Menu name and new Price for Update");
				    mname=sc.nextLine();
				    uprice=sc.nextInt();
				    menum.setMenuid(uid);
				    menum.setMenuname(mname);
				    menum.setPrice(uprice);
				    b=mserv.UpdateMenu(menum);
				    if(b)
				    {
				    	System.out.println("Menu Update Successfully.........");
				    }
				    else
				    {
				    	System.out.println("Menu Not Update Some Problem");
				    }
				   
				     case 0:
						   break;
				   default:
					     System.out.println("Wrong Choice");
					     break;
				   
				   }
		
			    }while(choice!=0);
			    
			  }
			  else
			  {
				  
				  System.out.println("INVALIDE LOGIN ...\nYou are not Admin of this mess");
			  }
			  break;
		
		 case 2: 
			    CustomerModel cmodel=new CustomerModel();
			    System.out.println("Are You Member of Our Mess then press yes");
			    sc.nextLine();
			    String ms=sc.nextLine();
			    if(ms.equals("yes") || ms.equals("YES"))
			    {
			    int count=0;
			    System.out.println("Enter the your Email ID and Password for LOGIN");
			    sc.nextLine();
			    email=sc.nextLine();
			    custpass=sc.nextLine();
			    //CustomerModel model=new CustomerModel();
			    model.setEmail(email);
			    model.setCpassword(custpass);
			    int d=scc.Login(model);
			    if(d!=0)
			    {
			    	System.out.println("Login Successfully......");
			    	System.out.println("Do you want to take Launch or Dinner Now then press yes or YES");
			    	String etn=sc.nextLine();
			    	if(etn.equals("yes") || etn.equals("YES"))
			    	{
			    		count++;
			    	}
			    	else
			    	{
			    		count--;
			    	}
			    }
			  }
			    else
			    {
			    	//System.out.println(" INVALIDE LOGIN Please Register After......");
		            System.out.println("Do you want to Register the mess then press yes");
      	           //sc.nextLine();
		        String check=sc.nextLine();
		        if(check.equals("yes") || check.equals("YES"))
		        {
		            System.out.println("Enter the your FullName, Mobile, Email,Advance Amount , How many time to Mess and password");
		            String custname=sc.nextLine();
		            String mob=sc.nextLine();
		            email=sc.nextLine();
		            int amt=sc.nextInt();
		            int htim=sc.nextInt();
		            sc.nextLine();
		            custpass=sc.nextLine();
		            cmodel.setCustomername(custname);
		            cmodel.setMob(mob);
		            cmodel.setEmail(email);
		            cmodel.setDeposit(amt);
		            cmodel.setHtime(htim);
		            cmodel.setCpassword(custpass);
		            boolean b=scc.isAddCustomer(cmodel);
		            if(b)
		            {
		            	System.out.println("Admission Successfully........");
		            }
		            else
		            {
		            	System.out.println("Admission Not Successully......");
		            }
		        }
		        else
		        {
		        System.out.println("Its OK..");
		        }
		      
			    } 
			    break;
		 
		 case 3:
			     
			         int chc;
			         ArrayList<Integer>abc=new ArrayList<Integer>();
			        
			         do
			         {
			        	 
			        	 System.out.println("Enter the your choice....");
			        	 System.out.println("1: Regular Customer");
			        	 System.out.println("2: Walking Customer");
			        	 System.out.println("0 FOR BACK");
			        	 chc=sc.nextInt();
			        	 switch(chc)
			        	 {
			        	 case 1:
			        		 int count=0;
			        		 int cm=0;
			        		  System.out.println("Are you member of this mess then press yes");
			        		  sc.nextLine();
			        		  String qt=sc.nextLine();
			        		  if(qt.equals("yes"))
			        		  {
			        			  System.out.println("Enter the your Email ID and Password for LOGIN");
			      			     //sc.nextLine();
			      			    email=sc.nextLine();
			      			    custpass=sc.nextLine();
			      			    model.setEmail(email);
			      			    model.setCpassword(custpass);
			      			    int d=scc.Login(model);
			      			    if(d!=0)
			      			    {
			      			    	System.out.println("Login Successfully......");
			      			    	int xyz;
			      			    do
			      			    {
			      			    	
			      			    	System.out.println("1: Lounch");
			      			    	System.out.println("2: Dinner");
			      			    	System.out.println("0 FOR Don't Eat");
			      			    	System.out.println("Enter the your choice Which time now you eating");
			      			        xyz=sc.nextInt();
			      			    	switch(xyz)
			      			    	{
			      			    	case 1:
			      			    		 count++;
			      			    		 //abc.add()
			      			    		 //System.out.println(count);
			      			    		 break;
			      			    	case 2:
			      			    		  cm++;
			      			    		  break;
			      			        default:
			      			        	System.out.println("Wrong Choice Please Enter the the correct choice...");
			      			    	}
			      			    	 
			      			    }while(xyz!=0);
			      			     cng=cng+count;
			      			     abc.add(cng);
			      			     System.out.println("Attendence is:"+cng);
			      			    }
			        			  
			        		  }
			        		 break;
			        		 
			        	 case 2:
			        		 Map<String,Integer> map=new LinkedHashMap<>();
				        	 int b;
				        	 ArrayList<Integer>a=new ArrayList<Integer>();
				        	 LinkedHashMap<Integer, Integer> mp=new LinkedHashMap<Integer, Integer>();
				        	 List<Menu_model> list1=mserv.Viewmenu();
				        	 ArrayList<Integer>all=new ArrayList<Integer>();
				        	 //int qt1[]=new int[10];
				        	 
						      System.out.println("Do you want eat the food then press yes");
						      sc.nextLine();
						      String chh=sc.nextLine();
						      if(chh.equals("yes"))
						      {
						    	  System.out.println("Enter the Name of the Customer");
						    	  String wcname=sc.nextLine();
						    	  wcmodel.setName(wcname);
						    	  boolean sk=wcserv.isAdCustomer(wcmodel);
						    	  if(sk)
						    	  {
						    		  //System.out.println("Customer Added Successfully......");
						    	  }
//						    	  else
//						    	  {
//						    		  System.out.println("Some Problem is there..........");
//						    	  }
						    	  qtycount++;
						    	  System.out.println("Menus Of This Week:");
						    	  System.out.println("===============================================================");
							      System.out.println("\tMenuId\t\t Name\t\t\tPrice");
							      System.out.println("================================================================");
							      for(Menu_model ms1:list1)
							      {
							    	  System.out.println("\t"+ms1.getMenuid()+"\t\t"+ms1.getMenuname()+"\t\t"+ms1.getPrice());
							      }
							   
							      System.out.println("================================================================");
							      String fsk=null;
							      do {
							    	  Menu_model model111=new Menu_model();
								      System.out.println("Enter the menu name and Quantity (No. of Plates)");
								      menuname=sc.nextLine();
								      qty=sc.nextInt();
								      al.add(qty);
								      qtycount++;
								      mp.put(qtycount,qty);
								      model111.setMenuname(menuname);
								      b=mserv.Checkmenu(model111);
								      a.add(b);
								     if(b!=0)
								     {
								    	  map.put(model111.getMenuname(),b);
									      cc=b*qty;
									      sum=sum+cc;
								     }
								     else
								     {
								    	System.out.println("This menu is Not Present....."); 
								     }
								      System.out.println("Do you want to Taken more foods?");
								      sc.nextLine();
								      fsk=sc.nextLine();
							      }while(fsk.equals("yes"));
							      
							      //System.out.println(qtycount);
							      System.out.println("Your Bill IS:-");
							      System.out.println("---------------------------------------------------------------------");
							      System.out.println("\tMenu Name\t\t     Quantity\t      Price\t\t Total Price");
							      System.out.println("---------------------------------------------------------------------");
							      Set<Map.Entry<String,Integer>> set=map.entrySet();

							      Set<Map.Entry<Integer,Integer>>set2=mp.entrySet();
							      int yy=0;
							      int x=0;
							      for (Map.Entry<String, Integer> en: set) 
							      {		
							    	System.out.println("\t"+en.getKey()+"\t\t\t     "+al.get(yy)+"  \t\t"+a.get(x)+"\t\t  "+(en.getValue()*al.get(yy)));
							    	  yy++;
							    	  x++;
								  }
							  	  a.clear();				    
							      al.clear();
							      System.out.println("   _______________________________________");
							      System.out.println("\tYOUR TOTAL BILL IS:"+sum);
							      wcmodel.setBill(sum);
							      boolean mb=wcserv.isAddAmt(wcmodel);
							      if(mb)
							      {
							    	  System.out.println("yes");
							      }
							      else
							      {
							    	  System.out.println("not....");
							      }
							      System.out.println("---------------------------------------------------------------------");     
				              }
						      else
						      {
						    	  System.out.println("Its OK");
						      }
						       break;
				       default:
				    	   System.out.println("Wrong Choice Please Enter the Correct Choice......");
			        	 }
			         }while(chc!=0);
		        	 
			       break;
		
		 case 4:
			  ArrayList<Integer>am=new ArrayList<Integer>();
			  //int add=0;
			 // int  jk=0;
			  int j=0;
			  System.out.println("========================================================================================================");
			  System.out.println("    Name\t\t\t   Mobile\t\t   Email\t\tDeposit\t     Time\t");
			  System.out.println("========================================================================================================");
			  List<CustomerModel>custmodel=scc.viewData();
			  for(CustomerModel cm:custmodel)
			  {
				  System.out.println("  "+cm.getCustomername()+"\t\t\t "+cm.getMob()+"\t\t"+cm.getEmail()+"\t\t  "+cm.getDeposit()+"\t\t"+cm.getHtime());
				  am.add(cm.getDeposit());
				  j++;
				
			  }
			  
			  System.out.println("=========================================================================================================");
//			  for(int i=0; i<j; i++)
//			  {
//				  // System.out.println(am.get(jk));
//				   add=add+am.get(jk);
//				   jk++;
//			  }
//			 System.out.println("SUM IS:"+add);
//			 
			  break;
	  
		 case 5 :
			 List<Menu_model> list111=mserv.Viewmenu();
		      System.out.println("===============================================================");
		      System.out.println("\tMenuId\t\t Name\t\t\tPrice");
		      System.out.println("================================================================");
		      for(Menu_model ms1:list111)
		      {
		    	  System.out.println("\t"+ms1.getMenuid()+"\t\t"+ms1.getMenuname()+"\t\t"+ms1.getPrice());
		      }
		      System.out.println("================================================================");
			  break;
    
		 case 6:
			 System.out.println("Enter the EmailId and Password of Regular Customer");
			 sc.nextLine();
			 String mail=sc.nextLine();
			 String pass=sc.nextLine();
			 CustomerModel md=new CustomerModel();
			 md.setEmail(mail);
			 md.setCpassword(pass);
			 List<CustomerModel> cust=scc.checkData(md);
			 if(cust!=null)
			 {
				 System.out.println("Your TotaL BILL of This Months:");
				 System.out.println("===============================================================================");
				 for(CustomerModel mdl:cust)
				 {
					 System.out.println("\tYour Name IS:  \t\t"+mdl.getCustomername());
					 System.out.println("\tYour Advance Amount:  \t"+mdl.getDeposit());
					 System.out.println("\tYour Total Time Mess:  \t"+mdl.getHtime());
					 //System.out.println("\tYour Total Attendence is:\t"+cng);
					 System.out.println("     __________________________________");
					 int amt=1500*mdl.getHtime();
					 System.out.println("\t Remaining Amount:  "+(amt-mdl.getDeposit()));
				 }
				 System.out.println("===============================================================================");
			 }
			 else
			 {
				 System.out.println("Wrong USERNAME & PASSWORD........!");
				 System.out.println("Your Are Not Member of This Mess...!!!");
			 }
			 
			 break;
		
		 case 7:
			 int fd;
			 do
			 {
				 System.out.println("Enter the your Choice...");
				 System.out.println("1: Find Regular Customer ");
				 System.out.println("2: Find Walking Customer ");
				 System.out.println("0 For Back");
				  fd=sc.nextInt();
				 switch(fd)
				 {
				 case 1:
					 int cpp=0;
					 List<CustomerModel>custmodel12=scc.viewData();
					  for(CustomerModel chap:custmodel12)
					  {
						  //System.out.println("  "+cm.getCustomername()+"\t\t\t "+cm.getMob()+"\t\t"+cm.getEmail()+"\t\t  "+cm.getDeposit()+"\t\t"+cm.getHtime());
						  cpp++;
					  }
					  System.out.println("____________________________________________________________________\n");
					  System.out.println("Total Regular Customer in This Month is :"+cpp+"\n");
					  System.out.println("____________________________________________________________________");
					 break;
				 case 2:
					   int mp=0;
					  List<Walking_model>lst=wcserv.WalkingVisit();
					  for(Walking_model m:lst)
					  {
						  //System.out.println(m.getWcid());
						  mp++;
					  }
					  System.out.println("____________________________________________________________________\n");
					  System.out.println("Total Walking Customer Visit in MONTH is :"+mp+"\n");
					  System.out.println("____________________________________________________________________");
				   break;
					  
				 }
			 }while(fd!=0);
			 
			 break;
		 case 8:
			 
			 
			 ArrayList<Integer>am1=new ArrayList<Integer>();
			 ArrayList<Integer>am2=new ArrayList<Integer>();
			  int add1=0;
			  int  jk1=0;
			  int j1=0;
			  int rs=0;
			  List<CustomerModel>custmodel1=scc.viewData();
			  
			  for(CustomerModel cm:custmodel1)
			  {
				  //System.out.println("  "+cm.getCustomername()+"\t\t\t "+cm.getMob()+"\t\t"+cm.getEmail()+"\t\t  "+cm.getDeposit()+"\t\t"+cm.getHtime());
				  am1.add(cm.getDeposit());
				  j1++;	
			  }
			  
			  for(CustomerModel cmp:custmodel1)
			  {
				 // System.out.println(cmp.getHtime());
				  am2.add(cmp.getHtime());
			  }
		     System.out.println("-----------------------------------------------------------------------------");
		     int skm=0;
			  for(int i=0; i<j1; i++)
			  {
				  // System.out.println(am.get(jk));
				   add1=add1+am1.get(jk1);
				   jk1++;
				   skm=skm+am2.get(rs);
				   rs++;
			  }
			  int amt=skm*1500;
			  int c=0;
				 List<CustomerModel>custm=scc.viewData();
				  for(CustomerModel cpm:custm)
				  {
					  //System.out.println("  "+cm.getCustomername()+"\t\t\t "+cm.getMob()+"\t\t"+cm.getEmail()+"\t\t  "+cm.getDeposit()+"\t\t"+cm.getHtime());
					  c++;
				  }
		     int div=c/2;
			 System.out.println("\tTotal Count of Customer is:"+div+"\n");
			 System.out.println("\tTotal Amount of This Month Is: "+amt+"\n");
			 System.out.println("\tTotal Taken Amount by Student Is : "+add1+"\n");
			
			 //System.out.println("\tTotal Time of Mess:"+skm+"\n");
			 if(div>=5 || div>=20)
			 {
				 System.out.println("\tProfit of Regular Customer is:"+(amt-7000)+"\n");
			 }
			 else if(div>=20 || div>=45)
			 {
				 System.out.println("\tProfit of Regular Customer is:"+(amt-15000)+"\n");
			 }
			 else
			 {
				 System.out.println("Don't Addmission.....");
			 }
			 System.out.println("\tTotal Remaining Amount of This Month is:"+(amt-add1)+"\n");
			System.out.println("---------------------------------------------------------------------------------");
			   break;
		
		 case 9:
			   
			   break;
			 
		 case 10:
			 System.out.println("!..............YOUR ARE EXITED FROM THIS APPLICATION...................");
			 System.exit(0);
			 break;
			 
	    default:
	    	 System.out.println("!!---------WRONG CHOICE-------!!");
		 }	
	
		 
	  }while(true);
	
	}
}
