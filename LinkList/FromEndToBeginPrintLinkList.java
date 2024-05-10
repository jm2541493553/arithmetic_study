import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class FromEndToBeginPrintLinkList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        LinkedList list2 = FromEndToBeginPrintLinkList02(list);

        list2.print();
    }

    //方法1：使用栈
    public static LinkedList  FromEndToBeginPrintLinkList01(LinkedList list){
        Stack<Integer> s = new Stack<>();
        LinkNode ln = list.head;
        while (ln!=null){
            s.push(ln.val);
            ln = ln.next;
        }
        LinkedList list2 = new LinkedList();
        while (!s.empty()){
            list2.add(s.pop());
        }
        return list2;
    }
    //方法2：头插法
    public static LinkedList  FromEndToBeginPrintLinkList02(LinkedList list){
        LinkNode ln = list.head;
        LinkedList list2 = new LinkedList();
        while (ln!=null){
            list2.insertAtHead(ln.val);
            ln = ln.next;
        }
        return list2;
    }
}
