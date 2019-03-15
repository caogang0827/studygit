/**
 * 
 */
package com.cg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cg.entity.Book;
import com.cg.entity.Type;
import com.cg.entity.User;

/**
 * @作者：曹刚
 * @时间：2019年3月7日
 */
public interface BookDao {

	
	//登录
	public User selectOneUser(User user);
	
	//全查图书
	public List<Book> selectAllBook(@Param("iname")String iname,@Param("tid")String tid);
	
	//单查
	public Book selectOneBook(@Param("bid")String bid);
	
	//全查种类
	public List<Type> selectAllType();
	
	//添加
	public Integer insertOneBook(Book book);
	
	//修改
	public Integer updateOneBook(Book book);
	
	//删除
	public Integer deleteBook(@Param("bids")String bids);

	
	public List<Book> selectSomeBook(@Param("uid")String uid);


	public Integer deleteMiddle(@Param("uid")Integer uid);


	public Integer insertLikeBook(@Param("uid")Integer uid, @Param("split")String[] split);

	
	public Integer deleteMiddleBook(@Param("bid")String bid);
	
	
}
