package burger;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SetSideMenu1 extends JFrame implements ItemListener {

	JPanel mainPanel = new JPanel(new GridLayout(2, 1));
	JPanel topPanel = new JPanel();
	JPanel drink = new JPanel();
	JLabel topLable = new JLabel();
	JRadioButton cider, coke, fanta, coffee;
	ButtonGroup group = new ButtonGroup();

	JPanel BottomPanel = new JPanel();
	JPanel side = new JPanel();
	JLabel BottomLable = new JLabel();
	JRadioButton fries, cheeseStick, nugget, salad;
	ButtonGroup group1 = new ButtonGroup();

	JPanel titlePanel = new JPanel(new GridLayout(2, 1));

	Image[] images = new Image[2];
	JPanel buttonPanel = new JPanel(new FlowLayout());
	JButton back = new JButton();
	JButton okay = new JButton();

	String menu = "한우불고기 버거 세트";
	int price = 8400;
	int count = 1;

	public SetSideMenu1() {
		setTitle("Choose Side");
		setBounds(560, 255, 800, 650);

		setLayout(new BorderLayout());
		setBackground(Color.white);
		setResizable(false);

		topLable.setIcon(new ImageIcon("./src/Image/drinkTitle.jpg"));
		BottomLable.setIcon(new ImageIcon("./src/Image/sideTitle.jpg"));
		titlePanel.add(topLable);
		titlePanel.add(BottomLable);
		titlePanel.setBackground(Color.WHITE);

		topPanel.setBackground(Color.WHITE);
		drink.setBackground(Color.WHITE);
		BottomPanel.setBackground(Color.WHITE);
		side.setBackground(Color.WHITE);

		coke = new JRadioButton("", new ImageIcon("./src/drink image/drink1_on.jpg"), true);
		cider = new JRadioButton("", new ImageIcon("./src/drink image/drink2_off.jpg"));
		fanta = new JRadioButton("", new ImageIcon("./src/drink image/drink3_off.jpg"));
		coffee = new JRadioButton("", new ImageIcon("./src/drink image/drink4_off.jpg"));
		drink.add(coke);
		drink.add(cider);
		drink.add(fanta);
		drink.add(coffee);
		topPanel.add(drink, BorderLayout.CENTER);
////	같은 그룹의 JRadioButton 클래스 객체를 ButtonGroup 클래스 객체에 추가해서 같은 그룹으로 묶어준다.
		group.add(coke);
		group.add(cider);
		group.add(fanta);
		group.add(coffee);

		coke.addItemListener(this);
		cider.addItemListener(this);
		fanta.addItemListener(this);
		coffee.addItemListener(this);

		cider.setBorderPainted(false);
		cider.setFocusPainted(false);
		cider.setContentAreaFilled(false);
		coke.setBorderPainted(false);
		coke.setFocusPainted(false);
		coke.setContentAreaFilled(false);
		fanta.setBorderPainted(false);
		fanta.setFocusPainted(false);
		fanta.setContentAreaFilled(false);
		coffee.setBorderPainted(false);
		coffee.setFocusPainted(false);
		coffee.setContentAreaFilled(false);

//	=======================================================================================

		fries = new JRadioButton("", new ImageIcon("./src/drink image/side2_on.jpg"), true);
		salad = new JRadioButton("", new ImageIcon("./src/drink image/side1_off.jpg"));
		nugget = new JRadioButton("", new ImageIcon("./src/drink image/side4_off.jpg"));
		cheeseStick = new JRadioButton("", new ImageIcon("./src/drink image/side3_off.jpg"));

		side.add(fries);
		side.add(salad);
		side.add(nugget);
		side.add(cheeseStick);
		BottomPanel.add(side, BorderLayout.CENTER);

		group1.add(fries);
		group1.add(salad);
		group1.add(nugget);
		group1.add(cheeseStick);

		fries.addItemListener(this);
		salad.addItemListener(this);
		nugget.addItemListener(this);
		cheeseStick.addItemListener(this);

		fries.setBorderPainted(false);
		fries.setFocusPainted(false);
		fries.setContentAreaFilled(false);
		salad.setBorderPainted(false);
		salad.setFocusPainted(false);
		salad.setContentAreaFilled(false);
		nugget.setBorderPainted(false);
		nugget.setFocusPainted(false);
		nugget.setContentAreaFilled(false);
		cheeseStick.setBorderPainted(false);
		cheeseStick.setFocusPainted(false);
		cheeseStick.setContentAreaFilled(false);

		// ======================================================

		buttonPanel.add(back);
		buttonPanel.add(okay);
		buttonPanel.setBackground(Color.white);

		back.setIcon(new ImageIcon("./src/Image/back.png"));
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MainFrame(null, 0, 0);
			}
		});
		okay.setIcon(new ImageIcon("./src/Image/confirm.png"));
		okay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
//			if(MainFrame.count == 0) {
//				MainFrame.list.clear();
//			}
				MainFrame.list.add(new MenuVO(menu, count, price)); // static 변수 list에 값 저장
				MainFrame.count++; // MainFrame이 한 번 더 실행 됐다고 표시
				new MainFrame("", 0, 0);
			}
		});

		back.setBorderPainted(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);

		okay.setBorderPainted(false);
		okay.setFocusPainted(false);
		okay.setContentAreaFilled(false);

		mainPanel.add(topPanel);
		mainPanel.add(BottomPanel);

		add(mainPanel, BorderLayout.EAST);
		add(buttonPanel, BorderLayout.SOUTH);
		add(titlePanel, BorderLayout.WEST);

		setVisible(true);
	}

	public static void main(String[] args) {
		SetSideMenu1 win = new SetSideMenu1();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object object = e.getSource();
		JRadioButton checkbox = (JRadioButton) object;
		JRadioButton checkbox2 = (JRadioButton) object;

		if (checkbox == cider) {
			if (checkbox.isSelected()) {
//			setIcon() : 체크 박스대신 표시되는 이미지를 변경한다.
				cider.setIcon(new ImageIcon("./src/drink image/drink2_on.jpg"));
			} else {
				cider.setIcon(new ImageIcon("./src/drink image/drink2_off.jpg"));
			}
		} else if (checkbox == coke) {
			if (checkbox.isSelected()) {
//			setIcon() : 체크 박스대신 표시되는 이미지를 변경한다.
				coke.setIcon(new ImageIcon("./src/drink image/drink1_on.jpg"));
			} else {
				coke.setIcon(new ImageIcon("./src/drink image/drink1_off.jpg"));
			}
		} else if (checkbox == fanta) {
			if (checkbox.isSelected()) {
//			setIcon() : 체크 박스대신 표시되는 이미지를 변경한다.
				fanta.setIcon(new ImageIcon("./src/drink image/drink3_on.jpg"));
			} else {
				fanta.setIcon(new ImageIcon("./src/drink image/drink3_off.jpg"));
			}
		} else if (checkbox == coffee) {
			if (checkbox.isSelected()) {
//			setIcon() : 체크 박스대신 표시되는 이미지를 변경한다.
				coffee.setIcon(new ImageIcon("./src/drink image/drink4_on.jpg"));
			} else {
				coffee.setIcon(new ImageIcon("./src/drink image/drink4_off.jpg"));
			}
		}

//		사이드!!!!!!!!

		if (checkbox2 == fries) {
			if (checkbox2.isSelected()) {
//				setIcon() : 체크 박스대신 표시되는 이미지를 변경한다.
				fries.setIcon(new ImageIcon("./src/drink image/side2_on.jpg"));
			} else {
				fries.setIcon(new ImageIcon("./src/drink image/side2_off.jpg"));
			}
		} else if (checkbox2 == salad) {
			if (checkbox2.isSelected()) {
//				setIcon() : 체크 박스대신 표시되는 이미지를 변경한다.
				salad.setIcon(new ImageIcon("./src/drink image/side1_on.jpg"));
			} else {
				salad.setIcon(new ImageIcon("./src/drink image/side1_off.jpg"));
			}
		} else if (checkbox2 == nugget) {
			if (checkbox2.isSelected()) {
//				setIcon() : 체크 박스대신 표시되는 이미지를 변경한다.
				nugget.setIcon(new ImageIcon("./src/drink image/side4_on.jpg"));
			} else {
				nugget.setIcon(new ImageIcon("./src/drink image/side4_off.jpg"));
			}
		} else if (checkbox2 == cheeseStick) {
			if (checkbox2.isSelected()) {
//				setIcon() : 체크 박스대신 표시되는 이미지를 변경한다.
				cheeseStick.setIcon(new ImageIcon("./src/drink image/side3_on.jpg"));
			} else {
				cheeseStick.setIcon(new ImageIcon("./src/drink image/side3_off.jpg"));
			}
		}

	}
}
