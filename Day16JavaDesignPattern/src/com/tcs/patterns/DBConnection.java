package com.tcs.patterns;

public class DBConnection {

	private static DBConnection con = new DBConnection();
	
	private DBConnection() {
	}
	
	public static DBConnection getConn()
	{
		return con;
	}
}
