package bootstrap;

import java.util.zip.CheckedOutputStream;

/**
 * @author :
 * @date : 17:28 2021/7/28
 */
public class MaxSumOfChildArray {
    //给定一个数组arr，返回子数组的最大累加和
    //例如，arr = [0,1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
    //题目保证没有全为负数的数据  -1,5,-3,10,-8,11
    //[要求]
    //时间复杂度为O(n)，空间复杂度为O(1)O(1)
    //思路
    //1.遍历。依次递加
    //2.N不出现负数，则该值继续递加
    //2.N值出现负数则比较当前递加的值，与之前递加的值，取二者间大值
    //2.累计值为负值则sum重置为0，从当前位置的下个值开始重新递加

    public static int sumChildArr(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int sum = 0;
        int maxSum = 0;
        for (int R = 0; R < arr.length; R++) {
            if (arr[R] < 0){
                maxSum = Math.max(maxSum, sum);
            }
            if (arr[R] + sum < 0) {
                sum = 0;
            }
            sum += arr[R];

        }
        maxSum = Math.max(maxSum, sum);
        return maxSum;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 3, 5, -2, 6, -1};
        int sumChildArr = sumChildArr(arr);
        System.out.println(sumChildArr);
    }

}
