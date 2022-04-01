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
import app.model.Kysymykset;
import app.model.Vaalikone;



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
	
	
	
	
	public int saveVaalikone(Vaalikone vaalikone) {
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			count=stmt.executeUpdate("insert into ehdokkaat(sukunimi, etunimi) values('"+vaalikone.getSukunimi()+"', "+vaalikone.getEtunimi()+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public ArrayList<Vaalikone> readAllVaalikone() {
		ArrayList<Vaalikone> list=new ArrayList<>();
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from ehdokkaat");
			while (rs.next()) {
				Vaalikone vaalikone=new Vaalikone();
				vaalikone.setEhdokas_Id(rs.getInt("ehdokas_id"));
				vaalikone.setSukunimi(rs.getString("sukunimi"));
				vaalikone.setEtunimi(rs.getString("etunimi"));
				list.add(vaalikone);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateVaalikone(Vaalikone vaalikone) {
		int count = 0;
		String sql = "update ehdokkaat set sukunimi = ?, etunimi = ? where ehdokas_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, vaalikone.getSukunimi());
			stmt.setString(2, vaalikone.getEtunimi());
			
			stmt.setInt(3, vaalikone.getEhdokas_id());
			
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public Vaalikone getVaalikoneInfo(int ehdokas_id) {
		Vaalikone result = null;
		String sql = "select * from ehdokkaat where ehdokas_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			stmt.setInt(1, ehdokas_id);
			
			ResultSet resultset = stmt.executeQuery();
			
			if (resultset.next()) {
				result = new Vaalikone();
				result.setEhdokas_Id(resultset.getInt("ehdokas_id"));
				result.setSukunimi(resultset.getString("sukunimi"));
				result.setEtunimi(resultset.getString("etunimi"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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
	
	public ArrayList<Kysymykset> readAllKysymykset() {
		ArrayList<Kysymykset> list=new ArrayList<>();
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from kysymys");
			while (rs.next()) {
				Kysymykset kysymys=new Kysymykset();
				kysymys.setKysymys_id(rs.getInt("kysymys_id"));
				kysymys.setKysymys(rs.getString("kysymys"));
				list.add(kysymys);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public ArrayList<Kysymykset> removeQuestion(String id) {
		try {
			String sql = "delete from kysymykset where kysymys_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllKysymykset();
		}catch (SQLException e) {
			return null;
		}}
	public Kysymykset getKysymyksetInfo(int kysymys_id) {
		Kysymykset result = null;
		String sql = "select * from kysymykset where kysymys_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			stmt.setInt(1, kysymys_id);
			
			ResultSet resultset = stmt.executeQuery();
			
			if (resultset.next()) {
				result = new Kysymykset();
				result.setKysymys_id(resultset.getInt("kysymys_id"));
				result.setKysymys(resultset.getString("kysymys"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
		}
		
	
	

