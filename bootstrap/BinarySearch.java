package bootstrap;

/**
 * 有重复数字的升序数组的二分查找
 * @author :
 * @date : 14:03 2021/7/29
 */
public class BinarySearch {
    //  请实现有重复数字的升序数组的二分查找
    //    给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的第一个出现的target，如果目标值存在返回下标，否则返回 -1
    //输入：
    //[1,2,4,4,5],4
    //返回值：
    //2
    //说明：
    //从左到右，查找到第1个为4的，下标为2，返回2

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 如果目标值存在返回下标，否则返回 -1
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public static int search(int[] nums, int target) {
        // write code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums[nums.length - 1] < target) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low < high) {
            mid = (high + low) / 2;

            if(high-low==1){
                if (nums[low] == target) {
                    return low;
                }
                if (nums[high] == target) {
                    return high;
                }
                return -1;
            }
            if (target > nums[mid]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target, int low, int high) {

        if (low - high >= 0) {
            return -1;
        }
        int mid = (high + low) / 2;
        if (high == low) {
            if (nums[low] == target) {
                return low;
            } else {
                return 0;
            }
        }
        if (high - low == 1) {
            if (nums[low] == target) {
                return low;
            }
            if (nums[high] == target) {
                return high;
            }
            return -1;
        }
        if (target > nums[mid]) {
            return search(nums, target, mid, high);
        } else {
            return search(nums, target, low, mid);
        }

    }

    public static void main(String[] args) {
        int s = 1 / 2;
        int[] arr = new int[]{-2};
        int index = search(arr, -3);
        System.out.println(index);
    }
}
