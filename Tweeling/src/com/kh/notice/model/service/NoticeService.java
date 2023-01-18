package com.kh.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;

public class NoticeService {
	
	public ArrayList<Notice> selectNoticeList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Notice> list =new NoticeDao().selectNoticeList(conn);
		
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}

	public int insertNotice(String userNo, String title, String content) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().insertNotice(conn,userNo,title,content);
	
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	
	public Notice increaseCount(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().increaseCount(conn,noticeNo);
		Notice n = null;
		
		if(result>0) {
			JDBCTemplate.commit(conn);
			
			n = new NoticeDao().selectNotice(conn,noticeNo);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return n;
	}
	
	
	public Notice selectNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		Notice n = new NoticeDao().selectNotice(conn, noticeNo);
		
		JDBCTemplate.close(conn);
		
		return n;
	}
	
	
	
	public int updateNotice(int nno,String title,String content) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().updateNotice(conn,nno,title,content);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		
		return result;
		
	}
	
	
	public int deleteNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().deleteNotice(conn,noticeNo);
				
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	
	
	

}
