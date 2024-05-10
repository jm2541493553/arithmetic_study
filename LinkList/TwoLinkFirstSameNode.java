import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoLinkFirstSameNode {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list1.add(scanner.nextInt());
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            list2.add(scanner.nextInt());
        }
        LinkNode x = TwoLinkFirstSameNode01(list1, list2);
        System.out.println(x.val);
    }
    public static LinkNode TwoLinkFirstSameNode01(LinkedList list1, LinkedList list2){
        Set<Integer> set = new HashSet<>();
        LinkNode l1 = list1.head;
        LinkNode l2 = list2.head;
        while (l1 != null){
            set.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            if (set.contains(l2.val)){
                return l2;
            }
            l2 = l2.next;
        }
        return null;
    }
}
