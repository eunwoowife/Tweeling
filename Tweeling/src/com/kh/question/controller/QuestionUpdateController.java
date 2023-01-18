package com.kh.question.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.member.model.service.MemberService;
import com.kh.question.model.service.QuestionService;
import com.kh.question.model.vo.QAttachment;
import com.kh.question.model.vo.Question;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class QuestionUpdateController
 */
@WebServlet("/update.question")
public class QuestionUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
        
        if(ServletFileUpload.isMultipartContent(request)) {
            // 전송파일 용량 제한
            int maxSize = 10* 1024 * 1024; // 10Mbyte로 지정한 것
            
            // 전달된 파일을 저장시킬 폴더의 물리적인 경로 알아내기
            String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
            
            // 전달된 파일명을 수정작업 후 서버에 업로드
            MultipartRequest multiRequest = new MultipartRequest(request,savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
            
            int userNo = Integer.parseInt(multiRequest.getParameter("userNo"));
            
            //--------------------------- myPage 상단 정보에 필요한 데이터 Start -------
            
            // 주문내역 건수 (해당 사용자의 총 주문 건으로 조회)
            int orderCount = new MemberService().orderCount(userNo);
            request.setAttribute("orderCount", orderCount);
//      System.out.println("MaPage::Ctrl::orderCount : "+orderCount);
            
            // 취소/교환/반품 건수
            // Order 객체에 컬럼을 추가하면 좋을 듯
            
            // 적립금액
            int mileage = new MemberService().selectMileage(userNo);
            request.setAttribute("mileage", mileage);
//      System.out.println("MaPage::Ctrl::mileage : "+mileage);
            
            // 쿠폰 수
            int couponNum = new MemberService().selectCouponNum(userNo);
            request.setAttribute("couponNum", couponNum);
//      System.out.println("MaPage::Ctrl::couponNum : "+couponNum);
            
            //--------------------------- myPage 상단 정보에 필요한 데이터 End -------
            
            // multipartRequest로 변환하였으니 해당 객체로 전달받은 데이터 꺼내기
            String qTitle = multiRequest.getParameter("qTitle");
            String qContent = multiRequest.getParameter("qContent");
            int qType = Integer.parseInt(multiRequest.getParameter("qType"));
            int questionNo = Integer.parseInt(multiRequest.getParameter("questionNo"));
//            System.out.println("update::ctrl: questionNo : "+questionNo);
            
            
            // 꺼낸 데이터를 Question 객체에 담기
            Question q = new Question(questionNo, userNo, qType, qTitle, qContent);
            
            // 첨부파일 참조변수 선언.(나중에 있으면 not null, 없으면 null일 것)
            QAttachment qat = null;
            
//            System.out.println("update.question::"+multiRequest.getOriginalFileName("reUpfile"));
            // 새로 전달된 파일(파일이름)이 있을 때
            if(multiRequest.getOriginalFileName("reUpfile") != null) {
                qat = new QAttachment();
                qat.setOriginName(multiRequest.getOriginalFileName("reUpfile"));
                qat.setChangeName(multiRequest.getFilesystemName("reUpfile"));
                qat.setFilePath("/resources/question_upfiles/");

                // 만약 기존에도 첨부파일이 있는 경우 보냈던 파일번호랑 수정명을 받아준다
                if (multiRequest.getParameter("originFileNo") != null) {
                    // 새로 첨부된 파일이 있고, 기존에도 파일이 있는 경우
                    // update Attachment - 기존의 파일 고유번호를 이용하여 update한다.
                    qat.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));

                    // 새로운 첨부파일이 있다면 기존에 있던 첨부파일은 더이상 필요없으니 서버에서 삭제한다.
                    new File(savePath + multiRequest.getParameter("originFileName")).delete();

                } else {// 새로운 첨부파일은 있지만 기존엔 첨부파일이 없을 경우
                        // insert Attachment - 기존에 파일이 없었으니 새로운 파일정보를 insert한다.
                        // 새로 추가하려면 참조된 게시글의 번호 refbno 를 가지고 가야한다.
                    qat.setQuestionNo(questionNo);
                }
            }
            // service 요청
            // 새로운 첨부파일이 없는 경우 - b, null : board update
            // 새로운 첨부파일이 있고 기존 첨부파일이 있는 경우 - b, at(file_no) : board-update, at-update
            // 새로운 첨부파일이 있고 기존 첨부파일은 없는 경우 -b,at(refBno) : board-update,at-insert
            
            int result = new QuestionService().updateQuestion(q,qat);
            
            if(result>0) {
                //성공시엔 게시글 상세 페이지로 재요청
                request.getSession().setAttribute("alertMsg","게시글 수정 성공");
                response.sendRedirect(request.getContextPath()+"/detail.question?qno="+questionNo);
            }else {
                request.setAttribute("errorMsg", "게시글 수정 실패");
                request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
            }
        }

	}

}
