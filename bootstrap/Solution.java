package bootstrap;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //p->nextp->nextp2...
    //链表反置
    //
    public static ListNode ReverseList(ListNode head) {

        ListNode before, newHead, p;
        newHead = null;
        p = head;
        if (p == null) {
            return head;
        }
        //1->2->3
        while (p != null) {
            //将当前head值存贮 置为旧head
            before = newHead;
            //当前head指向P当前的位置
            newHead = p;
            //p向下移动
            p = p.next;
            //当前head的next指向旧head before
            newHead.next = before;

        }
        return newHead;
    }

//    public static void main(String[] args) {
//        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        ListNode listNode1 = ReverseList(listNode);
//        print(listNode1);
//    }

    public static void main(String[] args) {
        List<ListNode> listNodes = new ArrayList<>(0);
        listNodes.forEach(i -> {

            if (i != null) {
                System.out.println(i.val);
            }
            else {
                System.out.println("null");
            }
        });
        ListNode listNode = new ListNode(1);
        listNodes.add(listNode);
        listNodes.add(null);
        listNodes.forEach(i -> {

            if (i != null) {
                System.out.println(i.val);
            }
            else {
                System.out.println("null");
            }
        });

        System.out.println("");
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}