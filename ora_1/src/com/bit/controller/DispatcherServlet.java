package com.bit.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.action.DsAction;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	
	HashMap<String, DsAction> map;
	
	private static final long serialVersionUID = 1L;
       
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//super.init(config);
		map = new HashMap<String, DsAction>();
		String path = config.getServletContext().getRealPath("WEB-INF");
		try {
		FileReader fr = new FileReader(path+"/dispatcherServlet.properties");
		Properties prop = new Properties();
		prop.load(fr);
		Iterator keyList = prop.keySet().iterator();
		while(keyList.hasNext()) {
			String key = (String)keyList.next();
			String className = prop.getProperty(key);
			DsAction da = (DsAction)Class.forName(className).newInstance();
			System.out.println(key + "   " + da);
			map.put(key, da);
		}
		fr.close();
		}catch (Exception e) {
			System.out.println("파일리더 예외 " + e.getMessage());
		}
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request, response);
	}

	private void proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI();
		String cpath = request.getContextPath();
		String cmd = uri.substring(cpath.length()+1);
		
		DsAction da = map.get(cmd);
		
		String view = da.action(request, response);
		
		if(view.endsWith(".do")) {
			response.sendRedirect(view);
		}
		else {
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request, response);
	}

}
