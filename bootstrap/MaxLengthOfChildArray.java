package bootstrap;

import com.sun.org.apache.xml.internal.dtm.ref.DTMAxisIterNodeList;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 * 输入：
 * [2,3,4,5]
 * 返回值：
 * 4
 * 说明：
 * [2,3,4,5]是最长子数组
 * 9 1 3 5 7 9 3 4 2 9 0 1
 *备注 考察点：集合的使用,滑动窗口计算
 * @author :
 * @date : 15:25 2021/7/22
 */
public class MaxLengthOfChildArray {
    public static void main(String[] args) {
        //int[] arr = new int[]{10174, 22971, 3540, 589, 26054, 24343, 5283, 10613, 15564, 30419, 28743, 16962, 12924, 3002, 11504, 623, 22203, 6892, 3276, 14022, 18747, 29478, 23093, 7301, 15692, 31043, 10793, 27142, 28661, 5635, 8954, 19103, 17475, 12556, 6982, 20936, 31201, 23854, 9514, 10619, 12777, 6635, 22963, 32737, 13818, 20023, 30869, 30762, 13707, 24700, 12320, 8892, 28030, 4065, 8559, 16529, 28152, 29388, 29923, 21978, 29297, 16037, 4816, 20457, 7, 15582, 21621, 16973, 15896, 4400, 16690, 32575, 15631, 13607, 11253, 3901, 8062, 19680, 17654, 19444, 22894, 14610, 29604, 8803, 31219, 2635, 3294, 16446, 13059, 14716, 14695, 12432, 4999, 18872, 8340, 11173, 10163, 14137, 11080, 7719, 29587, 22436, 29474, 11143, 31719, 3981, 12789, 12190, 20785, 318, 17785, 917, 20748, 6324, 6976, 2562, 4543, 6379, 6379, 18003, 11282, 3676, 21661, 880, 22369, 19139, 12720, 19868, 3054, 20005, 13735, 17308, 8059, 16658, 10596, 796, 4121, 25640, 23196, 13390, 28987, 6360, 4487, 30932, 12046, 26477, 3804, 16864, 7181, 9801, 9724, 20890, 31952, 9842, 18285, 27586, 1572, 2382, 3979, 31126, 353, 9131, 11642, 9462, 2808, 4610, 13919, 11974, 8012, 25085, 14544, 1172, 27075, 30006, 9353, 22906, 2588, 322, 23136, 17990, 17411, 20718, 30843, 13529, 19682, 10952, 14016, 6861, 11259, 226, 26509, 18267, 24756, 19922, 28841, 18555, 17201, 17149, 20603, 11084, 21288, 11286, 890, 7095, 26865, 11233, 24037, 10063, 31965, 13885, 11700, 10108, 30921, 27489, 14542, 5849, 18419, 14438, 27516, 21978, 6412, 24838, 19230, 8882, 1678, 22179, 285, 18548, 6479, 138, 4640, 18808, 22871, 22906, 5507, 2304, 24814, 1632, 261, 14363, 9722, 19045, 23744, 2506, 28040, 31786, 29535, 29282, 7593, 24658, 21131, 30257, 24959, 3394, 12198, 19300, 21399, 15396, 1212, 21288, 8825, 11058, 31158, 11792, 25470, 30001, 28113, 28599, 2018, 571, 13647, 13734, 10266, 30146, 24429, 9592, 6504, 15826, 6292, 5692, 428, 10134, 31955, 26906, 23933, 7454, 28301, 21818, 11384, 28767, 17775, 10977, 14296, 22396, 27045, 20957, 10056, 32324, 12110, 1828, 22517, 20731, 1581, 7608, 10726, 25693, 20897, 18125, 14224, 7904, 31959, 9518, 11173, 1850, 7998, 12253, 10542, 23587, 17723, 10233, 31193, 22876, 12575, 9701, 30356, 19952, 10326, 423, 24154, 26554, 8416, 6798, 3917, 22567, 25350, 16920, 22022, 13885, 29509, 19986, 18217, 16860, 22671, 5633, 22332, 27716, 4787, 24513, 9401, 18904, 21785, 32620, 10337, 20770, 2};
        //int[] arr = new int[]{1, 2, 3, 5, 2, 4, 6, 7, 2, 8, 9};
        int[] arr = new int[]{2, 3, 4, 5};
        int i = maxLength_example_1(arr);
        //int i1 = maxLength1(arr);
        System.out.println(i);
    }

    //滑动窗口计算 L,R,Set,length
    //L指针记录最左端开始的下标
    //R指针记录递增右端开始的下标
    //Set集合用于计算窗口内是否有重复元素
    //步骤 1.从arr[0]开始遍历,L,R均以0开始
    //1.以R向右滑动，每次下标递增+1
    //2.判断集合Set内是否存在与arr[R]相等的值
    //2.1true:
    //2.1.1则将当前arr[R]的值加入集合Set
    //2.1.2R=R++
    //2.2false:
    //2.2.1 则从Set中移除L指向的元素,(左窗口向右滑动一格)
    //2.2.2 L=L++,左指针向后移动1,重复从步骤1开始，直到遍历完arr[]。
    public static int maxLength_example_1(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr.length;
        }
        //int[] arr = new int[]{1, 2, 3, 5, 2, 4, 6, 7, 2, 8, 9};
        int l = 0, r = 0, length = 0;
        Set<Integer> set = new HashSet<>();
        for (; r < arr.length; ) {
            if (!set.contains(arr[r])) {
                set.add(arr[r]);
                r++;
            } else {
                length = Math.max(r - l, length);
                set.remove(arr[l]);
                l++;
            }
        }
        if (length == 0) {
            return arr.length;
        }
        return length;
    }

    public static int maxLength_example_2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr.length;
        }
        //int[] arr = new int[]{1, 2, 3, 5, 2, 4, 6, 7, 2, 8, 9};
        int l = 0, r = 0, length = 0;
        LinkedList<Integer> set = new LinkedList<>();
        for (; r < arr.length; ) {
            if (!set.contains(arr[r])) {
                set.add(arr[r]);
                r++;
            } else {
                length = Math.max(r - l, length);
                set.remove(new Integer(arr[l]));
                l++;
            }
        }
        if (length == 0) {
            return arr.length;
        }
        return length;
    }
    public static int maxLength_example_3(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr.length;
        }
        //int[] arr = new int[]{1, 2, 3, 5, 2, 4, 6, 7, 2, 8, 9};
        int l = 0, r = 0, length = 0;
        List<Integer> set = new ArrayList<>();
        for (; r < arr.length; ) {
            if (!set.contains(arr[r])) {
                set.add(arr[r]);
                r++;
            } else {
                length = Math.max(r - l, length);
                set.remove(new Integer(arr[l]));
                l++;
            }
        }
        if (length == 0) {
            return arr.length;
        }
        return length;
    }
}
