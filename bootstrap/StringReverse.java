package bootstrap;

/**
 * @date : 13:37 2021/8/27
 */
public class StringReverse {

    //NC103 反转字符串
    //描述
    //写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
    //输入：
    //"abcd"
    //返回值：
    //"dcba"


    /**
     * 反转字符串
     *
     * @param str string字符串
     * @return string字符串
     */
    public String solve(String str) {
        // write code here
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
