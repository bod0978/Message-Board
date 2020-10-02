package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public interface implDao {
	void add(Object o);
	
	void delete(Object o);
	
	void update(Object o);
	
	List query();
	
	
	public static Session getSe() {
		Configuration conn = new Configuration().configure();
		
		SessionFactory sf = conn.buildSessionFactory();
		
		Session se = sf.openSession();
		
		return se;
	}
}
