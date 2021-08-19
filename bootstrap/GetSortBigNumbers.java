package bootstrap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author :
 * @date : 11:33 2021/7/31
 */
public class GetSortBigNumbers {
    //描述
    //NC88 寻找第K大
    //有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
    //
    //给定一个整数数组a,同时给定它的大小n和要找的K(1<=K<=n)，请返回第K大的数(包括重复的元素，不用去重)，保证答案存在。
    //[1,3,5,2,2],5,3
    //返回值：
    //2

    //输入：
    //[10,10,9,9,8,7,5,6,4,3,4,2],12,3
    //返回值：
    //9
    //说明：
    //去重后的第3大是8，但本题要求包含重复的元素，不用去重，所以输出9

    public int findKth(int[] a, int n, int K) {
        // write code here 1 2 3 4 5
        int[] xsherSort = xsherSort(a);
        return xsherSort[n-K+1];
    }
    public static int[] xsherSort(int[] arr) {
        //希尔排序
        int gap = arr.length;
        while (true) {
            //增量每次减半
            gap /= 2;
            for (int i = 0; i < gap; i++) {
                //这个循环里其实就是一个插入排序
                for (int j = i + gap; j < arr.length; j += gap) {
                    int k = j - gap;
                    while (k >= 0 && arr[k] > arr[k + gap]) {
                        int temp = arr[k];
                        arr[k] = arr[k + gap];
                        arr[k + gap] = temp;
                        k -= gap;
                    }
                }
            }
            if (gap == 1) {
                break;
            }
        }
        return arr;
    }
}
