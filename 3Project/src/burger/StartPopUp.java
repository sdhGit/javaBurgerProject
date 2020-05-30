package burger;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPopUp extends JFrame {
	ImageIcon imageicon = new ImageIcon(".\\src\\image\\g.jpg");
	ImageIcon imageicon2 = new ImageIcon(".\\src\\image\\g1.jpg");
	ImageIcon imageicon3 = new ImageIcon(".\\src\\image\\3.jpg");

	JButton admin = new JButton(imageicon);
	JButton general = new JButton(imageicon2);
	JLabel label = new JLabel(imageicon3);
//	JLabel label = new JLabel(new ImageIcon(".\\src\\image\\3.jpg"));

	public StartPopUp() {
		setTitle("화영이 멍청이 바보 똥개 에붸붸붸붸");
		setSize(300, 218);
		setBackground(Color.white);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		admin.setBounds(0, 140, 150, 50);
		general.setBounds(155, 140, 140, 50);
		label.setBounds(-80, -60, 460, 760);

		admin.setBorderPainted(false);
		admin.setFocusPainted(false);
		admin.setContentAreaFilled(false);

		general.setBorderPainted(false);
		general.setFocusPainted(false);
		general.setContentAreaFilled(false);

		add(admin);
		add(general);
		add(label);

		admin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Login2();
				setVisible(false);
			}
		});

		general.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
				setVisible(false);
			}
		});

		setVisible(true);

	}

	public static void main(String[] args) {

		StartPopUp win = new StartPopUp();

	}
}
