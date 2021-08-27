package bootstrap;

import java.time.temporal.Temporal;
import java.util.Stack;

/**
 * @date : 18:28 2021/8/26
 */
public class NodeSumOfTwoLink {
    //NC40 两个链表生成相加链表
    //描述
    //假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
    //给定两个这种链表，请生成代表两个整数相加值的结果链表。
    //例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
    //示例1
    //输入：
    //[9,3,7],[6,3]
    //返回值：
    //{1,0,0,0}

    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public static ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        ListNode p1 = null, p2 = null, p3 = null;
        p1 = reverseLink(head1);
        p2 = reverseLink(head2);
        //进位值
        int formNum = 0;

        while (p1 != null || p2 != null) {
            int valP1 = p1 == null ? 0 : p1.val;
            int valP2 = p2 == null ? 0 : p2.val;
            ListNode temp = p1 == null ? p2 : p1;

            int desc = (valP1 + valP2 + formNum);
            formNum = desc / 10;
            int localVal = desc - (formNum) * 10;
            p2 = p2 == null ? null : p2.next;
            p1 = p1 == null ? null : p1.next;

            if (p3 == null) {
                temp.val = localVal;
                temp.next = null;
                p3 = temp;
            } else {
                temp.val = localVal;
                temp.next = p3;
                p3 = temp;
            }

        }
        if (formNum != 0) {
            ListNode temp = new ListNode(formNum);
            temp.next = p3;
            p3 = temp;
        }
        return p3;
    }


    public static ListNode reverseLink(ListNode head) {
        ListNode p = head;
        ListNode before = null;
        ListNode temp = null;
        while (p != null) {
            temp = p.next;
            if (before == null) {
                before = p;
                before.next = null;
            } else {
                p.next = before;
                before = p;
            }
            p = temp;
        }
        return before;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * 1 7 4 9
     * 1 4 5 9 0
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public static String solve(String s, String t) {
        // write code here
        if (s.length() < t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }
        int sL = s.length();
        int tL = t.length();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[] end = new int[sL];
        //逢十进一 进位
        int fromNum = 0;
        int decp = sL - tL;
        tL = tL - 1;
        for (int i = sL - 1; i >= 0; i--) {

            if (i >= decp) {
                int sN = sChar[i] - 48;
                int tN = tChar[tL] - 48;
                int sum = sN + tN + fromNum;
                int stN = sum % 10;
                fromNum = sum / 10;
                end[i] = stN;
                tL--;
            } else {
                int sN = sChar[i] - 48;
                int sum = sN + fromNum;
                int stN = sum % 10;
                fromNum = sum / 10;
                end[i] = stN;
            }
        }
        StringBuffer sb = new StringBuffer();
        if (fromNum != 0) {
            sb.append(fromNum);
        }
        for (int i = 0; i < end.length; i++) {
            sb.append(end[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(7);
        ListNode l2 = new ListNode(6);
        l2.next = new ListNode(3);
        ListNode listNode = addInList(l1, l2);
        System.out.println();
    }
}
