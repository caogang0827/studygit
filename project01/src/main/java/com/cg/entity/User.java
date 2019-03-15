/**
 * 
 */
package com.cg.entity;

/**
 * @作者：曹刚
 * @时间：2019年3月7日
 */
public class User {

	
	private Integer uid;
	private String uname;
	private String pwd;
	
	public User() {
		super();
	}
	public User(Integer uid, String uname, String pwd) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.pwd = pwd;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", pwd=" + pwd + "]";
	}
	
	
}
