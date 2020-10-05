package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.NoticeDao;

public class ListNoticeAction implements DsAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) // 공지사항 코드 타입 006
			throws ServletException, IOException {
		NoticeDao dao = NoticeDao.getInstance();
		request.setAttribute("list", dao.listNotice());
		request.setAttribute("category", dao.getBoardCategory("006"));
		return "listNotice.jsp";
	}

}
