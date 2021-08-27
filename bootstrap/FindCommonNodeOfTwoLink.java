package bootstrap;

import java.util.HashSet;

/**
 * @date : 17:08 2021/8/26
 */
public class FindCommonNodeOfTwoLink {
    //NC66 两个链表的第一个公共结点
    //描述
    //输入两个无环的单链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
    //输入：
    //{1,2,3},{4,5},{6,7}
    //返回值：
    //{6,7}
    //说明：
    //第一个参数{1,2,3}代表是第一个链表非公共部分，第二个参数{4,5}代表是第二个链表非公共部分，最后的{6,7}表示的是2个链表的公共部分
    //这3个参数最后在后台会组装成为2个两个无环的单链表，且是有公共节点的

    //输入：
    //{1},{2,3},{}
    //返回值：
    //{}
    //说明：
    //2个链表没有公共节点 ,返回null，后台打印{}

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != null) {
            hashSet.add(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            if (hashSet.contains(p2)) {
                return p2;
            }
            p2 = p2.next;
        }
        return null;
    }
}
