package com.kh.event.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.event.model.service.EventService;
import com.kh.event.model.vo.EventApply;

@WebServlet("/checkGotchaStatus.event")
public class EventCheckGotchaStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EventCheckGotchaStatus() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("loginUserNo"));
		int eventNo = Integer.parseInt(request.getParameter("eventNo"));
		EventApply eapp = new EventService().checkGotchaStatus(eventNo, userNo);
		response.setContentType("application/json; charset=UTF-8");
        new Gson().toJson(eapp, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
