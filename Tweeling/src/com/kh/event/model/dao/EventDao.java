package com.kh.event.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.event.model.vo.Event;
import com.kh.event.model.vo.EventApply;
import com.kh.event.model.vo.EventAttachment;
import com.kh.event.model.vo.EventGotchaMember;
import com.kh.event.model.vo.EventPageInfo;

public class EventDao {

    private Properties prop = new Properties();

    public EventDao() {
        String filePath = EventDao.class.getResource("/db/sql/event-mapper.xml").getPath();
        try {
            prop.loadFromXML(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int selectEventListCount(Connection conn, int eventType, int eventStatus) {
        int listCount = 0;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql1 = prop.getProperty("selectEventListCountActive");
        String sql2 = prop.getProperty("selectEventListCountInactive");
        String sql3 = prop.getProperty("selectGotchaListCount");
        try {
            if (eventStatus == 1) {
                pstmt = conn.prepareStatement(sql1);
            } else if (eventStatus == 2) {
                pstmt = conn.prepareStatement(sql2);
            } else {
                pstmt = conn.prepareStatement(sql3);
            }
            pstmt.setInt(1, eventType);
            rset = pstmt.executeQuery();
            if (rset.next()) {
                listCount = rset.getInt("COUNT");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return listCount;
    }

    public ArrayList<Event> selectEventList(Connection conn, EventPageInfo epi, int eventType, int eventStatus) {
        ArrayList<Event> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql1 = prop.getProperty("selectEventListActive");
        String sql2 = prop.getProperty("selectEventListInactive");
        String sql3 = prop.getProperty("selectGotchaList");
        int startRow = (epi.getCurrentPage() - 1) * epi.getBoardLimit() + 1;
        int endRow = epi.getCurrentPage() * epi.getBoardLimit();
        try {
            if (eventStatus == 1) {
                pstmt = conn.prepareStatement(sql1);
            } else if (eventStatus == 2) {
                pstmt = conn.prepareStatement(sql2);
            } else {
                pstmt = conn.prepareStatement(sql3);
            }
            pstmt.setInt(1, eventType);
            pstmt.setInt(2, startRow);
            pstmt.setInt(3, endRow);
            rset = pstmt.executeQuery();
            while (rset.next()) {
                list.add(new Event(rset.getInt("EVENT_NO"), rset.getInt("EVENT_TYPE"), rset.getString("EVENT_TOPIC"),
                        rset.getString("EVENT_TITLE"), rset.getString("EVENT_STARTDATE"),
                        rset.getString("EVENT_ENDDATE"),
                        rset.getDate("CREATE_DATE")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return list;
    }

    public Event selectDetailedEvent(Connection conn, int eventNo) {
        Event ev = new Event();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectDetailedEvent");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, eventNo);
            rset = pstmt.executeQuery();
            while (rset.next()) {
                ev = new Event(rset.getInt("EVENT_NO"), rset.getInt("EVENT_TYPE"), rset.getString("EVENT_TOPIC"),
                        rset.getString("EVENT_TITLE"), rset.getString("EVENT_CONTENT"),
                        rset.getString("EVENT_STARTDATE"),
                        rset.getString("EVENT_ENDDATE"), rset.getDate("CREATE_DATE"), rset.getString("STATUS"),
                        rset.getString("GOTCHA_YN"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return ev;
    }

    public EventAttachment selectEventAttachment(Connection conn, int eventNo) {
        EventAttachment ea = new EventAttachment();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectEventAttachment");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, eventNo);
            rset = pstmt.executeQuery();
            while (rset.next()) {
                ea = new EventAttachment(rset.getInt("EVENT_ATTACHMENT_NO"), rset.getString("EVENT_ORIGIN_NAME"),
                        rset.getString("EVENT_CHANGE_NAME"), rset.getString("EVENT_FILE_PATH"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return ea;
    }

    public int insertEvent(Connection conn, Event ev) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("insertEvent");            
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ev.getEventType());
            pstmt.setString(2, ev.getEventTopic());
            pstmt.setString(3, ev.getEventTitle());
            pstmt.setString(4, ev.getEventContent());
            pstmt.setString(5, ev.getEventStartDate());
            pstmt.setString(6, ev.getEventEndDate());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }
    
    public int insertGotcha(Connection conn, Event ev) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("insertGotcha");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ev.getEventType());
            pstmt.setString(2, ev.getEventTopic());
            pstmt.setString(3, ev.getEventTitle());
            pstmt.setString(4, ev.getEventContent());
            pstmt.setString(5, ev.getGotchaYn());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
        
    }

    public int insertEventAttachment(Connection conn, EventAttachment ea) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("insertEventAttachment");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ea.getEventOriginName());
            pstmt.setString(2, ea.getEventChangeName());
            pstmt.setString(3, ea.getEventFilePath());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public int updateEvent(Connection conn, Event ev) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("updateEvent");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ev.getEventType());
            pstmt.setString(2, ev.getEventTopic());
            pstmt.setString(3, ev.getEventTitle());
            pstmt.setString(4, ev.getEventContent());
            pstmt.setString(5, ev.getEventStartDate());
            pstmt.setString(6, ev.getEventEndDate());
            pstmt.setInt(7, ev.getEventNo());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public int deleteEvent(Connection conn, int eventNo) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("deleteEvent");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, eventNo);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public int applyGotcha(Connection conn, int userNo, int eventNo) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("applyGotcha");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userNo);
            pstmt.setInt(2, eventNo);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public EventApply checkGotchaStatus(Connection conn, int eventNo, int userNo) {
        EventApply eapp = new EventApply();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("checkGotchaStatus");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, eventNo);
            pstmt.setInt(2, userNo);
            rset = pstmt.executeQuery();
            while (rset.next()) {
                eapp = new EventApply(rset.getString("APPLY_STATUS"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return eapp;
    }

    public int deleteGotchaStatus(Connection conn, int eventNo, int userNo) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("deleteGotchaStatus");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, eventNo);
            pstmt.setInt(2, userNo);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public ArrayList<EventGotchaMember> showGotchaResult(Connection conn, int eventNo) {
        ArrayList<EventGotchaMember> gotcha = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("showGotchaResult");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, eventNo);
            rset = pstmt.executeQuery();
            while (rset.next()) {
                gotcha.add(new EventGotchaMember(rset.getString("USER_ID"), rset.getString("USER_NICKNAME"),
                        rset.getInt("PHONE")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return gotcha;
    }

    public int changeGotchaStatus(Connection conn, int eventNo) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("changeGotchaStatus");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, eventNo);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

}
