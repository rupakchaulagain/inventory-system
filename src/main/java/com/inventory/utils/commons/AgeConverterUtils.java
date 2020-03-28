package com.inventory.utils.commons;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import static com.inventory.utils.commons.DateUtils.convertDateToLocalDate;

public class AgeConverterUtils {

    public static String calculateAge(Date date) {

        LocalDate today = LocalDate.now();
        LocalDate birthDate = convertDateToLocalDate(date);

        Period period = Period.between(birthDate, today);

        int years = period.getYears();
        int month = period.getMonths();
        int days = period.getDays();

        String age;

        if (years <= 0 && month <= 0) {
            age = days + " days";
        } else if (years <= 0) {
            age = month + " months";
        } else {
            age = years + " years";
        }

        return age;
    }
}
