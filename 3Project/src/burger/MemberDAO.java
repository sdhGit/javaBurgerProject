package burger;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import burger.DBUtil;

public class MemberDAO {

	public static boolean insert(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getMySQLConnection();
			String sql2 = "select * from member ";
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			while (rs.next()) {

//				System.out.println(rs.getString(2));
				if (rs.getString(2).equals(vo.getId())) {

					return false;
				}

			}

			String sql = "insert into Member (ID, PASSWORD, NAME, TEL, EMAIL, CARD, YYMM, CVC) values (?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getCard());
			pstmt.setString(7, vo.getYymm());
			pstmt.setString(8, vo.getCvc());
			pstmt.executeUpdate();
			DBUtil.close(conn);
			DBUtil.close(pstmt);

			new Login();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;

	}

	public static boolean login(String ids, String pws) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getMySQLConnection();

			String sql = "select * from Member WHERE ID = " + "'" + ids + "'";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (pws.equals(rs.getString("PASSWORD"))) {
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		}
		return false;

	}

	public static String findID(String s, String p) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String re = "";
		try {
			conn = DBUtil.getMySQLConnection();
			String sql2 = "select * from member";
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {

				if (rs.getString(4).equals(s) && rs.getString(5).equals(p)) {
					re =  rs.getString(2);
					break;
				} else{
					re = "정보가일치하지않습니다";
					break;
				}
			}
			DBUtil.close(conn);
			DBUtil.close(pstmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;

	}

	public static String findPW(String i, String s) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String re ="";
		try {
			conn = DBUtil.getMySQLConnection();
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				if (rs.getString(2).equals(i) && rs.getString(4).equals(s)) {
					re =  rs.getString(3);
					break;
				} else {
					re = "정보가일치하지않습니다";
					break;
				}

			}

			DBUtil.close(conn);
			DBUtil.close(pstmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;

	}

	// 다예가 한부분
	public static ArrayList<MemberVO> select() {
		ArrayList<MemberVO> list = null;
		try {
			Connection conn = DBUtil.getMySQLConnection();
			String sql = "select * from member order by idx desc";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
//			ResultSet 객체에서 얻어온 테이블의 글 목록을 ArrayList에 저장한다.
			list = new ArrayList<MemberVO>();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setEmail(rs.getString("email"));
//				vo.setWriteDate(rs.getTimestamp("writeDate"));
				list.add(vo);
			}
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static String findI(String s, String n) {
		String re = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getMySQLConnection();
			String sql2 = "select * from member";
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				if (rs.getString(3).equals(s) && rs.getString(4).equals(n)) {
					re= rs.getString(2);
					break;
//				} else if (rs.getString(2).equals(null)) {
				}else {					
					re= "정보가일치하지않습니다.";
					break;
				}
			}
			DBUtil.close(conn);
			DBUtil.close(pstmt);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return re;

	}

}
