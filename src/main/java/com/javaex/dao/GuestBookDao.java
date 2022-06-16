package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;
@Repository
public class GuestBookDao {

	@Autowired
	private SqlSession sqlssion;
	
	//리스트
	public List<GuestBookVo> getGuestList() {
		
		List<GuestBookVo> gList= sqlssion.selectList("guestbook.getGuestList");
		
		return gList;
	}
	
	
	//게스트 추가
	public int bookInsert(GuestBookVo guestVo) {
	
		int count = sqlssion.insert("guestbook.bookInsert", guestVo);
		
		return count;
	}
	
	//게스트 삭제
	public int bookDelete(GuestBookVo guestBookVo) {
		
		int count = sqlssion.delete("guestbook.bookDelete",guestBookVo);
		
		return count;
	}
	
	//한사람 정보
	public GuestBookVo getGuest(int no) {
		
		GuestBookVo gVo = sqlssion.selectOne("guestbook.getGuest", no);
		
		return gVo;
	}
	

}
	
	


