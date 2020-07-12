//날짜 선택

package movie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class Page5 JFrame implements ActionListener{

	private Calendar today;
	private Font font;
	
	private String [] days = {"SUNDAY","MONDAY","TUESDAY","WEDNESDAY", "THURSDAY","FRIDAY","SATURDAY"};
    private JButton[] calBtn = new JButton[49];
    
    private JLabel title;
    private JTextField tfYear, tfMonth;
    
    private JPanel plNorth, plCenter;
    
    private int nYear, nMonth, nDate=0;
    
    public Page5() {
    	
    	today = Calendar.getInstance();
    	showCalendarFrame();   	
    }
    
    public void showCalendarFrame() {
    	
    	title= new JLabel("날짜를 선택하세요", SwingConstants.CENTER);
    	nYear = today.get(Calendar.YEAR);
    	nMonth = today.get(Calendar.MONTH)+1; //1월인 경우 0으로 반환되기 때문에
    	
    	font = new Font("Sherif", Font.BOLD, 15);
    	tfYear = new JTextField(nYear+ "년", 5);
    	tfMonth = new JTextField(nMonth + "월", 3);
    	
    	JPanel ymNorth = new JPanel();
    	
    	ymNorth.add(tfYear);
    	tfYear.setFont(font);
    	tfYear.setEnabled(false); //선택 비활성화하여 숫자 수정 불가능하게끔
    	
    	ymNorth.add(tfMonth);
    	tfMonth.setFont(font);
    	tfMonth.setEnabled(false);
    	
    	plNorth = new JPanel(new GridLayout(2,1));
    	plNorth.add(title);
    	plNorth.add(ymNorth);
    	
    	plNorth.setBackground(Color.WHITE);
    	ymNorth.setBackground(Color.WHITE);
    	
    	plCenter = new JPanel(new GridLayout(7,7));
    	font = new Font("바탕체", Font.BOLD,12);
    	plCenter.setBackground(Color.WHITE);
    	
    	gridInit();
    	calSet();
    	hideInit();
    	
    	Container container = getContentPane();
    	container.add(plNorth, BorderLayout.NORTH);
    	container.add(plCenter, BorderLayout.CENTER);
    	
    	setSize(800, 500);
    	setLocation(300, 300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    
    public void actionPerfomed(ActionEvent e) {
    	
    	plCenter.setBackground(Color.white);
    	for(int i = 0; i < days.length; i++) {
    		
    		plCenter.add(calBtn[i] = new JButton(days[i]));
    		
    	}for(int i = days.length; i <49; i++) {
    		
    		plCenter.add(calBtn[i] = new JButton(" "));
    		calBtn[i].addActionListener(this);
    	}
    }
    
    // 달력 세팅
    
    public void calSet() {
    	
    	nYear = today.get(Calendar.YEAR);
    	nMonth = today.get(Calendar.MONTH)+1;
    	nDate = today.get(Calendar.DATE);
    	int dayOfWeek = today.get(Calendar.DAY_OF_WEEK)-1;
    	
    	today.set(Calendar.YEAR, nYear);
    	today.set(Calendar.MONTH, (nMonth-1));
    	today.set(Calendar.DATE, 1);
    	
    	calBtn[0].setForeground(new Color(255,0,0));
    	calBtn[6].setForeground(new Color(0,0,255));
    	
    	int cntday=0;
    	int cntweek=0;
    	
    	for(int a = today.getFirstDayOfWeek(); a<dayOfWeek; a++) {
    		cntday++;
    	}
    	    cntweek=cntday;
    	    
    	    for(int b = 0; b < cntweek; b++) {
    	    	cntBtn[b+7].setText(" ");
    	    }
    	    
    	    for(int c=today.getMinimum(Calendar.DAY_OF_WEEK);
    	    		
    	    		c < today.getMaximum(Calendar.DAY_OF_MONTH);
    	    		c++    	    		
    	    	)
    	    { if((c != 1) && (c <nDate+5)) {
    	    	
    	    	calBtn[c+6+cntweek].setForeground(new Color(0,0,0));
    	    	
    	    	if((c+cntweek-1)%7 == 0) {
    	    		calBtn[c+6+cntweek].setForeground(new Color(255, 0,0)); //일요일
    	    	}
    	    	if((c+cntweek)%7 == 0) {
    	    		calBtn[c+6+cntweek].setForeground(new Color(0,0,255)); //토요일
    	    	}
    	    } else {
    	    	calBtn[c+6+cntweek].setForeground(new Color(211, 211, 211));
    	    }
    	    
    	    calBtn[c+6+cntweek].setText((c)+" ");
    	 }
    }
    
    public void hideInit() {
    	for(int i = 0; i < calBtn.length; i++) {
    		if((calBtn[i].getText()).equals(" ")) {//날짜 찍히지 않는 곳 비활성화
    			calBtn[i].setEnabled(false);
    			
    		}
    		calBtn[i].setBackground(Color.white); //버튼 색상
    		calBtn[i].setBorderPainted(false); //버튼 테두리 없애기
    	}
    }
}    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
