package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestVo;

@Service
public class GuestbookService {

	@Autowired
	private GuestbookDao guestbookDao;
	
	//전체 리스트
	public List<GuestVo> exeList(){
		System.out.println("GuestbookService.exeList()");
		List<GuestVo> guestList = guestbookDao.guestbookList();
		return guestList;
	}
	
	//등록
	public int exeInsert(GuestVo guestVo) {
		
		return guestbookDao.guestInsert(guestVo);
	}
	
	//삭제
	public int exeDelete(GuestVo guestVo) {
		
		return guestbookDao.guestDelete(guestVo);
	}
}
