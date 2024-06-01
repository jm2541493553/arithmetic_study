import java.util.Stack;

public class JudgeStackSeq {
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};
        System.out.println(IsPopOrder(pushA,popA));
    }
    public  static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        int popIndex = 0;
        Stack<Integer> datas = new Stack<>();
        for (int i = 0; i < pushA.length; i++) {
            datas.push(pushA[i]);
            while (popIndex < popA.length && !datas.isEmpty() && popA[popIndex] == datas.peek()) {
                datas.pop();
                popIndex++;
            }
        }
        return datas.isEmpty();
    }
}
