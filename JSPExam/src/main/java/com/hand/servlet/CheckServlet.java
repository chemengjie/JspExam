package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.Actor;
import com.hand.service.CheckUserService;


public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
    private CheckUserService cku = new CheckUserService();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		
		
		RequestDispatcher rd = null;
		String forward = null;
		
		if(uname == null){
			request.setAttribute("msg", "用户名为空");
			rd = request.getRequestDispatcher("/servlet/erro.jsp");
			rd.forward(request, response);
		}else{
			Actor actor = new Actor();
			actor.setFirst_name(uname);
			
			boolean bool = cku.check(actor);
			
			if(bool){
				request.getSession().setAttribute("flag", "success");
				forward = "/servlet/success.jsp";	
			}else{
				request.setAttribute("msg","用户名输入错误，请重新输入！");
				forward = "/servlet/erro.jsp";
			}
			
			rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
			
		}
		
	}

}
