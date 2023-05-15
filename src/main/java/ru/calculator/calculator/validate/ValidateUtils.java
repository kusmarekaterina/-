package ru.calculator.calculator.validate;

import ru.calculator.calculator.exceptions.IncorrectInputException;

public class ValidateUtils {

    public static String validateString(String value) throws IncorrectInputException {
        if (value == null || value.isEmpty() || value.isBlank()) {
            throw new IncorrectInputException("Ошибка ввода");
        } else {
            return value;
        }
    }

}
