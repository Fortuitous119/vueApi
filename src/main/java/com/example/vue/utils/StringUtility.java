   /*
    * Copyright (c) 2011 NCR/JAPAN Corporation SW-R&D
    *
    * StringUtility
    *
    * Helper class for string manipulation
    *
    * Jessel G. De la Cerna
    */

package com.example.vue.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * StringUtility is a helper class for manipulating String.
 */
public final class StringUtility {
    /** Default Constructor. */
    private StringUtility() {
    }

    /***
     * Helper method to replace string's index with character
     * e.g. 12345678 (display only last 4 character)
     *      ****5678 (replace with character '*')
     * @param formatStr String to format
     * @param index last substring index to display
     * @param toChar character to replace
     * @return formatted string
     */
    public static String replaceStringIndexWith(final String formatStr,
            final int index, final char toChar) {
        if (null == formatStr || formatStr.isEmpty()) {
            return "";
        }

        int lastIdx = formatStr.length() - index;


        if (0 > lastIdx) {
            return formatStr;
        }

        StringBuilder hideStr = new StringBuilder();
        for (int i = 0; i < lastIdx; i++) {
            hideStr.append(toChar);
        }
        hideStr.append(formatStr.substring(lastIdx));
        return hideStr.toString();
    }
    
    /**
     * Add comma to String of a number.
     * 10000-->10,000
     * @param num string of a number
     * @return formatted string
     */
    public static String addCommaToNumString(final String num) {
        if (null == num || num.isEmpty()) {
            return "";
        }

        DecimalFormat df = new DecimalFormat("##,###,###");

        try {
            return df.format(Long.valueOf(num));
        } catch (NumberFormatException ne) {
            return "";
        }
    }

    /**
     * Change the DB date format yyyy-mm-dd to customer's format.
     * @param date format yyyy-mm-dd
     * @param format e.g. "MMMM d,yyyy" or "yyyy'�N'M'��'d'��'"
     * @param locale e.g. Locale.ENGLISH or Locale.JAPAN
     * @return e.g. April 5,2012 or 2012�N5��20��
     */
    public static String formatDBDate(
            final String date, final String format, final Locale locale) {
        String patternStr = "\\d{4}\\-\\d{2}\\-\\d{2}";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher mat = pattern.matcher(date);
        if (!mat.find()) {
            return date;
        }

        Calendar calendar = Calendar.getInstance();
        String[] dateStr = date.split("-");
        calendar.set(Integer.valueOf(dateStr[0]), Integer.valueOf(dateStr[1])
                    - 1, Integer.valueOf(dateStr[2]));
        DateFormat dateFormat = new SimpleDateFormat(format, locale);
        return dateFormat.format(calendar.getTime());
    }

    /***
     * Get the formatted price value in yen currency.
     *
     * @param num number string to format in yen currency
     *
     * @return string of culture's currency symbol e.g. \(�� 1,000)
     */
    public static String addCommaYenToNumString(final String num) {
        if (null == num || num.isEmpty()) {
            return "";
        }

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        DecimalFormat df = (DecimalFormat) nf;

        try {
            return df.format(Long.valueOf(num));
        } catch (NumberFormatException ne) {
            return "";
        }
    }

    /***
     * Get the formatted price value in localized currency.
     *
     * @param amt to format in currency
     * @param language - the required localization
     *
     * @return string of culture's currency symbol e.g. \(�� 1,000)
     */
    public static String getCurrencyFormat(
            final String language, final long amt) {

        Locale locale = null;

        double amount = amt;
        if ("ja".equals(language)) {
            locale = Locale.JAPAN;
        } else {
            locale = Locale.US;
            amount /= 100;
        }

        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        DecimalFormat df = (DecimalFormat) nf;
        return df.format(amount);
    }

    /***
     * Get the formatted price value in yen currency.
     *
     * @param amt to format in yen currency
     *
     * @return string of culture's currency symbol e.g. \(�� 1,000)
     */
    public static String getCurrencySymbol(final long amt) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        DecimalFormat df = (DecimalFormat) nf;
        return df.format(amt);
    }
    /**
     * get the formatted price value with comma.
     * @param amt - amount to format
     * @return e.g. 1000->1,000
     */
    public static String getNumberWithComma(final long amt) {
        DecimalFormat df = new DecimalFormat();
        return df.format(amt);
    }

    /**
     * changes the string to number.
     * @param data - number string to convert
     * @param digits - number of digits desired
     * @param comp - comp
     * @return formatted string
     */
    public static String changeStrToDigits(final String data,
            final int digits, final String comp) {
        if (data == null) {
            return "";
        }
        String result = "";
        int len = data.length();

        if (len > digits) {
            //if length of data is longer than digits, get last digits
            result = data.substring(len - digits);
        } else if (len < digits) {
            //if length of data is shorter than digits,
            //put the data to digits with 0
            StringBuffer sbStoreId = new StringBuffer();
            for (int i = 0; i < digits - len; i++) {
                sbStoreId.append(comp);
            }
            result = sbStoreId.append(data).toString();
        } else {
            result = data;
        }

        return result;
    }

    /**
     * Tell if the given string is Number Formatted or not.
     * @param str   The given string.
     * @return  True if the String is in Number format, else, false.
     */
    public static boolean isNumberFormatted(final String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);

        //Is the String contains Non Numeric Character
        if (str.length() != pos.getIndex()) {
           return false;
        }

        return true;
    }

    /**
     * Compares two string object.
     *
     * @param str1
     *            the first string.
     * @param str2
     *            the second string.
     * @return true, if equal.
     */
    public static boolean compare(final String str1, final String str2) {
        if (null == str1 || null == str2) {
            return str1 == str2;
        }
        return str1.equals(str2);
    }

    /**
     * Checks values if null or empty.
     *
     * @param values
     *            optional variables.
     * @return true if null/empty, false if not null/empty.
     */
    public static boolean isNullOrEmpty(final Object... values) {
        boolean isNullEmpty = false;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null || "".equals(values[i])) {
                isNullEmpty = true;
                break;
            }
        }
        return isNullEmpty;
    }
    
    /**
     * Check string is null or empty
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(final String str) {
        boolean isNullEmpty = false;
        if (str == null || "".equals(str)) {
            isNullEmpty = true;
        }
        return isNullEmpty;
    }

    /**
     * Masks the given string with the character.
     *
     * @param toMask the string to mask
     * @param charMask the char to replace the characters of the string
     * @return the masked string
     */
    public static String mask(final String toMask, final char charMask) {
        String masked = "";
        for (int i = 0; i < toMask.length(); i++) {
        	masked += charMask;
        }
        return masked;
    }

    /**
     * Convert null or empty to zero
     *
     * @param param
     * @return parameter or zero
     */
    public static int convNullToZero(String param) {
        if (isNullOrEmpty(param)) {
            return 0;
        } else {
            return Integer.valueOf(param);
        }
    }
    
    /**
     * Convert null or empty to zero
     *
     * @param param
     * @return parameter or zero
     */
    public static long convNullToLongZero(String param) {
        if (isNullOrEmpty(param)) {
            return 0;
        } else {
            return Long.parseLong(param);
        }
    }
    
    /**
     * Convert null or empty to zero
     *
     * @param param
     * @return parameter or zero
     */
    public static double convNullToDoubleZero(String param) {
        if (isNullOrEmpty(param)) {
            return 0;
        } else {
            return Double.parseDouble(param);
        }
    }
    
    /**
     * Convert null to empty
     *
     * @param param
     * @return parameter or empty
     */
    public static String convNullToEmpty(Object param) {
        if (isNullOrEmpty(param)) {
            return "";
        } else {
            return param.toString().trim();
        }
    }

    public static boolean isIPformat(String val) {
        String patternStr = "(([0-1]?[0-9]{1,2}\\.)|(2[0-4][0-9]\\.)|(25[0-5]\\.)){3}(([0-1]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))";
        Pattern pattern = Pattern.compile(patternStr);
        return pattern.matcher(val).matches();
    }

    public static boolean isEmpty(String val) {
        return val.isEmpty();
    }

    public static String printStackTrace(Throwable throwable){
        StringWriter errorStackTrace = new StringWriter();
        if (throwable == null){
            return "";
        }
        throwable.printStackTrace(new PrintWriter(errorStackTrace));
        return errorStackTrace.toString();
    }
    
    /**
     * Escapes special characters for sql queries
     *  [ % , _ , & ] 
     * @param strQuery
     * @return
     */
    public static String escapeCharatersForSQLqueries(final String strQuery){
    	String strNewQuery = strQuery;
    	if(!isNullOrEmpty(strQuery)){  
    		strNewQuery = strQuery.replaceAll("%", "\\\\%").replaceAll("_", "\\\\_").replaceAll("\\[", "\\\\[");    		
    	}    	
    	return strNewQuery;
    } 
    
    /**
     * Converts the first character of a camel-cased String into upper case 
     * @param name the String to be converted
     * @return the resulting String
     */
    public static String toUpperCamel(String name) {
    	return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
    
    /**
     * Converts the String name into camel-case convention
     * @param name the String to be converted
     * @return the resulting String
     */
    public static String toCamelCase(String name) {
    	return Character.toLowerCase(name.charAt(0)) + name.substring(1);
    }
    
    /**
     * Converts the 'null' String literal to null String
     * @param value the 'null' String literal
     * @return null if satisfies the condition, returns the original value otherwise
     */
    public static String convNullStringToNull(String value) {
    	if ("null".equalsIgnoreCase(value)) {
    		return null;
    	}
    	return value;
    }
}
