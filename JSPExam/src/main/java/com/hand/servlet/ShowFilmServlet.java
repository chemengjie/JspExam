package com.hand.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.Film;
import com.hand.service.FilmService;

public class ShowFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmService filmService = new FilmService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Film> list = filmService.queryAll();
		request.setAttribute("films", list);
		request.getRequestDispatcher("servlet/filmlist.jsp").forward(request, response);
	}

}
