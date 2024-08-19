package com.tap.main;

import java.util.List;

import com.tap.entity.Employee;
import com.tap.manager.HibernateManager;
public class Launch 
{
   public static void main(String[] args)
   {
	 //  Employee e=new Employee(4,"nivi","analyst",45566);
	   HibernateManager hm=new HibernateManager();
	 //  hm.add(e);
	  // System.out.println("Success");
	  // System.out.println(hm.getUserById(4));
	   //hm.updateEmployee(e);
	   //hm.delete(9);
	   List<Employee>  emp=hm.getAll();
	   for(Employee e:emp)
	   {
		   System.out.println(e);
	   }
  }  
}
