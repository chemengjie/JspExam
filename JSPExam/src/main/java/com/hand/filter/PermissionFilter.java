package com.hand.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PermissionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PermissionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String servletPath = req.getServletPath();
		
		HttpSession session = req.getSession();
		String flag = (String) session.getAttribute("flag");
		
			if(flag != null && flag.equals("success")){
				System.out.println("PermissionFilter success..."+flag);
				chain.doFilter(request, response);
			}else if(flag != null && flag.equals("erro")){
				req.setAttribute("msg", "登录失败，请重新登录！<br/>");
				req.setAttribute("return_uri", servletPath);
				RequestDispatcher rd = req.getRequestDispatcher("/servlet/login.jsp");
				rd.forward(req, response);
			}else{
				req.setAttribute("msg", "您尚未登录！");
				req.setAttribute("return_uri", servletPath);
				RequestDispatcher rd = req.getRequestDispatcher("/servlet/login.jsp");
				rd.forward(req, response);
			}	
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
