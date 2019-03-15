/**
 * 
 */
package com.cg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.entity.Book;
import com.cg.entity.Type;
import com.cg.entity.User;
import com.cg.service.BookService;


/**
 * @作者：曹刚
 * @时间：2019年3月7日
 */
@Controller
public class MainController {

	
	@Autowired
	private BookService bookService;
	
	
	@RequestMapping("jsp/login.do")
	private String login(User user,HttpSession session,Model model) {
		
		User newuser = bookService.findOneUser(user);
				
		if(newuser==null) {
			
			model.addAttribute("error", "用户名或密码错误！");
			
			return "index";
			
		}else {
			
			session.setAttribute("user", newuser);
			
			session.setAttribute("uid", newuser.getUid());
			
			
			if("admin".equalsIgnoreCase(newuser.getUname())) {
				
				return "redirect:list1.do";
				
			}else{
				
				return "redirect:list2.do";
				
			}
		}
	}
	
	
	@RequestMapping("jsp/list1.do")
	private String list1(String tid,Model model,String iname) {
		
		System.out.println(iname);
		
		List<Type> type = bookService.findAllType();
		
		List<Book> list = bookService.findAllBook(iname, tid);
		
		model.addAttribute("type", type);
		
		model.addAttribute("list", list);
		
		model.addAttribute("tid", tid);
		
		return "list1";
	}
	
	
	@RequestMapping("jsp/list2.do")
	private String list2(String tid,Model model,String iname) {
		
		List<Type> type = bookService.findAllType();
				
		List<Book> list = bookService.findAllBook(iname, tid);

		model.addAttribute("type", type);
		
		model.addAttribute("list", list);
		
		model.addAttribute("tid", tid);
		
		return "list2";
	}
	
	@RequestMapping("jsp/likeBook.do")
	private String likeBook(String uid,Model model) {
		
		List<Book> list1 = bookService.findSomeBook(uid);
		
		String bid = "";
		
		if(list1.size()!=0) {
						
			for (Book book : list1) {
				
				bid+=","+book.getBid();
			}
			
			bid = bid.substring(1);
		
		}
					
		List<Book> list2 = bookService.findAllBook(null, null);
		
		model.addAttribute("list", list2);
				
		model.addAttribute("bid", bid);
		
		return "like";
		
	}
	
	@RequestMapping("jsp/choice.do")
	private String choice(String bid,HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		
		Integer uid = user.getUid();
		
		bookService.removeMiddle(uid);
		
		if(bid!=null) {
			
			String[] split = bid.split(",");
			
			bookService.addLikeBook(uid,split);
			
		}else {
			
			return "redirect:list2.do";
			
		}
		
		return "redirect:list2.do";
	}
	
	@RequestMapping("jsp/toadd.do")
	private String toadd(Model model) {
		
		List<Type> type = bookService.findAllType();
		
		model.addAttribute("type", type);
		
		return "add";
	}
	
	@RequestMapping("jsp/add.do")
	private String add(Book book) {
		
		bookService.addOneBook(book);
		
		return "redirect:list1.do";
	}
	
	@RequestMapping("jsp/delete.do")
	private String delete(String bid) {
		
		bookService.removeMiddleBook(bid);
		
		bookService.removeBook(bid);
		
		return "redirect:list1.do";
	}
	
	@RequestMapping("jsp/toupdate.do")
	private String toupdate(Model model,String bid) {
		
		Book book = bookService.findOneBook(bid);
		
		List<Type> type = bookService.findAllType();
		
		model.addAttribute("type", type);
		
		model.addAttribute("command", book);
		
		return "update";
	}
	
	@RequestMapping("jsp/update.do")
	private String update(Book book) {
		
		bookService.changeOneBook(book);
		
		return "redirect:list1.do";
	}
	
	@RequestMapping("jsp/exit.do")
	private String exit(HttpSession session){
		
		session.removeAttribute("user");
		
		session.invalidate();
		
		return "index";
	}
	
	
	
}
