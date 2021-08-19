package bootstrap;

import java.math.BigInteger;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * 输入 7
 * 输出 21
 * 三个相同的红球和两个不同的白球排成一行，共有多少种不同的方法?
 *
 * @author :
 * @date : 10:19 2021/7/22
 */
public class JumpSteps {
    static final BigInteger BIGINTEGER_CONST = new BigInteger("1");

    /**
     * 提炼 排列组合解法
     * @param target
     * @return
     */
    public static int jumpFloor(int target) {
        int length = target;
        BigInteger stepsSwitch = new BigInteger("0");
        for (int i = 0; length > 0; i++) {
            //跳2步
            int step_B = i;
            //跳1步
            int step_A = length - i * 2;
            if (step_A < 0) {
                break;
            }
            stepsSwitch = stepsSwitch.add(type_Arrangement(step_B + step_A, step_B));
            System.out.println("stepsSwitch=\t" + stepsSwitch);
        }
        return stepsSwitch.intValue();
    }

    /**
     * 最优解法
     * 斐波拉契数列 f(n)=f(n-1)+f(n-2)
     *
     * @param target
     * @return
     */
    public int jumpFloor_B(int target) {
        if (target == 2) {
            return 2;
        }
        if (target == 1) {
            return 1;
        }
        if(target<=0){
            return 0;
        }
        return jumpFloor_B(target - 1) + jumpFloor_B(target - 2);
    }

    /**
     * Arrangement排序
     *
     * @param n
     * @param m
     * @return
     */
    public static BigInteger type_Arrangement(int n, int m) {
        BigInteger result = new BigInteger("1");
        int nstep = n;
        int count = m;
        while (count > 0) {
            result = result.multiply(new BigInteger(Integer.toString(nstep)));
            nstep -= 1;
            count -= 1;
        }
        BigInteger v = result.divide(step(new BigInteger(Integer.toString(m))));
        System.out.println("step\tn" + n + "\tm" + m + "=" + v);
        return v;
    }

    public static BigInteger step(BigInteger n) {
        if (n.compareTo(BIGINTEGER_CONST) < 0) {
            return BIGINTEGER_CONST;
        }
        BigInteger subtract = n.subtract(BIGINTEGER_CONST);
        return n.multiply(step(subtract));
    }

    //    /**
//     * Arrangement排序
//     *
//     * @param n
//     * @param m
//     * @return
//     */
//    public static int type_Arrangement_B(int n, int m) {
//        int stepM = step(m);
//        int stepN=step(n);
//        int stepN_M=step(n-m);
//        int v = stepM / (stepN * stepN_M);
//        System.out.println(stepM+"//("+stepN+"*)"+stepN_M+"="+v);
//        return v;
//
    public static void main(String[] args) {
        BigInteger step = step(new BigInteger("29"));
        float i = jumpFloor(29);
        int i1 = (new Float(i)).intValue();
        System.out.println("result=======\t" + i);
    }
}

//
//public class Solution {
//    public  int jumpFloor(int target) {
//        int length = target;
//        int stepsSwitch = 0;
//        for (int i = 0; length > 0; i++) {
//            //跳2步
//            int step_B = i;
//            //跳1步
//            int step_A = length - i * 2;
//            if (step_A < 0) {
//                break;
//            }
//            stepsSwitch += new Float(type_Arrangement(step_B + step_A, step_B)).intValue();;
//
//        }
//        return stepsSwitch;
//    }
//
//    /**
//     * Arrangement排序
//     *
//     * @param n
//     * @param m
//     * @return
//     */
//    public  float type_Arrangement(int n, int m) {
//        float result = 1;
//        int nstep = n;
//        int count = m;
//        while (count > 0) {
//            result *= nstep;
//            nstep -= 1;
//            count -= 1;
//        }
//        return result / step(m);
//    }
//
//    public  float step(int n) {
//        if (n <= 1) {
//            return 1;
//        }
//        return n * step(n - 1);
//    }
//}