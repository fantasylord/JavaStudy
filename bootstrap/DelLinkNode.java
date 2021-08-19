package bootstrap;

import java.util.HashMap;

/**
 * @author :
 * @date : 13:41 2021/8/19
 */
public class DelLinkNode {
    //NC53 删除链表的倒数第n个节点
    //描述
    //给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针
    //例如，
    //给出的链表为: 1-> 2-> 3-> 4-> 5,n=2.
    //删除了链表的倒数第 n 个节点之后,链表变为1-> 2-> 3-> 5.
    // 
    //备注：
    //题目保证 nn 一定是有效的
    //请给出时间复杂度为\ O(n) O(n) 的算法
    //输入：
    //{1,2},2
    //返回值：
    //{2}

    /**
     * 1 2 3 4 5
     * 5 n=2 i=5-n+1 pi=3
     * 0 1 2 3 4
     * 哈希表
     *
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        HashMap<Integer, ListNode> nodes = new HashMap<>();
        ListNode p = head;
        int i = 0;
        while (p != null) {
            nodes.put(i++, p);
            p = p.next;
        }
        ListNode needDelp = nodes.get(nodes.size() - n);
        ListNode needbefore = nodes.get(nodes.size() - n - 1);
        if (needbefore == null && needDelp != null) {
            return head.next;
        } else {
            needbefore.next = needbefore.next.next;
            return head;
        }

    }

    //1 2 3 4 5
    //     双指针
    //      pd p
    public static ListNode removeNthFromEnd_Type_A(ListNode head, int n) {
        // write code here
        ListNode p = head;
        ListNode pd = null;//指向要被删除的节点
        int i = 0;
        while (p.next != null) {
            p = p.next;
            if (i >= n-1) {
                if (pd == null) {
                    pd = head;
                } else {
                    pd = pd.next;
                }
            }
            i++;
        }
        if (pd == null) {
            return head.next;
        } else {
            pd.next = pd.next.next;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
        ListNode listNode = removeNthFromEnd_Type_A(l, 1);
        System.out.println();
    }
}
