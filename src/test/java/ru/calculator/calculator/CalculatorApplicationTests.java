package ru.calculator.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static ru.calculator.calculator.service.Service.*;

@SpringBootTest
class CalculatorApplicationTests {

	@Test
	void contextLoads() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EE");
		String dayOfWeek = date.format(formatter);
		System.out.println(dayOfWeek);
		System.out.println(isWorkingDay(LocalDate.from(date)));
		LocalDate date2 = LocalDate.of (2023,5, 1);

		System.out.println(numberOfWorkingDay (date2, date));
		Integer vacationDays = numberOfWorkingDay (date2, date);


		System.out.println(holidayPay (1023.89, vacationDays));
		System.out.println(holidayPayWithTax (1023.89, vacationDays));
	}

}
