package com.hand.dao.impl;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hand.dao.Userdao;
import com.hand.entity.Actor;
import com.hand.entity.Adress;
import com.hand.entity.Film;
import com.hand.util.ConnectionFactory;



public  class UserDaoimpl implements Userdao {
	/**
	 * 保存用户信息
	 */
	public void save(Connection conn, Actor actor) throws SQLException {
		PreparedStatement ps = conn.prepareCall("insert into tbl_user(name,password,email) values(?,?,?)");
		
		ps.setString(1, actor.getFirst_name());
		ps.setString(2, actor.getLast_name());
		ps.setDate(3, actor.getLast_update());
		ps.execute();
	}
	

	/**
	 * 删除指定的用户信息
	 */
	public void delete(Connection conn, Actor actor) throws SQLException {
			PreparedStatement ps =  conn.prepareStatement("delete from actor where id = ?");
			ps.setLong(1, actor.getActor_id());
			ps.execute();

	}

	public void save(Connection conn, Adress address) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = conn.prepareCall("insert into address(city,country,user_id) values(?,?,?)");
		ps.setLong(1, address.getCity_id());
		ps.setString(2, address.getAddress());
		ps.setString(3, address.getAddress2());
		ps.execute();
	}

	public ResultSet get(Connection conn, Actor actor) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from customer where first_name =? ");
		ps.setString(1, actor.getFirst_name());
		return ps.executeQuery();
	}


	public List<Film> show() throws SQLException {
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		List<Film> list = new LinkedList<Film>();
		PreparedStatement ps = conn.prepareStatement("select f.film_id,f.title,f.description,l.name from film f left join language l on f.language_id = l.language_id");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Film film = new Film();
			film.setFilm_id(rs.getLong(1));
			film.setTitle(rs.getString(2));
			film.setDescription(rs.getString(3));
			film.setLanguageName(rs.getString(4));
			list.add(film);
		}
		rs.close();
		ps.close();
		conn.close();
		return list;
	}
}

	


