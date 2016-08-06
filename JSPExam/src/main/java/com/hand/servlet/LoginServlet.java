package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String userName = req.getParameter("uname");
//		String password = req.getParameter("upwd");
//		
//		System.out.println("用户名==》"+ userName);
//		System.out.println("密码==》"+ password);
//		
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("====== 进入doGet方法 ======");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("====== 进入doPost方法 ======");
		String first_name = req.getParameter("uname");
		
		
		System.out.println("用户名==》"+ first_name);
		
		
		String forward = null;
		if(first_name.equals("chemengjie")){
			
			//请求转发 不可以访问其他应用的地址
			forward = "/servlet/success.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
			//请求重定向 可以访问其他应用的地址
			//resp.sendRedirect(req.getContextPath()+ "/servlet/success.jsp");
		}else{
			//请求转发 不可以访问其他应用的地址
			forward = "/servlet/erro.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(forward);//请求调度器
			rd.forward(req, resp);
			//请求重定向 
			//resp.sendRedirect(req.getContextPath()+ "/servlet/erro.jsp");
		}
	}
}
