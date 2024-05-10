import java.util.Scanner;
//5
//1 2 3 4 5
//2
public class BackwardsKNodeFromLink {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        int k = scanner.nextInt();
        int x = BackwardsKNodeFromLink02(list, k);

        System.out.println(x);
    }

    public static int BackwardsKNodeFromLink01(LinkedList list, int k){
        LinkNode ln  = list.head;
        int count = 0;
        while (ln!=null){
            count ++ ;
            ln = ln.next;
        }
        ln  = list.head;
        int i=0;
        while (ln != null){
            ln = ln.next;
            i++;
            if (count - i == k){
                break;
            }
        }
        return ln.val;
    }

//    双指针
    public static int BackwardsKNodeFromLink02(LinkedList list, int k){
        LinkNode ln1  = list.head;
        LinkNode ln2  = list.head;
        int pre = 0;
        while (ln1!=null && ln2!=null){
            if (pre == k){
                ln1 = ln1.next;
                ln2 = ln2.next;
            }else {
                ln1 = ln1.next;
                pre ++;
            }

        }
        return ln2.val;
    }
}
