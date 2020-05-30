package burger;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import burger.MemberVO;

public class MainFrame extends JFrame {
	static int addPrice = 5000;

	MyBurger_Order MO = new MyBurger_Order();

	JPanel titlePanel = new JPanel();
	JPanel menuPanel = new JPanel();
	CardLayout card = new CardLayout();
	JPanel cardMain = new JPanel(card);
	JPanel cardPanel1 = new JPanel(new GridLayout(2, 3));
	JPanel cardPanel2 = new JPanel(new GridLayout(2, 3));
	JPanel cardPanel3 = new JPanel(new GridLayout(2, 4));
	JPanel cardPanel4 = new JPanel(new BorderLayout());
	JPanel tablePanel = new JPanel();
	JPanel payPanel = new JPanel(new GridLayout(1, 1));
	JPanel bannerPanel = new JPanel();
	ImageIcon bannerImage = new ImageIcon("./src/Image/banner.jpg");
	JLabel bannerLabel = new JLabel(bannerImage);

//	로그아웃버튼
	JButton logOut = new JButton("Logout");

//	메모장
	ImageIcon memoImage = new ImageIcon("./src/Image/memo.png");
	JButton memoBtn = new JButton(memoImage);

//	메뉴바
	String menubarImage1_1 = "./src/Image/setmenubar1.jpg";
	String menubarImage1_2 = "./src/Image/setmenubar2.jpg";
	String menubarImage2_1 = "./src/Image/burgermenubar1.jpg";
	String menubarImage2_2 = "./src/Image/burgermenubar2.jpg";
	String menubarImage3_1 = "./src/Image/drinkmenubar1.jpg";
	String menubarImage3_2 = "./src/Image/drinkmenubar2.jpg";
	String menubarImage4_1 = "./src/Image/sidemenubar1.jpg";
	String menubarImage4_2 = "./src/Image/sidemenubar2.jpg";

	ImageIcon setmenubar1 = new ImageIcon(menubarImage1_1);
	ImageIcon setmenubar2 = new ImageIcon(menubarImage1_2);
	ImageIcon burgermenubar1 = new ImageIcon(menubarImage2_1);
	ImageIcon burgermenubar2 = new ImageIcon(menubarImage2_2);
	ImageIcon drinkmenubar1 = new ImageIcon(menubarImage3_1);
	ImageIcon drinkmenubar2 = new ImageIcon(menubarImage3_2);
	ImageIcon sidemenubar1 = new ImageIcon(menubarImage4_1);
	ImageIcon sidemenubar2 = new ImageIcon(menubarImage4_2);

	JButton menubarBtn1 = new JButton(setmenubar2);
	JButton menubarBtn2 = new JButton(burgermenubar1);
	JButton menubarBtn3 = new JButton(drinkmenubar1);
	JButton menubarBtn4 = new JButton(sidemenubar1);

//	세트메뉴
	String setImage1_1 = "./src/Image/set1_off.png";
	String setImage1_2 = "./src/Image/set-01.png";
	String setImage2_1 = "./src/Image/set2_off.png";
	String setImage2_2 = "./src/Image/set-02.png";
	String setImage3_1 = "./src/Image/set3_off.png";
	String setImage3_2 = "./src/Image/set-03.png";
	String setImage4_1 = "./src/Image/set4_off.png";
	String setImage4_2 = "./src/Image/set-04.png";
	String setImage5_1 = "./src/Image/set5_off.png";
	String setImage5_2 = "./src/Image/set-05.png";
	String setImage6_1 = "./src/Image/set6_off.png";
	String setImage6_2 = "./src/Image/set-06.png";

	ImageIcon setImageIcon1 = new ImageIcon(setImage1_2);
	ImageIcon setImageIcon2 = new ImageIcon(setImage2_2);
	ImageIcon setImageIcon3 = new ImageIcon(setImage3_2);
	ImageIcon setImageIcon4 = new ImageIcon(setImage4_2);
	ImageIcon setImageIcon5 = new ImageIcon(setImage5_2);
	ImageIcon setImageIcon6 = new ImageIcon(setImage6_2);

	JButton setBtn1 = new JButton(setImageIcon1);
	JButton setBtn2 = new JButton(setImageIcon2);
	JButton setBtn3 = new JButton(setImageIcon3);
	JButton setBtn4 = new JButton(setImageIcon4);
	JButton setBtn5 = new JButton(setImageIcon5);
	JButton setBtn6 = new JButton(setImageIcon6);

//	버거단품
	String burgerImage1 = "./src/Image/burger1_on.jpg";
	String burgerImage2 = "./src/Image/burger2_on.jpg";
	String burgerImage3 = "./src/Image/burger3_on.jpg";
	String burgerImage4 = "./src/Image/burger4_on.jpg";
	String burgerImage5 = "./src/Image/burger5_on.jpg";
	String burgerImage6 = "./src/Image/burger6_on.jpg";

	ImageIcon burgerImageIcon1 = new ImageIcon(burgerImage1);
	ImageIcon burgerImageIcon2 = new ImageIcon(burgerImage2);
	ImageIcon burgerImageIcon3 = new ImageIcon(burgerImage3);
	ImageIcon burgerImageIcon4 = new ImageIcon(burgerImage4);
	ImageIcon burgerImageIcon5 = new ImageIcon(burgerImage5);
	ImageIcon burgerImageIcon6 = new ImageIcon(burgerImage6);

	JButton burgerBtn1 = new JButton(burgerImageIcon1);
	JButton burgerBtn2 = new JButton(burgerImageIcon2);
	JButton burgerBtn3 = new JButton(burgerImageIcon3);
	JButton burgerBtn4 = new JButton(burgerImageIcon4);
	JButton burgerBtn5 = new JButton(burgerImageIcon5);
	JButton burgerBtn6 = new JButton(burgerImageIcon6);

//	사이드단품
	String sideImage1 = "./src/Image/side1_on.jpg";
	String sideImage2 = "./src/Image/side2_on.jpg";
	String sideImage3 = "./src/Image/side3_on.jpg";
	String sideImage4 = "./src/Image/side4_on.jpg";
	String sideImage5 = "./src/Image/drink1_on.jpg";
	String sideImage6 = "./src/Image/drink2_on.jpg";
	String sideImage7 = "./src/Image/drink3_on.jpg";
	String sideImage8 = "./src/Image/drink4_on.jpg";

	ImageIcon sideImageIcon1 = new ImageIcon(sideImage1);
	ImageIcon sideImageIcon2 = new ImageIcon(sideImage2);
	ImageIcon sideImageIcon3 = new ImageIcon(sideImage3);
	ImageIcon sideImageIcon4 = new ImageIcon(sideImage4);
	ImageIcon sideImageIcon5 = new ImageIcon(sideImage5);
	ImageIcon sideImageIcon6 = new ImageIcon(sideImage6);
	ImageIcon sideImageIcon7 = new ImageIcon(sideImage7);
	ImageIcon sideImageIcon8 = new ImageIcon(sideImage8);

	JButton sideBtn1 = new JButton(sideImageIcon1);
	JButton sideBtn2 = new JButton(sideImageIcon2);
	JButton sideBtn3 = new JButton(sideImageIcon3);
	JButton sideBtn4 = new JButton(sideImageIcon4);
	JButton sideBtn5 = new JButton(sideImageIcon5);
	JButton sideBtn6 = new JButton(sideImageIcon6);
	JButton sideBtn7 = new JButton(sideImageIcon7);
	JButton sideBtn8 = new JButton(sideImageIcon8);

//	결제
	String payImage = "./src/Image/pay.jpg";
	ImageIcon payImageIcon1 = new ImageIcon(payImage);
	JButton payBtn1 = new JButton(payImageIcon1);

	String[] idx = { "1", "2", "3", "4", "5" };

	int i = 0;
	public static ArrayList<MenuVO> list = new ArrayList<>(); // new MainFrame() 되는 거 상관없이 list값 저장하기 위해 static
	public static int count = 0; // new MainFrame이 몇 번 실행 되었는지 카운트 함

//	마이버거
	JPanel mainPanel = new JPanel(new GridLayout(2, 1));
	JPanel topPanel = new JPanel();
	JLabel topLable = new JLabel();

	JPanel BottomPanel = new JPanel();
	JPanel Bread = new JPanel();
	JLabel BottomLable = new JLabel("Bread", JLabel.CENTER);
	JCheckBox Ott, Wit;
	ButtonGroup group = new ButtonGroup();

	JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
	JLabel dummy1 = new JLabel();
	JLabel dummy2 = new JLabel();
	JLabel dummy3 = new JLabel();
	JButton next = new JButton();

	JLabel breadLabel = new JLabel();

	String menu = "나만의버거";
	int price = 5000;
	String[] columnNames = { "번호", "메뉴", "수량", "가격" };
	DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	String[] rowData = new String[4];
	static DecimalFormat format = new DecimalFormat("###,###");
	JTable table = new JTable(model);
	JScrollPane sp = new JScrollPane(table);

	int totalPrice = 0;
	JLabel totalTitle = new JLabel("합계 : ");
	JLabel totalAmount = new JLabel();
	MenuVO vo = new MenuVO();

	public MainFrame(String name, int price, int count) {

//		if (this.count == 0) { // MainFrame 생성자가 처음 실행된 거라면 list에 수량 0, 가격 0 인 VO 객체 한 개를 추가함
//			list.add(vo);
//			System.out.println(count);
//		}

//	현황

		for (MenuVO dao : list) {
			String prices = dao.getPrice()+"";
			int prices2 = dao.getPrice();
			rowData[0] = ++i + "";
			rowData[1] = dao.getName();
			rowData[2] = dao.getCount() + "";
			rowData[3] = prices;
			totalPrice += prices2;
			model.addRow(rowData);
		}

//		선택 삭제
		JButton deletebutton = new JButton("선택 삭제");
		deletebutton.setBounds(200, 10, 80, 30);
		this.add(deletebutton);
		deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int dd = table.getSelectedRow();
					totalPrice = totalPrice -= list.get(dd).getPrice();
					totalAmount.setText(format.format(totalPrice));
					// totalAmount.setText(totalPrice -= list.get(dd).getPrice());
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					list.remove(dd);
					model.removeRow(dd);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(table, "선택된 행이 없어요", "화영이바보!", JOptionPane.OK_OPTION);
				}
			}
		});

		JPanel bannerPanel = new JPanel(new GridLayout(1, 2));

		totalTitle.setFont(new Font("D2coding", Font.BOLD, 20));
		totalAmount.setFont(new Font("D2coding", Font.BOLD, 20));
		totalAmount.setText(format.format(totalPrice));
		JPanel totalAmountPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		totalAmountPanel.add(totalAmount);
		totalAmountPanel.add(deletebutton);
		bannerPanel.add(totalTitle);
		bannerPanel.add(totalAmountPanel);
//      합계
		bannerPanel.setBounds(0, 975, 570, 40);
		add(bannerPanel); // 합계

//		기본설정
		setTitle("1등 예정 어벤져스 3조");
		setSize(800, 1050);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

//		타이틀
		titlePanel.setBounds(0, 0, 800, 120);
		titlePanel.setLayout(null);
		titlePanel.add(bannerLabel);
		titlePanel.setBackground(Color.white);
		titlePanel.add(memoBtn);

		logOut.setBackground(Color.white);
		logOut.setBounds(720, 10, 90, 20);
		logOut.setBorderPainted(false);
		logOut.setFocusPainted(false);
		logOut.setContentAreaFilled(false);
		logOut.setFont(new Font("나눔고딕", Font.ITALIC, 12));
		logOut.setForeground(Color.GRAY);
		logOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int yesOrNOButton = JOptionPane.showConfirmDialog(null, "로그아웃하실건가요?", "Logout",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon("./src/Image/mini.jpg"));
				if (yesOrNOButton == JOptionPane.YES_OPTION) {
					setVisible(false);
					new Login();
				} else {
					try {
						remove(yesOrNOButton);
					} catch (ArrayIndexOutOfBoundsException e1) {
					}
				}

			}
		});

		titlePanel.add(logOut);
		memoBtn.setBounds(747, 75, 41, 40);
		memoBtn.setBackground(Color.WHITE);
		memoBtn.setBorderPainted(false);
		memoBtn.setFocusPainted(false);
		memoBtn.setContentAreaFilled(false);
		memoBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new boardProject();
				
			}
			
		});
		
		bannerLabel.setBounds(200, 0, 400, 120);
		add(titlePanel);

//		메뉴
		cardMain.setBounds(0, 210, 800, 650);

		// 세트메뉴1
		cardPanel1.add(setBtn1);
		setBtn1.setBackground(Color.white);
		setBtn1.setBorderPainted(false);
		setBtn1.setFocusPainted(false);
//		setBtn1.setContentAreaFilled(false);
		setBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SetSideMenu1();
			}
		});
		cardPanel1.add(setBtn2);
		setBtn2.setBackground(Color.white);
		setBtn2.setBorderPainted(false);
		setBtn2.setFocusPainted(false);
//		setBtn2.setContentAreaFilled(false);
		setBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SetSideMenu2();
			}
		});
		cardPanel1.add(setBtn3);
		setBtn3.setBackground(Color.white);
		setBtn3.setBorderPainted(false);
		setBtn3.setFocusPainted(false);
//		setBtn3.setContentAreaFilled(false);
		setBtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SetSideMenu3();
			}
		});
		cardPanel1.add(setBtn4);
		setBtn4.setBackground(Color.white);
		setBtn4.setBorderPainted(false);
		setBtn4.setFocusPainted(false);
//		setBtn4.setContentAreaFilled(false);
		setBtn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SetSideMenu4();
			}
		});
		cardPanel1.add(setBtn5);
		setBtn5.setBackground(Color.white);
		setBtn5.setBorderPainted(false);
		setBtn5.setFocusPainted(false);
//		setBtn5.setContentAreaFilled(false);
		setBtn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SetSideMenu5();
			}
		});
		cardPanel1.add(setBtn6);
		setBtn6.setBackground(Color.white);
		setBtn6.setBorderPainted(false);
		setBtn6.setFocusPainted(false);
//		setBtn6.setContentAreaFilled(false);
		setBtn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SetSideMenu6();
			}
		});

		// 단품메뉴
		cardPanel2.add(burgerBtn1);
		burgerBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new BurgerMenu1();
			}
		});
		burgerBtn1.setBackground(Color.white);
		burgerBtn1.setBorderPainted(false);
		burgerBtn1.setFocusPainted(false);
		cardPanel2.add(burgerBtn2);
		burgerBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new BurgerMenu2();
			}
		});
		burgerBtn2.setBackground(Color.white);
		burgerBtn2.setBorderPainted(false);
		burgerBtn2.setFocusPainted(false);
		cardPanel2.add(burgerBtn3);
		burgerBtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new BurgerMenu3();
			}
		});
		burgerBtn3.setBackground(Color.white);
		burgerBtn3.setBorderPainted(false);
		burgerBtn3.setFocusPainted(false);
		cardPanel2.add(burgerBtn4);
		burgerBtn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new BurgerMenu4();
			}
		});
		burgerBtn4.setBackground(Color.white);
		burgerBtn4.setBorderPainted(false);
		burgerBtn4.setFocusPainted(false);
		cardPanel2.add(burgerBtn5);
		burgerBtn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new BurgerMenu5();
			}
		});
		burgerBtn5.setBackground(Color.white);
		burgerBtn5.setBorderPainted(false);
		burgerBtn5.setFocusPainted(false);
		cardPanel2.add(burgerBtn6);
		burgerBtn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new BurgerMenu6();
			}
		});
		burgerBtn6.setBackground(Color.white);
		burgerBtn6.setBorderPainted(false);
		burgerBtn6.setFocusPainted(false);

		// 사이드메뉴
		cardPanel3.add(sideBtn1);
		sideBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SideMenu1();
			}
		});
		sideBtn1.setBackground(Color.white);
		sideBtn1.setBorderPainted(false);
		sideBtn1.setFocusPainted(false);
		cardPanel3.add(sideBtn2);
		sideBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SideMenu2();
			}
		});
		sideBtn2.setBackground(Color.white);
		sideBtn2.setBorderPainted(false);
		sideBtn2.setFocusPainted(false);
		cardPanel3.add(sideBtn3);
		sideBtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SideMenu3();
			}
		});
		sideBtn3.setBackground(Color.white);
		sideBtn3.setBorderPainted(false);
		sideBtn3.setFocusPainted(false);
		cardPanel3.add(sideBtn4);
		sideBtn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SideMenu4();
			}
		});
		sideBtn4.setBackground(Color.white);
		sideBtn4.setBorderPainted(false);
		sideBtn4.setFocusPainted(false);
		cardPanel3.add(sideBtn5);
		sideBtn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SideMenu5();
			}
		});
		sideBtn5.setBackground(Color.white);
		sideBtn5.setBorderPainted(false);
		sideBtn5.setFocusPainted(false);
		cardPanel3.add(sideBtn6);
		sideBtn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SideMenu6();
			}
		});
		sideBtn6.setBackground(Color.white);
		sideBtn6.setBorderPainted(false);
		sideBtn6.setFocusPainted(false);
		cardPanel3.add(sideBtn7);
		sideBtn7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SideMenu7();
			}
		});
		sideBtn7.setBackground(Color.white);
		sideBtn7.setBorderPainted(false);
		sideBtn7.setFocusPainted(false);
		cardPanel3.add(sideBtn8);
		sideBtn8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SideMenu8();
			}
		});
		sideBtn8.setBackground(Color.white);
		sideBtn8.setBorderPainted(false);
		sideBtn8.setFocusPainted(false);

		cardMain.add("1", cardPanel1);
		cardMain.add("2", cardPanel2);
		cardMain.add("3", cardPanel3);
		cardMain.add("4", cardPanel4);
		add(cardMain);

//		메뉴바
		menuPanel.setBounds(0, 120, 800, 90);
		menuPanel.setBackground(Color.green);
		menuPanel.setLayout(new GridLayout(1, 4));
		menuPanel.add(menubarBtn1);
		menubarBtn1.setBorderPainted(false);
		menubarBtn1.setFocusPainted(false);
		menubarBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menubarBtn1.setIcon(setmenubar2);
				menubarBtn2.setIcon(burgermenubar1);
				menubarBtn3.setIcon(drinkmenubar1);
				menubarBtn4.setIcon(sidemenubar1);
				card.show(cardMain, "1");
			}
		});
		menuPanel.add(menubarBtn2);
		menubarBtn2.setBorderPainted(false);
		menubarBtn2.setFocusPainted(false);
		menubarBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menubarBtn1.setIcon(setmenubar1);
				menubarBtn2.setIcon(burgermenubar2);
				menubarBtn3.setIcon(drinkmenubar1);
				menubarBtn4.setIcon(sidemenubar1);
				card.show(cardMain, "2");
			}
		});
		menuPanel.add(menubarBtn3);
		menubarBtn3.setBorderPainted(false);
		menubarBtn3.setFocusPainted(false);
		menubarBtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menubarBtn1.setIcon(setmenubar1);
				menubarBtn2.setIcon(burgermenubar1);
				menubarBtn3.setIcon(drinkmenubar2);
				menubarBtn4.setIcon(sidemenubar1);
				card.show(cardMain, "3");
			}
		});
		menuPanel.add(menubarBtn4);
		menubarBtn4.setBorderPainted(false);
		menubarBtn4.setFocusPainted(false);
		menubarBtn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menubarBtn1.setIcon(setmenubar1);
				menubarBtn2.setIcon(burgermenubar1);
				menubarBtn3.setIcon(drinkmenubar1);
				menubarBtn4.setIcon(sidemenubar2);
				card.show(cardMain, "4");

//				model.removeRow(0);
				cardPanel4.add(new MyBurger12());

			}
		});

		add(menuPanel);

//		주문내역
		sp.setBounds(0, 860, 570, 115);
		table.setBackground(Color.WHITE);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(0);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		add(sp);

//		결제
		payPanel.setBounds(570, 860, 230, 160);
		payPanel.setBackground(Color.pink);
		add(payPanel);

		payPanel.add(payBtn1);
		payBtn1.setBorderPainted(false);
		payBtn1.setFocusPainted(false);
		payBtn1.setContentAreaFilled(false);
		payBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Check();
//				totalAmount.setText("0");
//				for (int j = i; j > 0; j--) {
//					model.removeRow(j - 1);
//					list.clear();
//				}
			}
		});

		setVisible(true);
	}

	// TODO

	class MyBurger12 extends JPanel implements ItemListener {

		JPanel mainPanel = new JPanel(new GridLayout(2, 1));
		JPanel topPanel = new JPanel();
		JLabel topLable = new JLabel();

		JPanel BottomPanel = new JPanel();
		JPanel Bread = new JPanel();
		JLabel BottomLable = new JLabel("Bread", JLabel.CENTER);
		JCheckBox Ott, Wit;
		ButtonGroup group = new ButtonGroup();

		JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
		JLabel dummy1 = new JLabel();
		JLabel dummy2 = new JLabel();
		JLabel dummy3 = new JLabel();
		JButton next = new JButton();

		JLabel breadLabel = new JLabel();

//		String menu = "마이버거";
//		int price = 5000;

		public MyBurger12() {
			setTitle("Choose Bread");
			setSize(800, 650);
			// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new BorderLayout());
			setBackground(Color.white);
			setResizable(false);

			topLable.setIcon(new ImageIcon("./src/myburger image/myBurgerInfor.jpg"));
			topPanel.add(topLable);

			topPanel.setBackground(Color.WHITE);
			BottomPanel.setBackground(Color.WHITE);
			Bread.setBackground(Color.WHITE);

//			=======================================================================================

//			bread 
			BottomLable.setFont(new Font("나눔고딕", Font.BOLD, 35));
			BottomLable.setPreferredSize(new Dimension(800, 60));
			BottomLable.setVerticalAlignment(JLabel.BOTTOM);
			BottomPanel.add(BottomLable);

			Ott = new JCheckBox("", new ImageIcon("./src/myburger image/bread1_off.jpg"));
			Wit = new JCheckBox("", new ImageIcon("./src/myburger image/bread2_off.jpg"));

			Bread.add(Ott);
			Bread.add(Wit);
			BottomPanel.add(Bread, BorderLayout.CENTER);

			group.add(Ott);
			group.add(Wit);

			Ott.addItemListener(this);
			Wit.addItemListener(this);

			Ott.setBorderPainted(false);
			Ott.setFocusPainted(false);
			Ott.setContentAreaFilled(false);
			Wit.setBorderPainted(false);
			Wit.setFocusPainted(false);
			Wit.setContentAreaFilled(false);

//			=======================================================================================

			buttonPanel.add(dummy1, dummy2);
			buttonPanel.add(dummy3);
			buttonPanel.add(next);
			buttonPanel.setBackground(Color.white);

			next.setIcon(new ImageIcon("./src/myburger image/Btn_rightArrow.jpg"));
			next.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					new MyBurger2();
					cardPanel4.add(new MyBurger2());
					setVisible(false);
				}
			});

			next.setBorderPainted(false);
			next.setFocusPainted(false);
			next.setContentAreaFilled(false);

			mainPanel.add(topPanel);
			mainPanel.add(BottomPanel);

			add(mainPanel, BorderLayout.CENTER);
			add(buttonPanel, BorderLayout.SOUTH);

			setVisible(true);
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object object = e.getSource();
			JCheckBox checkbox = (JCheckBox) object;

//			Bread		
			if (checkbox == Ott) {
				if (checkbox.isSelected()) {
					Ott.setIcon(new ImageIcon("./src/myburger image/bread1_on.jpg"));
					MO.breadLabel.setText("허니오트");
				} else {
					Ott.setIcon(new ImageIcon("./src/myburger image/bread1_off.jpg"));

				}
			} else if (checkbox == Wit) {
				if (checkbox.isSelected()) {
					Wit.setIcon(new ImageIcon("./src/myburger image/bread2_on.jpg"));
					MO.breadLabel.setText("위트");
				} else {
					Wit.setIcon(new ImageIcon("./src/myburger image/bread2_off.jpg"));
				}
			}
			MO.setVisible(true);
		}
	}

	class MyBurger2 extends JPanel implements ItemListener {

		JPanel mainPanel2 = new JPanel(new GridLayout(2, 1));
		JPanel topPanel2 = new JPanel();
		JPanel Patty = new JPanel();
		JLabel topLable2 = new JLabel("Patty", JLabel.CENTER);
		JCheckBox Beef, charcoalBeef, chicken;
		ButtonGroup group1 = new ButtonGroup();

		JPanel BottomPanel = new JPanel();
		JPanel Topping = new JPanel();
		JLabel BottomLable = new JLabel("Topping", JLabel.CENTER);
		JCheckBox egg, Bacon, Cheese, Shrimp;

		JPanel buttonPanel2 = new JPanel(new GridLayout(1, 4));
		JButton prev = new JButton();
		JLabel dummy1 = new JLabel();
		JLabel dummy2 = new JLabel();
		JButton next = new JButton();

		String menu = "마이버거";
		int price = 5000;

		public MyBurger2() {
			setTitle("Choose patty & Topping");
			setSize(800, 650);
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new BorderLayout());
			setBackground(Color.white);
			setResizable(false);

//			Patty 타이틀 꾸며주는 곳
			topLable2.setFont(new Font("나눔고딕", Font.BOLD, 35));
			topLable2.setPreferredSize(new Dimension(800, 60));
			topLable2.setVerticalAlignment(JLabel.BOTTOM);
			topPanel2.add(topLable2);

			topPanel2.setBackground(Color.WHITE);
			Patty.setBackground(Color.WHITE);
			BottomPanel.setBackground(Color.WHITE);
			Topping.setBackground(Color.WHITE);

			Beef = new JCheckBox("", new ImageIcon("./src/myburger image/patty1_off.jpg"));
			charcoalBeef = new JCheckBox("", new ImageIcon("./src/myburger image/patty2_off.jpg"));
			chicken = new JCheckBox("", new ImageIcon("./src/myburger image/patty3_off.jpg"));

			Patty.add(Beef);
			Patty.add(charcoalBeef);
			Patty.add(chicken);
			topPanel2.add(Patty, BorderLayout.CENTER);

//			같은 그룹의 JRadioButton 클래스 객체를 ButtonGroup 클래스 객체에 추가해서 같은 그룹으로 묶어준다.
			group1.add(Beef);
			group1.add(charcoalBeef);
			group1.add(chicken);

			Beef.addItemListener(this);
			charcoalBeef.addItemListener(this);
			chicken.addItemListener(this);

			Beef.setBorderPainted(false);
			Beef.setFocusPainted(false);
			Beef.setContentAreaFilled(false);
			charcoalBeef.setBorderPainted(false);
			charcoalBeef.setFocusPainted(false);
			charcoalBeef.setContentAreaFilled(false);
			chicken.setBorderPainted(false);
			chicken.setFocusPainted(false);
			chicken.setContentAreaFilled(false);

//			=======================================================================================

//			topping 타이틀 꾸며주는 곳
			BottomLable.setFont(new Font("나눔고딕", Font.BOLD, 35));
			BottomLable.setPreferredSize(new Dimension(800, 60));
			BottomLable.setVerticalAlignment(JLabel.BOTTOM);
			BottomPanel.add(BottomLable);

			egg = new JCheckBox("", new ImageIcon("./src/myburger image/topping1_off.jpg"));
			Bacon = new JCheckBox("", new ImageIcon("./src/myburger image/topping2_off.jpg"));
			Cheese = new JCheckBox("", new ImageIcon("./src/myburger image/topping3_off.jpg"));
			Shrimp = new JCheckBox("", new ImageIcon("./src/myburger image/topping4_off.jpg"));

			Topping.add(egg);
			Topping.add(Bacon);
			Topping.add(Cheese);
			Topping.add(Shrimp);
			BottomPanel.add(Topping, BorderLayout.CENTER);

			egg.addItemListener(this);
			Bacon.addItemListener(this);
			Cheese.addItemListener(this);
			Shrimp.addItemListener(this);

			egg.setBorderPainted(false);
			egg.setFocusPainted(false);
			egg.setContentAreaFilled(false);
			Bacon.setBorderPainted(false);
			Bacon.setFocusPainted(false);
			Bacon.setContentAreaFilled(false);
			Cheese.setBorderPainted(false);
			Cheese.setFocusPainted(false);
			Cheese.setContentAreaFilled(false);
			Shrimp.setBorderPainted(false);
			Shrimp.setFocusPainted(false);
			Shrimp.setContentAreaFilled(false);

//			=======================================================================================

			buttonPanel2.add(prev);
			buttonPanel2.add(dummy1, dummy2);
			buttonPanel2.add(next);
			buttonPanel2.setBackground(Color.white);
			buttonPanel2.setOpaque(true);

			prev.setIcon(new ImageIcon("./src/myburger image/Btn_leftArrow.jpg"));
			prev.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					현재페이지는 사라지면서 이전 페이지 불러오기
					cardPanel4.add(new MyBurger12());
					setVisible(false);
				}
			});
			next.setIcon(new ImageIcon("./src/myburger image/Btn_rightArrow.jpg"));
			next.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					현재페이지는 사라지면서 다음 페이지 불러오기
					cardPanel4.add(new MyBurger3());
					setVisible(false);
				}
			});

			prev.setBorderPainted(false);
			prev.setFocusPainted(false);
			prev.setContentAreaFilled(false);

			next.setBorderPainted(false);
			next.setFocusPainted(false);
			next.setContentAreaFilled(false);

			mainPanel2.add(topPanel2);
			mainPanel2.add(BottomPanel);

			add(mainPanel2, BorderLayout.CENTER);
			add(buttonPanel2, BorderLayout.SOUTH);

			setVisible(true);
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object object = e.getSource();
			JCheckBox checkbox1 = (JCheckBox) object;
			JCheckBox checkbox2 = (JCheckBox) object;

//			Patty	
			if (checkbox1 == Beef) {
				if (checkbox1.isSelected()) {
//					setIcon() : 체크 박스대신 표시되는 이미지를 변경한다.
					Beef.setIcon(new ImageIcon("./src/myburger image/patty1_on.jpg"));
					MO.meatLabel.setText("소고기");
				} else {
					Beef.setIcon(new ImageIcon("./src/myburger image/patty1_off.jpg"));
				}
			} else if (checkbox1 == charcoalBeef) {
				if (checkbox1.isSelected()) {
					charcoalBeef.setIcon(new ImageIcon("./src/myburger image/patty2_on.jpg"));
					MO.meatLabel.setText("숯불 소고기");
				} else {
					charcoalBeef.setIcon(new ImageIcon("./src/myburger image/patty2_off.jpg"));
				}
			} else if (checkbox1 == chicken) {
				if (checkbox1.isSelected()) {
					chicken.setIcon(new ImageIcon("./src/myburger image/patty3_on.jpg"));
					MO.meatLabel.setText("치킨");
				} else {
					chicken.setIcon(new ImageIcon("./src/myburger image/patty3_off.jpg"));
				}
			}

//			Topping			
			if (checkbox2 == egg) {
				if (checkbox2.isSelected()) {
//					setIcon() : 체크 박스대신 표시되는 이미지를 변경한다.
					egg.setIcon(new ImageIcon("./src/myburger image/topping1_on.jpg"));
//					MO.Topping1.setText("계란");
					MO.Topping1.setForeground(Color.BLACK);
					addPrice += 1500;
				} else {
					egg.setIcon(new ImageIcon("./src/myburger image/topping1_off.jpg"));
//					MO.Topping1.setText("");
					MO.Topping1.setForeground(Color.LIGHT_GRAY);
					addPrice -= 1500;

				}
			}
			if (checkbox2 == Bacon) {
				if (checkbox2.isSelected()) {
					Bacon.setIcon(new ImageIcon("./src/myburger image/topping2_on.jpg"));
					MO.Topping2.setForeground(Color.BLACK);
					addPrice += 1200;
				} else {
					Bacon.setIcon(new ImageIcon("./src/myburger image/topping2_off.jpg"));
					MO.Topping2.setForeground(Color.LIGHT_GRAY);
					addPrice -= 1200;
				}
			}
			if (checkbox2 == Cheese) {
				if (checkbox2.isSelected()) {
					Cheese.setIcon(new ImageIcon("./src/myburger image/topping3_on.jpg"));
					MO.Topping3.setForeground(Color.BLACK);
					addPrice += 800;
				} else {
					Cheese.setIcon(new ImageIcon("./src/myburger image/topping3_off.jpg"));
					MO.Topping3.setForeground(Color.LIGHT_GRAY);
					addPrice -= 800;
				}
			}
			if (checkbox2 == Shrimp) {
				if (checkbox2.isSelected()) {
					Shrimp.setIcon(new ImageIcon("./src/myburger image/topping4_on.jpg"));
					MO.Topping4.setForeground(Color.BLACK);
					addPrice += 1500;
				} else {
					Shrimp.setIcon(new ImageIcon("./src/myburger image/topping4_off.jpg"));
					MO.Topping4.setForeground(Color.LIGHT_GRAY);
					addPrice -= 1500;
				}
			}
			System.out.println(addPrice);
		}

	}

	class MyBurger3 extends JPanel implements ItemListener {

		JPanel mainPanel = new JPanel(new GridLayout(2, 1));
		JPanel topPanel = new JPanel();
		JPanel Vegetabl = new JPanel();
		JLabel topLable = new JLabel("Vegetabl", JLabel.CENTER);
		JCheckBox tomato, onion, lettuce, pickle;

		JPanel BottomPanel = new JPanel();
		JPanel Sauce = new JPanel();
		JLabel BottomLable = new JLabel("Sauce", JLabel.CENTER);
		JCheckBox Sweet, savory, Spicy;
		ButtonGroup group2 = new ButtonGroup();

		JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
		JButton prev = new JButton();
//		JButton back = new JButton();
//		JButton okay = new JButton();
		JLabel dummy1 = new JLabel();
		JLabel dummy2 = new JLabel();
		JLabel dummy3 = new JLabel();

		JButton okay = new JButton();

//		String menu = "나만의 버거";
//		String count = "1";

//		TODO
		public MyBurger3() {

			setTitle("Choose Vegetabl & Sauce");
//			TODO
			setSize(800, 650);
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new BorderLayout());
			setBackground(Color.white);
			setResizable(false);

//			Vegetabl 타이틀 꾸며주는 곳
			topLable.setFont(new Font("나눔고딕", Font.BOLD, 35));
			topLable.setPreferredSize(new Dimension(800, 60));
			topLable.setVerticalAlignment(JLabel.BOTTOM);
			topPanel.add(topLable);

			topPanel.setBackground(Color.WHITE);
			Vegetabl.setBackground(Color.WHITE);
			BottomPanel.setBackground(Color.WHITE);
			Sauce.setBackground(Color.WHITE);

			tomato = new JCheckBox("", new ImageIcon("./src/myburger image/vegetable1_off.jpg"));
			onion = new JCheckBox("", new ImageIcon("./src/myburger image/vegetable2_off.jpg"));
			lettuce = new JCheckBox("", new ImageIcon("./src/myburger image/vegetable3_off.jpg"));
			pickle = new JCheckBox("", new ImageIcon("./src/myburger image/vegetable4_off.jpg"));

			Vegetabl.add(tomato);
			Vegetabl.add(onion);
			Vegetabl.add(lettuce);
			Vegetabl.add(pickle);
			topPanel.add(Vegetabl, BorderLayout.CENTER);

			tomato.addItemListener(this);
			onion.addItemListener(this);
			lettuce.addItemListener(this);
			pickle.addItemListener(this);

			tomato.setBorderPainted(false);
			tomato.setFocusPainted(false);
			tomato.setContentAreaFilled(false);
			onion.setBorderPainted(false);
			onion.setFocusPainted(false);
			onion.setContentAreaFilled(false);
			lettuce.setBorderPainted(false);
			lettuce.setFocusPainted(false);
			lettuce.setContentAreaFilled(false);
			pickle.setBorderPainted(false);
			pickle.setFocusPainted(false);
			pickle.setContentAreaFilled(false);

//			=======================================================================================

//			Sauce 타이틀 꾸며주는 곳
			BottomLable.setFont(new Font("나눔고딕", Font.BOLD, 35));
			BottomLable.setPreferredSize(new Dimension(800, 60));
			BottomLable.setVerticalAlignment(JLabel.BOTTOM);
			BottomPanel.add(BottomLable);

			Sweet = new JCheckBox("", new ImageIcon("./src/myburger image/sauce1_off.jpg"));
			savory = new JCheckBox("", new ImageIcon("./src/myburger image/sauce2_off.jpg"));
			Spicy = new JCheckBox("", new ImageIcon("./src/myburger image/sauce3_off.jpg"));

			Sauce.add(Sweet);
			Sauce.add(savory);
			Sauce.add(Spicy);
			BottomPanel.add(Sauce, BorderLayout.CENTER);

			group2.add(Sweet);
			group2.add(savory);
			group2.add(Spicy);

			Sweet.addItemListener(this);
			savory.addItemListener(this);
			Spicy.addItemListener(this);

			Sweet.setBorderPainted(false);
			Sweet.setFocusPainted(false);
			Sweet.setContentAreaFilled(false);
			savory.setBorderPainted(false);
			savory.setFocusPainted(false);
			savory.setContentAreaFilled(false);
			Spicy.setBorderPainted(false);
			Spicy.setFocusPainted(false);
			Spicy.setContentAreaFilled(false);

//			=======================================================================================

			buttonPanel.add(prev);
			buttonPanel.add(dummy1);
			buttonPanel.add(dummy2, dummy3);
			buttonPanel.add(okay);
			buttonPanel.setBackground(Color.white);

			prev.setIcon(new ImageIcon("./src/myburger image/Btn_leftArrow.jpg"));
			prev.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					현재페이지는 사라지면서 이전 페이지 불러오기 
					cardPanel4.add(new MyBurger2());
					setVisible(false);
				}
			});

			prev.setBorderPainted(false);
			prev.setFocusPainted(false);
			prev.setContentAreaFilled(false);

			okay.setIcon(new ImageIcon("./src/Image/confirm.png"));
			okay.addActionListener(new ActionListener() {
				// TODO
				@Override
				public void actionPerformed(ActionEvent e) {
					vo.setName("나만의 버거");
					vo.setCount(1);
					vo.setPrice(addPrice);

					list.add(vo);
					for (MenuVO dao : list) {
						String prices = dao.getPrice()+"";
						rowData[0] = ++i + "";
						rowData[1] = dao.getName();
						rowData[2] = dao.getCount() + "";
						rowData[3] = dao.getPrice() + "";
						totalPrice += addPrice;
					}
					model.addRow(rowData);
//					if(model.equals(rowData[1].equals(""))) {
//						model.removeRow(0);
//					}
					totalAmount.setText(format.format(totalPrice));
//					MO.setgVisible(true);
					// 다시 첫번째 화면으로 전화되도록!
					cardPanel4.add(new MyBurger12());
					setVisible(false);

//					TODO 전 화면 꺼야함!!!
					dispose();
					new MainFrame("", 0, 0);
					addPrice = 5000;
					MO.setVisible(false);

//					MenuVO vo = new MenuVO();
//					list.add(vo);
//					cardPanel4.add(new MyBurger12());
//					revalidate();
//					card.show(cardMain, "1");
				}
			});
			okay.setBorderPainted(false);
			okay.setFocusPainted(false);
			okay.setContentAreaFilled(false);

			mainPanel.add(topPanel);
			mainPanel.add(BottomPanel);

			add(mainPanel, BorderLayout.CENTER);
			add(buttonPanel, BorderLayout.SOUTH);

			setVisible(true);
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object object = e.getSource();
			JCheckBox checkbox1 = (JCheckBox) object;
			JCheckBox checkbox2 = (JCheckBox) object;

//			Vegetable	tomato, onion, lettuce, pickle;
			if (checkbox1 == tomato) {
				if (checkbox1.isSelected()) {
//					setIcon() : 체크 박스대신 표시되는 이미지를 변경한다.
					tomato.setIcon(new ImageIcon("./src/myburger image/vegetable1_on.jpg"));
					MO.dishLabel1.setForeground(Color.BLACK);
				} else {
					tomato.setIcon(new ImageIcon("./src/myburger image/vegetable1_off.jpg"));
					MO.dishLabel1.setForeground(Color.LIGHT_GRAY);
				}
			}
			if (checkbox1 == onion) {
				if (checkbox1.isSelected()) {
					onion.setIcon(new ImageIcon("./src/myburger image/vegetable2_on.jpg"));
					MO.dishLabel2.setForeground(Color.BLACK);
				} else {
					onion.setIcon(new ImageIcon("./src/myburger image/vegetable2_off.jpg"));
					MO.dishLabel2.setForeground(Color.LIGHT_GRAY);
				}
			}

			if (checkbox1 == lettuce) {
				if (checkbox1.isSelected()) {
					lettuce.setIcon(new ImageIcon("./src/myburger image/vegetable3_on.jpg"));
					MO.dishLabel3.setForeground(Color.BLACK);
				} else {
					lettuce.setIcon(new ImageIcon("./src/myburger image/vegetable3_off.jpg"));
					MO.dishLabel3.setForeground(Color.LIGHT_GRAY);
				}
			}
			if (checkbox1 == pickle) {
				if (checkbox1.isSelected()) {
					pickle.setIcon(new ImageIcon("./src/myburger image/vegetable4_on.jpg"));
					MO.dishLabel4.setForeground(Color.BLACK);
				} else {
					pickle.setIcon(new ImageIcon("./src/myburger image/vegetable4_off.jpg"));
					MO.dishLabel4.setForeground(Color.LIGHT_GRAY);
				}
			}

//			Sauce
			if (checkbox2 == Sweet) {
				if (checkbox2.isSelected()) {
//					setIcon() : 체크 박스대신 표시되는 이미지를 변경한다.
					Sweet.setIcon(new ImageIcon("./src/myburger image/sauce1_on.jpg"));
					MO.sauseLabel.setText("달콤한 맛");
//					for (MenuVO dao : list) {
//						String prices = format.format(dao.getPrice());
//						rowData[0] = ++i + "";
//						rowData[1] = menu;
//						rowData[2] = count;
//						rowData[3] = addPrice + "";
//						model.addRow(rowData);
//					}
				} else {
					Sweet.setIcon(new ImageIcon("./src/myburger image/sauce1_off.jpg"));
				}
			}
			if (checkbox2 == savory) {
				if (checkbox2.isSelected()) {
					savory.setIcon(new ImageIcon("./src/myburger image/sauce2_on.jpg"));
					MO.sauseLabel.setText("고소한 맛");

				} else {
					savory.setIcon(new ImageIcon("./src/myburger image/sauce2_off.jpg"));
				}
			}
			if (checkbox2 == Spicy) {
				if (checkbox2.isSelected()) {
					Spicy.setIcon(new ImageIcon("./src/myburger image/sauce3_on.jpg"));
					MO.sauseLabel.setText("매콤한 맛");

				} else {
					Spicy.setIcon(new ImageIcon("./src/myburger image/sauce3_off.jpg"));
				}
			}
		}
	}

	class MyBurger_Order extends JFrame {

		JPanel mainPanel = new JPanel(new GridLayout());
		JPanel orderPanel = new JPanel(new GridLayout(5, 1));
		JPanel orderPanel1 = new JPanel(new GridLayout(2, 1));
		JPanel orderPanel2 = new JPanel(new GridLayout(4, 1));
		JPanel orderPanel3 = new JPanel(new GridLayout(4, 1));
		JLabel orderTitle = new JLabel("Order", JLabel.CENTER);
		JLabel breadLabel = new JLabel("", JLabel.CENTER);
		JLabel meatLabel = new JLabel("", JLabel.CENTER);
		JLabel Topping1 = new JLabel("계란", JLabel.CENTER);
		JLabel Topping2 = new JLabel("베이컨", JLabel.CENTER);
		JLabel Topping3 = new JLabel("치즈", JLabel.CENTER);
		JLabel Topping4 = new JLabel("통새우", JLabel.CENTER);
		JLabel dishLabel1 = new JLabel("토마토", JLabel.CENTER);
		JLabel dishLabel2 = new JLabel("양파", JLabel.CENTER);
		JLabel dishLabel3 = new JLabel("양상추", JLabel.CENTER);
		JLabel dishLabel4 = new JLabel("피클", JLabel.CENTER);
		JLabel sauseLabel = new JLabel("", JLabel.CENTER);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));


		public MyBurger_Order() {
			setTitle("Choose Bread");
			setBounds(1360, 235, 300, 650);
			setLayout(new BorderLayout());
			setBackground(Color.white);
			setResizable(false);

//			Order 타이틀 꾸며주는 곳
			orderTitle.setFont(new Font("나눔고딕", Font.BOLD, 35));
//			orderTitle.setPreferredSize(new Dimension(300, 100));
			orderTitle.setVerticalAlignment(JLabel.CENTER);
			orderPanel.add(orderTitle);

//			주문 내역 꾸며주는 곳
//			Bread & Meat
			breadLabel.setFont(new Font("나눔고딕", Font.BOLD, 20));
			breadLabel.setVerticalAlignment(JLabel.TOP);
			orderPanel1.add(breadLabel);
			meatLabel.setFont(new Font("나눔고딕", Font.BOLD, 20));
			meatLabel.setVerticalAlignment(JLabel.TOP);
			orderPanel1.add(meatLabel);
			orderPanel.add(orderPanel1);

//			Topping
			orderPanel2.add(Topping1);
			Topping1.setFont(new Font("나눔고딕", Font.BOLD, 20));
			Topping1.setForeground(Color.LIGHT_GRAY);
			Topping1.setVerticalAlignment(JLabel.TOP);
			orderPanel.add(orderPanel2);

			orderPanel2.add(Topping2);
			Topping2.setFont(new Font("나눔고딕", Font.BOLD, 20));
			Topping2.setForeground(Color.LIGHT_GRAY);
			Topping2.setVerticalAlignment(JLabel.TOP);
			orderPanel.add(orderPanel2);

			orderPanel2.add(Topping3);
			Topping3.setFont(new Font("나눔고딕", Font.BOLD, 20));
			Topping3.setForeground(Color.LIGHT_GRAY);
			Topping3.setVerticalAlignment(JLabel.TOP);
			orderPanel.add(orderPanel2);

			orderPanel2.add(Topping4);
			Topping4.setFont(new Font("나눔고딕", Font.BOLD, 20));
			Topping4.setForeground(Color.LIGHT_GRAY);
			Topping4.setVerticalAlignment(JLabel.TOP);
			orderPanel.add(orderPanel2);

//			Vegetable
			orderPanel3.add(dishLabel1);
			dishLabel1.setFont(new Font("나눔고딕", Font.BOLD, 20));
			dishLabel1.setForeground(Color.LIGHT_GRAY);
			dishLabel1.setVerticalAlignment(JLabel.TOP);
			orderPanel.add(orderPanel3);

			orderPanel3.add(dishLabel2);
			dishLabel2.setFont(new Font("나눔고딕", Font.BOLD, 20));
			dishLabel2.setForeground(Color.LIGHT_GRAY);
			dishLabel2.setVerticalAlignment(JLabel.TOP);
			orderPanel.add(orderPanel3);

			orderPanel3.add(dishLabel3);
			dishLabel3.setFont(new Font("나눔고딕", Font.BOLD, 20));
			dishLabel3.setForeground(Color.LIGHT_GRAY);
			dishLabel3.setVerticalAlignment(JLabel.TOP);
			orderPanel.add(orderPanel3);

			orderPanel3.add(dishLabel4);
			dishLabel4.setFont(new Font("나눔고딕", Font.BOLD, 20));
			dishLabel4.setForeground(Color.LIGHT_GRAY);
			dishLabel4.setVerticalAlignment(JLabel.TOP);
			orderPanel.add(orderPanel3);

//			Sause
			sauseLabel.setFont(new Font("나눔고딕", Font.BOLD, 20));
			sauseLabel.setVerticalAlignment(JLabel.CENTER);
			orderPanel.add(sauseLabel);

			orderPanel.setBackground(Color.WHITE);
			orderPanel1.setBackground(Color.WHITE);
			orderPanel2.setBackground(Color.WHITE);
			orderPanel3.setBackground(Color.WHITE);

//			=======================================================================================



			mainPanel.add(orderPanel);
//			mainPanel.add(BottomPanel);

			add(mainPanel, BorderLayout.CENTER);
			add(buttonPanel, BorderLayout.SOUTH);

			setVisible(false);
		}

		public void addOrder(MyBurger12 checkbox) {
			breadLabel.add(checkbox);
		}
	}

	class Check extends JFrame {

		ImageIcon imageicon;
		ImageIcon imageicon1;
		ImageIcon imageicon2;
		JLabel msg, bg;
		JButton check;
		JButton back;

		public Check() {
			imageicon = new ImageIcon(".\\src\\image\\5.jpg");
			imageicon1 = new ImageIcon(".\\src\\image\\6.jpg");
			imageicon2 = new ImageIcon(".\\src\\image\\3.jpg");

			msg = new JLabel("결제 하시겠습니까?");
			bg = new JLabel(imageicon2);
			check = new JButton(imageicon);
			back = new JButton(imageicon1);

			check.setBorderPainted(false);
			check.setFocusPainted(false);
			check.setContentAreaFilled(false);

			back.setBorderPainted(false);
			back.setFocusPainted(false);
			back.setContentAreaFilled(false);

			setTitle("결제");
			setSize(300, 158);

			setLayout(null);
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);

			msg.setBounds(90, 50, 150, 100);
			check.setBounds(0, 100, 90, 30);
			back.setBounds(203, 100, 90, 30);
			bg.setBounds(-90, -60, 460, 760);

			add(check);
			add(back);
			add(msg);
			add(bg);

check.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            
	            	
	              
	            	if (list.size() == 0) {
						JOptionPane.showMessageDialog(null, "선택된 메뉴가 없습니다.");
						setVisible(false);
	            	
	            	
	            	}else {
	            	
	            	JOptionPane.showMessageDialog(null, "결제 완료");
	               
	               for (int i = 0; i < model.getRowCount(); i++) {
	               int a = 0;
	               String b = String.valueOf(model.getValueAt(i, 1));
	               String c = String.valueOf(model.getValueAt(i, 2));
	               String d =  String.valueOf(model.getValueAt(i, 3));
	               
	               
	                Connection conn = null;
	                PreparedStatement pstmt = null;
	                ResultSet rs = null;
	               try {
	               conn = DBUtil.getMySQLConnection();
	               String sql = "insert into list (IDX,name,count,price) values (?,?,?,?)";
	               pstmt = conn.prepareStatement(sql);
	               
	               
	               
	                  
	               pstmt.setInt(1, a);
	               pstmt.setString(2, b);
	               pstmt.setString(3, c);
	               pstmt.setString(4, d);
	               pstmt.executeUpdate();
	                 DBUtil.close(conn);
	                 DBUtil.close(pstmt);
	            
	            }catch(SQLException e1) {
	               e1.printStackTrace();
	            }
	               }	
	               for(int j=list.size();j>0;j--) {
	            	   model.removeRow(j-1);
	            	   list.clear();
	            	   totalAmount.setText(0+"");
	               }
	               
						setVisible(false);
					}
				}
			});

			back.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "결제 실패");
					setVisible(false);
				}
			});

			setVisible(true);
		}
	}

}
