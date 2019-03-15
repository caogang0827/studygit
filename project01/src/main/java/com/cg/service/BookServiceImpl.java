/**
 * 
 */
package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Book;
import com.cg.entity.Type;
import com.cg.entity.User;
import com.cg.mapper.BookDao;

/**
 * @作者：曹刚
 * @时间：2019年3月7日
 */
@Transactional
@Service
public class BookServiceImpl implements BookService {

	
	@Autowired
	private BookDao bookDao;
	
	
	public User findOneUser(User user) {
		// TODO Auto-generated method stub
		return bookDao.selectOneUser(user);
	}

	
	public List<Book> findAllBook(String iname, String tid) {
		// TODO Auto-generated method stub
		return bookDao.selectAllBook(iname, tid);
	}

	
	public Book findOneBook(String bid) {
		// TODO Auto-generated method stub
		return bookDao.selectOneBook(bid);
	}

	
	public List<Type> findAllType() {
		// TODO Auto-generated method stub
		return bookDao.selectAllType();
	}

	
	public Integer addOneBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.insertOneBook(book);
	}

	
	public Integer changeOneBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.updateOneBook(book);
	}

	
	public Integer removeBook(String bids) {
		// TODO Auto-generated method stub
		return bookDao.deleteBook(bids);
	}

	
	public List<Book> findSomeBook(String uid) {
		// TODO Auto-generated method stub
		return bookDao.selectSomeBook(uid);
	}

	
	public Integer removeMiddle(Integer uid) {
		// TODO Auto-generated method stub
		return bookDao.deleteMiddle(uid);
	}

	
	public Integer addLikeBook(Integer uid, String[] split) {
		// TODO Auto-generated method stub
		return bookDao.insertLikeBook(uid,split);
	}

	
	public Integer removeMiddleBook(String bid) {
		// TODO Auto-generated method stub
		return bookDao.deleteMiddleBook(bid);
	}

}
