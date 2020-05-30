package burger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FindId extends JFrame {
	ImageIcon imageicon;
	ImageIcon imageicon1;
	ImageIcon imageicon2;

	JLabel nameL, telL;
	JButton check, back;
	JTextField name, tel;

	public FindId() {
		imageicon = new ImageIcon(".\\src\\image\\3.jpg");
		imageicon1 = new ImageIcon(".\\src\\image\\check.png");
		imageicon2 = new ImageIcon(".\\src\\image\\back.png");
		JLabel bannerLabel = new JLabel(imageicon);

		name = new JTextField();
		tel = new JTextField();
		nameL = new JLabel("이름");
		telL = new JLabel("전화번호");
		check = new JButton(imageicon1);
		back = new JButton(imageicon2);

		check.setBorderPainted(false);
		check.setFocusPainted(false);
		check.setContentAreaFilled(false);

		back.setBorderPainted(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);

		setTitle("아이디 찾기");
		setSize(300, 250);

		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		name.setBounds(80, 120, 130, 30);
		nameL.setBounds(10, 120, 130, 30);
		tel.setBounds(80, 170, 130, 30);
		telL.setBounds(10, 170, 130, 30);
		check.setBounds(235, 115, 41, 40);
		back.setBounds(235, 170, 40, 40);
		bannerLabel.setBounds(-90, -60, 460, 760);
		add(name);
		add(tel);
		add(nameL);
		add(telL);
		add(check);
		add(back);
		add(bannerLabel);

		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = name.getText();
				String p = tel.getText();
				String f = MemberDAO.findID(s, p);

				if (f.equals("정보가일치하지않습니다")) {
					JOptionPane.showMessageDialog(null, f);
					new FindId();
				} else {
					JOptionPane.showMessageDialog(null, s + "님 아이디: " + f);
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
