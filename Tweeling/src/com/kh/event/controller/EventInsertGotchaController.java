package com.kh.event.controller;

import java.io.File;
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
import com.kh.event.model.vo.EventAttachment;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/submitGotchaResult.event")
public class EventInsertGotchaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EventInsertGotchaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
        if (ServletFileUpload.isMultipartContent(request)) {
            int maxSize = 100 * 1024 * 1024;
            String savePath = request.getSession().getServletContext().getRealPath("/resources/event_upfiles/");
            MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
                    new EventFileRenamePolicy());
            String eventTypeFromForm = multiRequest.getParameter("gotchaResultType");
            int eventType = 0;
            if (Integer.parseInt(eventTypeFromForm) == 1) {
                eventType = 3;
            } else if (Integer.parseInt(eventTypeFromForm) == 2) {
                eventType = 4;
            };
            int eventNo = Integer.parseInt(multiRequest.getParameter("gotchaResultNo"));
            String eventTopic = multiRequest.getParameter("gotchaResultTopic");
            String eventTitle = multiRequest.getParameter("gotchaResultTitle");
            String eventContent = multiRequest.getParameter("gotchaResultContent");;
            Event ev = new Event();
            ev.setEventType(eventType);
            ev.setEventTopic(eventTopic);
            ev.setEventTitle(eventTitle);
            ev.setEventContent(eventContent);
            ev.setEventNo(eventNo);
            ev.setGotchaYn("Y");
            EventAttachment ea = null;
            if (multiRequest.getOriginalFileName("gotchaAttachment") != null) {
                ea = new EventAttachment();
                ea.setEventOriginName(multiRequest.getOriginalFileName("gotchaAttachment"));
                ea.setEventChangeName(multiRequest.getFilesystemName("gotchaAttachment"));
                ea.setEventFilePath("resources/event_upfiles/");
            }
            int resultA = new EventService().changeGotchaStatus(eventNo);
            int resultB = new EventService().insertGotcha(ev, ea);
            int result = resultA * resultB;
            if (result > 0) {
                response.sendRedirect(request.getContextPath() + "/eventListView.event");
            } else {
                if (ea != null) {
                    new File (savePath + ea.getEventChangeName()).delete();
                }
                response.sendRedirect(request.getContextPath() + "/eventListView.event");
            }
        }
	}

}
