package com.example.savoa.chatapplication;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by MITAR on 30-Mar-18.
 */

public class Custom {

    private char first_letter;
    private String name;
    private Drawable image;

    public Custom(char first_letter, String name, Drawable image) {
        this.first_letter = first_letter;
        this.name = name;
        this.image = image;
    }

    public char getFirst_letter() {
        return first_letter;
    }

    public void setFirst_letter(char first_letter) {
        this.first_letter = first_letter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
