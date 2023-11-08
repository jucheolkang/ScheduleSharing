package com.project.schedulesharing.base;


import com.project.schedulesharing.exception.BusinessExceptionHandler;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.project.schedulesharing.exception.ErrorCode.INVALID_TYPE_VALUE;

@Component
public class DateParser {

    private static SimpleDateFormat formatting = new SimpleDateFormat("yyyy-MM-dd");

    public String getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String[] daysOfWeek = {"", "일", "월", "화", "수", "목", "금", "토"};
        return daysOfWeek[dayOfWeek];
    }


    /**
     * 해당 날짜를 요일에 해당하는 정수로 반환 일요일 : 1, 월요일 : 2, ... , 토요일 : 7
     *
     * @param date
     * @return Integer
     */
    public Integer getDayOfWeekInt(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public Date getDate(int year, int month, int date) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, date, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return new Date(cal.getTimeInMillis());
    }

    public Date parseDate(String date) {
        try {
            return formatting.parse(date);
        } catch (ParseException e) {
            throw new BusinessExceptionHandler(INVALID_TYPE_VALUE);
        }
    }

    public String toString(Date date) {
        return formatting.format(date);
    }

    public Date getDateXDaysAgo(Date date, int days) {
        long timeInMillis = date.getTime();
        long daysInMillis = days * 24 * 60 * 60 * 1000L;
        long targetTimeInMillis = timeInMillis - daysInMillis;
        return new Date(targetTimeInMillis);
    }

    public Date getDateXDaysLater(Date date, int days) {
        long timeInMillis = date.getTime();
        long daysInMillis = days * 24 * 60 * 60 * 1000L;
        long targetTimeInMillis = timeInMillis + daysInMillis;
        return new Date(targetTimeInMillis);
    }
}
