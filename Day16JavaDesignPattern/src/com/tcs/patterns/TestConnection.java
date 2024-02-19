package com.tcs.patterns;

public class TestConnection {

	public static void main(String as[])
	{
		DBConnection con = DBConnection.getConn();
		DBConnection con1 = DBConnection.getConn();
		DBConnection con2 = DBConnection.getConn();
		System.out.println(con + "\n" + con1 + "\n" + con2);
	}
	
	
	
}
