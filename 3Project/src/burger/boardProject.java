package burger;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class boardProject extends JFrame implements ActionListener{

	private JLabel label = new JLabel("2");
	private JLabel image = new JLabel();
	private JPanel menu = new JPanel(new GridLayout(1, 2)); // chechkPhoto , onlyPhoto, m_label1 , 2, 3이 붙을 메뉴 panel
	private JPanel panel1 = new JPanel(); // checkPhoto, onlyPhoto 가 붙을 panel
	private JPanel panel2 = new JPanel(); // m_label1, 2, 3이 붙을 panel
	private JCheckBox checkPhoto = new JCheckBox();
	private JLabel onlyPhoto = new JLabel("사진 리뷰만");
	private JLabel m_label1 = new JLabel("최신순");
	private JLabel m_label2 = new JLabel("별점 높은순");
	private JLabel m_label3 = new JLabel("별점 낮은순");
	private static final int menuSize = 50; // 최신 50개의 후기만 보여줌
	private static JPanel[] memoPanels = new JPanel[menuSize]; // 여러개의 후기 패널 객체들이 붙을 전체 하나의 panel
	private static JPanel wholePanel;
	private static ArrayList<boardVO> arrlist = new ArrayList<>(); // 데이터들을 최신순, 별점순으로 sort 하기 위해 필요한 멤버변수
	private String sql = "select * from board order by idx desc"; // 기본 정렬
	private static int current_size; // 현재 화면에 나와 있는 후기 개수

	int check_color; // '최신순', '별점 높은순', '별점 낮은순' 중 어떤 라벨의 색깔이 검은색으로 활성 되었는지 표시. 각각 0, 1, 2
	private Dimension dimension; // 윈도우의 크기를 담기 위한 변수
	MakeBoard dlg = null;

	public static int getCurrent_size() {
		return current_size;
	}

	public static void setCurrent_size(int current_size) {
		boardProject.current_size = current_size;
	}

	public boardProject() {
		this.setTitle("후기 목록");
		this.setBounds(555, 308, 810, 740);
		this.setBackground(Color.YELLOW);

//		ImageIcon background_img = new ImageIcon("images/background.jpg");
//		
//		dimension = this.getSize();
//		
//		// 배경 Panel 생성후 컨텐츠페인으로 지정
//		JPanel background = new JPanel() {
//			public void paintComponent(Graphics g) {
//				g.drawImage(background_img.getImage(), 0, 0, null);
//				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
//				super.paintComponent(g);
//			}
//		};
		// background.setPreferredSize(new Dimension(dimension.width,
		// dimension.height));
		// background.setLayout(new GridLayout(2,1));
		
	

		m_label1.setPreferredSize(new Dimension(50, 22));
		m_label2.setPreferredSize(new Dimension(70, 22));
		m_label3.setPreferredSize(new Dimension(70, 22));

		m_label1.setOpaque(true);
		m_label2.setOpaque(true);
		m_label3.setOpaque(true);
		m_label1.setForeground(Color.BLACK);
		m_label2.setForeground(new Color(30, 30, 30, 110));
		m_label3.setForeground(new Color(30, 30, 30, 110));

		arrlist = boardDAO.getList(sql);

		m_label1.addMouseListener(new MouseAdapter() { // 최신순을 클릭했을 때

			@Override
			public void mouseClicked(MouseEvent e) {
				if (check_color != 0) { // 현재 다른 label이 선택 되었다면
					for (int i = 0; i < current_size; i++) {
						wholePanel.remove(memoPanels[i]);
					}

					m_label1.setForeground(Color.BLACK);
					m_label2.setForeground(new Color(30, 30, 30, 110));
					m_label3.setForeground(new Color(30, 30, 30, 110));

					check_color = 0; // m_label이 현재 검은색이라고 표시
					arrlist = boardDAO.getList(sql); // 최신순으로 정렬
					boardDAO.VOtoPanel(arrlist, memoPanels); // memoPanels 값이 변경됨
					for (int i = 0; i < current_size; i++) {
						wholePanel.add(memoPanels[i]);
					}
					revalidate();
//					
				}
			}

		});

		m_label2.addMouseListener(new MouseAdapter() { // 별점 높은순을 클릭했을 때

			@Override
			public void mouseClicked(MouseEvent e) {
				if (check_color != 1) { // 현재 다른 label이 선택 되었다면
					for (int i = 0; i < current_size; i++) {
						wholePanel.remove(memoPanels[i]);
					}

					m_label2.setForeground(Color.BLACK);
					m_label1.setForeground(new Color(30, 30, 30, 110));
					m_label3.setForeground(new Color(30, 30, 30, 110));
					check_color = 1; // m_label이 현재 검은색이라고 표시
					String sql = "select * from board order by starPoint desc";
					arrlist = boardDAO.getList(sql); // 별점 높은순으로 정렬
					boardDAO.VOtoPanel(arrlist, memoPanels); // memoPanels 값이 변경됨
					for (int i = 0; i < current_size; i++) {
						wholePanel.add(memoPanels[i]);
					}
					revalidate();
					
				}
			}

		});

		m_label3.addMouseListener(new MouseAdapter() { // 별점 낮은순을 클릭했을 때

			@Override
			public void mouseClicked(MouseEvent e) {
				if (check_color != 2) { // 현재 다른 label이 선택 되었다면
					for (int i = 0; i < current_size; i++) {
						wholePanel.remove(memoPanels[i]);
					}

					m_label3.setForeground(Color.BLACK);
					m_label1.setForeground(new Color(30, 30, 30, 110));
					m_label2.setForeground(new Color(30, 30, 30, 110));

					check_color = 2; // m_label이 현재 검은색이라고 표시
					String sql = "select * from board order by starPoint";
					arrlist = boardDAO.getList(sql); // 별점 낮은순으로 정렬
					boardDAO.VOtoPanel(arrlist, memoPanels); // memoPanels 값이 변경됨
					for (int i = 0; i < current_size; i++) {
						wholePanel.add(memoPanels[i]);
					}

					revalidate();
					
				}
			}

		});

		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.add(checkPhoto);

		checkPhoto.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == 1) { // checkPhoto가 check 되었으면
					for (int i = 0; i < current_size; i++) { // 기존에 있던 wholePanel을 지워줌
						wholePanel.remove(memoPanels[i]);
					}

					ArrayList<boardVO> list = arrlist;
					ArrayList<boardVO> photoVO = new ArrayList<>();
					for (int i = 0; i < list.size(); i++) {
						boardVO vo = list.get(i);
						if (!vo.getFilename().equals("")) {
							photoVO.add(vo);
						}
					}
					/*
					 * current_size = photoVO.size(); //photo가 있는 후기들의 개수
					 * 
					 * JPanel[] panels = new JPanel[current_size];
					 * 
					 * for (int i = 0; i < panels.length; i++) { panels[i] = new JPanel(); }
					 * 
					 * boardProject.VOtoPanel(photoVO, panels);
					 */
					boardDAO.VOtoPanel(photoVO, memoPanels);
					// wholePanel = new JPanel(new GridLayout(current_size, 1));
					
					for (int i = 0; i < current_size; i++) {
						wholePanel.add(memoPanels[i]); // 변경된 panel을 다시 부착
					}

					// JScrollPane scroll = new JScrollPane(wholePanel);
					// add(scroll, BorderLayout.CENTER);
					revalidate(); // 변경한 내용을 다시 보여줌
				} else { // check를 풀면
					for (int i = 0; i < current_size; i++) { // 기존에 있던 wholePanel을 지워줌
						wholePanel.remove(memoPanels[i]);
					}

					boardDAO.VOtoPanel(arrlist, memoPanels);
					// wholePanel = new JPanel(new GridLayout(current_size, 1));
					for (int i = 0; i < current_size; i++) {
						wholePanel.add(memoPanels[i]);
					}

					// JScrollPane scroll = new JScrollPane(wholePanel);
					// add(scroll, BorderLayout.CENTER);
					revalidate(); // 변경한 내용을 다시 보여줌
				}
			}
		});
		JButton btn = new JButton();
		btn.setIcon(new ImageIcon("images/memo2.png"));
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.addActionListener(this);
		
		
		panel1.add(onlyPhoto);
		panel1.add(btn);

		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel2.add(m_label1);
		panel2.add(m_label2);
		panel2.add(m_label3);

		menu.add(panel1);
		menu.add(panel2);

		this.add(menu, BorderLayout.NORTH);

		for (int i = 0; i < memoPanels.length; i++) {
			memoPanels[i] = new JPanel();
		}

		boardDAO.VOtoPanel(arrlist, memoPanels);
		wholePanel = new JPanel(new GridLayout(current_size, 1));

		for (int i = 0; i < current_size; i++) { // 사이즈 개수만큼 wholePanel에 붙이기
			wholePanel.add(memoPanels[i]);
		}

		JScrollPane scroll = new JScrollPane(wholePanel);
		this.add(scroll, BorderLayout.CENTER);

		// JScrollPane scrollPane = new JScrollPane(background);
		// setContentPane(scrollPane);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(dlg == null)
			dlg = new MakeBoard(this, "TestDialog",false);
		else
			dlg.requestFocus(); // 이미 만들어졌으면 포커스만 다이얼로그에게 주겠음.
		
	}
	
	public static void main(String[] args) {
		new boardProject();
	}
	
}
