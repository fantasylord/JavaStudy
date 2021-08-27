package bootstrap;

import java.util.HashMap;

/**
 * @date : 10:38 2021/8/27
 */
public class TreeLowestCommonAncestor {
    //NC102 在二叉树中找到两个节点的最近公共祖先
    //描述
    //给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
    //注：本题保证二叉树中每个节点的val值均不相同。
    //输入：
    //[3,5,1,6,2,0,8,#,#,7,4],5,1
    //返回值：
    //3

    /**
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    public static int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        HashMap<Integer, TreeNode> hashMap = new HashMap<>();
        hashMap.put(root.val, root);
        fetchroot(root, hashMap);
        TreeNode treeNodeo1 = hashMap.get(o1);
        TreeNode treeNodeo2 = hashMap.get(o2);
        while (true) {
            if (treeNodeo1.equals(treeNodeo2)) {
                return treeNodeo1.val;
            }
            if (treeNodeo1.val == o2) {
                return o2;
            }
            if (treeNodeo2.val == o1) {
                return o1;
            }
            treeNodeo1 = hashMap.get(treeNodeo1.val);
            treeNodeo2 = hashMap.get(treeNodeo2.val);
            if (treeNodeo1 == null || treeNodeo2 == null) {
                break;
            }
        }
        return root.val;
    }

    public static void fetchroot(TreeNode root, HashMap<Integer, TreeNode> hashMap) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            hashMap.put(root.right.val, root);
        }
        if (root.left != null) {
            hashMap.put(root.left.val, root);
        }
        fetchroot(root.left, hashMap);
        fetchroot(root.right, hashMap);
    }

    /**
     * 8
     * 6    10
     * 5  7  9  11
     * 12
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode t = new TreeNode(8);
        t.left = new TreeNode(6);
        t.right = new TreeNode(10);
        t.right.left = new TreeNode(9);
        t.left.left = new TreeNode(5);
        t.right.right = new TreeNode(11);
        t.left.right = new TreeNode(7);
        t.left.right.left = new TreeNode(12);
        int i = lowestCommonAncestor(t, 7, 12);
        System.out.println();
    }
}
