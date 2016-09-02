package com.beerfun;

import java.sql.*;
import java.util.ArrayList;

public class DAO {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "root";
	
	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;
	public static ArrayList<Beer> ourBeers = new ArrayList<>();
	

	
	public static void connToDB() {
		
		try {
			Class.forName(JDBC_DRIVER);	
			
			System.out.println("Trying to connect to the Database...");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the database.");
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Failed to conenct to the database.");
			e.printStackTrace();
		}
	}
	
	public static void readFromDB(){
		
		connToDB();
		
		
		
		
		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM assignments.beer;");
			
			while(RES_SET.next()){
			
			Beer beerInDB = new Beer();
			
			beerInDB.setBeerId(RES_SET.getInt("beerid"));
			beerInDB.setBrewer(RES_SET.getString("brewer"));
			beerInDB.setName(RES_SET.getString("name"));
			beerInDB.setStyle(RES_SET.getString("Style"));
			beerInDB.setAbv(RES_SET.getDouble("abv"));
			
			ourBeers.add(beerInDB);
			
			}
	
		
		
		
	} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		public static void writeToDB(Beer beer) {
			
			Beer beerToAdd = new Beer();
			
			beerToAdd = beer;
			
			connToDB();
			
			try {
				PREP_STMT = CONN.prepareStatement(insertToDB);
				
				PREP_STMT.setString(1, beerToAdd.getBrewer());
				PREP_STMT.setString(2, beerToAdd.getName());
				PREP_STMT.setString(3, beerToAdd.getStyle());
				PREP_STMT.setDouble(4, beerToAdd.getAbv());
				
				PREP_STMT.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
	
		
		private static String insertToDB = "INSERT INTO `assignments`.`beer`"
				+ "(brewer, name, style, abv)"
				+ " VALUES "
				+ "(?, ?, ?, ?)";
		
	
}


