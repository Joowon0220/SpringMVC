package com.mvc.upgrade;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardBiz biz;
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/list.do")
	public String list(Model model) {
		logger.info("select list");
		model.addAttribute("list", biz.selectList());
		
		return "list";
	}
	
	@RequestMapping(value = "/one.do")
	public String one(Model model, int myno) {
		logger.info("select one");
		logger.info(String.valueOf(myno));
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "one";
	}
	
	@RequestMapping(value = "/insertform.do")
	public String insertform() {
		return "insert";
	}
	
	@RequestMapping(value = "/insertres.do", method = RequestMethod.POST)
	public String insertRes(BoardDto dto) {
		logger.info("insert");
		
		int res = biz.insert(dto);
		
		if(res > 0) {
			return "redirect:list.do";
		} else {
			return "redirect:insertform.do";
		}
	}
	
	@RequestMapping(value = "/updateform.do")
	public String updateform(Model model, int myno) {
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "update";
	}
	
	@RequestMapping(value = "/updateres.do", method = RequestMethod.POST)
	public String updateRes(BoardDto dto) {
		logger.info("update");
		
		int res = biz.update(dto);
		
		if(res > 0) {
			return "redirect:list.do";
		} else {
			return "redirect:updateform.do";
		}
	}
	
	@RequestMapping(value = "delete.do")
	public String delete(int myno) {
		logger.info("delete");
		
		int res = biz.delete(myno);
		
		if(res > 0) {
			return "redirect:list.do";
		} else {
			return "redirect:list.do";
		}
	}
}
