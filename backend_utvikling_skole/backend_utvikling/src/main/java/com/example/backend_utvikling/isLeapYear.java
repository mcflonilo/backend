package com.example.backend_utvikling;

public class isLeapYear {
    public static boolean isLeapYear(int year){
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
            } else return true;
        }
        return false;

}}
