package burger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Sumit extends JFrame {
   ImageIcon imageicon;
   ImageIcon imageicon2;
   ImageIcon imageicon3;

   JLabel IDl, PWl, PWl2, NAMEl, TELl, EMAILl, CARDl, YYMMl, CVCl;
   JTextField ID, NAME, TEL, EMAIL, CARD, YYMM, CVC;
   JPasswordField PW, PW2;
   JButton ok, back;

   public Sumit() {
      imageicon = new ImageIcon(".\\src\\image\\1.jpg");
      imageicon2 = new ImageIcon(".\\src\\image\\2.jpg");
      imageicon3 = new ImageIcon(".\\src\\image\\3.jpg");

      JLabel bannerLabel = new JLabel(imageicon3);

      ID = new JTextField();
      PW = new JPasswordField();
      PW2 = new JPasswordField();
      NAME = new JTextField();
      TEL = new JTextField("- 제외하고 입력");
      EMAIL = new JTextField();
      CARD = new JTextField("- 제외하고 입력");
      YYMM = new JTextField("월/년, (/ 제외)");
      CVC = new JTextField("CVC");

      IDl = new JLabel("   아이디");
      PWl = new JLabel(" 비밀번호");
      PWl2 = new JLabel(" 비밀번호 확인");
      NAMEl = new JLabel("   이름");
      TELl = new JLabel(" 전화번호 ");
      EMAILl = new JLabel("   EMAIL");
      CARDl = new JLabel(" 카드번호 ");


      ok = new JButton(imageicon);
      back = new JButton(imageicon2);

      ok.setBorderPainted(false);
      ok.setFocusPainted(false);
      ok.setContentAreaFilled(false);

      back.setBorderPainted(false);
      back.setFocusPainted(false);
      back.setContentAreaFilled(false);

      ID.selectAll();
      PW.selectAll();
      PW2.selectAll();
      NAME.selectAll();
      TEL.selectAll();
      EMAIL.selectAll();
      CARD.selectAll();
      YYMM.selectAll();
      CVC.selectAll();
       
      

      setTitle("회원가입");
//      setSize(300, 370);
      setSize(400, 600);
      setLayout(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      setLocationRelativeTo(null);
      ID.setBounds(120, 200, 200, 30);
      IDl.setBounds(40, 200, 90, 30);

      PW.setBounds(120, 240, 200, 30);
      PWl.setBounds(40, 240, 100, 30);

      PW2.setBounds(120, 280, 200, 30);
      PWl2.setBounds(30, 280, 100, 30);

      NAME.setBounds(120, 320, 200, 30);
      NAMEl.setBounds(40, 320, 50, 30);

      TEL.setBounds(120, 360, 200, 30);
      TELl.setBounds(40, 360, 100, 30);

      EMAIL.setBounds(120, 400, 200, 30);
      EMAILl.setBounds(40, 400, 50, 30);

      CARD.setBounds(120, 440, 200, 30);
      CARDl.setBounds(40, 440, 90, 30);

      YYMM.setBounds(120, 480, 90, 30);
      CVC.setBounds(230, 480, 90, 30);

      ok.setBounds(120, 520, 90, 30);
      back.setBounds(230, 520, 90, 30);

      bannerLabel.setBounds(-35, -30, 460, 760);

      add(ID);
      add(PW);
      add(PW2);
      add(NAME);
      add(TEL);
      add(EMAIL);
      add(CARD);
      add(YYMM);
      add(CVC);

      add(IDl);
      add(PWl);
      add(PWl2);
      add(NAMEl);
      add(TELl);
      add(EMAILl);
      add(CARDl);
      add(ok);
      add(back);

      add(bannerLabel);

      ok.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            MemberVO vo = new MemberVO();
            vo.setId(ID.getText());
            vo.setPw(PW.getText().trim());
            vo.setName(NAME.getText());
            vo.setTel(TEL.getText());
            vo.setEmail(EMAIL.getText());
            vo.setCard(CARD.getText());
            vo.setYymm(YYMM.getText());
            vo.setCvc(CVC.getText());
            
            
            
            
            
            String id = vo.getId();
            String pw = vo.getPw();
            String name = vo.getName();
            String tel = vo.getTel();
            String email = vo.getEmail();
            String card = vo.getCard();
            String yy = vo.getYymm();
            String cvc = vo.getCvc();
            String idPattern = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
            String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z]).{8,20}$";
            String namePattern = "^[a-zA-Zㄱ-힣]*$";
            String telPattern = "^[0-9]+$";
            String emailPattern ="^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
            String yyPattern = "^[0-9]+$";
            String cvcPattern = "^[0-9]+$";




            
            Matcher matcher = Pattern.compile(idPattern).matcher(id);
            Matcher matcher1 = Pattern.compile(pwPattern).matcher(pw);
            Matcher matcher2 = Pattern.compile(namePattern).matcher(name);
            Matcher matcher3 = Pattern.compile(telPattern).matcher(tel);
            Matcher matcher4 = Pattern.compile(telPattern).matcher(card);
            Matcher matcher5 = Pattern.compile(emailPattern).matcher(email);
            Matcher matcher6 = Pattern.compile(yyPattern).matcher(yy);
            Matcher matcher7 = Pattern.compile(cvcPattern).matcher(cvc);
             
            idPattern = "(.)\\1\\1\\1";
            Matcher matchera1 = Pattern.compile(idPattern).matcher(id);
            pwPattern = "(.)\\1\\1\\1";
            Matcher matchera2 = Pattern.compile(pwPattern).matcher(pw);
            namePattern = "(.)\\1\\1\\1";
            Matcher matchera3 = Pattern.compile(namePattern).matcher(name);
            
            
//          아이디 
            if(!matcher.matches()){
            	JOptionPane.showMessageDialog(null, "한글 및 특수문자 공백은 입력이 안됩니다.");
            	ID.setText("");
                ID.requestFocus();
            }else if(matchera1.find()){
            	JOptionPane.showMessageDialog(null, "연속적인 아이디는 입력할수 없습니다.");
            	ID.setText("");
                ID.requestFocus();
            	
//      비번      	
            }else if(!matcher1.matches()){
            	JOptionPane.showMessageDialog(null, "비밀번호는 숫자 및 특수문자 포함 영문자 9~12자로 입력해주세요.");
            	PW.setText("");
                PW.requestFocus();
            }else if(matchera2.find()){
            	JOptionPane.showMessageDialog(null, "연속적인 비밀번호는 입력할수 없습니다..");
            	PW.setText("");
                PW.requestFocus();
            }else if(pw.contains(id)){
            	JOptionPane.showMessageDialog(null, "비밀번호에는 아이디가 포함될수 없습니다.");
            	PW.setText("");
                PW.requestFocus();
            }else if(pw.contains(" ")){
            	JOptionPane.showMessageDialog(null, "비밀번호에 공백이 들어갈 수 없습니다.");
            	PW.setText("");
                PW.requestFocus();
            
            }else if(!PW.getText().equals(PW2.getText())) {
            	JOptionPane.showMessageDialog(null, "비밀번호가 서로 일치하지 않습니다.");
            	PW.setText("");
            	PW2.setText("");
            	PW.requestFocus();
            
//            이름
            }else if(!matcher2.matches()){
            	JOptionPane.showMessageDialog(null, "올바르지 않은 이름입니다.");
            	NAME.setText("");
                NAME.requestFocus();
            }else if(matchera3.find()){
            	JOptionPane.showMessageDialog(null, "연속적인 단어는 입력할수 없습니다. ");
            	NAME.setText("");
                NAME.requestFocus();
            
            }else if(name.contains(" ")){
            	JOptionPane.showMessageDialog(null, "이름에 공백이 들어갈 수 없습니다.");
            	NAME.setText("");
                NAME.requestFocus();
            } else if (vo.getName().length() == 0) {
                JOptionPane.showMessageDialog(null, "이름을 입력해주세요");
                NAME.requestFocus();
            	
//            전화번호
            
            }else if(!matcher3.matches()){
            	JOptionPane.showMessageDialog(null, "올바르지 않은 전화번호입니다.");
            	 TEL.setText("");
                 TEL.requestFocus();
                 
            }else if(!TEL.getText().contains("010")) {
            	JOptionPane.showMessageDialog(null, "올바르지 않은 전화번호입니다.");
            	TEL.setText("");
            	TEL.requestFocus();
            
            }else if(tel.contains(" ")){
            	JOptionPane.showMessageDialog(null, "전화번호에 공백이 들어갈 수 없습니다.");
            	 TEL.setText("");
                 TEL.requestFocus();
            	
//           이메일
            }else if(!matcher5.matches()){
            	JOptionPane.showMessageDialog(null, "올바르지 않은 이메일입니다.");
            	 EMAIL.setText("");
                 EMAIL.requestFocus();
                        
            
            }else if(email.contains(" ")){
            	JOptionPane.showMessageDialog(null, "이메일에 공백이 들어갈 수 없습니다.");
            	 EMAIL.setText("");
                 EMAIL.requestFocus();
            	
            	
//        카드
            }else if(!matcher4.matches()){
            	JOptionPane.showMessageDialog(null, "올바르지 않은 카드번호입니다.");
            	 CARD.setText("");
                 CARD.requestFocus();
            
            }else if(card.contains(" ")){
            	JOptionPane.showMessageDialog(null, "카드번호에 공백이 들어갈 수 없습니다.");
            	 CARD.setText("");
                 CARD.requestFocus();
            	
            	
//            	yymm
            }else if(!matcher6.matches()){
            	JOptionPane.showMessageDialog(null, "올바르지 않은 연도입니다.");
            	YYMM.setText("");
                YYMM.requestFocus();
                        
            
            }else if(tel.contains(" ")){
            	JOptionPane.showMessageDialog(null, "연도에 공백이 들어갈 수 없습니다.");
            	YYMM.setText("");
                YYMM.requestFocus();
            	
            	
//            	cvc

            }else if(!matcher7.matches()){
            	JOptionPane.showMessageDialog(null, "올바르지 않은 cvc번호입니다.");
            	CVC.setText("");
                CVC.requestFocus();
                        
            
            }else if(tel.contains(" ")){
            	JOptionPane.showMessageDialog(null, "cvc번호에 공백이 들어갈 수 없습니다.");
            	CVC.setText("");
                CVC.requestFocus();

           
                
            } else if (vo.getTel().length() == 0) {
               JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요");
               TEL.requestFocus();
            } else if (vo.getCard().length()==0) {
               JOptionPane.showMessageDialog(null, "카드를 입력해주세요");
               CARD.requestFocus();
            } else if(vo.getYymm().length() == 0) {
            	JOptionPane.showMessageDialog(null, "YYMM을 입력해주세요");
            }else if(vo.getCvc().length() == 0) {
            	JOptionPane.showMessageDialog(null, "CVC을 입력해주세요");
            	

            
                  }else if(!(11 == vo.getTel().length())) {
                      JOptionPane.showMessageDialog(null, "전화번호 입력이 올바르지 않습니다");
                      TEL.setText("");
                      TEL.requestFocus();
                  
                  }else if(!(16 == vo.getCard().length())) {
                      JOptionPane.showMessageDialog(null, "카드번호 입력이 올바르지 않습니다");
                      CARD.setText("");
                      CARD.requestFocus();
                  }else if(!(4 == vo.getYymm().length())) {
                      JOptionPane.showMessageDialog(null, "YYMM 입력이 올바르지 않습니다");
                      YYMM.setText("");
                      YYMM.requestFocus();
                  }else if(!(3 == vo.getCvc().length())) {
                      JOptionPane.showMessageDialog(null, "CVC 입력이 올바르지 않습니다");
                      CVC.setText("");
                      CVC.requestFocus();    
                  } else {
                     boolean f = MemberDAO.insert(vo);
                     if (f) {
                        JOptionPane.showMessageDialog(null, "회원가입 성공");
                        setVisible(false);
                     } else {
                        JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
                        ID.setText("");
                        ID.requestFocus();
                     
                  }
            }

         }
      });

      back.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {

            JOptionPane.showMessageDialog(null, "회원가입 실패");
            new Login();
            setVisible(false);

         }
      });

      setVisible(true);

   }

}