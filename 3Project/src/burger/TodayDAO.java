package burger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class TodayDAO {

//	public static ArrayList<MenuVO> list() {
//		ArrayList<MenuVO> list = new ArrayList<>();
//		MenuVO vo = new MenuVO();
//		vo.getName();
//		vo.getPrice();
//		vo.getCount();
//		list.add(vo);
//		
//		return list;
//	}

	public static void insert(String num) {
		
		Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String number = null;
	      try {
				conn = DBUtil.getMySQLConnection();
				
				
				
			String sql = "insert into today (number) values (?)";
	        
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setString(1, num);
	        
	        pstmt.executeUpdate();
	       
	        DBUtil.close(conn);
	        DBUtil.close(pstmt);
		
			
			}catch(SQLException e) {
				e.printStackTrace();
			}

		
	}
	
	
	public static int select() {
		int list = 0 ;
		try {
			Connection conn = DBUtil.getMySQLConnection();
			String sql = "SELECT * FROM today";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

				while(rs.next()) {
					TodayVO vo = new TodayVO();
					vo.setIdx(rs.getInt("idx"));
					list = vo.getIdx();
				}
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static String select1() {
		int temp = TodayDAO.select();
		String list = null;
		try {
			Connection conn = DBUtil.getMySQLConnection();
			String sql = "SELECT * FROM today WHERE idx = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, temp);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			TodayVO vo = new TodayVO();
				vo.setNumber(rs.getString("number"));
				list = vo.getNumber();
			}
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
