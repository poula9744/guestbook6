package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;
	
	//addlist
	@RequestMapping(value="/addlist",  method = { RequestMethod.GET, RequestMethod.POST })
	public String guestList(Model model){
		System.out.println("GuestbookController.guestList()");
		
		List<GuestVo> guestList = guestbookService.exeList();
		model.addAttribute("guestList", guestList);
		System.out.println(guestList);
		
		return "addList";
	}

	//등록
	@RequestMapping(value="/insert",  method = { RequestMethod.GET, RequestMethod.POST })
	public String guestInsert(@ModelAttribute GuestVo guestVo) {
		System.out.println("GuestbookController.guestInsert()");
		
		guestbookService.exeInsert(guestVo);
		
		return "redirect:/addlist";
	}
	
	//삭제폼
	@RequestMapping(value="/deleteform",  method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm() {
		System.out.println("GuestbookController.deleteForm()");
		
		return "deleteForm";
	}

	//삭제
	@RequestMapping(value="/delete",  method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute GuestVo guestVo) {
		System.out.println("GuestbookController.delete()");
		
		guestbookService.exeDelete(guestVo);
		
		return "redirect:/addlist";
	}
}
