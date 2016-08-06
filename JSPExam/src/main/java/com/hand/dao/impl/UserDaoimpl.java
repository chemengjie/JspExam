package com.hand.dao.impl;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hand.dao.Userdao;
import com.hand.entity.Actor;
import com.hand.entity.Adress;
import com.hand.entity.Film;



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


	public ResultSet show(Connection conn) throws SQLException {
		
			         List<Film> list =new ArrayList<Film>();
			         
			         PreparedStatement psmt=null;
			         ResultSet rs=null;
			         try {
			             Class.forName("com.mysql.jdbc.Driver");
			         } catch (ClassNotFoundException e) {
			             e.printStackTrace();
			         }
			         
			         try {
			            
			             String sql="select film_id,title,description from film";
			             psmt=conn.prepareStatement(sql);
			             rs=psmt.executeQuery();
			             
			             while(rs.next())
			             {
			               
			                 Film fl=new Film();
			                 list.add(fl);
			             }
			             
			         } catch (SQLException e) {
			             e.printStackTrace();
			         }finally
			         {
			             try {
			                 if(rs!=null)
			                 {
			                     rs.close();
			                 }
			                 if(psmt!=null)
			                 {
			                     psmt.close();
			                 }
			                 if(conn!=null)
			                 {
			                     conn.close();
			                 }
			             } catch (SQLException e) {
			                 e.printStackTrace();
			             }
			         }
					return rs;
			         
			     }
	}

	


