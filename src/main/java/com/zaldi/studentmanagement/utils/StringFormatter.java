package com.zaldi.studentmanagement.utils;

public class StringFormatter {
    public static String dinamicComma(double number) {
        if (number %    1 == 0.0) {
            return  String.format("%.0f", number);
        } else {
            return String.format("%.2f", number);
        }
    }
}
