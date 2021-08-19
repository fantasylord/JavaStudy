package bootstrap;

import java.util.ArrayList;
import java.util.List;

/**返回该二叉树层序遍历的结果
 * @author :
 * @date : 15:00 2021/7/30
 */


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val){
        this.val=val;
    }
}

public class BinaryTreeLevelVectorSearch {
    //给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
    //例如：
    //给定的二叉树是{3,9,20,#,#,15,7},
    //   3
    //9    20
    //   15  7
    //该二叉树层序遍历的结果是
    //[
    //[3],
    //[9,20],
    //[15,7]
    //]
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        //
        if (null == root) {
            return new ArrayList<>();
        }
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        levelOrderFetch(treeNodes, result);
        return result;
    }

    public static void levelOrderFetch(ArrayList<TreeNode> levelNode, ArrayList<ArrayList<Integer>> result) {
        if (levelNode != null && levelNode.size() > 0) {
            ArrayList<TreeNode> nextTreeNodelist = new ArrayList<>();
            ArrayList<Integer> levelList = new ArrayList<>();
            boolean flag_activiNext = false;
            for (TreeNode item : levelNode) {
                levelList.add(item.val);
                if (null != item.left) {
                    flag_activiNext = true;
                    nextTreeNodelist.add(item.left);
                }
                if (null != item.right) {
                    flag_activiNext = true;
                    nextTreeNodelist.add(item.right);
                }
            }
            result.add(levelList);
            if (flag_activiNext) {
                levelOrderFetch(nextTreeNodelist, result);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t=new TreeNode(3);
        t.left=new TreeNode(9);
        t.right=new TreeNode(20);
        t.right.left=new TreeNode(15);
        t.right.right=new TreeNode(7);
        ArrayList<ArrayList<Integer>> arrayLists = levelOrder(t);
        for(ArrayList<Integer> item :arrayLists){
            item.forEach(i->{
                System.out.print(i+"\t");
            });
            System.out.println();
        }
        System.out.println();
    }

}
