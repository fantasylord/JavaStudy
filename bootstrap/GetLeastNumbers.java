package bootstrap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author :
 * @date : 11:12 2021/7/31
 */
public class GetLeastNumbers {
    //描述
    //NC119 最小的K个数
    //给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
    //0 <= k <= input.length <= 10000
    //0 <= input[i] <= 10000

    //输入：
    //[4,5,1,6,2,7,3,8],4
    //返回值：
    //[1,2,3,4]
    //说明：
    //返回最小的4个数即可，返回[1,3,2,4]也可以

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        List<Integer> integers = new ArrayList<>(input.length);
        for (int item : input) {
            integers.add(item);
        }
        List<Integer> collect = integers.stream().sorted().collect(Collectors.toList());
        ArrayList<Integer> result=new ArrayList<>(k);
        for (int i=0;i<k;i++){
            result.add(collect.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input=new int[]{4,5,1,6,2,7,3,8};
        int k=4;
        ArrayList<Integer> result=GetLeastNumbers_Solution(input,k);
        System.out.println();
    }
}
