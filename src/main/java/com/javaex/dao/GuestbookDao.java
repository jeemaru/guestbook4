package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.javaex.vo.GuestbookVo;

	public class GuestbookDao {
		
		@Autowired
		private SqlSession sqlSession;
		
		
		//방문자 1명 추가
		public int guestAdd(GuestbookVo guestbookVo) {
			System.out.println("GuestBookDao > guestAdd");
			int count = sqlSession.insert("guestbook.guestAdd",guestbookVo);
				
			return count;
		}
		
		//방문자 정보 1명 삭제하기
		public int guestDelete(int no) {
			int count = sqlSession.delete("guestbook.guestDelete", no);

			return count;
		}
		//방문자 전체목록 가져오기
		public List<GuestbookVo> guestSelect() {
			List<GuestbookVo> guestList = sqlSession.selectList("guestbook.selectList");
			
			return guestList;

		}
		
		// 방문자 한명만 정보가져오기
		public GuestbookVo getGuest(int no) {
			
			return sqlSession.selectOne("guestbook.getGuest", no);
		}
		
		public String guestPassword(int no) {
			
			return sqlSession.selectOne("guestbook.guestPassword", no);
		}


	}

