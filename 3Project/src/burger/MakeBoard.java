
package burger;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import burger.FindId;
import burger.Login;
import burger.MainFrame;
import burger.MemberDAO;
import burger.MemberVO;

public class MakeBoard extends JDialog implements ActionListener {
	boardProject parent;

	JLabel title; // "후기 작성하기" 라벨
	JPanel titlePanel;
	JButton complete; // 완료 버튼
	JPanel completePanel;
	JPanel menuPanel; // titlePanel과 completePanel가 붙을 panel
	JLabel star; // "별점"
	JPanel starLabel; // "별점" label이 붙을 패널
	JButton[] starPoint;
	JPanel starPanel; // starPoint 버튼이 붙을 panel
	JPanel starMenuPanel; // starLabel과 starPanel이 붙을 panel
	JTextArea textArea;
	JPanel memoPanel; // textArea가 붙을 panel
	JButton[] updatePhoto = new JButton[3];
	boolean[] isPhoto = new boolean[3];
	JLabel[] photoImg = new JLabel[3];
	JPanel photoPanel; // updatePhoto가 붙을 panel
	JPanel wholePanel; // 모든 Panel이 다 붙을 Panel
	JPasswordField pw = new JPasswordField(8);
	JTextField name = new JTextField(6);
	JLabel pwl = new JLabel("비밀번호");
	JLabel namel = new JLabel("이름");
	String f = null;

	ImageIcon starImg = new ImageIcon("images/star.png");
	ImageIcon gray_starImg = new ImageIcon("images/gray_star.png");
	int index = -1; // 5개의 별 중 제일 마지막에 칠해진 별의 인덱스, 처음에는 아무것도 안 칠해진 회색 별임
	String storingPath;
	String fileName;
	

	public void init() {
		titlePanel = new JPanel();
		title = new JLabel("★후기 작성하기★  →");
		titlePanel.add(title);
		titlePanel.setPreferredSize(new Dimension(50,10));
		
//		TitledBorder tb = new TitledBorder(new LineBorder(Color.black), "1번"); // panel 테두리 설정
//		tb.setTitleColor(Color.red);
//		titlePanel.setBorder(tb);
		
		
		completePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		complete = new JButton();
		complete.addActionListener(this);
		complete.setText("완료");
		completePanel.add(pwl);
		completePanel.add(pw);
		completePanel.add(namel);
		completePanel.add(name);
		completePanel.add(complete);
	
		
		menuPanel = new JPanel();
		menuPanel.add(title);
		menuPanel.add(pwl);
		menuPanel.add(pw);
		menuPanel.add(namel);
		menuPanel.add(name);
		menuPanel.add(complete);
	
		
		
		starLabel = new JPanel();
		star = new JLabel("별점");
		starLabel.add(star);

		// 후기 별점 5개 버튼 생성
		starPanel = new JPanel();
		starPoint = new JButton[5];
		// 처음에는 모두 회색 별로
		for (int i = 0; i < 5; i++) {
			starPoint[i] = new JButton();
			starPoint[i].addActionListener(this);
			starPoint[i].setIcon(gray_starImg);
			starPoint[i].setBorderPainted(false);
			starPoint[i].setContentAreaFilled(false);
			starPanel.add(starPoint[i]);
		}

		starMenuPanel = new JPanel();
		starMenuPanel.add(starLabel);
		starMenuPanel.add(starPanel);

		// 사진을 붙일 3개의 버튼 생성
		photoPanel = new JPanel();
		for (int i = 0; i < updatePhoto.length; i++) {
			updatePhoto[i] = new JButton();
			updatePhoto[i].setIcon(new ImageIcon("images/camera.PNG"));		
			updatePhoto[i].setBorderPainted(false);
			updatePhoto[i].setContentAreaFilled(false);
			updatePhoto[i].addActionListener(this);
			photoPanel.add(updatePhoto[i]);
		}	

		memoPanel = new JPanel();
		textArea = new JTextArea("후기 작성");
		
		textArea.addMouseListener(new MouseAdapter() {

	@Override
	public void mouseClicked(MouseEvent e) {
		textArea.setText("");
	}

	});

	// textArea 테두리 설정
	
	Border border = BorderFactory.createLineBorder(Color.BLACK);
	textArea.setBorder(BorderFactory.createCompoundBorder(border,
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

	wholePanel=new JPanel(new GridLayout(5,1));wholePanel.add(menuPanel);wholePanel.add(starMenuPanel);wholePanel.add(photoPanel);wholePanel.add(memoPanel);wholePanel.add(textArea);
	JScrollPane scroll = new JScrollPane(wholePanel);this.add(scroll,BorderLayout.CENTER);

	}

	public MakeBoard() {

		init();
		this.setTitle("후기 작성하기");
		this.setSize(600, 700);
		this.setLocation(500, 500);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public MakeBoard(boardProject frame, String title, boolean modal) {
		super(frame, title, modal);
		parent = frame;
		init();
		this.setSize(600, 700);
		this.setLocation(600, 300);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int a = 0; a < 5; a++) {
			if (e.getSource() == starPoint[a]) {
				if (index == a) { // 노란색으로 칠해진 별을 누른 별을 회색으로 바꿔야 함.
					for (int b = 0; b < a; b++) {
						starPoint[a].setIcon(this.starImg);
					}
					starPoint[a].setIcon(this.gray_starImg);
					index = a - 1; // 마지막에 칠해진 노란색의 위치를 표시
					break;
				} else if (a < index || a > index) { // index 보다 왼쪽 또는 오른쪽에 있는 별을 클릭하면 클릭한 부분이 새로운 index가 되고 그 부분까지
														// 노란색으로 바꿔야 함.
					for (int i = 0; i < 5; i++) {
						if (i <= a) {
							starPoint[i].setIcon(this.starImg);
						} else {
							starPoint[i].setIcon(this.gray_starImg);
						}
					}
					index = a;
					break;
				}
			} else
				continue;
		}
		for (int i = 0; i < 3; i++) {
			if (e.getSource() == updatePhoto[i]) {
				if (isPhoto[i] == false) {
					JFileChooser filedlg = new JFileChooser();
					int result = filedlg.showOpenDialog(this);

					if (result == JFileChooser.APPROVE_OPTION) {
						File file = filedlg.getSelectedFile();
						try {

							ImageIcon img = new ImageIcon(ImageIO.read(file));
							String filePath = file.getAbsolutePath();
							System.out.println(filePath); // 잘 들어감. 성공
							fileName = filePath.substring(filePath.lastIndexOf("\\") + 1); // 클릭한 사진의 절대 경로

							storingPath = this.getClass().getResource("/").getPath(); // 이 프로젝트의 절대 경로
							storingPath = storingPath.substring(1, storingPath.lastIndexOf("/") - 3);
							storingPath = storingPath.replace("/", "\\");
							storingPath = storingPath + "images\\" + fileName; // 이 프로젝트의 절대 경로 안에 있는 이미지 파일에 fileName
							System.out.println(storingPath);
																				// 붙이기
							ResizeImage resize = new ResizeImage(90, 90);
							resize.resizeImg(filePath, storingPath); 
							updatePhoto[i].setIcon(new ImageIcon("images/"+fileName));
							
							isPhoto[i] = true;
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} else { // 이미 사진이 등록되어 있으면 등록한 사진을 삭제할 수 있는 이벤트 넣어줌.
					int option = JOptionPane.showConfirmDialog(this, "등록한 사진을 삭제 하시겠습니까?", "삭제",
							JOptionPane.YES_NO_OPTION);
					if (option == 0) { // "예"를 눌렀으면 등록한 사진을 삭제해야 한다.
						updatePhoto[i].setIcon(new ImageIcon("images/camera.PNG"));
						isPhoto[i] = false; // isPhoto[0]에 등록된 사진이 없다고 표시
						File file = new File(storingPath);
						file.delete();
					}
				}
			} else
				continue;
		}
		if (e.getSource() == complete) { //완료 버튼을 누르면
			boardVO vo = new boardVO();
			MemberVO memberVO = new MemberVO();
			String s = pw.getText();
			String n = name.getText();
			f = MemberDAO.findI(s,n);
//			382913233
//			asfawfawf
			System.out.println("if 문 전입니다");
			if (f.equals("정보가일치하지않습니다.")) {
				System.out.println("if에 걸림");
				JOptionPane.showMessageDialog(null, "정보가 일치하지 않습니다.");
				new boardProject();
				parent.dispose();
			} else {
//				JOptionPane.showMessageDialog(null, "저장완료");
				vo.setStarPoint(index+1);
				vo.setMemo(textArea.getText());
				vo.setFilename("images/"+fileName);
				vo.setId(f);
				boardDAO.insert(vo);
				new boardProject();
			}
			
			setVisible(false);
			
			
			//boardProject.setCurrent_size(boardProject.getCurrent_size()+1);
			
			
			
//			this.dispose();
		}
	}
}
