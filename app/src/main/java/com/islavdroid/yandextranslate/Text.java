package com.islavdroid.yandextranslate;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by islav on 18.11.2016.
 */

public class Text {
    @SerializedName("text")
  /*  private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }*/

    private ArrayList<String> text;

    public ArrayList<String> getText() {
        return text;
    }

    public void setText(ArrayList<String> text) {
        this.text = text;
    }
}
