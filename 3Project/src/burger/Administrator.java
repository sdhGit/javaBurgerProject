package burger;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Administrator extends JFrame {
//   타이틀 패널 (상단)
	ImageIcon admin = new ImageIcon("./src/Image/adminTitle1.jpg");
	JLabel titleLabel = new JLabel(admin);
	JPanel titlePanel = new JPanel();

//   로그아웃버튼
	JButton logOut = new JButton("Logout");

//   메뉴바 패널 (중간)
	JPanel menubarPanel = new JPanel(new GridLayout(1, 4));
	ImageIcon admin1 = new ImageIcon("./src/Image/adminMenu2_off.jpg");
	ImageIcon admin2 = new ImageIcon("./src/Image/adminMenu2_on.jpg");
	ImageIcon admin3 = new ImageIcon("./src/Image/adminMenu1_off.jpg");
	ImageIcon admin4 = new ImageIcon("./src/Image/adminMenu1_on.jpg");
	ImageIcon admin5 = new ImageIcon("./src/Image/adminMenu3_off.jpg");
	ImageIcon admin6 = new ImageIcon("./src/Image/adminMenu3_on.jpg");
	ImageIcon admin7 = new ImageIcon("./src/Image/adminMenu4_off.jpg");
	ImageIcon admin8 = new ImageIcon("./src/Image/adminMenu4_on.jpg");

	JButton menubarButton1 = new JButton(admin2);
	JButton menubarButton2 = new JButton(admin3);
	JButton menubarButton3 = new JButton(admin5);
	JButton menubarButton4 = new JButton(admin7);

//   카드 레이아웃 (하단)
	CardLayout card = new CardLayout();
	JPanel CardpanelMain = new JPanel(card);
	JPanel Cardpanel1 = new JPanel();
	JPanel Cardpanel2 = new JPanel();
	JPanel Cardpanel3 = new JPanel(new GridLayout(1, 1));
	JPanel Cardpanel4 = new JPanel();

	String[] columnNames = { "메뉴", "개수", "가격", "날짜" };
	DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
		public boolean isCellEditable(int i, int c) {
			return false;
		}
	};
	JTable table = new JTable(model);
	JScrollPane sp = new JScrollPane(table);

	String[] columnNames1 = { "아이디", "비번", "이름", "전화번호", "이메일" };
	DefaultTableModel model1 = new DefaultTableModel(columnNames1, 0) {
		public boolean isCellEditable(int i, int c) {
			return false;
		}
	};
	JTable table1 = new JTable(model1);
	JScrollPane sp1 = new JScrollPane(table1);

	boolean flag1 = false;
	boolean flag2 = false;
	boolean flag3 = false;
	boolean flag4 = false;
	boolean flag5 = false;
	boolean flag6 = false;

	public Administrator() {
//      기본
		setTitle("ADMINISTRATOR");
		setSize(800, 1050);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

//      타이틀 패널 (상단)

//      titlePanel.setBounds(0, 0, 800, 120);
		titlePanel.setLayout(null);
//      titlePanel.add(titleLabel);
		titlePanel.setBackground(Color.white);

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
					new StartPopUp();
				} else {
					try {
						remove(yesOrNOButton);
					} catch (ArrayIndexOutOfBoundsException e1) {
					}
				}

			}
		});

		titlePanel.setBounds(0, 0, 800, 200);
		titlePanel.add(titleLabel);
		titleLabel.setBounds(150, 30, 500, 120);
		titlePanel.add(logOut);
		add(titlePanel);

//      메뉴바 패널 (중간)
		menubarPanel.setBounds(0, 200, 800, 80);
		menubarPanel.add(menubarButton1);
		menubarButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menubarButton1.setIcon(admin2);
				menubarButton2.setIcon(admin3);
				menubarButton3.setIcon(admin5);
				menubarButton4.setIcon(admin7);
				card.show(CardpanelMain, "1");
			}
		});
		menubarPanel.add(menubarButton2);
		menubarButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menubarButton1.setIcon(admin1);
				menubarButton2.setIcon(admin4);
				menubarButton3.setIcon(admin5);
				menubarButton4.setIcon(admin7);

				card.show(CardpanelMain, "2");
				ArrayList<MemberVO> list = MemberDAO.select();

//            JTable에 데이터를 넣어줄 때 기존에 넣어준 모든 데이터를 제거하지 않으면 기존 데이터 뒤에 새로 넣어주는 데이터가 추가되서 
//            보여지므로 기존의 데이터를 모두 제거하고 넣어줘야 한다. => 마지막 데이터 부터 제거하는 것이 편리하다.
//            getRowCount() : JTable 디자인에 사용한 DefaultTableModel 클래스 객체(model)에 저장된 데이터의 개수를 얻어온다.
				for (int i = model1.getRowCount() - 1; i >= 0; i--) {
//               removeRow(row) : JTable 디자인에 사용한 DefaultTableModel 클래스 객체에서 JTable에 넣어준 row 번째 데이터를 제거한다.
					model1.removeRow(i);
				}

				if (list.size() == 0) {
					JOptionPane.showMessageDialog(table1, "테이블에 저장된 메모가 없습니다.");
				} else {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
//               테이블에 저장된 데이터가 5개의 필드를 가지고 있으므로 5개의 데이터를 저장할 수 있는 문자열 배열을 만들고 ArrayList에 저장된
//               데이터를 넣어준다.
					String[] rowData = new String[5];
//               JTable에 ArrayList에 저장된 데이터의 개수 만큼 반복하며 데이터를 넣어준다.
					for (MemberVO data : list) {
						rowData[0] = data.getId();
						rowData[1] = data.getPw();
						rowData[2] = data.getName();
						rowData[3] = data.getTel();
						rowData[4] = data.getEmail();

//                  JTable의 디자인에 사용한 DefaultTableModel 클래스 객체에 addRow() 메소드로 데이터를 넣어준다.
						model1.addRow(rowData);
					}

				}
			}
		});
		menubarPanel.add(menubarButton3);
		menubarButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menubarButton1.setIcon(admin1);
				menubarButton2.setIcon(admin3);
				menubarButton3.setIcon(admin6);
				menubarButton4.setIcon(admin7);

				card.show(CardpanelMain, "3");
				
			}
		});
		menubarPanel.add(menubarButton4);
		menubarButton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menubarButton1.setIcon(admin1);
				menubarButton2.setIcon(admin3);
				menubarButton3.setIcon(admin5);
				menubarButton4.setIcon(admin8);
				card.show(CardpanelMain, "4");
				new boardProject();
			}
		});
		add(menubarPanel);

//      카드 레이아웃 (하단)
		// 매출관리
		CardpanelMain.setBounds(0, 280, 800, 745);

		Cardpanel1.setLayout(null);
		JPanel Cardpanel1_1 = new JPanel(null);
		Cardpanel1_1.setBounds(0, 0, 800, 50);
		JTextField txt1 = new JTextField();
		txt1.setBounds(15, 15, 80, 20);
		JLabel l1 = new JLabel("년");
		l1.setBounds(100, 15, 20, 20);
		JTextField txt2 = new JTextField();
		txt2.setBounds(125, 15, 80, 20);
		JLabel l2 = new JLabel("월");
		l2.setBounds(210, 15, 20, 20);
		JTextField txt3 = new JTextField();
		txt3.setBounds(235, 15, 80, 20);
		JLabel l3 = new JLabel("일");
		l3.setBounds(320, 15, 20, 20);
		JLabel label = new JLabel("-");
		label.setBounds(355, 15, 20, 20);
		label.setFont(new Font("나눔고딕", Font.BOLD, 25));
		JTextField txt4 = new JTextField();
		txt4.setBounds(390, 15, 80, 20);
		JLabel l4 = new JLabel("년");
		l4.setBounds(475, 15, 20, 20);
		JTextField txt5 = new JTextField();
		txt5.setBounds(490, 15, 80, 20);
		JLabel l5 = new JLabel("월");
		l5.setBounds(575, 15, 20, 20);
		JTextField txt6 = new JTextField();
		txt6.setBounds(600, 15, 80, 20);
		JLabel l6 = new JLabel("일");
		l6.setBounds(685, 15, 20, 20);
		JButton btn1 = new JButton("검색");

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = model.getRowCount() - 1; i >= 0; i--) {
//               removeRow(row) : JTable 디자인에 사용한 DefaultTableModel 클래스 객체에서 JTable에 넣어준 row 번째 데이터를 제거한다.
					model.removeRow(i);
				}
				try {
					String startDate = txt1.getText() + "-" + txt2.getText() + "-" + txt3.getText() + "%"; // 년, 월, 일
					String endDate = txt4.getText() + "-" + txt5.getText() + "-" + txt6.getText() + "%"; // 년, 월, 일

					int sday = Integer.parseInt(txt3.getText());
					int eday = Integer.parseInt(txt6.getText());
					int smonth = Integer.parseInt(txt2.getText());
					int emonth = Integer.parseInt(txt5.getText());
					int syear = Integer.parseInt(txt1.getText());
					int eyear = Integer.parseInt(txt4.getText());

					int year = eyear - syear;
					int month = emonth - smonth;
					int day = eday - sday;

					// 년, 월, 일 for문 시작
					for (int h = 0; h <= year; h++) {
						System.out.println("year : " + syear);

						if (year != 0 && h == 0) {
							month = 12 - smonth;
						} else if (year != 0 && h == year) {
							month = emonth - 1;
						}

						for (int j = 0; j <= month; j++) {

							System.out.println("month: " + smonth);

							if (month == 0 && year != 0) {
								day = 31 - sday;
							} else if (smonth == emonth && syear == eyear) {
								day = eday - sday;
							} else if (month == 0 && h == year) {
								day = eday - 1;
							}

							if (month != 0 && j == 0 && h == 0) {
								day = 31 - sday;
							} else if (month != 0 && j == month && h == year) {
								day = eday - 1;
							}
							for (int i = 0; i <= day; i++) {

								String fday;
								String fmonth;
								if (smonth < 10) {

									fmonth = "0" + (smonth + "");
								} else {
									fmonth = smonth + "";
								}
								if (sday < 10) {

									fday = "0" + (sday + "");
								} else {
									fday = sday + "";
								}
								String date = (syear + "") + "-" + fmonth + "-" + fday + "%";
								System.out.println(date);
								ArrayList<MenuVO> list = MenuDAO.select(date);
								sday++;

								if (list.size() == 0) {
//               JOptionPane.showMessageDialog(table, "테이블에 저장된 메모가 없습니다.");
								} else {
									SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
//               테이블에 저장된 데이터가 5개의 필드를 가지고 있으므로 5개의 데이터를 저장할 수 있는 문자열 배열을 만들고 ArrayList에 저장된
//               데이터를 넣어준다.
									String[] rowData = new String[4];
//               JTable에 ArrayList에 저장된 데이터의 개수 만큼 반복하며 데이터를 넣어준다.
									for (MenuVO data : list) {
										rowData[0] = data.getName();
										rowData[1] = data.getCount() + "";
										rowData[2] = data.getPrice() + "";
										rowData[3] = sdf.format(data.getDate());
//                  JTable의 디자인에 사용한 DefaultTableModel 클래스 객체에 addRow() 메소드로 데이터를 넣어준다.
										model.addRow(rowData);
									}
								}
							}
							smonth++;
							sday = 1;
							if (day <= 31) {
								day = 30;
							}

						}
						syear++;
						smonth = 1;
						if (month <= 12) {
							month = 11;
						}
					}

				} catch (NumberFormatException e1) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
					String[] rowData = new String[4];
					ArrayList<MenuVO> list = MenuDAO.select1();
					for (MenuVO data : list) {
						rowData[0] = data.getName();
						rowData[1] = data.getCount() + "";
						rowData[2] = data.getPrice() + "";
						rowData[3] = sdf.format(data.getDate());
						model.addRow(rowData);
					}
				}
			}
		});
		btn1.setBounds(720, 10, 70, 30);
		Cardpanel1_1.add(txt1);
		Cardpanel1_1.add(l1);
		Cardpanel1_1.add(txt2);
		Cardpanel1_1.add(l2);
		Cardpanel1_1.add(txt3);
		Cardpanel1_1.add(l3);
		Cardpanel1_1.add(label);
		Cardpanel1_1.add(txt4);
		Cardpanel1_1.add(l4);
		Cardpanel1_1.add(txt5);
		Cardpanel1_1.add(l5);
		Cardpanel1_1.add(txt6);
		Cardpanel1_1.add(l6);
		Cardpanel1_1.add(btn1);

		JPanel Cardpanel1_2 = new JPanel(new GridLayout());
		Cardpanel1_2.setBounds(0, 50, 800, 685);

		Cardpanel1_2.add(sp);

		Cardpanel1.add(Cardpanel1_1);
		Cardpanel1.add(Cardpanel1_2);

		// 직원관리
		Cardpanel2.setLayout(new GridLayout());
		JPanel Cardpanel2_1 = new JPanel(new GridLayout());
		Cardpanel2_1.setBounds(0, 0, 800, 685);

		Cardpanel2.add(sp1);

		// 오늘의버거
		JPanel TodayPanel = new JPanel(new GridLayout(2, 1));

		JPanel TopPanel = new JPanel(new GridLayout(1, 3));
		JPanel TopBtn01 = new JPanel();
		JPanel TopBtn02 = new JPanel();
		JPanel TopBtn03 = new JPanel();
		JLabel TopLable1 = new JLabel();
		JLabel TopLable2 = new JLabel();
		JLabel TopLable3 = new JLabel();

		JPanel BottomPanel = new JPanel(new GridLayout(1, 3));
		JPanel BotBtn01 = new JPanel();
		JPanel BotBtn02 = new JPanel();
		JPanel BotBtn03 = new JPanel();
		JLabel BotLable1 = new JLabel();
		JLabel BotLable2 = new JLabel();
		JLabel BotLable3 = new JLabel();

//  	버튼
		JPanel BtnPanel1 = new JPanel(new GridLayout(1, 2));
		JPanel BtnPanel2 = new JPanel(new GridLayout(1, 2));
		JPanel BtnPanel3 = new JPanel(new GridLayout(1, 2));
		JPanel BtnPanel4 = new JPanel(new GridLayout(1, 2));
		JPanel BtnPanel5 = new JPanel(new GridLayout(1, 2));
		JPanel BtnPanel6 = new JPanel(new GridLayout(1, 2));

		JButton Choice1 = new JButton();
		JButton Choice2 = new JButton();
		JButton Choice3 = new JButton();
		JButton Choice4 = new JButton();
		JButton Choice5 = new JButton();
		JButton Choice6 = new JButton();

		TopBtn01.setBackground(Color.white);
		TopBtn01.add(BtnPanel1);
		TopBtn01.add(TopLable1);
		TopLable1.setIcon(new ImageIcon("./src/Today Image/Today1_off.png"));
		TopPanel.add(TopBtn01);

//	
		TopBtn02.setBackground(Color.white);
		TopBtn02.add(BtnPanel2);
		TopBtn02.add(TopLable2);
		TopLable2.setIcon(new ImageIcon("./src/Today Image/Today2_off.png"));
		TopPanel.add(TopBtn02);

		TopBtn03.setBackground(Color.white);
		TopBtn03.add(BtnPanel3);
		TopBtn03.add(TopLable3);
		TopLable3.setIcon(new ImageIcon("./src/Today Image/Today3_off.png"));
		TopPanel.add(TopBtn03);

		BotBtn01.setBackground(Color.white);
		BotBtn01.add(BtnPanel4);
		BotBtn01.add(BotLable1);
		BotLable1.setIcon(new ImageIcon("./src/Today Image/Today4_off.png"));
		BottomPanel.add(BotBtn01);

		BotBtn02.setBackground(Color.white);
		BotBtn02.add(BtnPanel5);
		BotBtn02.add(BotLable2);
		BotLable2.setIcon(new ImageIcon("./src/Today Image/Today5_off.png"));
		BottomPanel.add(BotBtn02);

		BotBtn03.setBackground(Color.white);
		BotBtn03.add(BtnPanel6);
		BotBtn03.add(BotLable3);
		BotLable3.setIcon(new ImageIcon("./src/Today Image/Today6_off.png"));
		BottomPanel.add(BotBtn03);

		TopPanel.setBackground(Color.WHITE);
		BottomPanel.setBackground(Color.WHITE);

		TopPanel.add(TopBtn01);
		TopPanel.add(TopBtn02);
		TopPanel.add(TopBtn03);
		BottomPanel.add(BotBtn01);
		BottomPanel.add(BotBtn02);
		BottomPanel.add(BotBtn03);

//	버튼
		BtnPanel1.setBackground(Color.WHITE);
		BtnPanel2.setBackground(Color.WHITE);
		BtnPanel3.setBackground(Color.WHITE);
		BtnPanel4.setBackground(Color.WHITE);
		BtnPanel5.setBackground(Color.WHITE);
		BtnPanel6.setBackground(Color.WHITE);

//	선택버튼
		BtnPanel1.add(Choice1);
		BtnPanel2.add(Choice2);
		BtnPanel3.add(Choice3);
		BtnPanel4.add(Choice4);
		BtnPanel5.add(Choice5);
		BtnPanel6.add(Choice6);

		Choice1.setBackground(Color.WHITE);
		Choice1.setIcon(new ImageIcon("./src/Today Image/admin_icon01.jpg"));
		Choice1.setBorderPainted(false);
		Choice1.setFocusPainted(false);
		Choice1.setContentAreaFilled(false);

		Choice2.setBackground(Color.WHITE);
		Choice2.setIcon(new ImageIcon("./src/Today Image/admin_icon01.jpg"));
		Choice2.setBorderPainted(false);
		Choice2.setFocusPainted(false);
		Choice2.setContentAreaFilled(false);

		Choice3.setBackground(Color.WHITE);
		Choice3.setIcon(new ImageIcon("./src/Today Image/admin_icon01.jpg"));
		Choice3.setBorderPainted(false);
		Choice3.setFocusPainted(false);
		Choice3.setContentAreaFilled(false);

		Choice4.setBackground(Color.WHITE);
		Choice4.setIcon(new ImageIcon("./src/Today Image/admin_icon01.jpg"));
		Choice4.setBorderPainted(false);
		Choice4.setFocusPainted(false);
		Choice4.setContentAreaFilled(false);

		Choice5.setBackground(Color.WHITE);
		Choice5.setIcon(new ImageIcon("./src/Today Image/admin_icon01.jpg"));
		Choice5.setBorderPainted(false);
		Choice5.setFocusPainted(false);
		Choice5.setContentAreaFilled(false);

		Choice6.setBackground(Color.WHITE);
		Choice6.setIcon(new ImageIcon("./src/Today Image/admin_icon01.jpg"));
		Choice6.setBorderPainted(false);
		Choice6.setFocusPainted(false);
		Choice6.setContentAreaFilled(false);

//	한우불고기버거 선택취소
		Choice1.addActionListener(new ActionListener() {
			String choice = "1";
			TodayPopUp popUp = new TodayPopUp(choice);

			public void actionPerformed(ActionEvent e) {
				TodayDAO.insert("1");
				if (flag1 == false) {
					TopLable1.setIcon(new ImageIcon("./src/Today Image/Today1_on.png"));
					popUp.setVisible(true);
					flag1 = true;
				} else {
					TopLable1.setIcon(new ImageIcon("./src/Today Image/Today1_off.png"));
					popUp.setVisible(false);
					flag1 = false;
				}
			}
		});

//	통새우버거 선택취소
		Choice2.addActionListener(new ActionListener() {
			String choice = "2";
			TodayPopUp popUp = new TodayPopUp(choice);

			public void actionPerformed(ActionEvent e) {
				TodayDAO.insert("2");
				if (flag2 == false) {
					TopLable2.setIcon(new ImageIcon("./src/Today Image/Today2_on.png"));
					popUp.setVisible(true);
					flag2 = true;
				} else {
					TopLable2.setIcon(new ImageIcon("./src/Today Image/Today2_off.png"));
					popUp.setVisible(false);
					flag2 = false;
				}
			}
		});

//	치킨버거 선택취소
		Choice3.addActionListener(new ActionListener() {
			String choice = "3";
			TodayPopUp popUp = new TodayPopUp(choice);

			public void actionPerformed(ActionEvent e) {
				TodayDAO.insert("3");
				if (flag3 == false) {
					TopLable3.setIcon(new ImageIcon("./src/Today Image/Today3_on.png"));
					popUp.setVisible(true);
					flag3 = true;
				} else {
					TopLable3.setIcon(new ImageIcon("./src/Today Image/Today3_off.png"));
					popUp.setVisible(false);
					flag3 = false;
				}
			}
		});

//	모짜렐라치즈버거 선택취소
		Choice4.addActionListener(new ActionListener() {
			String choice = "4";
			TodayPopUp popUp = new TodayPopUp(choice);

			public void actionPerformed(ActionEvent e) {
				TodayDAO.insert("4");
				if (flag4 == false) {
					BotLable1.setIcon(new ImageIcon("./src/Today Image/Today4_on.png"));
					popUp.setVisible(true);
					flag4 = true;
				} else {
					BotLable1.setIcon(new ImageIcon("./src/Today Image/Today4_off.png"));
					popUp.setVisible(false);
					flag4 = false;
				}
			}
		});

//	에그버거 선택취소
		Choice5.addActionListener(new ActionListener() {
			String choice = "5";
			TodayPopUp popUp = new TodayPopUp(choice);

			public void actionPerformed(ActionEvent e) {
				TodayDAO.insert("5");
				if (flag5 == false) {
					BotLable2.setIcon(new ImageIcon("./src/Today Image/Today5_on.png"));
					popUp.setVisible(true);
					flag5 = true;
				} else {
					BotLable2.setIcon(new ImageIcon("./src/Today Image/Today5_off.png"));
					popUp.setVisible(false);
					flag5 = false;
				}
			}
		});

//	베이컨버거 선택취소
		Choice6.addActionListener(new ActionListener() {
			String choice = "6";
			TodayPopUp popUp = new TodayPopUp(choice);

			public void actionPerformed(ActionEvent e) {
				TodayDAO.insert("6");
				if (flag6 == false) {
					BotLable3.setIcon(new ImageIcon("./src/Today Image/Today6_on.png"));
					popUp.setVisible(true);
					flag6 = true;
				} else {
					BotLable3.setIcon(new ImageIcon("./src/Today Image/Today6_off.png"));
					popUp.setVisible(false);
					flag6 = false;
				}
			}
		});

		TodayPanel.add(TopPanel);
		TodayPanel.add(BottomPanel);

		Cardpanel3.add(TodayPanel);

		CardpanelMain.add("1", Cardpanel1);
		CardpanelMain.add("2", Cardpanel2);
		CardpanelMain.add("3", Cardpanel3);
		CardpanelMain.add("4", Cardpanel4);
		add(CardpanelMain);

		setVisible(true);
	}

	public static void main(String[] args) {
		new Administrator();
	}
}