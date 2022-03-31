//package dao;
//import javax.servlet.http.HttpServlet;
//public class Dao extends HttpServlet {
//}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.ShowCandidates;
import app.data.Game;


public class Dao {
	private Connection conn;
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/gamedb", "pena", "kukkuu");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<ShowCandidates> readAllShowCandidates() {
		ArrayList<ShowCandidates> list=new ArrayList<>();
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from vaalikone");
			while (rs.next()) {
				ShowCandidates ShowCandidates=new ShowCandidates();
				ShowCandidates.setId(rs.getInt("id"));
				ShowCandidates.setEtunimi(rs.getString("etunimi"));
				ShowCandidates.setSukunimi(rs.getFloat("sukunimi"));
				list.add(ShowCandidates);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void addUser(String username, String pw, String salt) {
		String sql = "insert into useraccount (username, hashedpassword,salt) values (?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			stmt.setString(2, pw);
			stmt.setString(3, salt);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
	
		}
	}
	
	public String getUserSalt(String username) {
		String result = "";
		String sql = "select salt from useraccount where username = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,  username);
			
			ResultSet rs = stmt.executeQuery();
			
			if ( rs.next()) {
				result = rs.getString("salt");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			}
		return result;
		}
	
	public String getUserPasswordHash(String username) {
		String result = "";
		String sql = "select hashedpassword from useraccount where username = ?";
		try { 
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getString("hashedpassword");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			}
		return result;
		}
	}
	
	

