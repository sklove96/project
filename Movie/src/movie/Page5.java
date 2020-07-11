//날짜 선택

package movie;

import java.awt.Font;
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
    	
    	
    	
    }
    
    
    
    
    
