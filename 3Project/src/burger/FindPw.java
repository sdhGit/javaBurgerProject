package burger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FindPw extends JFrame {
	ImageIcon imageicon;
	ImageIcon imageicon1;
	ImageIcon imageicon2;

	JLabel nameL, idL;
	JButton check, back;
	JTextField name, id;

	public FindPw() {
		imageicon = new ImageIcon(".\\src\\image\\3.jpg");
		imageicon1 = new ImageIcon(".\\src\\image\\check.png");
		imageicon2 = new ImageIcon(".\\src\\image\\back.png");
		JLabel bannerLabel = new JLabel(imageicon);

		name = new JTextField();
		id = new JTextField();
		nameL = new JLabel("이름");
		idL = new JLabel("아이디");
		check = new JButton(imageicon1);
		back = new JButton(imageicon2);

		check.setBorderPainted(false);
		check.setFocusPainted(false);
		check.setContentAreaFilled(false);

		back.setBorderPainted(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);

		setTitle("비밀번호 찾기");
		setSize(300, 250);

		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		80, 170, 130, 30 10, 170, 130, 30
		id.setBounds(80, 120, 130, 30);
		name.setBounds(80, 170, 130, 30);
		idL.setBounds(0, 120, 130, 30);
		nameL.setBounds(10, 170, 130, 30);
		check.setBounds(235, 115, 41, 40);
		back.setBounds(235, 170, 40, 40);
		bannerLabel.setBounds(-90, -60, 460, 760);
		add(name);
		add(id);
		add(nameL);
		add(idL);
		add(check);
		add(back);
		add(bannerLabel);

		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String i = id.getText();
				String s = name.getText();
				String f = MemberDAO.findPW(i, s);

				if (f.equals("정보가일치하지않습니다")) {
					JOptionPane.showMessageDialog(null, f);
					new FindPw();
				} else {
					JOptionPane.showMessageDialog(null, s + "님 비밀번호: " + f);
					new Login();
				}
				setVisible(false);
			}
		});

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login();

			}
		});

		setVisible(true);
	}
}
