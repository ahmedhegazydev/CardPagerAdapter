package com.example.presschool.models;

import android.view.View;

public class CardItem {
    private View v;

    public CardItem(View v) {
        this.v = v;
    }

    public View getV() {
        return v;
    }

    public void setV(View v) {
        this.v = v;
    }
}