package com.kh.event.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.event.model.service.EventService;
import com.kh.event.model.vo.Event;
import com.kh.event.model.vo.EventPageInfo;

@WebServlet("/eventList.event")
public class EventListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EventListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventType = Integer.parseInt(request.getParameter("eventType"));
        int eventStatus = Integer.parseInt(request.getParameter("eventStatus"));
        int listCount = Integer.parseInt(request.getParameter("listCount"));
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageLimit = Integer.parseInt(request.getParameter("pageLimit"));
        int boardLimit = Integer.parseInt(request.getParameter("boardLimit"));
        int maxPage = Integer.parseInt(request.getParameter("maxPage"));
        int startPage = Integer.parseInt(request.getParameter("startPage"));
        int endPage = Integer.parseInt(request.getParameter("endPage"));
        if (endPage > maxPage) {
            endPage = maxPage;
        }
        EventPageInfo epi = new EventPageInfo(eventType, eventStatus, listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);      
        ArrayList<Event> list = new EventService().selectEventList(epi, eventType, eventStatus);
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(list, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
