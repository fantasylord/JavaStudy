package bootstrap;

import javax.xml.stream.FactoryConfigurationError;

/**
 * @author :
 * @date : 16:58 2021/8/13
 */
public class IsPrefixString {
    //1961. 检查字符串是否为数组前缀
    //给你一个字符串 s 和一个字符串数组 words ，请你判断 s 是否为 words 的 前缀字符串 。
    //
    //字符串 s 要成为 words 的 前缀字符串 ，需要满足：s 可以由 words 中的前 k（k 为 正数 ）个字符串按顺序相连得到，且 k 不超过 words.length 。
    //
    //如果 s 是 words 的 前缀字符串 ，返回 true ；否则，返回 false 。
    //示例 1：
    //
    //输入：s = "iloveleetcode", words = ["i","love","leetcode","apples"]
    //输出：true
    //解释：
    //s 可以由 "i"、"love" 和 "leetcode" 相连得到。
    //示例 2：
    //
    //输入：s = "iloveleetcode", words = ["apples","i","love","leetcode"]
    //输出：false
    //解释：
    //数组的前缀相连无法得到 s 。
    //
    public static boolean isPrefixString(String s, String[] words) {
        boolean flag = true;
        String str = s;
        for (String item : words) {
            if (str == null || str.length() == 0) {
                flag = true;
                break;
            }
            if (str.indexOf(item) == 0) {
                str = str.substring(item.length());
            } else {
                flag = false;
                break;
            }
        }
        if (str.length() > 0) {
            flag = false;
        }
        return flag;
    }

    public static boolean isPrefixString_CanRepeat(String s, String[] words) {
        boolean flag = true;

        for (int i = 0; i < words.length; i++) {
            if (s == null || s.length() == 0) {
                flag = true;
                break;
            }
            if (s.indexOf(words[i]) == 0) {
                s = s.substring(words[i].length());
                i--;
                continue;

            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String s = "iloveleetcode";
        String[] words = new String[]{"i", "love", "leetcode", "apples"};
        boolean prefixString = isPrefixString(s, words);
        System.out.println();
    }
}
