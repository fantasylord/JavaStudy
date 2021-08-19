package bootstrap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :
 * @date : 13:49 2021/7/31
 */


public class TreeOrders {
//    class TreeNode {
//        int val = 0;
//        TreeNode left = null;
//        TreeNode right = null;
//
//        public TreeNode(int val) {
//            this.val = val;
//        }
//    }

    //描述
    //分别按照二叉树先序，中序和后序打印所有的节点。
    //、四种遍历概念
    //  先序遍历：先访问根节点，再访问左子树，最后访问右子树。
    //  后序遍历：先左子树，再右子树，最后根节点。
    //  中序遍历：先左子树，再根节点，最后右子树。
    //  层序遍历：每一层从左到右访问每一个节点。

    /**
     * T
     * L   R
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public static int[][] treeOrders(bootstrap.TreeNode root) {
        // write code here
        List<Integer> firstOrder = new ArrayList<>();
        List<Integer> midOrder = new ArrayList<>();
        List<Integer> afterOrder = new ArrayList<>();
        if (root != null) {
            Integer integer_first = treeFirstOrders(root, firstOrder);
            Integer integer_mid = treeMidOrders(root, midOrder);
            Integer integer_after = treeAfterOrders(root, afterOrder);
            int length = firstOrder.size();
            int[] firstInt = new int[length];
            int[] midInt = new int[length];
            int[] afterInt = new int[length];
            for (int i = 0; i < firstOrder.size(); i++) {
                firstInt[i] = firstOrder.get(i);
                midInt[i] = midOrder.get(i);
                afterInt[i] = afterOrder.get(i);
            }
            return new int[][]{firstInt, midInt, afterInt};
        }
        return null;
    }

    public static Integer treeFirstOrders(bootstrap.TreeNode root, List<Integer> order) {
        // write code here
        if (root != null) {
            order.add(root.val);
            Integer value_left = treeFirstOrders(root.left, order);
            Integer value_right = treeFirstOrders(root.right, order);
            if (value_left != null) {
                order.add(value_left);
            }
            if (value_right != null) {
                order.add(value_right);
            }
        }
        return null;
    }

    public static Integer treeMidOrders(TreeNode root, List<Integer> order) {
        // write code here
        // 1
        //2 3
        if (root != null) {

            Integer value_left = treeMidOrders(root.left, order);
            if (value_left != null) {
                order.add(value_left);
            }
            order.add(root.val);
            Integer value_right = treeMidOrders(root.right, order);
            if (value_right != null) {
                order.add(value_right);
            }
        }
        return null;
    }

    public static Integer treeAfterOrders(TreeNode root, List<Integer> order) {
        // write code here
        if (root != null) {
            Integer value_left = treeAfterOrders(root.left, order);
            if (value_left != null) {
                order.add(value_left);
            }
            Integer value_right = treeAfterOrders(root.right, order);
            if (value_right != null) {
                order.add(value_right);
            }
            order.add(root.val);
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        List<Integer> t = new ArrayList<>();
        int[][] integer = treeOrders(root);
        System.out.println();
    }
}
