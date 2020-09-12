package com.qy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 字符串转Util
    public static java.util.Date strToUtilDate(String str) {
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Util转sql
    public static java.sql.Date utilToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    // util转字符串
    public static String toStr(java.util.Date bornDate) {
        return sdf.format(bornDate);
    }
}
