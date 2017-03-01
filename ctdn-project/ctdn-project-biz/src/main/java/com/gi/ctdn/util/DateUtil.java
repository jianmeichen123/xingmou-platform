package com.gi.ctdn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by zcy on 17-2-24.
 */
public class DateUtil {

    private static final String dateFormat = "yyyy-MM-dd";
    public static final TimeZone GTM8TimeZone = TimeZone.getTimeZone("GMT+8");

    public static Long getNow(){
        return new Date().getTime();
    }

    public static Date convertStringToDate(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setTimeZone(GTM8TimeZone);
        return sdf.parse(time);
    }

    public  static  void main(String args[]){
        try {
            System.out.println(convertStringToDate("2017-02-28"));
            System.out.print(new Date());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
