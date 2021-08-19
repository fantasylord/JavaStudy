package bootstrap;

/**
 * @author :
 * @date : 11:12 2021/7/1
 */
public class MySort {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    //冒泡排序
    public static int[] MySort(int[] arr) {
//        // write code here
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length - i; j++) {
//                if (arr[j - 1] > arr[j]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j - 1];
//                    arr[j - 1] = temp;
//                }
//            }
//        }

        //xsher
        int step = arr.length / 2;
        while (step >= 1) {
            for (int i = 0; i <= step; i++) {

                for (int j = i; j < arr.length; j = j + step) {
                    if (arr[j] > arr[j + step]) {

                          int temp=arr[j+step];
                          arr[j+step]=arr[j];
                          arr[j]=step;

                    }
                }
            }
            step = step / 2;
        }
        return arr;

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

    //直接排序
    public static int[] normalSort(int[] arr) {
        for (int i = 1; i < arr.length; i++)
        //第0位独自作为有序数列，从第1位开始向后遍历
        {
            //0~i-1位为有序，若第i位小于i-1位，继续寻位并插入，否则认为0~i位也是有序的，忽略此次循环，相当于continue
            if (arr[i] < arr[i - 1]) {
                //保存第i位的值
                int temp = arr[i];
                int j = i - 1;
                //从第i-1位向前遍历并移位，直至找到小于第i位值停止
                while (j >= 0 && temp < arr[j]) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                //插入第i位的值
                arr[j + 1] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] l = new int[]{3, 4, 7, 9, 11, 33, 1, 2, 5, 6, 8, 10};
        print(l);
        MySort(l);
        print(l);

    }

    public static void print(int[] arr) {
        if (arr != null) {
            for (int i : arr) {
                System.out.print(("\t" + i));
            }
            System.out.println();
        }
    }
}