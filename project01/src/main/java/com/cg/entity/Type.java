/**
 * 
 */
package com.cg.entity;

import java.util.List;

/**
 * @作者：曹刚
 * @时间：2019年3月7日
 */
public class Type {

	
	private Integer tid;
	private String tname;
	
	private List<Book> book;

	public Type() {
		super();
	}

	public Type(Integer tid, String tname, List<Book> book) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.book = book;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Type [tid=" + tid + ", tname=" + tname + "]";
	}
	
	
}
