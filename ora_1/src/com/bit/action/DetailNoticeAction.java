package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.NoticeDao;

public class DetailNoticeAction implements DsAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int n_no = Integer.parseInt(request.getParameter("n_no"));
		NoticeDao dao = new NoticeDao();
		request.setAttribute("n", dao.detailNotice(n_no));
		return "detailNotice.jsp";
	}

}
