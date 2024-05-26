import java.util.ArrayList;
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

        ArrayList<Integer> list2 = FromEndToBeginPrintLinkList02(list);
        for (Integer val:list2) {
            System.out.println(val);
        }
    }

    //方法1：使用栈
    public static ArrayList<Integer>  FromEndToBeginPrintLinkList01(LinkedList list){
        Stack<Integer> s = new Stack<>();
        LinkNode ln = list.head;
        while (ln!=null){
            s.push(ln.val);
            ln = ln.next;
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        while (!s.empty()){
            list2.add(s.pop());
        }
        return list2;
    }
    //方法2：头插法
    public static ArrayList<Integer> FromEndToBeginPrintLinkList02(LinkedList list){
        LinkNode head = new LinkNode(-1);
        LinkNode ln = list.head;
        ArrayList<Integer> list2 = new ArrayList<>();
        while (ln!=null){
            LinkNode temp = ln.next;
            ln.next = head.next;
            head.next = ln;
            ln = temp;
        }
        while (head!=null){
            list2.add(head.val);
            head = head.next;
        }
        return list2;
    }
}
