package com.buba.test.service;

import java.util.List;

import com.buba.test.dao.TestDao;
import com.buba.test.pojo.Book;
import com.buba.test.pojo.PageBean;

public class TestService {
	private TestDao dao = new TestDao();
	public PageBean querys(Book book, PageBean bean) {
		return dao.querys(book,bean);
	}
}
