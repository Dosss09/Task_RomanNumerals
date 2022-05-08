package com.example.task_romannumerals;

import android.widget.EditText;

public class MainActivityPresenter implements MainActivityContract.Presenter {
    private MainActivityContract.View view;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void getConvert(EditText text, int[] mass) {
        // Проверка строки на соответствие условию задачи
        if (text.length() < 1 || text.length() > 15) {
            view.onError("Введенные значения противоречат условию задачи!");
        } else {
            // Вызов статического метода для конвертирования значения
            int returnedNumber = Repository.getConvert(text, mass);

            // Вывод результата на View
            if (returnedNumber > 0) {
                view.onSuccess(returnedNumber);
            } else {
                view.onError("Ошибка конвертации!");
            }
        }
    }
}
