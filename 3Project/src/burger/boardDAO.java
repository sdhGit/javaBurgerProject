package burger;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import burger.DBUtil;

public class boardDAO {
	
	public static void insert(boardVO vo) { // DB에 후기 데이터 넣음
//		이름, 비밀번호, 메모가 모두 입력되었나 검사한다.
		boolean flag = true;
		if (vo.getMemo().length() == 0 && vo.getId().equals(null)) {
			JOptionPane.showMessageDialog(null, "메모가 입력되지 않았습니다.");
			flag = false;
		}
		
		

//		이름, 메모가 모두 입력되었으면 테이블에 저장한다.
			if(flag) {
			try {
				Connection conn = DBUtil.getMySQLConnection();
				String sql = "insert into board (id, memo, starPoint, Filename) values (?, ?, ?, ?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getMemo());
				pstmt.setInt(3, vo.getStarPoint());
				pstmt.setString(4, vo.getFilename());
				pstmt.executeUpdate();
				DBUtil.close(conn);
				DBUtil.close(pstmt);
				JOptionPane.showMessageDialog(null, "메모가 입력되었습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			}
	}
		
		
			

	public static ArrayList<boardVO> getList(String sql) { // db에 있는 데이터 다 가져와서 ArrayList에 넣고 반환함
		ArrayList<boardVO> list = null;
		try {
			Connection conn = DBUtil.getMySQLConnection();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
//			ResultSet 객체에서 얻어온 테이블의 글 목록을 ArrayList에 저장한다.
			list = new ArrayList<boardVO>();
			while (rs.next()) {
				boardVO vo = new boardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setId(rs.getString("id"));
				vo.setMemo(rs.getString("memo"));
				vo.setWriteDate(rs.getTimestamp("writeDate"));
				vo.setStarPoint(rs.getInt("starPoint"));
				vo.setFilename(rs.getString("Filename"));
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

	
	
	public static void VOtoPanel(ArrayList<boardVO> vo, JPanel[] memoPanels) { // vo 객체들을 각각의 JPanel에 부착하기
		int current_size;
		if (vo.size() < memoPanels.length) {
			boardProject.setCurrent_size(vo.size());
			current_size = vo.size();
		}
			
		else {
			boardProject.setCurrent_size(memoPanels.length); // 화면에 보여지는 최대 후기 개수는 memoPanels.length만큼이다
			current_size = memoPanels.length;
		}
		JLabel[] label = new JLabel[6]; // db 멤버가 6개임.
		for (int i = 0; i < current_size; i++) {
			JPanel voPanel = new JPanel(new GridLayout(3, 1, 8, 8)); // 한개의 후기 패널의 layout
			voPanel.setPreferredSize(new Dimension(300, 400));

			TitledBorder tb = new TitledBorder(new LineBorder(Color.black), (i + 1) + "번"); // panel 테두리 설정
			tb.setTitleColor(Color.red);
			voPanel.setBorder(tb);

			JPanel miniPanel = new JPanel(new GridLayout(2, 1)); // 이름과 miniPanel2를 붙일 패널
			JPanel miniPanel2 = new JPanel(); // starPoint와 날짜만 따로 이 panel에 붙임
			
			boardVO board = vo.get(i);

			label[0] = new JLabel(board.getId());
			
			JPanel star_point = new JPanel(new FlowLayout(FlowLayout.LEFT));
			star_point.setPreferredSize(new Dimension(95 ,20));
			int num = board.getStarPoint();
			
			label[1] = new JLabel();
			for(int j=0;j<5;j++) {
				if(j<num) {
					star_point.add(new JLabel(new ImageIcon("images/star.png")));
				}
				else {
					star_point.add(new JLabel(new ImageIcon("images/gray_star.png")));
				}
				
			}
			

			Date date = new Date(); // 오늘 날짜 구하기
			SimpleDateFormat sdf = new SimpleDateFormat("MM월 dd일", Locale.KOREA);
			String today = sdf.format(date);

			Date dDate = new Date(); // 어제 날짜 구하기
			dDate = new Date(dDate.getTime()+(1000*60*60*24*-1));
			String yesterday = sdf.format(dDate);
			
			String memo_date = sdf.format(board.getWriteDate()); // 후기를 작성한 날짜
			if (memo_date.equals(today)) { // 후기를 오늘 작성했다면
				memo_date = "오늘";
			} 
			else if(memo_date.equals(yesterday)) {
				memo_date = "어제";
			}
			else {
				memo_date = sdf.format(board.getWriteDate());
			}
			label[2] = new JLabel("" + memo_date);
			
			if (board.getFilename().equals("")) {
				label[3] = new JLabel(new ImageIcon("images/NoImage.PNG"));
				// label[3] = new JLabel(); // 음식 사진
			}

			else {
				label[3] = new JLabel(new ImageIcon(board.getFilename())); // 음식 사진
				
			}

			label[4] = new JLabel("" + board.getMemo());
			JTextArea textArea = new JTextArea();
			textArea.setText(label[4].getText());
			JScrollPane scroll = new JScrollPane(textArea);

			miniPanel.add(label[0]);
			miniPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
			miniPanel2.add(star_point); // starPoint
			miniPanel2.add(label[2]); // 날짜
			miniPanel.add(miniPanel2, new FlowLayout(FlowLayout.LEFT));
			voPanel.add(miniPanel); // 이름, starPoint, 날짜
			voPanel.add(label[3]); // 이미지
			voPanel.add(scroll); // 후기 메모
			voPanel.add(label[3]); // 이미지
			voPanel.add(scroll); // 후기 메모

			memoPanels[i] = new JPanel();
			memoPanels[i].add(voPanel);
		}

	}

	// **Overload** VOtoPanel
	public static void VOtoPanel(ArrayList<boardVO> vo, JPanel[] memoPanels ,JPanel[] panels) { // vo 객체들을 각각의 JPanel에 부착하기
		
		int current_size;
		if (vo.size() < memoPanels.length) {
			boardProject.setCurrent_size(vo.size());
			current_size = vo.size();
		}
			
		else {
			boardProject.setCurrent_size(memoPanels.length); // 화면에 보여지는 최대 후기 개수는 memoPanels.length만큼이다
			current_size = memoPanels.length;
		}
		JLabel[] label = new JLabel[6]; // db 멤버가 6개임.

		for (int i = 0; i < current_size; i++) {
			JPanel voPanel = new JPanel(new GridLayout(3, 1, 8, 8)); // 한개의 후기 패널의 layout
			voPanel.setPreferredSize(new Dimension(500, 500));
			TitledBorder tb = new TitledBorder(new LineBorder(Color.black), (i + 1) + "번"); // panel 테두리 설정
			tb.setTitleColor(Color.red);
			voPanel.setBorder(tb);

			JPanel miniPanel = new JPanel(new GridLayout(2, 1)); // 이름과 miniPanel2를 붙일 패널
			JPanel miniPanel2 = new JPanel(); // starPoint와 날짜만 따로 이 panel에 붙임
			boardVO board = vo.get(i);

			label[0] = new JLabel(board.getId());
			JPanel star_point = new JPanel(new FlowLayout(FlowLayout.LEFT));
			int num = board.getStarPoint();
			
			label[1] = new JLabel();
			for(int j=0;j<num;j++) {
				star_point.add(new JLabel(new ImageIcon("images/star.png")));
			}
			

			Date date = new Date(); // 오늘 날짜 구하기
			SimpleDateFormat sdf = new SimpleDateFormat("MM월 dd일", Locale.KOREA);
			String today = sdf.format(date);

			Date dDate = new Date(); // 어제 날짜 구하기
			dDate = new Date(dDate.getTime()+(1000*60*60*24*-1));
			String yesterday = sdf.format(dDate);
			
			String memo_date = sdf.format(board.getWriteDate()); // 후기를 작성한 날짜
			if (memo_date.equals(today)) { // 후기를 오늘 작성했다면
				memo_date = "오늘";
			} 
			else if(memo_date.equals(yesterday)) {
				memo_date = "어제";
			}
			else {
				memo_date = sdf.format(board.getWriteDate());
			}
			label[2] = new JLabel("" + memo_date);

			if (board.getFilename().equals("")) {
				label[3] = new JLabel(new ImageIcon("images/NoImage.PNG"));
				// label[3] = new JLabel(); // 음식 사진
			}

			else {
				label[3] = new JLabel(new ImageIcon(board.getFilename())); // 음식 사진
			}

			label[4] = new JLabel("" + board.getMemo());
			JTextArea textArea = new JTextArea();
			textArea.setText(label[4].getText());
			JScrollPane scroll = new JScrollPane(textArea);

			miniPanel.add(label[0]);
			miniPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
			miniPanel2.add(star_point); // starPoint
			miniPanel2.add(label[2]); // 날짜
			miniPanel.add(miniPanel2);
			voPanel.add(miniPanel); // 이름, starPoint, 날짜
			voPanel.add(label[3]); // 이미지
			voPanel.add(scroll); // 후기 메모

			panels[i] = new JPanel();
			panels[i].add(voPanel);

		}
	}

}
