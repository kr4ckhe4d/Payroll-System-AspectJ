package com.mtit.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

private static Connection mConnection = null;
	
    public static Connection getConnection()
    {
    	createConnection();
    	return mConnection;
    }
    
    public static void closeConnection() {
    	if(mConnection != null) {
    		try {
				mConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }
    
    private static void createConnection() {
    	try {
       	  try {
   			Class.forName("org.sqlite.JDBC");
   		} catch (ClassNotFoundException e) {
   			e.printStackTrace();
   		}
       	  mConnection = DriverManager.getConnection(Constants.DATABASE_URL);
         } catch (SQLException ex) {
             throw new RuntimeException("Error connecting to the database", ex);
         }
    }
}
