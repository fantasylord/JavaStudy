package bootstrap;

import java.util.Stack;

/**
 * @author :
 * @date : 11:14 2021/7/30
 */
public class StackFromDoubleQueue {
    //用两个栈来实现一个队列，分别完成在队列尾部插入整数(push)和在队列头部删除整数(pop)的功能。 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
    //
    //示例:
    //输入:
    //["PSH1","PSH2","POP","POP"]
    //返回:
    //1,2
    //解析:
    //"PSH1":代表将1插入队列尾部
    //"PSH2":代表将2插入队列尾部
    //"POP“:代表删除一个元素，先进先出=>返回1
    //"POP“:代表删除一个元素，先进先出=>返回2
    //输入：
    //["PSH1","PSH2","POP","POP"]
    //返回值：
    //1,2
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(new Integer(node));
    }

    public int pop() {
        int ret = stack1.peek();
        stack1.remove(0);
        return ret;
    }

    public static void main(String[] args) {

    }
}
