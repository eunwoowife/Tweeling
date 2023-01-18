package com.kh.common;

import com.kh.common.model.vo.PageInfo;

public class PagingTemplate {
    
    public static int getMaxPage(int listCount, int boardLimit) {
        int maxPage=(int)(Math.ceil(((double)listCount / boardLimit)));;
        return maxPage;
    }
    
    public static int getStartPage(int currentPage, int pageLimit) {
        int startPage = ((currentPage-1)/pageLimit) * pageLimit + 1;
        return startPage;
    }

    public static int getEndPage(int listCount, int currentPage, int pageLimit, int boardLimit) {
        int startPage = PagingTemplate.getStartPage(currentPage, pageLimit);
        int endPage = startPage + pageLimit - 1; 
        
        //startPage가 11일때 endPage는 20으로 된다 (만약 maxPage가 13이라면?)
        //endPage를 maxPage로 변경
        int maxPage = PagingTemplate.getMaxPage(listCount, boardLimit);
        if(endPage>maxPage) {
            endPage = maxPage;
        }
        return endPage;
    }
    
    public static PageInfo getPageInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {
        int maxPage = PagingTemplate.getMaxPage(listCount, boardLimit);
        int startPage = PagingTemplate.getStartPage(currentPage, pageLimit);
        int endPage = PagingTemplate.getEndPage(listCount, currentPage, pageLimit, boardLimit);
        PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
        return pi;
    }
    
}
