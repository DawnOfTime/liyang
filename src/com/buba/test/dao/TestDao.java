package com.buba.test.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.buba.test.comm.HibernateSessionFactory;
import com.buba.test.pojo.Book;
import com.buba.test.pojo.PageBean;

public class TestDao {

	public PageBean querys(Book book, PageBean bean) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=session.beginTransaction();
		String hql = "from Book where 1 = 1 ";
		String hql2 = "select count(*) from Book where 1 = 1 ";
		if(null!=book){
			if(null!=book.getSm() && !book.getSm().equals("")){
				hql += " and sm = '"+book.getSm()+"'";
				hql2 += " and sm = '"+book.getSm()+"'";
			}
			if(null!=book.getCbs() && !book.getCbs().equals("")){
				hql += " and cbs = '"+book.getCbs()+"'";
				hql2 += " and cbs = '"+book.getCbs()+"'";
			}
			if(null!=book.getZz() && !book.getZz().equals("")){
				hql += " and zz = '"+book.getZz()+"'";
				hql2 += " and zz = '"+book.getZz()+"'";
			}
			if(null!=book.getCbsj() && !book.getCbsj().equals("")){
				hql += " and cbsj = '"+book.getCbsj()+"'";
				hql2 += " and cbsj = '"+book.getCbsj()+"'";
			}
		}
		long num = (Long) session.createQuery(hql2).uniqueResult();
		bean.setTotalrecord((int) num);
		List list = session.createQuery(hql)
					.setFirstResult((bean.getPagecode()-1)*bean.getPagesize())
					.setMaxResults(bean.getPagesize())
					.list();
		tx.commit();
		session.close();
		bean.setBeanList(list);
		return bean;
	}
}
