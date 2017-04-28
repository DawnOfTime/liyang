package com.buba.test.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.buba.test.pojo.Book;
import com.buba.test.pojo.PageBean;
import com.buba.test.service.TestService;
import com.opensymphony.xwork2.Action;

public class TestAction {
	HttpServletRequest request=ServletActionContext.getRequest();
	private TestService service = new TestService();
	private Book book;
	
	private PageBean pagebean;
	private String pagecode;
	
	
	public String querys() throws UnsupportedEncodingException{
		PageBean bean = new PageBean();
		bean.setPagecode((null!=pagecode&&!"".equals(pagecode.trim()))
				?Integer.parseInt(pagecode.trim()):1);
		bean.setUrl(getParameterUrl(request.getParameterMap(),request));
		PageBean pageBean = service.querys(book,bean);
		
		bean.setBeanList(pageBean.getBeanList());
		bean.setTotalrecord(pageBean.getTotalrecord());
		
		request.setAttribute("pageBean", bean);
		return Action.SUCCESS;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public PageBean getPagebean() {
		return pagebean;
	}
	public void setPagebean(PageBean pagebean) {
		this.pagebean = pagebean;
	}
	public String getPagecode() {
		return pagecode;
	}
	public void setPagecode(String pagecode) {
		this.pagecode = pagecode;
	}
	public String getParameterUrl(Map parameterMap,HttpServletRequest request) throws UnsupportedEncodingException{
		String url="";
		Set<String> set=parameterMap.keySet();
		for(String stuid : set){
			String [] arr=(String[])parameterMap.get(stuid);
			if(!"pagecode".equals(stuid)){
				if(!"".equals(url)){
					url+="&";
				}
				arr[0] = URLDecoder.decode(arr[0], "utf-8");
				url+=stuid+"="+arr[0];
			}
		}
		String s = request.getContextPath()+"/test/querys";
		return s+"?"+url;
	}
}
