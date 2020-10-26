package com.zhursin.Roman;

import java.util.HashMap;
import java.util.Map;

/**
 * Code to convert to and from Roman numerals.
 */

public class RomanNumerals {
    /**
     * Formats a number in Roman numerals.
     * @param value
     *   The value to format.
     * @return
     *   The value in Roman numerals.
     */
    public static String convertArabicToRoman(int value) {
        String romanNum = "";

        while (value > 0) {
            while (value >= 100) {
                romanNum = romanNum + "C";
                value -= 100;
            }
            while (value >= 90) {
                romanNum = romanNum + "XC";
                value -= 90;
            }
            while (value >= 50) {
                romanNum = romanNum + "L";
                value -= 50;
            }
            while (value >= 40) {
                romanNum = romanNum + "XL";
                value -= 40;
            }
            while (value >= 10) {
                romanNum = romanNum + "X";
                value -= 10;
            }
            while (value >= 9) {
                romanNum = romanNum + "IX";
                value -= 9;
            }
            while (value >= 5) {
                romanNum = romanNum + "V";
                value -= 5;
            }
            while (value >= 4) {
                romanNum = romanNum + "IV";
            }
            while (value >= 1) {
                romanNum = romanNum + "I";
                value -= 1;
            }
        }
        return romanNum;
    }

    /**
     * Parses a number in Roman numerals.
     * @param str
     *   The number to parse.
     * @return
     *   The value, or -1 if the number isn't in Roman numerals.
     */
    public static int convertRomanToArabic(String str) {

        if (str == null || str.length() == 0) {
            return 0;
        }

        Map<Character, Integer> charMap = new HashMap<>();

        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);

        int result = 0;

        for(int i = 0; i < str.length() - 1; i++) {

            if (charMap.get(str.charAt(i)) >= charMap.get(str.charAt(i+1))) {
                result = result + charMap.get(str.charAt(i));
            } else {
                result = result - charMap.get(str.charAt(i));
            }
        }
        result = result + charMap.get(str.charAt(str.length()-1));

        return result;
    }
}
