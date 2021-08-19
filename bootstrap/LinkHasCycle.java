package bootstrap;

import jdk.internal.org.objectweb.asm.tree.LdcInsnNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :
 * @date : 18:06 2021/7/30
 */
public class LinkHasCycle {
    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //判断给定的链表中是否有环。如果有环则返回true，否则返回false。
    //你能给出空间复杂度的解法么？
    //输入分为2部分，第一部分为链表，第二部分代表是否有环，然后回组成head头结点传入到函数里面。-1代表无环，其他的数字代表有环，这些参数解释仅仅是为了方便读者自测调试

    //输入：
    //{3,2,0,-4},1
    //返回值：
    //true
    //说明：
    //第一部分{3,2,0,-4}代表一个链表，第二部分的1表示，-4到位置1，即-4->2存在一个链接，组成传入的head为一个带环的链表 ,返回true

    //输入：
    //{1},-1
    //返回值：
    //false
    //说明：
    //第一部分{1}代表一个链表，-1代表无环，组成传入head为一个无环的单链表，返回false

    //输入：
    //{-1,-7,7,-4,19,6,-9,-5,-2,-5},6
    //返回值：
    //true

    //题解：第一部分参数代表传入的链表，第二个参数是测试时系统根据传入的参数在当前位置设置环链



    public boolean hasCycle(ListNode head) {
        if (head == null||head.next== null) {
            return false;
        }
        ListNode cycleSentry = head;
        List<ListNode> list=new ArrayList<>();
        while (cycleSentry != null) {
            if(list.contains(cycleSentry)){
                return true;
            }
            list.add(cycleSentry);

        }
        return false;
    }

}
