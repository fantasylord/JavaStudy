package bootstrap;

import javafx.util.converter.NumberStringConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;

/**
 * @author :
 * @date : 10:39 2021/7/31
 */
public class FindSumValueofTwoNum {
    //描述
    //NC61 两数之和
    //给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
    //你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
    //假设给出的数组中只存在唯一解
    //例如：
    //给出的数组为 {20, 70, 110, 150},目标值为90
    //输出 index1=1, index2=2

    //输入：
    //[3,2,4],6
    //返回值：
    //[2,3]
    //说明：
    //因为 2+4=6 ，而 2的下标为2 ， 4的下标为3 ，又因为 下标2 < 下标3 ，所以输出[2,3]

    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public static int[] twoSum(int[] numbers, int target) {
        // write code here
        if (null == numbers) {
            return new int[]{};
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{};
    }

    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public static int[] twoSum_hahs(int[] numbers, int target) {
        // write code here
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(hashMap.get(target-numbers[i])!=null){
                return new int[]{hashMap.get(target-numbers[i]),i+1};
            }
            hashMap.put(numbers[i],i+1);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers=new int[]{3,2,4};
        int[] result=twoSum(numbers,6);
        System.out.println();
    }
}
