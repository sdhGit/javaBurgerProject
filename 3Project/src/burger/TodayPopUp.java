package burger;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TodayPopUp extends JFrame implements MouseListener{
//	JPanel BannerPanel = new JPanel(new GridLayout());
//	JPanel TitlePanel = new JPanel();
//	JPanel TodayPanel = new JPanel(new CardLayout());
//	JPanel TodayPanel = new JPanel();
//	JLabel TodayTitle = new JLabel("<< 오늘은 추천 버거 >>", JLabel.CENTER);
//	JLabel orderLable = new JLabel("주문 내역이 표시되는 곳!", JLabel.CENTER);
	
	JLabel imglabel1 = new JLabel(new ImageIcon("./src/Today Image/todayBurger1.jpg"));
	JLabel imglabel2 = new JLabel(new ImageIcon("./src/Today Image/todayBurger2.jpg"));
	JLabel imglabel3 = new JLabel(new ImageIcon("./src/Today Image/todayBurger3.jpg"));
	JLabel imglabel4 = new JLabel(new ImageIcon("./src/Today Image/todayBurger4.jpg"));
	JLabel imglabel5 = new JLabel(new ImageIcon("./src/Today Image/todayBurger5.jpg"));
	JLabel imglabel6 = new JLabel(new ImageIcon("./src/Today Image/todayBurger6.jpg"));
//	Container popUpcont;
	
	String choice;
	
	public TodayPopUp(String choice) {
		
		setTitle("Choose Bread");
		setSize(400, 430);
		setBackground(Color.white);
		setLocationRelativeTo(null);
		setResizable(false);
		
		imglabel1.addMouseListener(this);
		imglabel2.addMouseListener(this);
		imglabel3.addMouseListener(this);
		imglabel4.addMouseListener(this);
		imglabel5.addMouseListener(this);
		imglabel6.addMouseListener(this);
		
		
		
		if(choice.equals("1")) {
			add(imglabel1);
		}else if(choice.equals("2")) {
			add(imglabel2);
		}else if(choice.equals("3")) {
			add(imglabel3);
		}else if(choice.equals("4")) {
			add(imglabel4);
		}else if(choice.equals("5")) {
			add(imglabel5);
		}else if(choice.equals("6")) {
			add(imglabel6);
		}
		
		
		setVisible(false);
	}
	
public String getChoice() {return choice;}
public void setChoice(String choice) {this.choice = choice;}

@Override
public void mouseClicked(MouseEvent e) {
	setVisible(false);
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}




}	
