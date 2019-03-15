/**
 * 
 */
package com.cg.entity;

/**
 * @作者：曹刚
 * @时间：2019年3月7日
 */
public class Book {

	
	private Integer bid;
	private String bname;
	private String bauthor;
	private Integer bpopular;
	
	private Type type;

	public Book() {
		super();
	}

	public Book(Integer bid, String bname, String bauthor, Integer bpopular, Type type) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bauthor = bauthor;
		this.bpopular = bpopular;
		this.type = type;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public Integer getBpopular() {
		return bpopular;
	}

	public void setBpopular(Integer bpopular) {
		this.bpopular = bpopular;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", bauthor=" + bauthor + ", bpopular=" + bpopular + ", type="
				+ type + "]";
	}
	
	
}
