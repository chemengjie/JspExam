package com.hand.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.hand.dao.Userdao;
import com.hand.dao.impl.UserDaoimpl;
import com.hand.entity.Actor;
import com.hand.entity.Film;
import com.hand.util.ConnectionFactory;

public class CheckUserService {
	private Userdao userDao = new UserDaoimpl();
	
	public boolean check(Actor actor){
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			ResultSet resultSet = userDao.get(conn, actor);
			
			while(resultSet.next()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		}
		return false;
	}
}
