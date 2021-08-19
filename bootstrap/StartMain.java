package bootstrap;


public class StartMain {

    //    public static void main(String[] args) {
//        var a=new A();
//        a.setA(1);
//        a.setB(new B());
//        a.getB().setB(1);
//        print(a);
//        var aa=getA(a);
//        print(a);
//        print(aa);
//    }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        ListNode c = a;
        a.val = 3;
        System.out.println(c.val);

    }
}
