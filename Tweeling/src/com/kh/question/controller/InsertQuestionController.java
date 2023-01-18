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
 * Servlet implementation class InsertQuestionController
 */
@WebServlet("/insert.question")
public class InsertQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertQuestionController() {
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
	        int maxSize = 10* 1024 * 1024;
	        String savePath = request.getSession().getServletContext().getRealPath("/resources/question_upfiles/");
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
	        
	        //--------------------------- 1:1 문의 데이터
	        String qTitle = multiRequest.getParameter("qTitle");
	        String qContent = multiRequest.getParameter("qContent");
	        int qType = Integer.parseInt(multiRequest.getParameter("qType"));
	        
	        Question qst = new Question(userNo, qType, qTitle, qContent);
	        
	        QAttachment qat = null;
	        if(multiRequest.getOriginalFileName("upfile") != null) {
//              System.out.println("첨부파일 있음");
                qat = new QAttachment();
                qat.setOriginName(multiRequest.getOriginalFileName("upfile")); // getOriginalFileName : 원본 파일명
                //qat.setChangeName(multiRequest.getFilesystemName("upfile"));   // getFilesystemName : 실제 서버에 업로드 된 파일명
                qat.setFilePath("resources/question_upfiles/");
            }
	        
	        int result = new QuestionService().insertQuestion(qst, qat);
            
            if(result > 0) {
                // 성공 시 가장 최신글로 등록이 될테니 게시글 목록 첫 페이지 띄워주기
                request.getSession().setAttribute("alertMsg", "게시글 등록 성공");
                response.sendRedirect(request.getContextPath()+"/listView.question?currentPage=1");
                
            }
            else {
                // 실패 시 업로드된 첨부파일을 가지고 있을 필요가 없기 때문에 삭제 작업을 해 줘야 한다.
                if(qat != null) {
                    // 삭제하고자 하는 파일 객체를 생성하여 delete 메소드를 호출해서 삭제한다.
                    System.out.println("삭제 파일 : " + savePath+qat.getOriginName());
                    new File(savePath+qat.getOriginName()).delete();
                    
                }
                
                // 실패 시 에러페이지에 에러메세지와 함께 보내주기
                request.setAttribute("errorPage", "게시글 작성 실패");
                request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
            }
	        
	    }
        
	}

}
