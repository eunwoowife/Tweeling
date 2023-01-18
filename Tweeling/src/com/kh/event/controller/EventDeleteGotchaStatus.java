package com.kh.event.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.event.model.service.EventService;

@WebServlet("/deleteGotchaStatus.event")
public class EventDeleteGotchaStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EventDeleteGotchaStatus() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("loginUserNo"));
		int eventNo = Integer.parseInt(request.getParameter("eventNo"));
		new EventService().deleteGotchaStatus(eventNo, userNo);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
