package ru.calculator.calculator.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Service {
    public static Double holidayPayWithTax (double salary, int days) {
        double holidayPayWithTax = salary * days;
        return holidayPayWithTax;
    }

    public static Double holidayPay (double salary, int days) {
        double holidayPayWithTax = holidayPayWithTax (salary, days);
        double tax = holidayPayWithTax * 13 / 100;
        double holidayPay = holidayPayWithTax - tax;
        return holidayPay;
    }

    public static boolean isWorkingDay(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EE");
        String dayOfWeek = date.format(formatter);
        return (!dayOfWeek.startsWith("вс") && !dayOfWeek.startsWith("сб"));
    }

    public static Integer numberOfWorkingDay (LocalDate startDate, LocalDate endDate) {
        int workingDay = 0;
        while (!startDate.equals(endDate)) {
            if (isWorkingDay(startDate)) {
                workingDay++;
            }
            startDate = startDate.plusDays(1);
        }
        return workingDay;
    }
}
