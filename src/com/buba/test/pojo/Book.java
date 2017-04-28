package com.buba.test.pojo;


public class Book {
	private Integer bh;
	private String sm;
	private String cbs;
	private String zz;
	private String cbsj;
	public Integer getBh() {
		return bh;
	}
	public void setBh(Integer bh) {
		this.bh = bh;
	}
	public String getSm() {
		return sm;
	}
	public void setSm(String sm) {
		this.sm = sm;
	}
	public String getCbs() {
		return cbs;
	}
	public void setCbs(String cbs) {
		this.cbs = cbs;
	}
	public String getZz() {
		return zz;
	}
	public void setZz(String zz) {
		this.zz = zz;
	}
	public String getCbsj() {
		return cbsj;
	}
	public void setCbsj(String cbsj) {
		this.cbsj = cbsj;
	}
	@Override
	public String toString() {
		return "Book [bh=" + bh + ", sm=" + sm + ", cbs=" + cbs + ", zz=" + zz
				+ ", cbsj=" + cbsj + "]";
	}
}
