package view.calendar;

import java.time.LocalDate;
import java.util.Calendar;

public class BookingDateManager {
    private Calendar startDay;
    private Calendar endDay;

    public Calendar getStartDay() {
        return startDay;
    }

    public Calendar getEndDay() {
        return endDay;
    }

    public boolean isStartDaySelected() {
        return startDay != null;
    }

    public boolean isEndDaySelected() {
        return endDay != null;
    }

    void clear() {
        startDay = null;
        endDay = null;
    }

    public boolean chooseAll() {
        return isStartDaySelected() && isEndDaySelected();
    }

    public void setDate(Calendar calendar) {
        if (isStartDaySelected()) {
            if (isEndDaySelected()) {
                clear();
                startDay = calendar;
            } else {
                if (!startDay.after(calendar)) {
                    endDay = calendar;
                }
            }
        } else {
            startDay = calendar;
        }
    }

    public boolean isBeforeStartDay(Calendar calendar) {
        if (startDay == null) {
            return false;
        }
        return startDay.after(calendar);
    }

    public boolean containsPeriod(Calendar calendar) {
        if (startDay == null) return false;

        LocalDate target = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        LocalDate startDate = LocalDate.of(startDay.get(Calendar.YEAR), startDay.get(Calendar.MONTH) + 1, startDay.get(Calendar.DAY_OF_MONTH));

        if (endDay == null) return startDate.equals(target);

        LocalDate endDate = LocalDate.of(endDay.get(Calendar.YEAR), endDay.get(Calendar.MONTH) + 1, endDay.get(Calendar.DAY_OF_MONTH));

        return !target.isBefore(startDate) && !target.isAfter(endDate);
    }
}
