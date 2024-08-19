package com.tap.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tap.entity.Employee;


public class HibernateManager
{
	static Session session=null;
    static
    {
    	session = new Configuration().configure().buildSessionFactory().openSession();
    }
    
    public void add(Employee e)
    {
    	Transaction t=session.beginTransaction();
    	session.persist(e);
    	t.commit();
    }
    public Employee getUserById(int id)
    {
    	return session.get(Employee.class, id);
    	
    }
	public void updateEmployee(Employee e) {
		Transaction t=session.beginTransaction();
		session.update(e);
		session.getTransaction().commit();
		System.out.println("Data updated");
	}
	public void delete(int id) {
		Transaction t=session.beginTransaction();
		Employee e=session.get(Employee.class,id);
		if(e!=null)
		{
			session.delete(e);
			System.out.println("deleted");
		}
		else
		{
			System.out.println("no record");
		}
		session.getTransaction().commit();
		
		
	}
	
	public List<Employee> getAll()
	{
		String q="from Employee";
		 Query<Employee> query=session.createQuery(q);
		 List<Employee> list = query.list();
		 return list;
	}
}
