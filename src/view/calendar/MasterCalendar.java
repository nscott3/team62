package view.calendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class MasterCalendar extends JFrame implements ActionListener, WindowListener {
    JPanel bar = new JPanel();
    JButton lastMonth = new JButton("Prev");
    JComboBox<Integer> yearCombo = new JComboBox<>();
    DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<>();
    JLabel yLbl = new JLabel("year ");
    JComboBox<Integer> monthCombo = new JComboBox<>();
    DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<>();
    JLabel mLbl = new JLabel("month");
    JButton nextMonth = new JButton("Next");
    JPanel center = new JPanel(new BorderLayout());
    JPanel cntNorth = new JPanel(new GridLayout(0, 7));
    JPanel cntCenter = new JPanel(new GridLayout(0, 7));
    String dw[] = {"Sun", "Mon", "Thu", "Wed", "Thr", "Fri", "Sar"};
    Calendar now = Calendar.getInstance();

    int year, month, date;

    public MasterCalendar() {
        year = now.get(Calendar.YEAR);
        month = now.get(Calendar.MONTH) + 1;
        date = now.get(Calendar.DATE);
        for (int i = year; i <= year + 50; i++) {
            yearModel.addElement(i);
        }
        for (int i = 1; i <= 12; i++) {
            monthModel.addElement(i);
        }

        add("North", bar);
        bar.setLayout(new FlowLayout());
        bar.setSize(300, 400);
        bar.add(lastMonth);
        bar.add(yearCombo);
        yearCombo.setModel(yearModel);
        yearCombo.setSelectedItem(year);
        bar.add(yLbl);
        bar.add(monthCombo);
        monthCombo.setModel(monthModel);
        monthCombo.setSelectedItem(month);
        bar.add(mLbl);
        bar.add(nextMonth);
        bar.setBackground(new Color(0, 210, 180));
        add("Center", center);
        center.add("North", cntNorth);
        for (int i = 0; i < dw.length; i++) {
            JLabel dayOfWeek = new JLabel(dw[i], JLabel.CENTER);
            if (i == 0) dayOfWeek.setForeground(Color.red);
            else if (i == 6) dayOfWeek.setForeground(Color.blue);
            cntNorth.add(dayOfWeek);
        }
        center.add("Center", cntCenter);
        dayPrint(year, month);
        yearCombo.addActionListener(this);
        monthCombo.addActionListener(this);
        lastMonth.addActionListener(this);
        nextMonth.addActionListener(this);
        addWindowListener(this);

        setSize(400, 300);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    // 이벤트 처리
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JButton) {
            JButton eventBtn = (JButton) obj;
            int yy = (Integer) yearCombo.getSelectedItem();
            int mm = (Integer) monthCombo.getSelectedItem();
            if (eventBtn.equals(lastMonth)) {
                //전달
                if (mm == 1 && yy == year) {
                } else if (mm == 1) {
                    yy--;
                    mm = 12;
                } else {
                    mm--;
                }
            } else if (eventBtn.equals(nextMonth)) {
                // 다음달
                if (mm == 12) {
                    yy++;
                    mm = 1;
                } else {
                    mm++;
                }
            }
            yearCombo.setSelectedItem(yy);
            monthCombo.setSelectedItem(mm);
        } else if (obj instanceof JComboBox) {
            // 콤보박스 이벤트 발생시
            createDayStart();
        }
    }

    private void createDayStart() {
        cntCenter.setVisible(false);
        //패널 숨기기
        cntCenter.removeAll();
        // 날짜 출력한 라벨 지우기
        dayPrint((Integer) yearCombo.getSelectedItem(), (Integer) monthCombo.getSelectedItem());
        cntCenter.setVisible(true);
        // 패널 재출력
    }

    // 날짜 출력
    public void dayPrint(int y, int m) {
        Calendar cal = Calendar.getInstance();
        cal.set(y, m - 1, 1);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        // 1일에 대한 요일
        int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        // 1월에 대한 마지막 요일
        for (int i = 1; i < week; i++) {
            // 1월 1일 전까지 공백을 표시해라
            cntCenter.add(new JLabel(""));
        }
        for (int i = 0; i <= lastDate - 1; i++) {
            // 1월 마지막 날까지 숫자를 적어라, 그리고 토요일 일요일은 색깔을 입혀라
            JLabel day = new JLabel();
            day.setHorizontalAlignment(JLabel.CENTER);
            if ((week + i) % 7 == 0) {
                cntCenter.add(day).setForeground(Color.blue);
                day.setText(1 + i + "");
            } else if ((week + i) % 7 == 1) {
                cntCenter.add(day).setForeground(Color.red);
                day.setText(1 + i + "");
            } else {
                cntCenter.add(day);
                day.setText(1 + i + "");
            }
            day.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent me) {
                    JLabel mouseClick = (JLabel) me.getSource();
                    String str = mouseClick.getText();
                    String y = "" + yearCombo.getSelectedItem();
                    String m = "" + monthCombo.getSelectedItem();
                    // 받은 "요일"이 1자리면 0을 붙여라
                    if (str.equals("")) ;
                    else if (str.length() == 1) str = "0" + str;
                    // 받은 "월"이 1자리면 0을 붙여라
                    if (m.length() == 1) m = "0" + m;
//                    if (customReservation.clickCheck == 0) {
//                        CustomReservation.startDateField.setText(y + "/" + m + "/" + str);
//                        CustomReservation.startDateField.setEnabled(false);
//                        customReservation.clickCheck++;
//                    } else if (customReservation.clickCheck == 1) {
//                        CustomReservation.arriveDateField.setText(y + "/" + m + "/" + str);
//                        CustomReservation.arriveDateField.setEnabled(false);
//                        customReservation.clickCheck--;
//                    }
                }
            });
        }
    }

    public void windowOpened(WindowEvent e) {
//        customReservation.calendarWindowTest = 1;
    }

    public void windowClosing(WindowEvent e) {
//        customReservation.calendarWindowTest = 0;
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }
}
