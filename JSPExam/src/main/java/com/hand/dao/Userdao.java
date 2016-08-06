package com.hand.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hand.entity.Actor;
import com.hand.entity.Adress;
import com.hand.entity.Film;
import com.hand.entity.Language;
import com.hand.entity.language_identity;


public interface Userdao {
	public void save(Connection conn,Actor actor) throws SQLException;
	public void save(Connection conn,Adress city) throws SQLException;
	
	public void delete(Connection conn,Actor actor) throws SQLException;
	
	public ResultSet get(Connection conn,Actor actor) throws SQLException;
	
	public List<Film> show() throws SQLException;
	
}
