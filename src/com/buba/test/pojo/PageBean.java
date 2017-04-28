package com.buba.test.pojo;

import java.util.List;

public class PageBean {
	private int pagecode;
	private int totalpage;
	private int totalrecord;
	private int pagesize=5;
	private List beanList;
	private String url;
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPagecode() {
		return pagecode;
	}
	public void setPagecode(int pagecode) {
		this.pagecode = pagecode;
	}
	public int getTotalpage() {
		totalpage=(totalrecord%pagesize==0)?(totalrecord/pagesize):((totalrecord/pagesize)+1);
		return totalpage;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}

	public List getBeanList() {
		return beanList;
	}
	public void setBeanList(List beanList) {
		this.beanList = beanList;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "PageBean [pagecode=" + pagecode + ", totalpage=" + totalpage
				+ ", totalrecord=" + totalrecord + ", pagesize=" + pagesize
				+ ", beanList=" + beanList + ", url=" + url + "]";
	}
}
