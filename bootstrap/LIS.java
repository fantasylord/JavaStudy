package bootstrap;

import com.sun.xml.internal.txw2.output.IndentingXMLFilter;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @date : 19:01 2021/8/30
 */
public class LIS {
    //NC91 最长递增子序列
    //描述
    //给定数组arr，设长度为n，输出arr的最长递增子序列。（如果有多个答案，请输出其中 按数值(注：区别于按单个字符的ASCII码值)进行比较的 字典序最小的那个）

    //示例1
    //输入：
    //[2,1,5,3,6,4,8,9,7]
    //返回值：
    //[1,3,4,8,9]
    //示例2
    //输入：
    //[1,2,8,6,4]
    //返回值：
    //[1,2,4]
    //说明：
    //其最长递增子序列有3个，（1，2，8）、（1，2，6）、（1，2，4）其中第三个 按数值进行比较的字典序 最小，故答案为（1，2，4）

    /**
     * 2,1,5,3,6,4,8,9,7,10,11
     * 1 1 1 1 1 1 1 1 1 1  1
     * <p>
     * 1 1 2 2 3 3 4 5 4 6  7
     * 动态规划：
     * 前置：需要一个记录当前最大长度的max,当前最大长度的值的位置 index.初始为arr[0]的相关数据
     * 一个长度为arr.length的数组，用于存放每个元素从arr[0]到当前位置的最长子串长度
     * 1、每次新增一个元素N，遍历之前的元素看这个Nj(j为当前下标)是能跟之前的元素arr[i]匹配递增，若能则，N子串长度就应该是这个arr[i],然后继续遍历，若有多个匹配递增，则取长度最大作为当前元素的长度
     * 2、记录当前N的位置 index,记录当前N长度存放于maxarrlength。
     * 2、比较max与当前的maxarrlength[j]的长度值
     * ：2.1小于当前max 不做任何处理
     * ：2.2等于当前max 则代表长度一样，按题意需要比较末尾的值，由index可以获取arr[index]为max的末尾值，
     * 2.2.1若arr[index]<arr[j] 则更新index=j
     * 2.2.1反之 则不做处理
     * 2.3大于当前max,则代表当前长度比原记录长，更新max=maxarrlength[j]+1,index=j
     *
     * @return
     */
    public static int[] LIS(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        //存放子串的最大长度
        int[] maxarrLength = new int[arr.length];
        //i,length,{}
        //key->index value->max
        //记录每次变量后当前长子串最大值的位置
        int index = 0;
        //当前index位置的子串末尾最大长度
        int max = 1;
        int[] temparr = new int[arr.length];
        //从第一个数开始查找
        for (int i = 0; i < arr.length; i++) {
            //记录到第i个位置时，最大的子串长度。
            maxarrLength[i] = 1;
            //需要查找的总长度等于本轮i的之前的数据，方法归纳为 每一轮过后需得到前i个数最长子串
            for (int j = i - 1; j >= 0; j--) {
                //当前第i个数为新元素，优先匹配当比当前新元素小的值。
                if (arr[j] < arr[i] && (maxarrLength[j] + 1 > maxarrLength[i])) {
                    maxarrLength[i] = maxarrLength[j] + 1;
                    if ((maxarrLength[i] > max) || (maxarrLength[i] == max && arr[i] <= arr[index])) {
                        max = maxarrLength[i];
                        index = i;
                    }
                }
            }
        }

        int[] result = new int[max];
        //temp默认当前长度为最后一次查找时的长度
        int temp = maxarrLength[index];

        //index为最后一次记录最长子串的下标，即当前数组存在最长子串的的下标的最大值
        //从index开始倒序查找，
        for (int i = index; i >= 0; i--) {
            if (max == 0) {
                break;
            }
            if (maxarrLength[i] == temp) {
                temp--;
                result[--max] = arr[i];
            }
        }

        return result;
    }

    //二分查找最近的数值
    public static int getInsertIndex(List<Integer> arr, int val, int low, int high) {
        if (arr.size() == 1) {
            return 0;
        }

        if (high - low == 1) {
            //val==arr.get(low)  mid  val>arr.get(mid) high
            return val <= arr.get(low) ? low : high;
        }
        int mid = (low + high) / 2;
        if (val >= arr.get(mid)) {
            return getInsertIndex(arr, val, mid, high);
        } else {
            return getInsertIndex(arr, val, low, mid);
        }
    }

    //
    //核心思想：
    //1.
    //设计一个lsit用来存放有序数组 maxLength，区别于
    //
    //遍历arr
    //      arr[i]的值比maxLength里面的末尾值大，则直接插入

    /**
     * 贪心算法+二分查找
     * 核心1：
     * 需要准备：与动态规划相似
     * 一个用于记录当前最长子串的末尾值maxVal,一个用于记录当前最长子串的末尾值的下标 maxIndex
     * 一个集合maxlength存放每个元素下标位置对应的：arr[0]到当前位置的最长子串
     * 与动态规划不同处：
     * 这里额外开辟一个集合arraySortVal去完成贪心算法的核心思想[局部最优解->全局最优解]：
     * 思想：
     * 1.局部最优解： 从局部数据开始分析：假设arr只有 1 4 3 2 3
     * 首先maxVal=1，maxlength=[1],maxIndex=0,arraySortVal=[1];
     * 2.从第二个元素开始遍历：i=2
     * 2.1 arr[i](4)  >maxVal ,则maxlength=[1,4],maxVal=4,maxIndex=1,arraySortVal=[1] (原理新加入的值已经大于原来的最大值)，则代表这个元素可以匹配之前的最长元素。
     * 2.2 arr[i](4) < maxVal, 则需要分析arr[1]能达到的最长长度，这里arraySortVal就派上用场了，查找arraySortVal中与arr[i]最接近的左值(即比arr[i]小的最大值)下标lmin，
     *                      2.3 lmin就是当前这个arr[1]能达到的最大长度。
     *                      2.4 替换arraySortVal[lmin]的值为arr[i],
     *                          解释1：arraySortVal为有序递增序列，其长度是存放到arr[index]为止的最长子串，内容则是局部子串最优解的值
     *                          举例解释： i=2时，初始arraySortVal[1,4] ,进来的元素是3时，在arr[2]这里能取到的子串就是1,3 ，
     *                          arraySortVal长度仍为最大子串长度，但递增序列arraySortVal[1](3)的值可以降低为2。局部最优解值就完成了更新。
     *                                  当i=3时，初始arraySortyVsl1,3]，进来元素2同理更新替换3的位置。
     *                          因为maxVal记录的是最长子串的末尾值，2如果小于它 就一定长度只能<maxVal对应的索引maxarrLength[maxindex]的值)。
     *                          解释完2：再来解释为什么要替换，这里的2的只是针对于当前的arraySortVal来讲，在arr[i]这个位置能拿到的局部的子串，
     *                                  （比如 1 4 3 2 3）在arr[1]的最优解是1 4 ，而在arr[3]的最优解是1 2）
     *                                  即arraySortVal记录的只是局部最优解（arr[0]~arr[i]）的最优解，当i=arr.length。那么arraySortVal就是全局最优解
     *
     *2.3 arr[i](3) =maxVal,完成2.2的全部步骤后，还需要更新MaxIndex，（一个最长递增序列，按贪心思想，长度与末尾值均相同，则这个下标应该是以最后一次遍历的为准。）
     * 核心2：简单的二分查找的变种，找最近的左值
     *
     * @param arr
     * @return
     */
    public static int[] LIS1(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        //2  1  3  4  2
        //存放已经分析过的值
        ArrayList<Integer> arraySortVal = new ArrayList<>();
        int[] maxLength = new int[arr.length];
        arraySortVal.add(arr[0]);
        maxLength[0] = 1;
        int maxVal = arr[0];
        //存储当前最大值的下标
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            //如果比当前已存在的最大值都大，则说明这个值一定是未查找过的
            //直接在存储字串长度末尾添加这个值maxlength
            //记录这个最大值->maxval
            //更新最大长度值的索引坐标maxIndex
            if (arr[i] > maxVal) {
                arraySortVal.add(arr[i]);
                maxVal = arr[i];
                maxLength[i] = maxLength[maxIndex] + 1;
                maxIndex = i;
                continue;

            } else if (arr[i] < maxVal) {
                //如果值存在，则比较这个值与其匹配的最接近的较小值
                //先获取当前长度的大小，用于二分查找
                //接着找到当前位置，递增序列maxLength 内的最长字串就应是当前坐标+1（坐标从0开始）
                int size = arraySortVal.size();
                int insertIndex = getInsertIndex(arraySortVal, arr[i], 0, size - 1);
                if (insertIndex == size - 1) {
                    maxVal = arr[i];
                    maxIndex = i;
                }
                arraySortVal.set(insertIndex, arr[i]);
                // 这里最大子串的长度=当前位置下标 +1（因为已经是递增序列了，当前下标+1为元素总数量）
                maxLength[i] = insertIndex + 1;

            } else {
                maxLength[i] = maxLength[maxIndex];
                maxIndex = i;
            }


        }
        int length = arraySortVal.size();

        int[] result = new int[length];
        //temp默认当前长度为最后一次查找时的长度
        //
        //index为最后一次记录最长子串的下标，即当前数组存在最长子串的的下标的最大值
        //从index开始倒序查找，
        //这里主要需要理解 如果maxLength 为 2 2 3 查找长度为2的时候优先取 maxlength[1]
        // 因为如果maxLength[1]这个下标的在arr[]对应的值必然是小于maxlength[0]的 （有序递增 如果 maxlegnth[1]对应的arr[]值大于它，那么这里的值应该是3）
        for (int i = maxIndex; i >= 0; i--) {
            if (length == 0) {
                break;
            }
            if (maxLength[i] == length) {
                length = maxLength[i];
                result[--length] = arr[i];
            }
        }
        return result;
    }
//    //贪心算法
//    //设计一个lsit用来存放有序数组 maxLength
//    //遍历arr
//    //      arr[i]的值比maxLength里面的末尾值大，则直接插入
//    public static int[] LIS1(int[] arr) {
//        if (arr.length <= 1) {
//            return arr;
//        }
//        //2  1  3  4  2
//        //存放已经分析过的值
//        //ArrayList<Integer> arraySortVal = new ArrayList<>();
//        int size=1;
//        int[] arraySortVal = new int[arr.length];
//
//        int[] maxLength = new int[arr.length];
//        arraySortVal[0] = arr[0];
//        int maxVal = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            //如果比当前已存在的最大值都大，则说明这个值一定是未查找过的
//            if (arr[i] > maxVal) {
//                maxVal = arr[i];
//                maxLength[i] = maxLength[i - 1] + 1;
//                size=i;
//                continue;
//
//            } else if (arr[i] < maxVal) {
//                int insertIndex = getInsertIndex(arraySortVal, arr[i], 0, size);
//                arraySortVal[insertIndex]=arr[i];
//                maxLength[i] = 1;
//                //反之，这个值可能会存在于arraySortVal 里面
//                //这里在arr[i]之前的值已经是
//            }
//
//        }
//        int[] result = new int[size];
//        for (int i = 0; i <size; i++) {
//            result[i] = arraySortVal[i];
//        }
//        return result;
//    }

    public static void main(String[] args) {


        //       int[] arr = new int[]{1, 2, 8, 6, 4, 11, 12, 13, 14, 15, 3, 4, 5, 6, 7};
//        int[] arr = new int[]{101, 2, 100, 1, 1, 2, 3, 4, 5, 5, 3, 5, 6, 7, 6, 4, 8, 9, 7, 6, 7};
        int[] arr = new int[]{1, 3, 8, 6, 5, 2, 5};
        ArrayList<Integer> tes = new ArrayList<Integer>() {
            {
                //1,2,4,5,7,10,12,14
                add(1);
                add(2);
                add(4);
                add(5);
                add(6);
                add(10);
                add(12);
                add(14);
            }
        };
        int insertIndex1 = getInsertIndex(tes, 2, 0, tes.size());
        int[] lis = LIS(arr);
        for (int item : lis) {
            System.out.print(item + "\t");
        }
        System.out.println();
        int[] lis1 = LIS1(arr);
        for (int item : lis1) {
            System.out.print(item + "\t");
        }
        System.out.println();
    }

//    public static int[] getFilearr() {
//        BufferedReader bufferedReader = null;
//        String buff = "";
//        try {
//            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("D:\\testarr.txt")));
//            bufferedReader = new BufferedReader(inputStreamReader);
//            String line = null;
//            int i = 0;
//            while ((line = bufferedReader.readLine()) != null) {
//                if (null != line) {
//                    buff.concat(line);
//                    i++;
//                }
//
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//
//    }
}
