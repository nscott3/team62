package view.calendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;

public class MonthCalendar extends JPanel {
    JPanel bar = new JPanel();
    JLabel yearLabel = new JLabel();
    JLabel monthLabel = new JLabel();

    JPanel center = new JPanel(new BorderLayout());
    JPanel cntNorth = new JPanel(new GridLayout(0, 7));
    JPanel cntCenter = new JPanel(new GridLayout(0, 7));
    String[] dayOfWeeks = {"Sun", "Mon", "Thu", "Wed", "Thr", "Fri", "Sat"};
    Calendar now = Calendar.getInstance();

    MonthListener listener;
    BookingDateManager bookingDateManager;

    int year, month, date;
    private ArrayList<JLabel> dayList = new ArrayList<>();

    public MonthCalendar(BookingDateManager bookingDateManager) {
        this.bookingDateManager = bookingDateManager;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        year = now.get(Calendar.YEAR);
        month = now.get(Calendar.MONTH) + 1;
        date = now.get(Calendar.DATE);

        add("North", bar);
        bar.setLayout(new FlowLayout());
        bar.setSize(300, 400);
        bar.setBackground(new Color(0, 210, 180));

        yearLabel.setText(year + " ");
        bar.add(yearLabel);

        monthLabel.setText(String.valueOf(month));
        bar.add(monthLabel);

        add("Center", center);
        center.add("North", cntNorth);

        for (int i = 0; i < dayOfWeeks.length; i++) {
            JLabel dayOfWeek = new JLabel(this.dayOfWeeks[i], JLabel.CENTER);
            if (i == 0) dayOfWeek.setForeground(Color.red);
            else if (i == 6) dayOfWeek.setForeground(Color.blue);
            cntNorth.add(dayOfWeek);
        }

        center.add("Center", cntCenter);

        dayPrint(year, month);

        setSize(400, 300);
        setVisible(true);
    }

    public void setOnDayClickListener(MonthListener listener) {
        this.listener = listener;
    }

    public void setDate(int year, int month) {
        this.year = year;
        this.month = month;

        yearLabel.setText(year + " ");
        monthLabel.setText(String.valueOf(month));

        //hide panel
        cntCenter.setVisible(false);
        // delete output date label
        cntCenter.removeAll();

        dayPrint(year, month);
        //show panel 
        cntCenter.setVisible(true);
    }

    public void updateDayColor() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);

        for (int i = 0; i < dayList.size(); i++) {
            JLabel dayLabel = dayList.get(i);
            int day = Integer.parseInt(dayLabel.getText());
            calendar.set(Calendar.DAY_OF_MONTH, day);

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == 1) { // sun
                if (bookingDateManager.isBeforeStartDay(calendar)) {
                    dayLabel.setForeground(Color.pink);
                } else {
                    dayLabel.setForeground(Color.red);
                }
            } else if (dayOfWeek == 7) { // sat
                if (bookingDateManager.isBeforeStartDay(calendar)) {
                    dayLabel.setForeground(Color.cyan);
                } else {
                    dayLabel.setForeground(Color.blue);
                }
            } else {
                if (bookingDateManager.isBeforeStartDay(calendar)) {
                    dayLabel.setForeground(Color.lightGray);
                } else {
                    dayLabel.setForeground(Color.black);
                }
            }

            if (bookingDateManager.containsPeriod(calendar)) {
                dayLabel.setBackground(Color.lightGray);
            } else {
                dayLabel.setBackground(null);
            }
        }
    }

    // show date
    public void dayPrint(int y, int m) {
        Calendar cal = Calendar.getInstance();

        cal.set(y, m - 1, 1);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        // show which day of week is for day 1 
        int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        // last day of month
        for (int i = 1; i < week; i++) {
            // show a gap before a day 1 
            cntCenter.add(new JLabel(""));
        }

        dayList.clear();

        for (int i = 0; i <= lastDate - 1; i++) {
            // write a last date of a month and color saturday and sunday
            JLabel day = new JLabel();
            day.setOpaque(true);
            dayList.add(day);

            day.setHorizontalAlignment(JLabel.CENTER);
            if ((week + i) % 7 == 0) { // Sat
                cntCenter.add(day).setForeground(Color.blue);
                day.setText(1 + i + "");
            } else if ((week + i) % 7 == 1) { // Sun
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

                    if (!str.isEmpty()) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month - 1);
                        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(str));

                        if (bookingDateManager.chooseAll()) {
                            listener.resetTextField();
                        }

                        bookingDateManager.setDate(calendar);
                        listener.onDayClick();
                    }
                }
            });
        }
    }

    public interface MonthListener {
        void onDayClick();
        void resetTextField();
    }
}
