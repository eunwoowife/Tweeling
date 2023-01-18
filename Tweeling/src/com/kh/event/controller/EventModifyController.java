package com.kh.event.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.event.model.EventFileRenamePolicy;
import com.kh.event.model.service.EventService;
import com.kh.event.model.vo.Event;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/eventModify.event")
public class EventModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EventModifyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    if (ServletFileUpload.isMultipartContent(request)) {
	        int maxSize = 50 * 1024 * 1024;
	        String savePath = request.getSession().getServletContext().getRealPath("/resources/event_upfiles/");
	        MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new EventFileRenamePolicy());
	        int eventNo = Integer.parseInt(multiRequest.getParameter("modifyEventNo"));
	        int eventType = Integer.parseInt(multiRequest.getParameter("modifyEventType"));
	        String eventTopic = multiRequest.getParameter("modifyEventTopic");
	        String eventTitle = multiRequest.getParameter("modifyEventTitle");
	        String eventContent = multiRequest.getParameter("modifyEventContent");
            String eventStartDate = multiRequest.getParameter("modifyEventStartDate");
            String eventEndDate = multiRequest.getParameter("modifyEventEndDate");
	        Event ev = new Event();
	        ev.setEventNo(eventNo);
	        ev.setEventType(eventType);
	        ev.setEventTopic(eventTopic);
	        ev.setEventTitle(eventTitle);
	        ev.setEventContent(eventContent);
	        ev.setEventStartDate(eventStartDate);
	        ev.setEventEndDate(eventEndDate);
            int result = new EventService().updateEvent(ev);
	        if (result > 0) {
	            response.sendRedirect(request.getContextPath() + "/eventListView.event");
	        } else {
                response.sendRedirect(request.getContextPath() + "/eventListView.event");
	        }
	        
	    }
	}

}
