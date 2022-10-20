package com.lyk.ftgson.bean;

import java.io.Serializable;

/**
 * Created by lianyongke on 2018/3/19.
 */

public class ResultBean implements Serializable {

    private String temperature;
    private String weather;
    private String wind;
    private String week;
    private boolean bool;
    private double aDouble;
    private float aFloat;
    private long aLong;
    private int aInt;
    private int date;

    @Override
    public String toString() {
        return "ResultBean{" +
                "\n\ntemperature='" + temperature + '\'' +
                "\n\n, weather='" + weather + '\'' +
                "\n\n, wind='" + wind + '\'' +
                "\n\n, week='" + week + '\'' +
                "\n\n, bool='" + bool + '\'' +
                "\n\n, aDouble='" + aDouble + '\'' +
                "\n\n, aFloat='" + aFloat + '\'' +
                "\n\n, aLong='" + aLong + '\'' +
                "\n\n, aInt='" + aInt + '\'' +
                "\n\n, date=" + date +
                '}';
    }
}
