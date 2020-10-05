package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.NoticeDao;
import com.bit.vo.NoticeVo;

public class InsertNoticeOkAction implements DsAction {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		NoticeVo n = new NoticeVo();
		n.setN_no(Integer.parseInt(request.getParameter("n_no")));
		n.setCode_value(request.getParameter("code_value"));
		n.setN_title(request.getParameter("n_title"));
		n.setN_content(request.getParameter("n_content"));
		NoticeDao dao = new NoticeDao();
		int re = dao.insertNotice(n);
		request.setAttribute("re", re);
		
		return "insertNoticeOk.jsp";
	}

}




