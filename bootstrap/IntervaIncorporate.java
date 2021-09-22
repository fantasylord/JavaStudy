package bootstrap;

import com.sun.deploy.security.ValidationState;
import com.sun.xml.internal.fastinfoset.util.ValueArrayResourceException;

/**
 * @date : 16:56 2021/9/18
 */
public class IntervaIncorporate {

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

//示例 1：
// 合并区间
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//示例 2：
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
// 
//
//提示：

    /**
     * [1,3] [2,6] ,[8,10]
     * [1,6]
     *
     * @param vals
     * @return
     */
    public static int[][] valscombine(int[][] vals) {

        int[] flags = new int[vals.length];
        int[][] result = new int[vals.length][2];

        for (int i = 0; i < vals.length; i++) {
            if (flags[i] == 1) {
                continue;
            }
            result[i][0] = vals[i][0];
            result[i][1] = vals[i][1];

            for (int j = i + 1; j < vals.length; j++) {

                //1.  j0在i区间内
                //  i0<j0<i1

                //   J0     J1
                // i0    i1

                //   j0     j1
                // i0           i1
                if (result[i][0] <= vals[j][0] && vals[j][0] <= result[i][1]) {
                    result[i][1] = Math.max(result[i][1], vals[j][1]);
                    flags[j] = 1;
                    continue;
                }
                //2.  j1在i区间内
                //  i0<j1<i1

                //   j0      j1
                //      i0       i1

                //    j0       j1
                // i0               i1
                if (result[i][0] <= vals[j][1] && vals[j][1] <= result[i][1]) {
                    result[i][0] = Math.min(result[i][0], vals[j][0]);
                    flags[j] = 1;
                    continue;
                }
                //3. i0在j区间内
                // j0<i0<j1

                //    j0      j1
                //        i0       i1

                //    j0       j1
                //       i0 i1
                if (vals[j][0] <= result[i][0] && result[i][0] <= vals[j][1]) {
                    result[i][0] = vals[j][0];
                    result[i][1] = Math.max(result[i][1], vals[j][1]);
                    flags[j] = 1;
                    continue;

                }

                //4. i1在j区间内
                // j1<i1<j1

                //     j0      j1
                //  i0    i1

                //     j0       j1
                //       i0   i1
                if (result[j][0] <= vals[i][1] && vals[i][1] <= result[j][1]) {
                    result[i][1] = vals[j][1];
                    result[i][0] = Math.min(result[i][0], vals[j][0]);
                    flags[j] = 1;
                    continue;

                }

            }
        }

        return result;

    }

    public static void main(String[] args) throws Exception {

        int[][] vals = new int[][]{{11,12},{1, 3},{13,24}, {2, 6}, {8, 10}, {15, 18}};
        int[][] valscombine = valscombine(vals);
        for (int[] item : valscombine) {
            if (item[0] == 0 && item[1] == 0) {
                continue;
            }
            System.out.println("[" + item[0] + "," + item[1] + "]");
        }
        System.in.read();
    }

}
