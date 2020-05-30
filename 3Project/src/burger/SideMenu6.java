package burger;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SideMenu6 extends JFrame {

	static int count =1;
	JPanel mainPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JLabel burger = new JLabel();
	JLabel text = new JLabel(count+"");
	JButton sub = new JButton();
	JButton add = new JButton();

	JPanel buttonPanel = new JPanel(new FlowLayout());
	JButton back = new JButton();
	JButton okay = new JButton();
	String menu = "사이다";
	int price = 1800;

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public SideMenu6() {
		setTitle("SideMenu");
		setSize(250, 450);
		setLayout(new BorderLayout());
		setBackground(Color.white);
		setLocationRelativeTo(null);
		setResizable(false);

		burger.setIcon(new ImageIcon("./src/Image/drink2_on.jpg"));
		rightPanel.add(burger);
		rightPanel.setBackground(Color.white);
		mainPanel.add(rightPanel);
		mainPanel.setBackground(Color.white);

		leftPanel.add(sub);
		leftPanel.add(text);
		leftPanel.add(add);
		leftPanel.setBackground(Color.WHITE);
		mainPanel.add(leftPanel);

		add(mainPanel, BorderLayout.CENTER);

//		===================================
		buttonPanel.add(back);
		buttonPanel.add(okay);
		buttonPanel.setBackground(Color.WHITE);
		add(buttonPanel, BorderLayout.SOUTH);

		setVisible(true);
		text.requestFocus();
//		=====================================
//		sub.setSize(new Dimension(10,10));
		sub.setBorderPainted(false);
		sub.setFocusPainted(false);
		sub.setContentAreaFilled(false);
		sub.setIcon(new ImageIcon("./src/Image/Btn-09.jpg"));
		sub.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count>0) {
				count--;
				text.setText(count+"");
				}
			}
		});
		add.setBorderPainted(false);
		add.setFocusPainted(false);
		add.setContentAreaFilled(false);
		add.setIcon(new ImageIcon("./src/Image/Btn-10.jpg"));
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				text.setText(count+"");
			}
		});
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
//				if(MainFrame.count == 0) {
//					MainFrame.list.clear();
//					
//				}
				MainFrame.list.add(new MenuVO(menu, count, price*count)); //static 변수 list에 값 저장
				MainFrame.count++; // MainFrame이 한 번 더 실행 됐다고 표시
				new MainFrame("", 0, 0);
				count=1;
			}
		});
		
		back.setBorderPainted(false);
	    back.setFocusPainted(false);
	    back.setContentAreaFilled(false);
	    
	    okay.setBorderPainted(false);
	    okay.setFocusPainted(false);
	    okay.setContentAreaFilled(false);

	}

	public static void main(String[] args) {
		SideMenu6 go = new SideMenu6();
	}

}
