//좌석 선택 페이지
package movie;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Page7 extends JFrame{
	
	Font font;
	JButton[] seat = new JButton[50];
	
	Page7(){
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout(5,10));
		
		font = new Font("고딕", Font.BOLD, 30);
		
		//스크린
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel screen = new JLabel("SCREEN");
		jp1.add(screen);
		screen.setFont(font);
		jp1.setBackground(Color.white);
		
		//좌석
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(3,10,10,10));
		
		for(int i = 0; i <30; i++) {
			seat[i] = new JButton(""+(i+1));
			jp2.add(seat[i]);
		}
		
		jp2.setBackground(Color.white);
		
		JPanel jp3 = new JPanel();
		jp3.setLayout(new GridLayout(3,1,10,10));
		
		
		
		
		
	}

}
