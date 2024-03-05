package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;
	
	//전체 리스트
	public List<GuestVo> guestbookList(){
		System.out.println("GuestbookDao.guestbookList()");
		List<GuestVo> guestList = sqlSession.selectList("guestbook.list");
		return guestList;
	}
	
	//등록
	public int guestInsert(GuestVo guestVo) {
		
		return sqlSession.insert("guestbook.insert", guestVo);
	}
	
	//삭제
	public int guestDelete(GuestVo guestVo) {
		return sqlSession.delete("guestbook.delete", guestVo);
	}
}
