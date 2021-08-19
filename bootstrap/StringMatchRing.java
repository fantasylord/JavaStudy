package bootstrap;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author :
 * @date : 11:33 2021/8/16
 */
public class StringMatchRing {
    //给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
    //括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。

    //示例1
    //输入：
    //"["
    //返回值：
    //false
    //示例2
    //输入：
    //"[]"
    //返回值：
    //true
    //[(])
//  String str = "[](([[]]){}{[]}([]))";

    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public static boolean isValid(String s) {
        String str = s;
        int length = str.length();
        Stack<String> strStack = new Stack<>();
        for (int i = 1; i <= length; i++) {
            String ch = str.substring(i - 1, i);
            if ("{[(".indexOf(ch) >= 0) {
                strStack.push(ch);
                continue;
            }
            if (strStack.isEmpty()) {
                return false;
            }
            if ("}".equals(ch)) {
                if (strStack.peek().equals("{")) {
                    strStack.pop();
                } else {
                    return false;
                }
            }
            if (")".equals(ch)) {
                if (strStack.peek().equals("(")) {
                    strStack.pop();
                } else {
                    return false;
                }
            }
            if ("]".equals(ch)) {
                if (strStack.peek().equals("[")) {
                    strStack.pop();
                } else {
                    return false;
                }
            }
        }
        return strStack.isEmpty();
        // write code here

    }
    public static void main(String[] args) {
        String str = "()[]{}";
        boolean res = isValid(str);
        System.out.println(str);
    }
}
