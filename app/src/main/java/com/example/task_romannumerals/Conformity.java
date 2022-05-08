package com.example.task_romannumerals;

import android.widget.EditText;

public class Conformity {
    // Метод сравнения римских значений с арабскими значениями
    public static int rNumerals(String numerals) {
        // Возвращаемая переменная
        int numbers = 0;

        // Проверка переменной на наличие значения
        if (numerals == null) {
            return numbers;
        }

        // Сравнение и поиск требуемого значения
        switch (numerals)
        {
            case "I":
                numbers = 1;
                break;
            case "V":
                numbers = 5;
                break;
            case "X":
                numbers = 10;
                break;
            case "L":
                numbers = 50;
                break;
            case "C":
                numbers = 100;
                break;
            case "D":
                numbers = 500;
                break;
            case "M":
                numbers = 1000;
                break;
            default:
                numbers = -1;
                break;
        }

        return numbers;
    }

    // Метод обнуления данных в заполненного значениями массиве
    public static void getClearArray(EditText romanNumbers, int[] numbers) {
        for (int i = 0; i < romanNumbers.length(); i++) {
            numbers[i] = 0;
        }
    }
}
