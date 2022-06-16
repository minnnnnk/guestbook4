package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Service
public class GuestService {
	
	//필드
	@Autowired
	private GuestBookDao guestBookDao;
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	public List<GuestBookVo> getGuestList() {
		
		List<GuestBookVo> gList = guestBookDao.getGuestList();
		
		return gList;
	}
	
	public int bookInsert(GuestBookVo guestBookVo) {
		
		int count = guestBookDao.bookInsert(guestBookVo);
		
		return count;
	}
	
	public int bookDelete(GuestBookVo guestBookVo) {
		
		int count = guestBookDao.bookDelete(guestBookVo);
		
		return count;
	}
}
