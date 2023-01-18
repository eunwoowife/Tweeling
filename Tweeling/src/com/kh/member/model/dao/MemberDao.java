package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Coupon;
import com.kh.member.model.vo.Member;
import com.kh.product.model.vo.Product;

public class MemberDao {
    private Properties prop = new Properties();
    
    public MemberDao() {
        String filePath = MemberDao.class.getResource("/db/sql/member-mapper.xml").getPath();
        try {
            prop.loadFromXML(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
public Member loginMember(Connection conn, String userId, String userPwd) {
        
        Member m =null;
        ResultSet rset=null;
        PreparedStatement pstmt= null;
        
        String sql=prop.getProperty("LoginMember");
        
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, userPwd);
            
            rset=pstmt.executeQuery();
            
            if(rset.next()) {
                
                m= new Member(
                        rset.getInt("USER_NO")
                        ,rset.getString("USER_ID")
                        ,rset.getString("USER_PWD")
                        ,rset.getString("USER_NAME")
                        ,rset.getString("USER_NICKNAME")
                        ,rset.getString("USER_PHONE")
                        ,rset.getString("USER_EMAIL")
                        ,rset.getString("USER_GENDER")
                        ,rset.getString("USER_ADDRESS")
                        ,rset.getDate("USER_BDAY")
                        ,rset.getString("USER_BIAS")
                        ,rset.getDate("USER_ENROLLDATE")
                        ,rset.getInt("USER_POINT")
                        ,rset.getString("USER_STATUS")
                        ,rset.getString("ADMIN_STATUS")
                        );
            }
                        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(rset);
        }
        return m;
    }

    public int insertMember(Connection conn,Member m) {
    
        int result = 0; 
        
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("insertMember");
    
        try {
            pstmt=conn.prepareStatement(sql);
    
            
            pstmt.setString(1, m.getUserId());
            pstmt.setString(2, m.getUserPwd());
            pstmt.setString(3, m.getUserName());
            pstmt.setString(4, m.getUserNinkname());
            pstmt.setString(5, m.getPhone());
            pstmt.setString(6, m.getEmail());
            pstmt.setString(7, m.getGender());
            pstmt.setString(8, m.getAddress());
            pstmt.setDate(9, m.getUserBday());
            pstmt.setString(10, m.getUserBias());
        
            result=pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }
    
    public int idCheck(Connection conn, String checkId) {

        ResultSet rset = null;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("idCheck");
        int count = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, checkId);
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                count = rset.getInt("COUNT");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(rset);
        }
        
        return count;
    }
    
    
    public int nickCheck(Connection conn, String checkNick) {
        ResultSet rset = null;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("nickCheck");
        int count = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, checkNick);
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                count = rset.getInt("COUNT");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(rset);
        }
        
        return count;
    }
    

public String findMember(Connection conn, String userName, String email) {
	        
	        String m=null;
	        
	        PreparedStatement pstmt= null;
	        String sql=prop.getProperty("findId");
	        ResultSet rset=null;
	        System.out.println(email+"여기는 DAO");
	        
	        
	
	        try {
	            pstmt=conn.prepareStatement(sql);
	            pstmt.setString(1, userName);
	            pstmt.setString(2, email);
	            
	            rset=pstmt.executeQuery();
	   
	            if(rset.next()) {
	                m=(rset.getString("USER_ID"));
	                  
	            }
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally {
	            JDBCTemplate.close(rset);
	            JDBCTemplate.close(pstmt);
	        }
	                
	        System.out.println(m);
	        return m;
	    }

    public int updateMember(Connection conn,Member m1) {
        
        int result = 0; 
        
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("updateMember");
        
    
    
        try {
            pstmt=conn.prepareStatement(sql);
            
            pstmt.setString(1, m1.getUserNinkname());
            pstmt.setString(2, m1.getUserPwd());
            pstmt.setString(3, m1.getAddress());
            pstmt.setString(4, m1.getEmail());
            pstmt.setString(5, m1.getPhone());
            pstmt.setString(6, m1.getUserBias());
            pstmt.setString(7, m1.getUserId());
            pstmt.setString(8,m1.getUserId());
        
        
            result=pstmt.executeUpdate();
          
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
        }
        
        
        return result;
    }





    //회원 탈퇴
    public int deleteMember(Connection conn,String userId,String userPwd) {
        //delete구문으로 삭제해도 되지만 상태값을 변경시켜서(update) 탈퇴처리하기 
        
        int result = 0;
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("deleteMember");
    
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, userPwd);
            
            result = pstmt.executeUpdate();
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
        }
        
        return result;
        
    }



    // myPage start--------------------------------------
    public int orderCount(Connection conn, int userNo) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("orderCount");
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, userNo);
            
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                result = rset.getInt("COUNT");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }

    public int selectMileage(Connection conn, int userNo) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectMileage");
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, userNo);
            
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                result = rset.getInt("POINT");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }

    public int selectCouponNum(Connection conn, int userNo) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectCouponNum");
        int result = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, userNo);
            
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                result = rset.getInt("COUNT");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }
    
    public ArrayList<Product> selectWishList(Connection conn, int userNo) {
        ArrayList<Product> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectWishList");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, userNo);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                list.add(new Product(rset.getInt("PRODUCT_NO")
                                    ,rset.getString("PRODUCT_NAME")
                                    ,rset.getInt("PRODUCT_PRICE")
                                    ,rset.getString("TITLE_IMG"))
                        );
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
//        System.out.println("MEMDAO::selectWishList:: list : "+list);
        return list;
    }

    public ArrayList<Coupon> selectCouponList(Connection conn, int userNo) {
        ArrayList<Coupon> cList = new ArrayList<>();
        ResultSet rset = null;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("selectCouponList");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, userNo);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                cList.add(new Coupon(rset.getInt("COUPON_NO")
                                   , rset.getInt("USER_NO")
                                   , rset.getString("COUPON_NAME")
                                   , rset.getInt("COUPON_PERCENT")
                                   , rset.getString("COUPON_STATUS"))
                        );
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(rset);
        }
//        System.out.println("MemberDao::selectCouponList:: cList: "+cList);
        return cList;
    }

    public Member selectMember(Connection conn, int userNo) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectMember");
        Member m = null;
        
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, userNo);
            
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                m = new Member(rset.getInt("USER_NO")
                                        , rset.getString("USER_ID")
                                        , rset.getString("USER_PWD")
                                        , rset.getString("USER_NAME")
                                        , rset.getString("USER_NICKNAME")
                                        , rset.getString("USER_PHONE")
                                        , rset.getString("USER_EMAIL")
                                        , rset.getString("USER_GENDER")
                                        , rset.getString("USER_ADDRESS")
                                        , rset.getDate("USER_BDAY")
                                        , rset.getString("USER_BIAS")
                                        , rset.getDate("USER_ENROLLDATE")
                                        , rset.getInt("USER_POINT")
                                        , rset.getString("USER_STATUS")
                        );
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        
        return m;
    }
    
}
