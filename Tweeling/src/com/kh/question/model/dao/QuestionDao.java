package com.kh.question.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.PageInfo;
import com.kh.product.model.vo.PAttachment;
import com.kh.question.model.vo.QAttachment;
import com.kh.question.model.vo.QReply;
import com.kh.question.model.vo.Question;

public class QuestionDao {
    private Properties prop = new Properties();
    
    public QuestionDao() {
        String filePath = QuestionDao.class.getResource("/db/sql/question-mapper.xml").getPath();
        try {
            prop.loadFromXML(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int selectListCount(Connection conn, int userNo) {
        int result = 0;
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectListCount");
        
        PAttachment pa= null;
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, userNo);
            
            rset = pstmt.executeQuery();
            
            if (rset.next()) { // 커서가 가리킬 위치가 있는지 (조회결과가 있다면)
                result = rset.getInt("COUNT");
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
//        System.out.println("Order :: DAO :: selectListCount :: "+ result);
        return result;
    }

    //사용자 요청 페이지 목록 메소드
    public ArrayList<Question> selectList(Connection conn, int userNo, PageInfo pi) {
        
        //select 문 
        ArrayList<Question> qlist = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        String sql = prop.getProperty("selectList");
        
        int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit()+1;
        int endRow = pi.getCurrentPage() * pi.getBoardLimit();
        
//        System.out.println("startRow : "+startRow);
//        System.out.println("endRow : "+endRow);
//        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, userNo);
            pstmt.setInt(2, startRow);
            pstmt.setInt(3, endRow);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                qlist.add(new Question(rset.getInt("RNUM")
                                  ,rset.getInt("QUESTION_NO")
                                  ,rset.getInt("QUESTION_WRITER")
                                  ,rset.getInt("QUESTION_TYPE")
                                  ,rset.getString("QUESTION_TITLE")
                                  ,rset.getString("QUESTION_CONTENT")
                                  ,rset.getDate("CREATE_DATE")
                                  ,rset.getString("STATUS")
                                  )
                        );
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
//        System.out.println("QuestionDao:: selectList:: qlist : " + qlist);
        return qlist;
    }

    public int insertQuestion(Connection conn, Question qst) {
        int result = 0;
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("insertQuestion");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, qst.getQuestionWriter());
            pstmt.setInt(2, qst.getQuestionType());
            pstmt.setString(3, qst.getQuestionTitle());
            pstmt.setString(4, qst.getQuestionContent());
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }

    public int insertAttachment(Connection conn, QAttachment qat) {
        int result = 0;
        
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("insertAttachment");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, qat.getOriginName());
            pstmt.setString(2, qat.getFilePath());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public Question selectQuestion(Connection conn, int qno) {
        Question q = null;
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        String sql = prop.getProperty("selectQuestion");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,qno);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                q = new Question(rset.getInt("QUESTION_NO")
                            ,rset.getInt("QUESTION_WRITER")
                            ,rset.getInt("QUESTION_TYPE")
                            ,rset.getString("QUESTION_TITLE")
                            ,rset.getString("QUESTION_CONTENT")
                            ,rset.getDate("CREATE_DATE")
                            ,rset.getString("STATUS")
                            );
            }        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
//        System.out.println("selectBoard :: b : " + b);
        return q;
    }

    public QAttachment selectAttachment(Connection conn, int qno) {
        QAttachment qat = null;
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        String sql = prop.getProperty("selectAttachment");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, qno);
            
            rset = pstmt.executeQuery();
            
           // FILE_NO, REF_BNO, ORIGIN_NAME, CHANGE_NAME, FILE_PATH, UPLOAD_DATE, FILE_LEVEL
            while(rset.next()) {
                qat = new QAttachment(rset.getInt("FILE_NO")
                                 , rset.getInt("QUESTION_NO")
                                 , rset.getString("ORIGIN_NAME")
                                 , rset.getString("FILE_PATH")
                                 , rset.getInt("FILE_LEVEL")
                        );
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return qat;
    }

    public int updateQuestion(Connection conn, Question q) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("updateQuestion");
//        System.out.println("넣기 전 : q :"+q);
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, q.getQuestionType());
            pstmt.setString(2, q.getQuestionTitle());
            pstmt.setString(3, q.getQuestionContent());
            pstmt.setInt(4, q.getQuestionNo());
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }

    public int updateAttachment(Connection conn, QAttachment qat) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("updateAttachment");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, qat.getOriginName());
            pstmt.setString(2, qat.getFilePath());
            pstmt.setInt(3, qat.getFileNo());
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public int insertNewAttachment(Connection conn, QAttachment qat) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("insertNewAttachment");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, qat.getQuestionNo());
            pstmt.setString(2, qat.getOriginName());
            pstmt.setString(3, qat.getFilePath());
            
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public int deleteQuestion(Connection conn, int questionNo) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("deleteQuestion");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, questionNo);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
        }
//        System.out.println("delete DAO result : "+result);
        return result;
    }

    public ArrayList<QReply> selectReplyList(Connection conn, int qno) {
        ArrayList<QReply> list = new ArrayList<>();
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectReplyList");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, qno);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                list.add(new QReply(rset.getInt("QUESTION_REPLY_NO")
                                  ,rset.getString("QUESTION_REPLY_CONTENT")
                                  ,rset.getString("USER_ID")
                                  ,rset.getDate("CREATE_DATE")));
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return list;
    }
    
    public int insertReply(Connection conn, QReply r) {
        
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("insertReply");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, r.getReplyContent());
            pstmt.setInt(2, r.getRefQno());
            pstmt.setInt(3, Integer.parseInt(r.getReplyWriter()));
            
            result = pstmt.executeUpdate();
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }

        public int deleteReply(Connection conn, int rno) {
            int result = 0;
            PreparedStatement pstmt = null;
            String sql = prop.getProperty("deleteReply");
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, rno);
                result = pstmt.executeUpdate();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally {
                JDBCTemplate.close(pstmt);
            }
//            System.out.println("deleteReply DAO result : "+result);
            return result;
        }
}
