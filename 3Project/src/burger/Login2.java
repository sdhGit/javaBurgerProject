package burger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login2 extends JFrame {
	ImageIcon imageicon;
	ImageIcon imageicon2;
	ImageIcon imageicon3;
	ImageIcon imageicon4;
	ImageIcon imageicon5;
	
	JLabel idl, pwl;
	static JTextField id;
	JButton login2, sumit2, findid, findpw;
	static JPasswordField pw;
	
	public Login2() {
//	생성
	imageicon = new ImageIcon(".\\src\\image\\signup.png");
	imageicon2 = new ImageIcon(".\\src\\image\\login.png");
	imageicon3 = new ImageIcon(".\\src\\image\\3.jpg");
	imageicon4 = new ImageIcon(".\\src\\image\\7.png");
	imageicon5 = new ImageIcon(".\\src\\image\\8.png");
	
	JLabel bannerLabel = new JLabel(imageicon3);
	id = new JTextField();	
	pw = new JPasswordField();	
	idl = new JLabel("     ID : ");
	pwl = new JLabel("  PW : ");
	login2 = new JButton(imageicon2);
	sumit2 = new JButton(imageicon);
	findid = new JButton(imageicon4);
	findpw = new JButton(imageicon5);
	
	sumit2.setBorderPainted(false);
	sumit2.setFocusPainted(false);
	sumit2.setContentAreaFilled(false);

	login2.setBorderPainted(false);
	login2.setFocusPainted(false);
	login2.setContentAreaFilled(false);
	
	findid.setBorderPainted(false);
	findid.setFocusPainted(false);
	findid.setContentAreaFilled(false);

	findpw.setBorderPainted(false);
	findpw.setFocusPainted(false);
	findpw.setContentAreaFilled(false);
	
	
	
	
//	프레임 세팅
	setTitle("관리자로그인");
	setSize(300, 250);

	setLayout(null);
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	
//	레이아웃 세팅
	id.setBounds(60, 100, 130, 30);
	idl.setBounds(10, 100, 40, 30);
	
	pw.setBounds(60, 140, 130, 30);
	pwl.setBounds(10, 140, 40, 30);
	
	login2.setBounds(200, 100, 80, 75);
	sumit2.setBounds(30, 180, 100, 30);
	findid.setBounds(140,180,70,30);
	findpw.setBounds(210,180,70,30);
	bannerLabel.setBounds(-90, -60, 460, 760);
	
	
	add(idl);
	add(pwl);
	add(id);
	add(pw);
	add(login2);
	add(sumit2);
	add(findid);
	add(findpw);
	
	add(bannerLabel);
	
	findid.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new FindId2();
			setVisible(false);
		}
	});
	
	findpw.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new FindPw2();
			setVisible(false);
		}
	});
	
	
	
	
	
	sumit2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "필수입력\n아이디, 비밀번호, 이름, 전화번호, 카드");
			new Sumit2();
			setVisible(false);
			
		}
	});
	
	login2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String ids = id.getText();
			String pws = pw.getText();
			boolean flag =MemberDAO2.login2(ids,pws);
			if(flag) {
				JOptionPane.showMessageDialog(null, "로그인 성공");
				new Administrator();
				setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "로그인 실패");
				id.setText("");
				pw.setText("");
				id.requestFocus();
			}
			
		}
	});
	
	
	setVisible(true);
	}
}
