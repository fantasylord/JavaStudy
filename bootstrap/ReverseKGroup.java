package bootstrap;

/**
 * @author :
 * @date : 17:16 2021/8/2
 */
public class ReverseKGroup {
    //描述
    //NC50 链表中的节点每k个一组翻转
    //将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
    //如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
    //你不能更改节点中的值，只能更改节点本身。
    //要求空间复杂度  O(1)
    //例如：
    //给定的链表是1->2->3->4->5
    //1→2→3→4→5
    //对于  k = 2
    //你应该返回 2-> 1-> 4-> 3-> 5
    //对于  k = 3
    //你应该返回 3->2 ->1 -> 4-> 5
    //输入：
    //{1,2,3,4,5},2
    //返回值：
    //{2,1,4,3,5}

    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    /*
     * public class ListNode {
     *   int val;
     *   ListNode next = null;
     * }
     */

    /**
     * 转置指定K个数为界限的链表
     *
     * @param head
     * @param k
     * @return
     */
    /**
     * 转置指定K个数为界限的链表
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode pR = head;
        ListNode pL = head;
        ListNode p = null;
        ListNode temp = null;
        ListNode beforeNode = head;
        int count = 1;
        while (pR != null) {
            if (count % k == 0) {
                temp = pR.next;
                ListNode splidNode = reverseLink(pL, pR);
                if (p == null) {
                    p = splidNode;
                } else {
                    if (beforeNode != null) {
                        beforeNode.next = splidNode;

                    }

//                    ListNode listNode = fetchLast(p);
//                    listNode.next = splidNode;
                }
                beforeNode = pL;
                pL = temp;
                pR = temp;
                count = 1;
                continue;
            }
            count++;
            pR = pR.next;
        }
        if (pL != null) {
            if (p == null) {
                p = beforeNode;
            } else {
                beforeNode.next = pL;
            }
        }
        return p;
    }


    /**
     * 返置子链表的信息
     *
     * @param head
     * @param end
     * @return
     */
    //1->2->3
    //h     e
    public static ListNode reverseLink(ListNode head, ListNode end) {
        ListNode newHead = null;
        ListNode before = null;
        ListNode p = head;
        if (head == end) {
            newHead = head;
            newHead.next = null;
            return newHead;
        }
        boolean flag = false;
        while (p != null && !flag) {
            if (p == end) {
                flag = true;
            }
            //存储旧的head
            before = newHead;
            //当前newhead指向p的位置
            newHead = p;
            //p向后移动
            p = p.next;
            //newhead.next指向before
            newHead.next = before;
        }
        return newHead;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        l1.next.next.next.next.next.next = new ListNode(7);
        ListNode listNode = reverseKGroup(l1, 4);
        System.out.println();
    }
}
