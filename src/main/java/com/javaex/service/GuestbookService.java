package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	@Autowired
	private GuestbookDao guestbookDao;
	
public List<GuestbookVo> getGuestList(){
		
		List<GuestbookVo> guestList = guestbookDao.guestSelect();
		
		return guestList;
	}
	
	public int addGuest(GuestbookVo guestbookVo) {
		
		int count = guestbookDao.guestAdd(guestbookVo);
		
		return count;
	}
	
	public int guestDelete(int no) {
		
		int count = guestbookDao.guestDelete(no);
		
		return count;
	}
	
	public String guestPassword(int no) {
		
		String oraclePassword = guestbookDao.guestPassword(no);
		
		return oraclePassword;
	}
	
}
