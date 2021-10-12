package bootstrap;

import javax.lang.model.util.ElementFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @date : 16:17 2021/10/11
 */
public class SumOfThreeNums {
    //NC54 数组中相加和为0的三元组
    //描述
    //给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
    //
    //数据范围：，数组中各个元素值满足
    //空间复杂度： O(n^2)，时间复杂度O(n^2)
    //注意：
    //三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
    //解集中不能包含重复的三元组。
    // 1.题意要求是递增有序的且不重复的三元组

    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3) {
            return new ArrayList<ArrayList<Integer>>(0);
        }
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Boolean flag = false;
        for (int i = 0; i < num.length; i++) {
            if (flag) {
                break;
            }
            //1.递增序列 若最小下标>0 则不存在
            if (num[i] > 0) {
                break;
            }
            int x = num[i];
            int left = i + 1;
            int right = num.length - 1;

            // x+y+z=0 则存在三元组满足条件
            //x+y+z>0  x值确定 考虑递增特性 当>0时，只能减小z的值， z值默认为当前遍历轮的最大值
            //x+y+z<0  x值确定 考虑递增特性 当<0时，只能增大y的值， y值默认为当前遍历轮的最小值
            // left代表y值坐标 right则Z值坐标
            while (left < right) {
                if (x + num[left] + num[right] == 0) {
                    ArrayList<Integer> item = new ArrayList<>();
                    item.add(x);
                    item.add(num[left]);
                    item.add(num[right]);
                    //找到当前三元组后，left指针需要进行移动 x,z值确定 则y值一定确定
                    //-16 -15 -8 -7 -7 -7 -6  0  8  8  14  15
                    result.add(item);
                    while (left < num.length - 1 && num[left] == num[left + 1] ) {
                        left++;
                    }
                    while (right > 1 && num[right] == num[right - 1] ) {
                        right--;
                    }
                    right--;
                    left++;
                    continue;
                } else if (x + num[left] + num[right] < 0) {
                    left++;
                } else {
                    right--;
                }
                //x+y < z
                if (x + num[left] > 0)  {
                    flag = true;
                    break;
                }
            }
            while (i < num.length - 1 && num[i] == num[i + 1]) {
                i++;
            }

        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> threeSum_TypeB(int[] num) {

        //用来比较去重的记录
        HashSet<String> readSet = new HashSet<>();
        //记录重复的元素有多少个
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //返回结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //将num排好序
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            addMap(hashMap, num[i]);
            if (!hashMap.containsKey(num[i])) {
            }
        }
        for (int i = 0; i < num.length; i++) {
            int x = num[i];
            boolean flagx = removeMap(hashMap, x);
            for (int j = i + 1; j < num.length; j++) {
                int y = num[j];
                boolean flagy = removeMap(hashMap, y);
                int z = -x - y;
                if (hashMap.containsKey(z)) {
                    ArrayList<Integer> item = new ArrayList<>();
                    item.add(x);
                    item.add(y);
                    item.add(z);
                    List<Integer> collect = item.stream().sorted().collect(Collectors.toList());
                    String strnum = collect.get(0) + "," + collect.get(1) + "," + collect.get(2);
                    if (!readSet.contains(strnum)) {
                        readSet.add(strnum);
                        ArrayList<Integer> itemlist = new ArrayList<>();
                        itemlist.addAll(collect);
                        result.add(itemlist);
                    } else {
                        readSet.add(strnum);
                    }
                }
                if (flagy) {
                    addMap(hashMap, y);
                }

            }
            if (flagx) {
                addMap(hashMap, x);
            }
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> threeSum_TypeA(int[] num) {
        if (num == null || num.length < 3) {
            return new ArrayList<ArrayList<Integer>>(0);
        }
        //用来比较去重的记录
        HashSet<String> readSet = new HashSet<>();
        //用来排序存放去重后的元素集合
        TreeSet<Integer> distinctNum = new TreeSet<>();
        //记录重复的元素有多少个
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //返回结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //将num排好序后转化为list
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            addMap(hashMap, num[i]);
            if (!distinctNum.contains(num[i])) {
                distinctNum.add(num[i]);
            }
        }

        for (int i = 0; i < hashMap.size(); i++) {
            Integer n = distinctNum.pollFirst();
            if (n == null) {
                break;
            }
            for (int j = 0; j < hashMap.get(n); j++) {
                numList.add(n);
            }
        }

        for (int i = 0; i < num.length; i++) {
            int x = numList.get(i);
            boolean flagx = removeMap(hashMap, x);
            for (int j = i + 1; j < num.length; j++) {
                int y = numList.get(j);
                boolean flagy = removeMap(hashMap, y);
                int z = -x - y;
                if (hashMap.containsKey(z)) {
                    ArrayList<Integer> item = new ArrayList<>();
                    item.add(x);
                    item.add(y);
                    item.add(z);
                    List<Integer> collect = item.stream().sorted().collect(Collectors.toList());
                    String strnum = collect.get(0) + "," + collect.get(1) + "," + collect.get(2);
                    if (!readSet.contains(strnum)) {
                        readSet.add(strnum);
                        ArrayList<Integer> itemlist = new ArrayList<>();

                        itemlist.addAll(collect);
                        result.add(itemlist);
                    } else {
                        readSet.add(strnum);
                    }
                }
                if (flagy) {
                    addMap(hashMap, y);
                }

            }
            if (flagx) {
                addMap(hashMap, x);
            }
        }
        return result;

    }

    private static boolean removeMap(HashMap<Integer, Integer> map, int key) {
        if (map.containsKey(key)) {
            if (map.get(key) > 1) {
                map.put(key, map.get(key) - 1);
            } else {
                map.remove(key);
            }
            return true;
        }
        return false;

    }

    private static boolean addMap(HashMap<Integer, Integer> map, int key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
        return true;
    }

    public static void main(String[] args) {

        int[] num = new int[]{0,0,0};
        int size = 1000;
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            arr[i] = random.nextInt(1) > 0 ? random.nextInt(1000) : -1 * random.nextInt(1000);
        }
//      int[] num = new int[]{-10,0,10,20,-10,-40};
        //10 20 -10 -40
        //-10 0 10
        // 20 -10 -40
        //0 10 -10
        ArrayList<ArrayList<Integer>> arrayLists = threeSum(num);
        for (ArrayList<Integer> item : arrayLists) {

            for (Integer i : item) {
                System.out.print("\t," + i);
            }
            System.out.println();

        }
    }
}
