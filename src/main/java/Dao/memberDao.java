package Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.member;


public class memberDao implements implDao{

	public static void main(String[] args) {
		
		List l = new memberDao().logincheck("r2oot", "r781104");
		System.out.println(l.size());
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
		
		Transaction tt = se.beginTransaction();
		member m = (member)o;
		se.delete(m.getId());

		tt.commit();
		se.close();
		
	}

	@Override
	public void update(Object o) {
		Session se = implDao.getSe();
		
		Transaction tt = se.beginTransaction();
		member m = (member)o;
	
		se.update(m);
		tt.commit();
		se.close();
		
	}

	@Override
	public List query() {
		Session se = implDao.getSe();
		Query q = se.createQuery("from member " );
		List l = q.list();
		return l;
	}
	
	public List logincheck(String user,String password) {
		Session se = implDao.getSe();
		Query q = se.createQuery("from member where user = '"+user+"' and password='"+password+"'" );
		List l = q.list();
		return l;
	}
	
	public List checkuser(String user) {
		Session se = implDao.getSe();
		Query q = se.createQuery("from member where user = '"+user+"'" );
		List l = q.list();
		return l;
	}
	
	public List userloo(int id) {
		Session se = implDao.getSe();
		Query q = se.createQuery("from member where id = '"+id+"'" );
		List l = q.list();
		return l;
	}
}
