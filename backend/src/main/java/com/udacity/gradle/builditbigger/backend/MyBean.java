package com.udacity.gradle.builditbigger.backend;

import com.doiliomatsinhe.lib.Joker;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private String myData;

    public String getData() {
        myData = new Joker().getJoke();
        return myData;
    }

    /**
     * Remove this later as it will not be needed
     * @param data
     */
    public void setData(String data) {
        myData = data;
    }
}