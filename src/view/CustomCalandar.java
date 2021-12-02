package view;

import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class CustomCalandar extends JFrame implements ActionListener, WindowListener{
	// ��� ����
	JPanel bar = new JPanel(); JButton lastMonth = new JButton("��");
	JComboBox<Integer> yearCombo = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();
	JLabel yLbl = new JLabel("�� ");
	JComboBox<Integer> monthCombo = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();
	JLabel mLbl = new JLabel("��");
	JButton nextMonth = new JButton("��");
	// �߾� ����
	JPanel center = new JPanel(new BorderLayout());
	// �߾� ��� ���� 
	JPanel cntNorth = new JPanel(new GridLayout(0,7));
	// �߾� �߾� ����
	JPanel cntCenter = new JPanel(new GridLayout(0,7));
	// ���� �Է�
	String dw[] = {"��","��","ȭ","��","��","��","��"};
	Calendar now = Calendar.getInstance();
	int year, month, date;
	public CustomCalendar() { 
		year = now.get(Calendar.YEAR);
		// 2021�� 
		month = now.get(Calendar.MONTH)+1; 
		// 0�� == 1�� 
		date = now.get(Calendar.DATE); 
		for(int i=year; i<=year+50; i++)
		{
			yearModel.addElement(i);
			} for(int i=1; i<=12; i++) {
				monthModel.addElement(i); 
				}
			//////////////////////////������/////////////////////////////////////////// 
			// ��� ����
			add("North", bar);
			bar.setLayout(new FlowLayout());
			bar.setSize(300,400);
			bar.add(lastMonth);
			//////////////////////////�޷�/////////////////////////////////////////////
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
			// �߾� ����
			add("Center", center);
			// �߾� ��� ����
			center.add("North",cntNorth);
			for(int i=0; i<dw.length; i++) {
				JLabel dayOfWeek = new JLabel(dw[i],JLabel.CENTER);
				if(i==0) dayOfWeek.setForeground(Color.red);
				else if(i==6) dayOfWeek.setForeground(Color.blue);
				cntNorth.add(dayOfWeek); }
			// �߾� �߾� ���� 
			center.add("Center",cntCenter);
			dayPrint(year,month);
			// �̺�Ʈ
			yearCombo.addActionListener(this);
			monthCombo.addActionListener(this);
			lastMonth.addActionListener(this);
			nextMonth.addActionListener(this);
			addWindowListener(this);
			// frame �⺻ ����
			setSize(400,300);
			setVisible(true);
			setResizable(false);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
}

