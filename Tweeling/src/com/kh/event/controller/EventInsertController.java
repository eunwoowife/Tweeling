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

@WebServlet("/eventInsert.event")
public class EventInsertController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EventInsertController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if (ServletFileUpload.isMultipartContent(request)) {
            int maxSize = 100 * 1024 * 1024;
            String savePath = request.getSession().getServletContext().getRealPath("/resources/event_upfiles/");
            MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
                    new EventFileRenamePolicy());
            String eventTypeFromForm = multiRequest.getParameter("eventType");
            int eventType = Integer.parseInt(eventTypeFromForm);          
            String eventTopic = multiRequest.getParameter("eventTopic");
            String eventTitle = multiRequest.getParameter("eventTitle");
            String eventContent = multiRequest.getParameter("eventContent");
            String eventStartDate = multiRequest.getParameter("eventStartDate");
            String eventEndDate = multiRequest.getParameter("eventEndDate");
            Event ev = new Event();
            ev.setEventType(eventType);
            ev.setEventTopic(eventTopic);
            ev.setEventTitle(eventTitle);
            ev.setEventContent(eventContent);
            ev.setEventStartDate(eventStartDate);
            ev.setEventEndDate(eventEndDate);
            EventAttachment ea = null;
            if (multiRequest.getOriginalFileName("eventAttachment") != null) {
                ea = new EventAttachment();
                ea.setEventOriginName(multiRequest.getOriginalFileName("eventAttachment"));
                ea.setEventChangeName(multiRequest.getFilesystemName("eventAttachment"));
                ea.setEventFilePath("resources/event_upfiles/");
            }
            int result = new EventService().insertEvent(ev, ea);
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
