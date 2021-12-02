package view;

import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class CustomCalandar extends JFrame implements ActionListener, WindowListener{
	// 상단 지역
	JPanel bar = new JPanel(); JButton lastMonth = new JButton("◀");
	JComboBox<Integer> yearCombo = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();
	JLabel yLbl = new JLabel("년 ");
	JComboBox<Integer> monthCombo = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();
	JLabel mLbl = new JLabel("월");
	JButton nextMonth = new JButton("▶");
	// 중앙 지역
	JPanel center = new JPanel(new BorderLayout());
	// 중앙 상단 지역 
	JPanel cntNorth = new JPanel(new GridLayout(0,7));
	// 중앙 중앙 지역
	JPanel cntCenter = new JPanel(new GridLayout(0,7));
	// 요일 입력
	String dw[] = {"일","월","화","수","목","금","토"};
	Calendar now = Calendar.getInstance();
	int year, month, date;
	public CustomCalendar() { 
		year = now.get(Calendar.YEAR);
		// 2021년 
		month = now.get(Calendar.MONTH)+1; 
		// 0월 == 1월 
		date = now.get(Calendar.DATE); 
		for(int i=year; i<=year+50; i++)
		{
			yearModel.addElement(i);
			} for(int i=1; i<=12; i++) {
				monthModel.addElement(i); 
				}
			//////////////////////////프레임/////////////////////////////////////////// 
			// 상단 지역
			add("North", bar);
			bar.setLayout(new FlowLayout());
			bar.setSize(300,400);
			bar.add(lastMonth);
			//////////////////////////달력/////////////////////////////////////////////
			bar.add(yearCombo);
			yearCombo.setModel(yearModel);
			yearCombo.setSelectedItem(year);
			bar.add(yLbl);
			bar.add(monthCombo);
			monthCombo.setModel(monthModel);
			monthCombo.setSelectedItem(month);
			bar.add(mLbl);
			bar.add(nextMonth);
			bar.setBackground(new Color(0,210,180));
			// 중앙 지역
			add("Center", center);
			// 중앙 상단 지역
			center.add("North",cntNorth);
			for(int i=0; i<dw.length; i++) {
				JLabel dayOfWeek = new JLabel(dw[i],JLabel.CENTER);
				if(i==0) dayOfWeek.setForeground(Color.red);
				else if(i==6) dayOfWeek.setForeground(Color.blue);
				cntNorth.add(dayOfWeek); }
			// 중앙 중앙 지역 
			center.add("Center",cntCenter);
			dayPrint(year,month);
			// 이벤트
			yearCombo.addActionListener(this);
			monthCombo.addActionListener(this);
			lastMonth.addActionListener(this);
			nextMonth.addActionListener(this);
			addWindowListener(this);
			// frame 기본 셋팅
			setSize(400,300);
			setVisible(true);
			setResizable(false);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
}

