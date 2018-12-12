import java.util.Stack;

/**
 * 题目：用两个栈实现队列
 * 用两个栈实现一个队列，队列的声明如下，请实现它的两个函数appendTail和deleteHead
 * 分别完成在队列尾部插入节点和在队列头部删除节点的功能
 * @author ASUS
 * @since 2018-12-12 20:21
 */

public class Demo9 {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void appednTail(int node){
        stack1.push(node);
    }

    public int deleteHead(){
        if (stack1.empty() && stack2.empty())
            throw new RuntimeException("Queue is empty");
        if (stack2.empty()){
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

}
