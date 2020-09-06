package com.inventory.utils.commons;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

@Slf4j
public class DateUtils {
    public static Long getTimeInMillisecondsFromLocalDate() {
        LocalDateTime localDate = LocalDateTime.now();
        return Timestamp.valueOf(localDate).getTime();
    }

    public static Long getDifferenceBetweenTwoTime(Long startTime) {
        return getTimeInMillisecondsFromLocalDate() - startTime;
    }

    public static java.sql.Date utilDateToSqlDate(Date uDate) {
        try {
            DateFormat sqlDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            return java.sql.Date.valueOf(sqlDateFormatter.format(uDate));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String utilDateToSqlDateInString(Date uDate) {
        try {
            DateFormat sqlDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            return java.sql.Date.valueOf(sqlDateFormatter.format(uDate)).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static java.sql.Date utilDateToSqlDateTime(Date uDate) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return java.sql.Date.valueOf(formatter.format(uDate));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date addDays(Date oldDate, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oldDate);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static LocalDate convertDateToLocalDate(Date date) {
        return new java.sql.Date(date.getTime()).toLocalDate();
    }

    public static String getDayCodeFromDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("EE");
        return dateFormat.format(date);
    }

    public static boolean isLocalDateBetweenInclusive(LocalDate startDate, LocalDate endDate, LocalDate target) {
        return !target.isBefore(startDate) && !target.isAfter(endDate);
    }

    public static boolean isDateBetweenInclusive(Date startDate, Date endDate, Date target) {
        Date targetDateOnly = removeTime(target);
        Date startDateOnly = removeTime(startDate);
        Date endDateOnly = removeTime(endDate);
        return !targetDateOnly.before(startDateOnly) && !targetDateOnly.after(endDateOnly);
    }



    public static String getTimeIn12HourFormat(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
        return dateFormat.format(date);
    }

    public static String getTimeFromDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return dateFormat.format(date);
    }

    public static String convert12HourTo24HourFormat(String time12) {

        try {
            SimpleDateFormat dateParser = new SimpleDateFormat("h:mm a");
            Date date = dateParser.parse(time12);

            SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm");

            return dateFormatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date datePlusTime(Date date, Date time) {

        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.HOUR, time.getHours());
        cl.add(Calendar.MINUTE, time.getMinutes());

        return cl.getTime();
    }

    public static Date parseTime(String requestedTime) {
        try {
            SimpleDateFormat time = new SimpleDateFormat("HH:mm");
            return time.parse(requestedTime);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isFirstDateGreater(Date dateA, Date dateB) {

        Calendar calA = Calendar.getInstance();
        calA.setTime(dateA);

        Calendar calB = Calendar.getInstance();
        calB.setTime(dateB);

        if (calA.get(YEAR) > calB.get(YEAR)) {
            return true;
        } else if (calA.get(YEAR) == calB.get(YEAR)) {
            if (calA.get(MONTH) > calB.get(MONTH)) {
                return true;
            } else if (calA.get(MONTH) == calB.get(MONTH)) {
                return calA.get(Calendar.DAY_OF_MONTH) > calB.get(Calendar.DAY_OF_MONTH);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static String convert24HourTo12HourFormat(String timeIn24HrFormat) {
        try {
            SimpleDateFormat dateParser = new SimpleDateFormat("HH:mm");
            Date date = dateParser.parse(timeIn24HrFormat);
            SimpleDateFormat dateFormatter = new SimpleDateFormat("h:mm a");
            return dateFormatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date convertLocalDateToDate(LocalDate requestedDate) {
        return Date.from(requestedDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static String getCurrentDateTime() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        return formatter.format(date);

    }

    public static List<Date> getDates(
            Date startDate, Date endDate) {
        List<Date> datesInRange = new ArrayList<>();
        Date today = utilDateToSqlDate(new Date());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(endDate);

        while (!calendar.after(endCalendar)) {
            Date result = calendar.getTime();
            if (utilDateToSqlDate(calendar.getTime()).before(today)) {
                calendar.add(Calendar.DATE, 1);

            } else {
                datesInRange.add(result);
                calendar.add(Calendar.DATE, 1);
            }
        }
        return datesInRange;
    }

    public static List<String> getDayNames(
            Date startDate, Date endDate) {
        List<String> daysName = new ArrayList<>();
        Date today = utilDateToSqlDate(new Date());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(endDate);

        while (!calendar.after(endCalendar)) {
            Date result = calendar.getTime();
            if (utilDateToSqlDate(calendar.getTime()).before(today)) {
                calendar.add(Calendar.DATE, 1);

            } else {
                String day=convertDateToLocalDate(result).getDayOfWeek().toString();
                daysName.add(day);
                calendar.add(Calendar.DATE, 1);
            }
        }
        return daysName;
    }

    public static List<Date> utilDateListToSqlDateList(List<Date> uDates) {
        List<Date> resultDates = new ArrayList<>();
        uDates.forEach(uDate -> {
            try {
                DateFormat sqlDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = java.sql.Date.valueOf(sqlDateFormatter.format(uDate));
                resultDates.add(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return resultDates;

    }
}
