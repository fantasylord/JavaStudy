package bootstrap;

import javax.net.ssl.SNIHostName;
import javax.security.auth.Subject;
import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.Stack;

/**大数加法
 * @author :
 * @date : 17:09 2021/8/18
 */
public class BigNumAddSolve {
    //NC1 大数加法
    //描述
    //以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
    //（字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）

    //输入：
    //"1","99"
    //返回值：
    //"100"
    //说明：
    //1+99=100

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * 1 7 4 9
     * 1 4 5 9 0
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public static String solve(String s, String t) {
        // write code here
        if (s.length() < t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }
        int sL = s.length();
        int tL = t.length();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[] end=new int[sL];
        //逢十进一 进位
        int fromNum = 0;
        int decp = sL - tL;
        tL = tL - 1;
        for (int i = sL - 1; i >= 0; i--) {

            if (i >= decp) {
                int sN = sChar[i] - 48;
                int tN = tChar[tL] - 48;
                int sum = sN + tN + fromNum;
                int stN = sum % 10;
                fromNum = sum / 10;
                end[i]=stN;
                tL--;
            } else {
                int sN = sChar[i] - 48;
                int sum = sN + fromNum;
                int stN = sum % 10;
                fromNum = sum / 10;
                end[i]=stN;
            }
        }
        StringBuffer sb=new StringBuffer();
        if (fromNum != 0) {
            sb.append(fromNum);
        }
        for (int i=0;i<end.length;i++){
            sb.append(end[i]);
        }
        return  sb.toString();
    }

    public static void main(String[] args) {
        String s = "09";
        String t = "01";
        String solve = solve(s, t);
        System.out.println();
    }
}
