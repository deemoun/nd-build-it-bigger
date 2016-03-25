package com.dyarygin.builditbigger.backend;

import com.dmitry.JokeTeller;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        JokeTeller jokeTeller = new JokeTeller();
        return jokeTeller.tellJokes();
    }

    public void setData(String data) {
        myData = data;
    }
}