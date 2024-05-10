import java.util.Scanner;

public class MergeTwoLinkToOne {

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
        LinkedList list3 = MergeTwoLinkToOne01(list1, list2);

        list3.print();
    }

    public static LinkedList MergeTwoLinkToOne01(LinkedList list1, LinkedList list2){
        LinkedList list3 = new LinkedList();
        LinkNode ln1 = list1.head;
        LinkNode ln2 = list2.head;
        while (true){
            if (ln1 == null &&ln2 !=null){
                while (ln2 != null){
                    list3.add(ln2.val);
                    ln2 = ln2.next;
                }
                break;
            } else if (ln1 != null &&ln2 ==null){
                while (ln1 != null){
                    list3.add(ln1.val);
                    ln1 = ln1.next;
                }
                break;
            }else if (ln1.val < ln2.val){
                list3.add(ln1.val);
                ln1 = ln1.next;
            } else if (ln1.val > ln2.val){
                list3.add(ln2.val);
                ln2 = ln2.next;
            } else if (ln1.val == ln2.val) {
                list3.add(ln1.val);
                ln1 = ln1.next;
                list3.add(ln2.val);
                ln2 = ln2.next;
            }
        }
        return list3;
    }
}
