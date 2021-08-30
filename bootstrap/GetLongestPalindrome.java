package bootstrap;

import sun.misc.PostVMInitHook;

import java.util.HashSet;

/**
 * @date : 16:57 2021/8/30
 */
public class GetLongestPalindrome {
    //NC17	最长回文子串
    //描述
    //对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
    //
    //给定字符串A以及它的长度n，请返回最长回文子串的长度。
    //示例1
    //"abc1234321ab",12
    //复制
    //返回值：
    //7  ccbbbcc


    public static int getLongestPalindrome(String A, int n) {
        char[] chs = A.toCharArray();
        if (chs.length < 2) {
            return 1;
        }
        int maxLength = 0;
        for (int i = 1; i < chs.length - 1; i++) {
            int stepLenght = 0;
            stepLenght = Math.min(n - 1 - i, i);
            int length = 0;
            if (chs[i] == chs[i - 1]) {
                length = 0;
                for (int j = 1; j <= stepLenght; j++) {
                    if (chs[i - j] == chs[i + j - 1]) {
                        length += 2;
                    } else {
                        break;
                    }
                }
            }
            maxLength = maxLength > length ? maxLength : length;
            if (chs[i - 1] == chs[i + 1]) {
                length = 1;
                for (int j = 1; j <= stepLenght; j++) {
                    {
                        if (chs[i - j] == chs[i + j]) {
                            length += 2;
                        } else {
                            break;
                        }
                    }
                }
            }
            maxLength = maxLength > length ? maxLength : length;
        }
        return maxLength;
    }

    //baabccc
    public static void main(String[] args) {
        String str = "cc1b21bbcc";
        int n = str.length();
        int longestPalindrome = getLongestPalindrome(str, n);
        System.out.println();
    }
}
