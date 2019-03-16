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
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.entity.Player;
import com.cg.entity.Team;
import com.cg.entity.User;
import com.cg.service.PlayerService;
import com.cg.utils.PageUtils;

/**
 * @作者：曹刚
 * @时间：2019年3月14日
 */
@Controller
public class MainController {

	
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping("jsp/login.do")
	private String login(User user,Model model,HttpSession session) {
		
		User newuser = playerService.findUser(user);
		
		if(newuser==null) {
			
			model.addAttribute("error", "用户名或密码错误！");
			
		}else {
			
			session.setAttribute("user", newuser);
			
			return "redirect:list.do";
			
		}
		
		return "index";
		
	}
	
	@RequestMapping("jsp/list.do")
	private String list(String iname,String page,Model model) {
		
		System.out.println(iname);
		
		Integer count = playerService.findAllCount(iname);
		
		PageUtils pu = new PageUtils(3, count, page);
		
		List<Player> list = playerService.findAllPlayer(iname, pu);
		
		model.addAttribute("list", list);
		
		model.addAttribute("pu", pu);
		
		model.addAttribute("iname", iname);
		
		return "list";
		
	}
	
	@RequestMapping("jsp/getTeam.do")
	@ResponseBody
	private List<Team> getTeam() {
		
		List<Team> team = playerService.findAllTeam();
		
		return team;
	}
	
	@RequestMapping("jsp/add.do")
	private String add(Player player) {
		
		playerService.addOnePlayer(player);
		
		return "redirect:list.do";
	}
	
	@RequestMapping("jsp/toupdate.do")
	private String toupdate(String pid,Model model) {
		
		Player player = playerService.findOnePlayer(pid);
		
		model.addAttribute("command", player);
		
		List<Team> team = playerService.findAllTeam();
		
		model.addAttribute("team", team);
		
		return "update";
		
	}
	
	@RequestMapping("jsp/update.do")
	private String update(Player player) {
		
		playerService.changeOnePlayer(player);
		
		return "redirect:list.do";
	}
	
	@RequestMapping("jsp/delete.do")
	@ResponseBody
	private String delete(String pids) {
		
		Integer removePlayer = playerService.removePlayer(pids);
		
		if(removePlayer > 0) {
			
			return "yes";
			
		}else {
			
			return "no";
			
		}
	}
	
	@RequestMapping("jsp/findPlayer.do")
	@ResponseBody
	private String findPlayer(String pname) {
		
		System.out.println(pname);
		
		Player player = playerService.findPlayer(pname);
		
		if(player==null) {
			
			return "yes";
			
		}else {
			
			return "no";
			
		}
	}
	
	@RequestMapping("jsp/exit.do")
	private String exit(HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		
		if(user!=null) {
			
			session.removeAttribute("user");
			
			session.invalidate();
			
		}
		
		return "index";
		
	}
	
	
}
