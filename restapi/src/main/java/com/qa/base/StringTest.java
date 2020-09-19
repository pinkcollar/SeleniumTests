package com.qa.base;

import org.apache.commons.codec.binary.StringUtils;



public class StringTest {
    public static void main(String[] args) {
        String s1 = "Amazonnnnnnnnn";
        String s2 = "Amaazon";
       System.out.println( difference(s1, s2));

    }
    public static String difference(String s1, String s2) {
        if (s1 == null) {
            return s2;
        }
        if (s2 == null) {
            return s1;
        }
        int at = indexOfDifference(s1, s2);

        return s2.substring(at);
    }

    public static int indexOfDifference(CharSequence cs1, CharSequence cs2) {
        if (cs1 == cs2) {
          return -1;
        }
        if (cs1 == null || cs2 == null) {
            return 0;
        }
        int i;
        for (i = 0; i < cs1.length() && i < cs2.length(); ++i) {
            if (cs1.charAt(i) != cs2.charAt(i)) {
               break;
            }

        }
        if (i < cs2.length() || i < cs1.length()) {
            return i;
        }
        return -1;
    }
}