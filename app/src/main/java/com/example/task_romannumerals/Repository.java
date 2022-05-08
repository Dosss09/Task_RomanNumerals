package com.example.task_romannumerals;

import android.widget.EditText;

public class Repository {
    private static int number;

    // Метод конверирования значения из римской системы счисления в арабскую
    public static int getConvert(EditText romanNumbers, int[] numbers)
    {
        // Возвращаемая переменная
        int tmp = 0;
        // Переменные для подсчета вхождений римских значений V, L, D
        int countV = 0;
        int countL = 0;
        int countD = 0;

        // Цикл по подсчету вхождений значений V, L, D
        for (int i = 0; i < romanNumbers.length(); i++) {
            if (String.valueOf(romanNumbers.getText().charAt(i)).equals("V")) {
                countV++;
            } else if (String.valueOf(romanNumbers.getText().charAt(i)).equals("L")) {
                countL++;
            }else if (String.valueOf(romanNumbers.getText().charAt(i)).equals("D")) {
                countD++;
            }
        }

        // Условие, при котором (в случае превышения количества вхождения значений V, L, D значения в 1), происходит присваивание 0
        // или конвертирование в арабское значение
        if (countV > 1) {
            tmp = 0;
        } else if (countL > 1) {
            tmp = 0;
        } else if (countD > 1) {
            tmp = 0;
        } else {

            // Заполнение массива данными
            for (int i = 0; i < romanNumbers.length(); i++) {
                // Получение символа по индексу нахождения в строке
                String symbol = String.valueOf(romanNumbers.getText().charAt(i));
                // Конвертирование символа в число при помощи метода rNumerals
                number = Conformity.rNumerals(symbol);
                // Заполнение массива числами
                numbers[i] = number;
            }

            // Проверка массива на наличие повторяющихся цифр
            for (int i = 0; i < romanNumbers.length(); i++) {
                if (String.valueOf(romanNumbers.getText().charAt(i)).equals("I")
                        && (numbers[i] == numbers[i + 1] && numbers[i] == numbers[i + 2] && numbers[i] == numbers[i + 3]))
                {
                    Conformity.getClearArray(romanNumbers, numbers);
                    System.out.println("Число I повторяется более 3 раз");
                } else if (String.valueOf(romanNumbers.getText().charAt(i)).equals("X")
                        && (numbers[i] == numbers[i + 1] && numbers[i] == numbers[i + 2] && numbers[i] == numbers[i + 3]))
                {
                    Conformity.getClearArray(romanNumbers, numbers);
                    System.out.println("Число X повторяется более 3 раз");
                } else if (String.valueOf(romanNumbers.getText().charAt(i)).equals("C")
                        && (numbers[i] == numbers[i + 1] && numbers[i] == numbers[i + 2] && numbers[i] == numbers[i + 3]))
                {
                    Conformity.getClearArray(romanNumbers, numbers);
                    System.out.println("Число X повторяется более 3 раз");
                }  else if (String.valueOf(romanNumbers.getText().charAt(i)).equals("M")
                        && (numbers[i] == numbers[i + 1] && numbers[i] == numbers[i + 2] && numbers[i] == numbers[i + 3]))
                {
                    Conformity.getClearArray(romanNumbers, numbers);
                    System.out.println("Число X повторяется более 3 раз");
                }
            }

            // Проверка возрастания значений в массиве для исключения нахождения числа
            // введенного не корректно
            int count = 0;
            for (int i = 0; i < romanNumbers.length(); i++) {
                if (romanNumbers.length() > 2 && numbers[i] < numbers[i + 1]
                    || romanNumbers.length() > 2 && numbers[i] == numbers[i + 1] && numbers[i + 1] < numbers[i + 2]
                        || romanNumbers.length() > 2 && numbers[i] == numbers[i + 1] && numbers[i + 1] == numbers[i + 2] && numbers[i + 2] < numbers[i + 3]) {
                    count++;
                }
            }

            // Временная переменная для хранения длинны введенного значения
            int tmpNum = romanNumbers.length();
            // Нахождение требуемоего числа
            for (int i = 0; i < romanNumbers.length(); i++) {
                System.out.println("count = " + count);
                System.out.println("tmpNum = " + (tmpNum - 1));

                if (count == (tmpNum - 1)) {
                    tmp = 0;
                    break;
                }

                // Если предыдущее число меньше текущего происходит вычитание из текущего числа
                // предыдущего увеличенного в 2 раза (это необходимо для того, чтобы обнулить действие предыдущей итерации)
                if (i > 0 && numbers[i - 1] < numbers[i]) {
                    tmp += (numbers[i] - numbers[i - 1] * 2);
                    System.out.println("tmp1 = " + tmp);
                }
                // Получение требуемого значения
                else {
                    tmp += numbers[i];
                    System.out.println("tmp2 = " + tmp);
                }
            }
        }

        return tmp;
    }
}
