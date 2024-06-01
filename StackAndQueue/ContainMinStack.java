import java.util.Stack;

class ContainMinStack01 {
    //借助一个辅助栈
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node){
        dataStack.push(node);
        if (minStack.isEmpty()){
            minStack.push(node);
        }else {
            if (node < minStack.peek()){
                minStack.push(node);
            }
        }
    }
    public int pop(){
        if (dataStack.peek() == minStack.peek()){
           minStack.pop();
        }
        return dataStack.pop();
    }

    public int min(){
        return minStack.peek();
    }
}

class TestContainMinStack{
    public static void main(String[] args) {
        ContainMinStack01 minStack = new ContainMinStack01();
        minStack.push(-2);
        minStack.push(-3);
        minStack.push(0);

        System.out.println(minStack.min());
    }
}
