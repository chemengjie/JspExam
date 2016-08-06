package com.hand.util;

import com.hand.dao.impl.UserDaoimpl;
import com.hand.service.CheckUserService;

public class ConnTest {

	public static void main(String[] args) {
		System.out.println(ConnectionFactory.getInstance().makeConnection());
		
	}

}
