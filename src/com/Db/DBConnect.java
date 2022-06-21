package com.Db;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect {

	private static Connection conn;
	public static Connection getConn()
	{
		try {
			
			if(conn==null)
			{
				Class.forName("com.mysql.jdbc.Driver");
				 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes2","root","Bajar@143");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return conn;
		
	}
	
}

//public class DBConnect {
//    private static Connection conn;
//
//    static{
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes2","root","Bajar@143");
//            System.out.println("connected");
//        }
//        catch(ClassNotFoundException | SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static Connection getConnection(){
//        return conn;
//    }
//
//}