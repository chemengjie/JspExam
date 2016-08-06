package com.hand.service;

import java.sql.SQLException;
import java.util.List;

import com.hand.dao.Userdao;
import com.hand.dao.impl.UserDaoimpl;
import com.hand.entity.Film;

public class FilmService {
	private Userdao userDao = new UserDaoimpl();
	public List<Film> queryAll() {
		List<Film> list = null;
		try {
			list = userDao.show();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
