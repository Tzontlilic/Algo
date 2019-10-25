import java.util.Stack;
public class MinStack {

    private Stack<Integer> minStack = new Stack<Integer>();
    private Stack<Integer> mainStack = new Stack<Integer>();


    /**
     * 入栈
     * @param element 要入栈的元素
     */
    public void push(int element) {
        mainStack.push(element);
        // 如果辅助栈是空的或者入栈元素小于辅助栈栈顶，则将此元素加入辅助栈
        if (minStack.empty() || element < minStack.peek()) {
            minStack.push(element);
        }
    }

    /**
     * 出栈
     */
    public int pop() {
        // 如果出栈元素等于栈顶，就将辅助栈栈顶也出栈
        if (mainStack.peek().equals(minStack.peek())) {
        
            minStack.pop();
        }
        return mainStack.pop();
    }

    /**
     * 获取最小值
     */
    public int getMin() throws Exception{
    
        if (mainStack.empty()) {
            throw new Exception("Stack is empty");
        }
        return minStack.peek();
    }


    public static void main(String[] args) throws Exception{
    
        MinStack mMinStack = new MinStack();
        mMinStack.push(1);
        mMinStack.push(3);
        mMinStack.push(6);
        mMinStack.push(4);
        mMinStack.push(-1);
        System.out.println(mMinStack.getMin());

        mMinStack.pop();
        System.out.println(mMinStack.getMin());
    }
}
