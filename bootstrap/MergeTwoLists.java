package bootstrap;

/**
 * @author :
 * @date : 17:30 2021/7/31
 */
//class ListNode {
//    int val;
//    ListNode next = null;
//
//    public ListNode(int val) {
//        this.val = val;
//    }
//}
public class MergeTwoLists {
    //描述
    //NC33 合并有序链表
    //将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。
    //输入：
    //{1},{2}
    //返回值：
    //{1,2}

    //输入：
    //{2},{1}
    //返回值：
    //{1,2}


    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     * 1->2
     * 2->3
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        ListNode head_1 = l1;
        ListNode head_2 = l2;
        ListNode phead = null;
        ListNode head = null;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            head = phead = l1;
            l1 = l1.next;
            head_1 = l1;
        } else {
            head = phead = l2;
            l2 = l2.next;
            head_2 = l2;
        }
        while (head_1 != null || head_2 != null) {
            if (head_1 == null) {
                phead.next = head_2;
                break;
            }
            if (head_2 == null) {
                phead.next = head_1;
                break;
            }
            if (head_1.val < head_2.val) {
                phead.next = head_1;
                phead = phead.next;
                head_1 = head_1.next;

            } else {
                phead.next = head_2;
                phead = phead.next;
                head_2 = head_2.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println();
    }
}
