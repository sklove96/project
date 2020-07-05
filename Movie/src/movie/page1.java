package movie;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import resMovie.Page3;
import resMovie.Page4;

public class page1 extends JFrame{
	
	Page2 f2;
	Font font;
	DAO dao;
	DTO_Member dto;
	Font font;
	
	public page1() {
		
		ImageIcon cgvIcon = new ImageIcon("./images/cgv1.jpg");
		
		JPanel background = new JPanel() {
			
			public void paintComponent(Graphics g)
			
			g.drawImage(cgvIcon.getImage(), 0, 0, null);
			
			setOpaque(false); // 그림 표시 설정, 투명하게
			
			super.paintComponent(g);			
		}		
	};
	
	font = new Font("고딕", Font.BOLD, 20);
	
	JLabel idLabel=new JLabel("ID :");
	idLabel.setFont(font);
	idLabel.setForeground(Color.DARK_GRAY);
	
	JLabel pwLabel=new JLabel("PW :");
	pwLabel.setFont(font);
	pwLabel.setForeground(Color.DARK_GRAY);
	
	JTextField idTextField = new JTextField();
	JPasswordField passwordField= new JPasswordField();
	
	JButton loginButton = new JButton("로그인");
	JButton signInButton = new JButton("회원가입");
	JButton loginThButton = new JButton("비회원 로그인");
	JButton searchPW = new JButton("비밀번호 찾기");
	JButton deleteButton = new JButton("회원 탈퇴");
	
	Container container = getContentPane();
	
	container.add(loginThButton);
	container.add(idLabel);
	container.add(pwLabel);
	container.add(idTextField);
	container.add(loginButton);
	container.add(signInButton);
	container.add(searchPW);
	container.add(deleteButton);
	container.add(background);
	
	idLabel.setBounds(90, 58, 40, 40);
	pwLabel.setBounds(90, 100, 60, 40);
	
	idTextField.setBounds(150, 65, 240, 30);
	passwordField.setBounds(150, 105, 240, 30);
	loginButton.setBounds(407, 65, 115, 70);
	signInButton.setBounds(150, 150, 115, 30);
	searchPW.setBounds(280, 150, 115, 30);
	loginThButton.setBounds(407, 150, 115, 30);
	deleteButton.setBounds(407,180,115,30);
	
	setSize(650, 500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("로그인 화면 ");
	setVisible(true);
	
	
	//로그인
	loginButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			dao = new DAO();
			dto = new DTO_Member();
			
			if(dao.login(idTextField.getText(), passwordField.getText())== 1) {
				JOptionPane.showMessageDialog(null, "로그인 성공");
				new Page5();
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "다시 입력해주세요");					
		}
	}
});
	
	// 회원가입
	signInButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f2 = new Page2();
		}		
	});;
	
	// 비회원로그인
	loginThButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "비회원 로그인에 성공하셨습니다");
			new Page5();
			dispose();
		}
	});
	
	// 비밀번호 찾기
	searchPW.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new Page3();
		}		
	});
	
	// 회원 삭제(추가)
	deleteButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new Page4();
			}
		});
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
