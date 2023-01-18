package com.kh.event.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.event.model.service.EventService;

@WebServlet("/eventListCount.event")
public class EventListCountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EventListCountController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int eventType = Integer.parseInt(request.getParameter("eventType"));
        int eventStatus = Integer.parseInt(request.getParameter("eventStatus"));
        int listCount = new EventService().selectEventListCount(eventType, eventStatus);
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().print(listCount);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
