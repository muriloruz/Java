package com.example.appidade;

import android.text.Editable;
import android.text.TextWatcher;

public class DateTextWatcher implements TextWatcher {

    private boolean isUpdating;
    private String oldText = "";

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {
        String newText = s.toString();


        String unformattedText = newText.replaceAll("[^\\d]", "");


        if (isUpdating) {
            oldText = unformattedText;
            isUpdating = false;
            return;
        }


        StringBuilder formattedText = new StringBuilder();
        int length = unformattedText.length();

        if (length > 0) {
            formattedText.append(unformattedText.substring(0, Math.min(2, length)));
        }
        if (length > 2) {
            formattedText.append("/").append(unformattedText.substring(2, Math.min(4, length)));
        }
        if (length > 4) {
            formattedText.append("/").append(unformattedText.substring(4, Math.min(8, length)));
        }

        isUpdating = true;
        s.replace(0, s.length(), formattedText.toString());
    }
}

