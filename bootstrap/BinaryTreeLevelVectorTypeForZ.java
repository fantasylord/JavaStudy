package bootstrap;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @date : 16:37 2021/8/25
 */
public class BinaryTreeLevelVectorTypeForZ {
    //NC14 按之字形顺序打印二叉树
    //描述
    //给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
    //例如：
    //给定的二叉树是{1,2,3,#,#,4,5}

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        LinkedList<TreeNode> roots = new LinkedList<>();
        roots.add(pRoot);
        fetch(result, roots, true);
        return result;
    }

    public static void fetch(ArrayList<ArrayList<Integer>> tlist, LinkedList<TreeNode> localnodes, boolean switchDirection) {

        if (localnodes == null || localnodes.isEmpty()) {
            return;
        }
        ArrayList<Integer> tItem = new ArrayList<>();
        LinkedList<TreeNode> nextT = new LinkedList<>();
        for (int i = 0; i < localnodes.size(); i++) {
            TreeNode item = localnodes.get(i);
            if (item.left != null) {
                nextT.add(item.left);
            }
            if (item.right != null) {
                nextT.add(item.right);
            }
            if (switchDirection) {
                tItem.add(localnodes.get(i).val);
            } else {
                tItem.add(0, localnodes.get(i).val);
            }
        }
        tlist.add(tItem);
        fetch(tlist, nextT, !switchDirection);

    }
    /**
     *      8
     *   6    10
     * 5  7  9  11
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode t = new TreeNode(8);
        t.left = new TreeNode(6);
        t.right = new TreeNode(10);
        t.left.left = new TreeNode(5);
        t.left.right = new TreeNode(7);
        t.right.left = new TreeNode(9);
        t.right.right = new TreeNode(11);
        ArrayList<ArrayList<Integer>> arrayLists = Print(t);
        for (ArrayList<Integer> item : arrayLists) {
            item.forEach(i -> {
                System.out.print(i + "\t");
            });
            System.out.println();
        }
        System.out.println();
    }
}
