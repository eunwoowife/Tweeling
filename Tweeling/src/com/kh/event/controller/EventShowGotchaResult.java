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
import com.kh.event.model.vo.EventGotchaMember;

@WebServlet("/showGotchaResult.event")
public class EventShowGotchaResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EventShowGotchaResult() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eventNo = Integer.parseInt(request.getParameter("eventNo"));
		ArrayList<EventGotchaMember> gotcha = new EventService().showGotchaResult(eventNo);
		response.setContentType("application/json; charset=UTF-8");
        new Gson().toJson(gotcha, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
