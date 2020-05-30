package burger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class MenuDAO {

	public static ArrayList<MenuVO> list() {
		ArrayList<MenuVO> list = new ArrayList<>();
		MenuVO vo = new MenuVO();
		vo.getName();
		vo.getPrice();
		vo.getCount();
		list.add(vo);
		
		return list;
	}

	public static ArrayList<MenuVO> select(String date) {
		ArrayList<MenuVO> list = null;
		try {
			Connection conn = DBUtil.getMySQLConnection();
			String sql = "select * from list where writedate like ?";
//			SELECT * FROM memo WHERE NAME = '홍길동' OR NAME = '임꺽정';
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, date);
			
			ResultSet rs = pstmt.executeQuery();
//			ResultSet 객체에서 얻어온 테이블의 글 목록을 ArrayList에 저장한다.
			list = new ArrayList<MenuVO>();
			while(rs.next()) {
				MenuVO vo = new MenuVO();
				vo.setName(rs.getString("name"));
				vo.setCount(rs.getInt("count"));
				vo.setPrice(rs.getInt("price"));
				vo.setDate(rs.getDate("writedate"));
				list.add(vo);
			}
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<MenuVO> select1() {
		ArrayList<MenuVO> list = null;
		try {
			Connection conn = DBUtil.getMySQLConnection();
			String sql = "select * from list";
//			SELECT * FROM memo WHERE NAME = '홍길동' OR NAME = '임꺽정';
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
//			ResultSet 객체에서 얻어온 테이블의 글 목록을 ArrayList에 저장한다.
			list = new ArrayList<MenuVO>();
			while(rs.next()) {
				MenuVO vo = new MenuVO();
				vo.setName(rs.getString("name"));
				vo.setCount(rs.getInt("count"));
				vo.setPrice(rs.getInt("price"));
				vo.setDate(rs.getDate("writedate"));
				list.add(vo);
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
