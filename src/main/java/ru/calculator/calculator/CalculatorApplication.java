package ru.calculator.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.calculator.calculator.validate.ValidateUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import static ru.calculator.calculator.service.Service.holidayPayWithTax;
import static ru.calculator.calculator.service.Service.holidayPay;
import static ru.calculator.calculator.service.Service.numberOfWorkingDay;

@SpringBootApplication
public class CalculatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите дату начала отпуска: dd.MM.yyyy");
            LocalDate startDate = LocalDate.parse(ValidateUtils.validateString(scanner.nextLine()), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            System.out.println("Введите дату конца отпуска: dd.MM.yyyy");
            LocalDate endDate = LocalDate.parse(ValidateUtils.validateString(scanner.nextLine()), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            Integer vacationDays = numberOfWorkingDay(startDate, endDate);
            System.out.println("Введите среднюю зарплату за день за 12 месяцев");
            String averageSalary = ValidateUtils.validateString(scanner.nextLine());
            Double holidayPayWithTax = holidayPayWithTax(Double.parseDouble(averageSalary), vacationDays);
            System.out.println("Сумма отпускных без НДФЛ " + holidayPayWithTax);
            Double holidayPay = holidayPay(Double.parseDouble(averageSalary), vacationDays);
            System.out.println("Сумма отпускных с учётом НДФЛ " + holidayPay);
        } catch (DateTimeParseException e) {
            System.out.println("Введите дату правильно");
        } catch (RuntimeException e) {
            System.out.println("Ошибка ввода");
        }
    }
}


