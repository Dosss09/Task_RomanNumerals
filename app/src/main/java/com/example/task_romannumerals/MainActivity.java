package com.example.task_romannumerals;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {
    // Создание экземпляров класса MainActivity
    private MainActivityContract.Presenter presenter;
    private EditText romanNumbers;
    private Button convertButton, deleteButton;
    private TextView arabianNumbers;
    private static final int SIZE = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Создание объекта класса MainActivityPresenter
        presenter = new MainActivityPresenter(this);

        // Инициализация экземпляров
        romanNumbers = findViewById(R.id.edit_text_number);
        convertButton = findViewById(R.id.convert_btn);
        deleteButton = findViewById(R.id.delete_btn);
        arabianNumbers = findViewById(R.id.text_view_numbers);

        // Создание массива
        int[] numbers = new int[SIZE];

        // Слушатель нажатия на кнопку конвертирования значения
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Отправка запроса в презентер
                presenter.getConvert(romanNumbers, numbers);
            }
        });

        // Слушатель нажатия на кнопку очистки полей на View
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Проверка заполненности массива значениями
                if (numbers[0] > 0) {
                    // В случае наличия значений, производится очистка
                    Conformity.getClearArray(romanNumbers, numbers);
                }

                // Очистка поля ввода значения
                romanNumbers.setText("");
                // Восстановление текста в поле получения значения после конвертации
                arabianNumbers.setText("Полученное, после конвертации, число в арабской системе счисления");
                // Восстановление цвета текста
                arabianNumbers.setTextColor(Color.parseColor("grey"));
            }
        });
    }

    @Override
    public void onSuccess(int numbers) {
        // Присваиваю TextView полученное значение
        arabianNumbers.setText("Число после конвертации = " + String.valueOf(numbers));
        arabianNumbers.setTextColor(Color.parseColor("grey"));
    }

    @Override
    public void onError(String message) {
        arabianNumbers.setText(message);
        arabianNumbers.setTextColor(Color.parseColor("red"));
    }
}