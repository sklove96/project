// 회원가입

package movie;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import resMovie.DAO;
import resMovie.DTO_Member;

public class Page2 extends JFrame{
	
	Font font;
	
	JTextField name;
	JTextField tel;
	JTextField id;
	JTextField pw;
	
	JButton insert;
	JButton cancel;
	JButton overlap;
	
	DAO dao = new DAO();
	DTO_Member dto;
	
	
	Page2(){
		
		font = new Font("고딕", Font.BOLD, 12);
		
		JPanel p= new JPanel();
		Color b= new Color(196, 211, 253);
		p.setBackground(b);
		
		JLabel nameLabel = new JLabel("NAME : ");
		JLabel telLabel = new JLabel("TEL : ");
		JLabel idLabel = new JLabel("ID : ");
		JLabel pwLabel = new JLabel("PW : ");
		
		Container container = getContentPane();
		
		container.add(nameLabel);
		container.add(telLabel);
		container.add(idLabel);
		container.add(pwLabel);
		
		name = new JTextField();
		tel = new JTextField();
		id = new JTextField();
		pw = new JTextField();
		
		container.add(name);
		container.add(tel);
		container.add(id);
		container.add(pw);
		
		insert = new JButton("저장");
		insert.setFont(font);
		
		cancel = new JButton("취소");
		cancel.setFont(font);
		
		overlap = new JButton("중복확인");
		overlap.setFont(font);
		
		container.add(insert);
		container.add(cancel);
		container.add(overlap);
		
		container.add(p);
		
		 nameLabel.setBounds(30, 10, 50, 40);
	     telLabel.setBounds(30, 50, 50, 40);
	     idLabel.setBounds(30, 90, 50, 40);
	     pwLabel.setBounds(30, 130, 50, 40);
	    
	     name.setBounds(100, 10, 200, 30);
	     tel.setBounds(100, 50, 200, 30);
	     id.setBounds(100, 90, 200, 30);
	     pw.setBounds(100, 130, 200, 30);
	      
	     insert.setBounds(220, 170, 80, 30);
	     cancel.setBounds(100, 170, 80, 30); 
	     overlap.setBounds(310, 90, 90, 30);
	     
	     setSize(450,250);
		 setTitle("회원가입");
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setVisible(true);
	     
	     
	     //아이디 중복체크
	     overlap.addActionListener(new ActionListener() {
	     	@Override
	     	public void actionPerformed(ActionEvent e) { 
	     		dao = new DAO();
	 			dto = new DTO_Member();

	 			if(dao.idCheak(id.getText()) == 1) {
	 			JOptionPane.showMessageDialog(null, "아이디가 중복되었습니다.  다시 입력하여주세요.");	 			
	 			}else {
	 			JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
	 		}
	     }
	  });;
	  
	  	   // 취소, main 으로 복귀	  
	  	   cancel.addActionListener(new ActionListener() {
	  		public void actionPerfomed(ActionEvent e) {
			  dispose();		  
	  }
});;

           //회원가입
          insert.addActionListener(new ActionListener() {
        	  
        	  public void actionPerformed(ActionEvent e) {
        		  try {
        			  //null 체크
        			  if((name.getText().equals("") || tel.getText().equals("") 
                    		  || id.getText().equals("") || pw.getText().equals(""))
        	                  {
        	                     JOptionPane.showMessageDialog(null, "저장할 내용을 입력하세요.");		// JOptionPane 팝업창을 보여주는 메소드 입니다.                
        	                  } else {
        							  dto = new DTO_Member(); 
        							  dto.setName(name.getText());
        							  dto.setTel(tel.getText()); 
        							  dto.setId(id.getText());
        							  dto.setPw(pw.getText()); 
        							  dao.insert(dto);
        							  JOptionPane.showMessageDialog(null, "회원가입 되셨습니다.");
        							  dispose();
        	                	      // System.out.println(name1.getText());
        	                		}
        	                     }
        	                catch (Exception e2) {
        	                  e2.printStackTrace();
        	           }
        	     }
          });
	}
}
