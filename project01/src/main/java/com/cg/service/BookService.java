/**
 * 
 */
package com.cg.service;

import java.util.List;


import com.cg.entity.Book;
import com.cg.entity.Type;
import com.cg.entity.User;

/**
 * @作者：曹刚
 * @时间：2019年3月7日
 */
public interface BookService {

	
	//登录
	public User findOneUser(User user);
	
	//全查图书
	public List<Book> findAllBook(String iname,String tid);
	
	//单查
	public Book findOneBook(String bid);
	
	//全查种类
	public List<Type> findAllType();
	
	//添加
	public Integer addOneBook(Book book);
	
	//修改
	public Integer changeOneBook(Book book);
	
	//删除
	public Integer removeBook(String bids);

	
	public List<Book> findSomeBook(String uid);

	
	public Integer removeMiddle(Integer uid);

	
	public Integer addLikeBook(Integer uid, String[] split);

	
	public Integer removeMiddleBook(String bid);
	
}
