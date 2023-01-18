package com.kh.event.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.event.model.dao.EventDao;
import com.kh.event.model.vo.Event;
import com.kh.event.model.vo.EventApply;
import com.kh.event.model.vo.EventAttachment;
import com.kh.event.model.vo.EventGotchaMember;
import com.kh.event.model.vo.EventPageInfo;

public class EventService {
    
    public int selectEventListCount(int eventType, int eventStatus) {
        Connection conn = JDBCTemplate.getConnection();
        int count = new EventDao().selectEventListCount(conn, eventType, eventStatus);
        JDBCTemplate.close(conn);
        return count;
    }

    public ArrayList<Event> selectEventList(EventPageInfo epi, int eventType, int eventStatus) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Event> list = new EventDao().selectEventList(conn, epi, eventType, eventStatus);
        JDBCTemplate.close(conn);
        return list;
    }

    public Event selectDetailedEvent(int eventNo) {
        Connection conn = JDBCTemplate.getConnection();
        Event ev = new EventDao().selectDetailedEvent(conn, eventNo);
        JDBCTemplate.close(conn);
        return ev;
    }

    public EventAttachment selectEventAttachment(int eventNo) {
        Connection conn = JDBCTemplate.getConnection();
        EventAttachment ea = new EventDao().selectEventAttachment(conn, eventNo);
        JDBCTemplate.close(conn);
        return ea;
    }

    public int insertEvent(Event ev, EventAttachment ea) {
        Connection conn = JDBCTemplate.getConnection();
        int resultA = new EventDao().insertEvent(conn, ev);
        int resultB = 1;
        if (ea != null) {
            resultB = new EventDao().insertEventAttachment(conn, ea);
        }
        int result = resultA * resultB;
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        return result;
    }
    
    public int insertGotcha(Event ev, EventAttachment ea) {
        Connection conn = JDBCTemplate.getConnection();
        int resultA = new EventDao().insertGotcha(conn, ev);
        int resultB = 1;
        if (ea != null) {
            resultB = new EventDao().insertEventAttachment(conn, ea);
        }
        int result = resultA * resultB;
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        return result;
    }

    public int updateEvent(Event ev) {
        Connection conn = JDBCTemplate.getConnection();
        int result = new EventDao().updateEvent(conn, ev);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }

    public int deleteEvent(int eventNo) {
        Connection conn = JDBCTemplate.getConnection();
        int result = new EventDao().deleteEvent(conn, eventNo);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }
    
    public int applyGotcha(int userNo, int eventNo) {
        Connection conn = JDBCTemplate.getConnection();
        int result = new EventDao().applyGotcha(conn, userNo, eventNo);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }
    
    public EventApply checkGotchaStatus(int eventNo, int userNo) {
        Connection conn = JDBCTemplate.getConnection();
        EventApply eapp = new EventDao().checkGotchaStatus(conn, eventNo, userNo);
        JDBCTemplate.close(conn);
        return eapp;
    }
    
    public int deleteGotchaStatus(int eventNo, int userNo) {
        Connection conn = JDBCTemplate.getConnection();
        int result = new EventDao().deleteGotchaStatus(conn, eventNo, userNo);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }
    
    public ArrayList<EventGotchaMember> showGotchaResult(int eventNo) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<EventGotchaMember> gotcha = new EventDao().showGotchaResult(conn, eventNo);
        JDBCTemplate.close(conn);
        return gotcha;
        
    }

    public int changeGotchaStatus(int eventNo) {
        Connection conn = JDBCTemplate.getConnection();
        int result = new EventDao().changeGotchaStatus(conn, eventNo);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }

 





   

}
