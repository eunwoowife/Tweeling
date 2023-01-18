package com.kh.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Coupon;
import com.kh.member.model.vo.Member;
import com.kh.product.model.vo.Product;

public class MemberService {
    public Member loginMember(String userId,String userPwd) {
        Connection conn=JDBCTemplate.getConnection();
        
        Member m =new MemberDao().loginMember(conn, userId, userPwd);
        
        JDBCTemplate.close(conn);
    
        return m;
    }
    
    public int insertMember(Member m) {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = new MemberDao().insertMember(conn, m);

        if(result>0) {
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
        
        JDBCTemplate.close(conn);
        
        return result;
    }
    
    public int idCheck(String checkId) {
        Connection conn = JDBCTemplate.getConnection();
        
        int count = new MemberDao().idCheck(conn,checkId);
        
        JDBCTemplate.close(conn);
        
        return count;
    }
    
    public int nickCheck(String checkNick) {
    	 Connection conn = JDBCTemplate.getConnection();
         
         int count = new MemberDao().nickCheck(conn,checkNick);
         
         JDBCTemplate.close(conn);
         
         return count;
	}


    public String findMember(String userName, String email) {
        
   
        
        Connection conn = JDBCTemplate.getConnection();
        
        String m  =new MemberDao().findMember(conn,userName,email);
        
        JDBCTemplate.close(conn);
       
        
        return m;
        
        
    }
    
    //-- 11.16 추가

    public int updateMember(Member m1) {
        
        Connection conn = JDBCTemplate.getConnection();
        
        int result = new MemberDao().updateMember(conn, m1);
    
        if(result>0) {
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
        
        JDBCTemplate.close(conn);
       
        return result;
    }
    
    public int deleteMember(String userId, String userPwd) {
        
        Connection conn = JDBCTemplate.getConnection();
        
        int result = new MemberDao().deleteMember(conn,userId,userPwd);
        
        if(result>0) {
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
        
        JDBCTemplate.close(conn);
        
        return result;
    }
    
    // myPage start--------------------------------------
    public int orderCount(int userNo) {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = new MemberDao().orderCount(conn, userNo);
        
        JDBCTemplate.close(conn);
        
        return result;
    }

    public int selectMileage(int userNo) {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = new MemberDao().selectMileage(conn, userNo);
        
        JDBCTemplate.close(conn);
        
        return result;
    }

    public int selectCouponNum(int userNo) {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = new MemberDao().selectCouponNum(conn, userNo);
        
        JDBCTemplate.close(conn);
        
        return result;
    }
    
    public ArrayList<Product> selectWishList(int userNo) {
        Connection conn = JDBCTemplate.getConnection();
        
        ArrayList<Product> list = new MemberDao().selectWishList(conn, userNo);
        
        JDBCTemplate.close(conn);
        
        return list;
    }

    public ArrayList<Coupon> selectCouponList(int userNo) {
        Connection conn = JDBCTemplate.getConnection();
        
        ArrayList<Coupon> cList = new MemberDao().selectCouponList(conn, userNo);
        
        JDBCTemplate.close(conn);
        
        return cList;
    }

    public Member selectMember(int userNo) {
        Connection conn = JDBCTemplate.getConnection();
        
        Member m = new MemberDao().selectMember(conn, userNo);
        
        JDBCTemplate.close(conn);
        
        return m;
    }

	//-----------------------------------------------------------------

}
