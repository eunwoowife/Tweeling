package com.kh.question.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.PageInfo;
import com.kh.question.model.dao.QuestionDao;
import com.kh.question.model.vo.QAttachment;
import com.kh.question.model.vo.QReply;
import com.kh.question.model.vo.Question;

public class QuestionService {
    public int selectListCount(int userNo) {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = new QuestionDao().selectListCount(conn, userNo);
        
        JDBCTemplate.close(conn);
        
        return result;
    }

    public ArrayList<Question> selectList(int userNo, PageInfo pi) {
        //사용자 요청 페이지 목록 메소드
        Connection conn = JDBCTemplate.getConnection();
        
        ArrayList<Question> list = new QuestionDao().selectList(conn, userNo, pi);
        
        JDBCTemplate.close(conn);
        
        return list;
    }
    
    public int insertQuestion(Question qst, QAttachment qat) {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = new QuestionDao().insertQuestion(conn, qst);
        
        int resultAttach = 1;
        
        if(qat != null) {
            resultAttach = new QuestionDao().insertAttachment(conn, qat);
        }
        
        JDBCTemplate.close(conn);
        
        return result;
    }
    
    public Question selectQuestion(int qno) {
        Connection conn = JDBCTemplate.getConnection();
        
        Question q = new QuestionDao().selectQuestion(conn, qno);
        
        JDBCTemplate.close(conn);
        
        return q;
    }
    
    public QAttachment selectAttachment(int qno) {
        Connection conn = JDBCTemplate.getConnection();
        
        QAttachment qat = new QuestionDao().selectAttachment(conn, qno);
        
        JDBCTemplate.close(conn);
        
        return qat;
    }

    public int updateQuestion(Question q, QAttachment qat) {
        Connection conn = JDBCTemplate.getConnection();
        // 게시글 정보 수정
        System.out.println("updateQuestion 실행");
        int result = new QuestionDao().updateQuestion(conn, q);
        System.out.println("Q::Service::update::result :"+result);
        int result2 = 1;
        
        // 새롭게 첨부된 파일이 있는 경우
        if(qat != null) {
            if(qat.getFileNo() != 0) {
                result2 = new QuestionDao().updateAttachment(conn, qat);
            }
            else {
                // 기존 첨부파일이 없었던 경우 : insert
                // 기존 insertAttachment를 쓸 수 없는 이유 : 기존에는 참조 게시글 번호를
                // 게시글이 등록됨과 동시에 currentValue를 잡아줬기 때문에 이미 뽑혀있는
                // 시퀀스 번호를 찾으려면 전달받아서 진행해야 한다.
                result2 = new QuestionDao().insertNewAttachment(conn, qat);
            }
        }
    
        // 게시글 정보 수정과 첨부파일 정보수정이 둘 다 올바르게 되었을 때를 알 수 있게 곱연산을 한다.
        // 만약 둘 중 하나라도 실패하여 0이 나오면 result가 0이 되게끔
        int finalResult = result * result2;
        
        if(finalResult>0) {
            JDBCTemplate.commit(conn);
        }
        else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return finalResult;
    }

    public int deleteQuestion(int questionNo) {
        Connection conn = JDBCTemplate.getConnection();

        int result =new QuestionDao().deleteQuestion(conn, questionNo);
        
        if(result>0) {
            JDBCTemplate.commit(conn);
        }
        else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        
        return result;
    }

    public ArrayList<QReply> selectReplyList(int qno) {
        Connection conn = JDBCTemplate.getConnection();
        
        ArrayList<QReply> list = new QuestionDao().selectReplyList(conn,qno);
        
        JDBCTemplate.close(conn);
        
        return list;
    }

    public int insertReply(QReply r) {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = new QuestionDao().insertReply(conn,r);
        
        if(result>0) {
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        
        return result;
    }

    public int deleteReply(int rno) {
        Connection conn = JDBCTemplate.getConnection();

        int result =new QuestionDao().deleteReply(conn, rno);
        
        if(result>0) {
            JDBCTemplate.commit(conn);
        }
        else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        
        return result;
    }
}
