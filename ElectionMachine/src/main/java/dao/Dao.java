//package dao;
//import javax.servlet.http.HttpServlet;
//public class Dao extends HttpServlet {
//}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
		}catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public void close() {
		try {
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public int saveVaalikone(Vaalikone vaalikone) {
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			count=stmt.executeUpdate("insert into ehdokkaat(ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) values('"+vaalikone.getEhdokas_id()+"','"+vaalikone.getSukunimi()+"', '"+vaalikone.getEtunimi()+"', '"+vaalikone.getPuolue()+"', '"+vaalikone.getKotipaikkakunta()+"', "+vaalikone.getIka()+", '"+vaalikone.getMiksi_eduskuntaan()+"', '"+vaalikone.getMita_asioita_haluat_edistaa()+"', '"+vaalikone.getAmmatti()+"')");
		}catch (SQLException e) {
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
				vaalikone.setPuolue(rs.getString("puolue"));
				vaalikone.setKotipaikkakunta(rs.getString("kotipaikkakunta"));
				vaalikone.setIka(rs.getInt("ika"));
				vaalikone.setMiksi_eduskuntaan(rs.getString("miksi_eduskuntaan"));
				vaalikone.setMita_asioita_haluat_edistaa(rs.getString("mita_asioita_haluat_edistaa"));
				vaalikone.setAmmatti(rs.getString("ammatti"));
				list.add(vaalikone);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return list;
			}
	
	public int updateVaalikone(Vaalikone vaalikone) {
		int count = 0;
		String sql = "update ehdokkaat set sukunimi = ?, etunimi = ?, puolue = ?, kotipaikkakunta = ?, ika = ?, miksi_eduskuntaan = ?, mita_asioita_haluat_edistaa = ?, ammatti = ? where ehdokas_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, vaalikone.getSukunimi());
			stmt.setString(2, vaalikone.getEtunimi());
			stmt.setString(3, vaalikone.getPuolue());
			stmt.setString(4, vaalikone.getKotipaikkakunta());
			stmt.setString(5, vaalikone.getMiksi_eduskuntaan());
			stmt.setString(6, vaalikone.getMita_asioita_haluat_edistaa());
			stmt.setString(7, vaalikone.getAmmatti());
			
			stmt.setInt(8, vaalikone.getEhdokas_id());
			stmt.setInt(9, vaalikone.getIka());
			
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
				result.setPuolue(resultset.getString("puolue"));
				result.setKotipaikkakunta(resultset.getString("kotipaikkakunta"));
				result.setIka(resultset.getInt("ika"));
				result.setMiksi_eduskuntaan(resultset.getString("miksi_eduskuntaan"));
				result.setMita_asioita_haluat_edistaa(resultset.getString("mita_asioita_haluat_edistaa"));
				result.setAmmatti(resultset.getString("ammatti"));
				
			}
		}catch (SQLException e) {
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
		}catch (SQLException e) {
			
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
		}catch (SQLException e) {
			
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
		}catch (SQLException e) {
			
			e.printStackTrace();
			}
		return result;
		}
	
	
	public int saveKysymykset(Kysymykset kysymykset) {
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			count=stmt.executeUpdate("insert into kysymykset(kysymys_id, kysymys)"
					+ " values('"+kysymykset.getKysymys_id()+"', "+kysymykset.getKysymys()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		}
	
	public ArrayList<Kysymykset> readAllKysymykset() {
		ArrayList<Kysymykset> list=new ArrayList<>();
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from kysymykset");
			while (rs.next()) {
				Kysymykset kysymykset=new Kysymykset();
				kysymykset.setKysymys_id(rs.getInt("kysymys_id"));
				kysymykset.setKysymys(rs.getString("kysymys"));
				list.add(kysymykset);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		}
	
	public int updateKysymykset(Kysymykset kysymykset) {
		int count = 0;
		String sql = "update kysymykset set kysymys_id = ?, kysymys = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, kysymykset.getKysymys());
			
			stmt.setInt(2, kysymykset.getKysymys_id());
		
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
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
		}
		}
	
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
	
	public int removeCandidate(int Ehdokas_id) throws SQLException {

        int count = 0;
        String sql = "DELETE from ehdokkaat WHERE Ehdokas_id=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, Ehdokas_id);

            count = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
	
	public boolean getConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				}catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
					throw new SQLException (e);
				}
				conn = DriverManager.getConnection("jdbc:db2:mysql", "pena", "kukkuu");
			}
			return true;
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Yhdistäminen ei onnistu");
			return false;
		}
		}
	public int deleteCandidate(int ehdokas_id) {
        int count = 0;
        String sql = "delete from ehdokkaat WHERE ehdokas_id=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, ehdokas_id);

            count = stmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return count;
    }
}
	
	
	
		
		
	
	

