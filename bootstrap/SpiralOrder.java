package bootstrap;

import javafx.print.Printer;

import java.util.ArrayList;

/**
 * @date : 13:41 2021/8/27
 */
public class SpiralOrder {
    //NC38 螺旋矩阵
    //描述
    //给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
    //示例1
    //输入：
    //[[1,2,3]
    // [4,5,6]
    // [7,8,9]]
    //返回值：
    //[1,2,3,6,9,8,7,4,5]
    //[2][1]
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;//行
        if (m == 0) {
            return new ArrayList<>();
        }
        int n = matrix[0].length;//列

        ArrayList<Integer> res = new ArrayList<>(m * n);
        int stepRow = n;
        int stepCol = m - 1;
        boolean flag = true;
        int i = 0, j = 0;
        //stepRow > 0 && stepCol >= 0 边界值分析
        while (stepRow > 0 && stepCol >= 0) {
            if (flag) {
                for (int step = 0; step < stepRow; step++) {
                    j++;
                    res.add(matrix[i][j - 1]);
                }
                for (int step = 0; step < stepCol; step++) {
                    i++;
                    res.add(matrix[i][j - 1]);
                }

            } else {
                for (int step = 0; step < stepRow; step++) {
                    j--;
                    res.add(matrix[i][j - 1]);
                }
                for (int step = 0; step < stepCol; step++) {
                    i--;
                    res.add(matrix[i][j - 1]);
                }
            }
            stepRow--;
            stepCol--;
            flag = !flag;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] num = new int[][]{{1, 2, 3}, {4, 5, 6,}, {7, 8, 9}};
 //       int[][] num = new int[][]{{ 2, 3}};
        int i = num[0][0];
        ArrayList<Integer> integers = spiralOrder(num);
        System.out.println();
    }
}