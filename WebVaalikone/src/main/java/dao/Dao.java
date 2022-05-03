package dao;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import Data.Kysymys;

import Data.Admin;
import Data.Ehdokas;

import java.sql.Connection;

public class Dao {
	private String url;
	private String user;
	private String pass;
	private Connection conn;

	public Dao() {
		url = "jdbc:mysql://localhost:3306/vaalikone";
		user = "haltia";
		pass = "1234";
	}

	public boolean getConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
					throw new SQLException(e);
				}
				conn = DriverManager.getConnection(url, user, pass);
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public ArrayList<Kysymys> lueKysymykset() {
		ArrayList<Kysymys> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from kysymykset");
			while (rs.next()) {
				Kysymys k = new Kysymys();
				k.setKysymys(rs.getString("kysymys"));
				k.setId(rs.getInt("kysymys_id"));
				list.add(k);
			}
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	public ArrayList<Integer> lueVastaukset(int id) {
		ArrayList<Integer> list = new ArrayList<>();
		try {
			String sql = "select * from vastaukset where ehdokas_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet RS = pstmt.executeQuery();
			while (RS.next()) {
				list.add(RS.getInt("vastaus"));
			}
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	public Admin AdminLogin(String username, String passwrd) {
		Admin admin = null;
		try {

			PreparedStatement pstmt = conn.prepareStatement("select * from adminlogin where username=? and passwrd=?");
			pstmt.setString(1, username);
			pstmt.setString(2, passwrd);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				admin = new Admin();
				admin.setUsername(rs.getString("username"));
				admin.setPasswrd(rs.getString("passwrd"));
			}
			return admin;

		} catch (Exception e) {
			return null;
		}

	}

	public ArrayList<Ehdokas> lueEhdokkaat() {
		ArrayList<Ehdokas> ehdokkaatlist = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ehdokkaat");
			while (rs.next()) {
				Ehdokas ed = new Ehdokas();
				ed.setEhdokas_id(rs.getInt("ehdokas_id"));
				ed.setSukunimi(rs.getString("sukunimi"));
				ed.setEtunimi(rs.getString("etunimi"));
				ed.setPuolue(rs.getString("puolue"));
				ed.setMiksi_eduskuntaan(rs.getString("MIKSI_EDUSKUNTAAN"));
				ed.setMita_asioita_haluat_edistaa(rs.getString("MITA_ASIOITA_HALUAT_EDISTAA"));
				ed.setKotipaikkakunta(rs.getString("KOTIPAIKKAKUNTA"));
				ed.setVaalinro(rs.getInt("vaalinro"));
				ed.setEhduser(rs.getString("ehduser"));
				ed.setEhdpass(rs.getString("ehdpass"));
				ehdokkaatlist.add(ed);
			}
			return ehdokkaatlist;
		} catch (SQLException e) {
			return null;
		}
	}

	public Ehdokas lueEhdokas(String ehdokas_id) {

		Ehdokas ed = null;

		try {

			PreparedStatement pstmt = conn.prepareStatement("select * from ehdokkaat where ehdokas_id=?");
			pstmt.setString(1, ehdokas_id);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ed = new Ehdokas();

				ed.setEhdokas_id(rs.getInt("ehdokas_id"));
				ed.setSukunimi(rs.getString("sukunimi"));
				ed.setEtunimi(rs.getString("etunimi"));
				ed.setPuolue(rs.getString("puolue"));
				ed.setMiksi_eduskuntaan(rs.getString("MIKSI_EDUSKUNTAAN"));
				ed.setMita_asioita_haluat_edistaa(rs.getString("MITA_ASIOITA_HALUAT_EDISTAA"));
				ed.setKotipaikkakunta(rs.getString("KOTIPAIKKAKUNTA"));
				ed.setVaalinro(rs.getInt("vaalinro"));
				ed.setEhduser(rs.getString("ehduser"));
				ed.setEhdpass(rs.getString("ehdpass"));
			}
			return ed;
		} catch (SQLException e) {
			return null;
		}

	}

	public ArrayList<Ehdokas> Muokkaehdokas(Ehdokas ed) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"update ehdokkaat set sukunimi=?, etunimi=?, puolue=?, MIKSI_EDUSKUNTAAN=?, MITA_ASIOITA_HALUAT_EDISTAA=?, KOTIPAIKKAKUNTA=?, vaalinro=?,ehduser=?,ehdpass=? where ehdokas_id=?");

			pstmt.setString(1, ed.getSukunimi());
			pstmt.setString(2, ed.getEtunimi());
			pstmt.setString(3, ed.getPuolue());
			pstmt.setString(4, ed.getMiksi_eduskuntaan());
			pstmt.setString(5, ed.getMita_asioita_haluat_edistaa());
			pstmt.setString(6, ed.getKotipaikkakunta());
			pstmt.setInt(7, ed.getVaalinro());
			pstmt.setString(8, ed.getEhduser());
			pstmt.setString(9, ed.getEhdpass());
			pstmt.setInt(10, ed.getEhdokas_id());
			
			pstmt.executeUpdate();
			return lueEhdokkaat();

		} catch (SQLException e) {
			return null;
		}
	}

	public int countKysymykset() {
		int maara = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(DISTINCT kysymys_id) AS kysymykset FROM vastaukset");
			while (rs.next()) {
				maara = rs.getInt("kysymykset");
			}
			return maara;
		} catch (SQLException e) {
			return 0;
		}
	}

	public ArrayList<Ehdokas> lisaaEhdokas(Ehdokas ed) {

		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"insert into ehdokkaat (sukunimi, etunimi, puolue, MIKSI_EDUSKUNTAAN, MITA_ASIOITA_HALUAT_EDISTAA, KOTIPAIKKAKUNTA, vaalinro, ehduser, ehdpass) values (?,?,?,?,?,?,?,?,?)");

			pstmt.setString(1, ed.getSukunimi());
			pstmt.setString(2, ed.getEtunimi());
			pstmt.setString(3, ed.getPuolue());
			pstmt.setString(4, ed.getMiksi_eduskuntaan());
			pstmt.setString(5, ed.getMita_asioita_haluat_edistaa());
			pstmt.setString(6, ed.getKotipaikkakunta());
			pstmt.setInt(7, ed.getVaalinro());
			pstmt.setString(8, ed.getEhduser());
			pstmt.setString(9, ed.getEhdpass());

			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(
					"select ehdokas_id from ehdokkaat where sukunimi=? and etunimi=? and puolue=? and MIKSI_EDUSKUNTAAN=? and MITA_ASIOITA_HALUAT_EDISTAA=? and KOTIPAIKKAKUNTA=? and vaalinro=?");
			pstmt.setString(1, ed.getSukunimi());
			pstmt.setString(2, ed.getEtunimi());
			pstmt.setString(3, ed.getPuolue());
			pstmt.setString(4, ed.getMiksi_eduskuntaan());
			pstmt.setString(5, ed.getMita_asioita_haluat_edistaa());
			pstmt.setString(6, ed.getKotipaikkakunta());
			pstmt.setInt(7, ed.getVaalinro());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int ehdokas = rs.getInt("ehdokas_id");
				lisaaVastaus(ehdokas);
			}
			return lueEhdokkaat();
		} catch (SQLException e) {
			return null;
		}
	}

	public void lisaaVastaus(int ehdokas) {
		ArrayList<Kysymys>kysymykset = lueKysymykset();
		Random rn = new Random();
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"insert into vastaukset (ehdokas_id, kysymys_id, vastaus,kommentti) values (?,?,?,?)");
			for (int i = 0; i < kysymykset.size(); i++) {
				int vastaus = rn.nextInt(5) + 1;
				pstmt.setInt(1, ehdokas);
				pstmt.setInt(2, kysymykset.get(i).getId());
				pstmt.setInt(3, vastaus);
				pstmt.setString(4, "ehdokkaan " + ehdokas + " vastaus kysymykseen " + kysymykset.get(i).getId());

				pstmt.executeUpdate();
			}

		} catch (SQLException e) {

		}

	}

	public Ehdokas lueEhdokkaatPoisto() {
		Ehdokas list = new Ehdokas();
		try {
			Statement stmt = conn.createStatement();
			ResultSet RS = stmt.executeQuery("select * from ehdokkaat");
			while (RS.next()) {
				Ehdokas ehdokas = new Ehdokas();
				ehdokas.setEhdokas_id(RS.getInt("ehdokas_id"));
				list = ehdokas;
			}
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	public Ehdokas poistaEhdokas(String ehdokas) {
		try {
			String sql = "DELETE FROM ehdokkaat WHERE ehdokas_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ehdokas);
			String sql2 = "DELETE FROM vastaukset WHERE ehdokas_id = ?";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, ehdokas);
			pstmt2.executeUpdate();
			pstmt.executeUpdate();
			return lueEhdokkaatPoisto();
		} catch (SQLException e) {
			return null;
		}
	}
}
