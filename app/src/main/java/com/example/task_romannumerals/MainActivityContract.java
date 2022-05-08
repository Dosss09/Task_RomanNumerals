package com.example.task_romannumerals;

import android.widget.EditText;

public interface MainActivityContract {
    interface View {
        void onSuccess(int numbers);
        void onError(String message);
    }

    interface Presenter {
        void getConvert(EditText text, int[] mass);
    }
}
