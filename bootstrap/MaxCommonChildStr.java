package bootstrap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @author :
 * @date : 16:52 2021/8/19
 */
public class MaxCommonChildStr {
    //NC127 最长公共子串
    //给定两个字符串str1和str2,输出两个字符串的最长公共子串
    //题目保证str1和str2的最长公共子串存在且唯一。----------重要条件-------
    //输入：
    //"1AB2345CD","12345EF"
    //返回值：
    //"2345"

    /**
     * longest common substring
     *
     * @param str1 string字符串 the string   123
     * @param str2 string字符串 the string   1ab1234
     * @return string字符串
     */
    public static String LCS(String str1, String str2) {
        // write code here
        String strMax, strMin;
        String commonMaxStr = "";
        if (str1.length() > str2.length()) {
            strMax = str1;
            strMin = str2;
        } else {
            strMax = str2;
            strMin = str1;
        }
        int[][] res = new int[strMin.length() + 1][strMax.length() + 1];
        int max = 0, indexR = 0;
        char[] maxChars = strMax.toCharArray();
        char[] minChars = strMin.toCharArray();
        for (int j = 1; j < maxChars.length + 1; j++) {
            for (int i = 1; i < minChars.length + 1; i++) {
                if (minChars[i - 1] == maxChars[j - 1]) {
                    res[i][j] = 1 + res[i - 1][j - 1];
                    if (max < res[i][j]) {
                        indexR = j;
                        max = res[i][j];
                    }
                } else {
                    res[i][j] = 0;
                }
            }
        }
        String substring = strMax.substring(indexR - max, indexR);
        return substring;
    }

    /**
     * 不一定存在共字串的情况
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String LCS_Type(String str1, String str2) {
        StringBuilder strMax = new StringBuilder(), strMin = new StringBuilder();
        String commonMaxStr = "";

        if (str1.length() > str2.length()) {
            strMax.append(str1);
            strMin.append(str2);
        } else {
            strMax.append(str2);
            strMin.append(str1);
        }
        for (int i = 1; i <= strMin.length(); i++) {
            if (commonMaxStr.length() > strMin.length() - commonMaxStr.length() + 1) {
                break;
            }
            for (int j = strMin.length(); j > i; j--) {
                if (commonMaxStr.length() > strMin.length() - commonMaxStr.length() + 1) {
                    break;
                }

                String temp = strMin.substring(i - 1, j);
                if (strMax.indexOf(temp) >= 0) {
                    if (commonMaxStr.length() < temp.length()) {
                        commonMaxStr = temp;
                    }
                }
            }
        }
        return commonMaxStr.length() == 0 ? null : commonMaxStr;
    }

    public static void main(String[] args) {
        HashMap<String, String> s = new HashMap<>(10);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        System.out.println(df.format(new Date()));
        String lcs = LCS(str1, str2);
        System.out.println(df.format(new Date()));
        System.out.println(lcs);
    }
}
