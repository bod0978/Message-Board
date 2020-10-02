package Dao;

import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.bill;

public class billDao implements implDao{
	
	public static void main(String args[]) {
	
		bill b = new bill();
		b.setId(6);
		new billDao().delete(b);
		
	}
	
	@Override
	public void add(Object o) {
		Session se = implDao.getSe();
		Transaction tt = se.beginTransaction();
		se.save(o);
		tt.commit();
		se.close();
	}

	@Override
	public void delete(Object o) {
		Session se = implDao.getSe();
		
		Transaction tt= se.beginTransaction();
		
		bill b = (bill)o;
		
		se.delete(b);
		
		tt.commit();
		se.close();
	}

	@Override
	public void update(Object o) {
		Session se = implDao.getSe();
		
		Transaction tt= se.beginTransaction();
		bill b = (bill)o;
		se.update(b);
		tt.commit();
		se.close();
		
	}

	@Override
	public List query() {
		Session se = implDao.getSe();
		Query q = se.createQuery("from bill" );
		List l = q.list();
		return l;
	}
	
	public String queryall() {
		Session se = implDao.getSe();
		Query q = se.createQuery("from bill" );
		List l = q.list();
		String all = "";
		String tab ="";
		Object o [] = l.toArray();
		
		for(int i=0;i<o.length;i++) {
			bill b = (bill)o[i];
			
			if((b.getNote().length()) >= 8) {
				tab = b.getNote().subSequence(0, 8)+".....";
			}
			//all =all+ "<tr align=center ><td width=150>"+b.getCount()+"<td width=150>"+b.getName()+"<td >"+b.getNote();
			all = all+"<tr><td width=\""+150+"\" height=\""+20+"\">"+b.getId()+"<td width=\""+150+"\" height=\""+20+"\">"+b.getCount()+"<td width=\""+150+"\">"+b.getName()+"<td width=\""+400+"\">"+tab+"</td>";
			//b.getNote().subSequence(0, 10)+"</td>";
			
		}
		return all;
	}
	
	
	public Integer queryCount(String Count) {
		Session se = implDao.getSe();
		Query q = se.createQuery("from bill");
		List l = q.list();
		
		Object o [] = l.toArray();
		
		for(int i=0; i<o.length;i++) {
		bill b = (bill)o[i];
		
			if(b.getCount().equals(Count)) {
				return b.getId();
			}
		}
		return null;
	}
	
	public List queryId(Integer id) {
		Session se = implDao.getSe();
		Query q = se.createQuery("from bill where id = '"+id+"'");
		List l = q.list();

		return l;
	}
	
}
