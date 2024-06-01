import java.util.Stack;

public class TwoStackImplQueue {
    //入队栈
    Stack<Integer> stack1 = new Stack<>();
    //出队栈
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop(){
        if (!stack2.isEmpty()){
            return stack2.pop();
        }else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

class TestQueue{
    public static void main(String[] args) {
        TwoStackImplQueue queue = new TwoStackImplQueue();
        for (int i=0; i< 5;i++){
            queue.push(i);
        }
        for (int i =0;i <5 ;i++){
            System.out.println(queue.pop());
        }
    }
}
