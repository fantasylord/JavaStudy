package bootstrap;

import sun.rmi.runtime.Log;

/**
 * @date : 17:02 2021/10/13
 */
public class Sqrt {
    //描述
    //实现函数 int sqrt(int x).
    //计算并返回 x 的平方根（向下取整）
    //
    //数据范围： 0 < x < 2^{31}0<x<2
    //31
    //
    //要求：空间复杂度 O(1)O(1)，时间复杂度 O(logx)O(logx)


    /**
     * @param x int整型
     * @return int整型
     */
    public static int sqrt(int x) {

        int maxsqrt = 1;
        int sqrt = 1;
        int num = 1;
        while (true) {
            num = sqrt * sqrt;
            if (num > x) {
                break;
            }
            maxsqrt = Math.max(maxsqrt, sqrt);
            sqrt++;

        }
        return maxsqrt;
    }
    //二分查找
    public static int binarysearch(int x) {
        if (x == 0) {
            return x;
        }
        int left = 1;
        int right = x;
        long mid = 0;

        // 4
        while (true) {
            mid = (right + left) / 2;
            if (x / mid >= mid && mid+1 > x / (mid+1)) {
                break;
            } else if (mid < x/mid) {
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }
        return (int)mid;

    }

    public static void main(String[] args) {
        int num = 1518991037;
        System.out.println(sqrt(num));
        System.out.println(binarysearch(num));
    }
}
