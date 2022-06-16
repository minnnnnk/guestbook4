package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestBookVo;

@Controller
public class GuestBookController {
	
	//필드
	@Autowired
	private GuestService guestService;
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	
	
	//게스트리스트
	@RequestMapping(value="/list" ,method ={RequestMethod.GET,RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GuestBookController>list");
		
		//GuestBookDao gDao = new GuestBookDao();
		
		List<GuestBookVo> gList = guestService.getGuestList();
		
		model.addAttribute("gList",gList);
		
		return "addList";
	}
	//게스트 추가
	@RequestMapping(value="add", method= {RequestMethod.GET,RequestMethod.POST})
	public String add(@ModelAttribute GuestBookVo guestBookVo) {
		System.out.println("GuestBookController>add");
		
		
		//GuestBookDao gDao = new GuestBookDao();
		
		guestService.bookInsert(guestBookVo);
		
		return "redirect:/list";
		
	}
	//게스트 삭제폼
	@RequestMapping(value="/deleteForm" ,method= {RequestMethod.GET,RequestMethod.POST})
	public String deleteForm() {
		System.out.println("GuestBookController>deleteForm");
		return "deleteForm";
	}
	//게스트 삭제
	@RequestMapping(value="delete",method= {RequestMethod.GET,RequestMethod.POST})
	public String delete(@ModelAttribute GuestBookVo guestBookVo) {
		System.out.println("GuestBookController>delete");
		
		//GuestBookDao gDao = new GuestBookDao();
	
		int count = guestService.bookDelete(guestBookVo);
		System.out.println(count);
		
		return "redirect:/list";
	}
	
	
}
