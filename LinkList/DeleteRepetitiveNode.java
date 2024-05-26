import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DeleteRepetitiveNode {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
//        LinkedList list2 = DeleteRepetitiveNode1(list);
//        list2.print();
        DeleteRepetitiveNode2(list);
    }
    public static LinkedList DeleteRepetitiveNode1(LinkedList list){
        HashMap<Integer,Integer> maps = new LinkedHashMap<>();
        LinkNode pHead = list.head;
        if (pHead != null) {
            // 遍历添加到set中
            while (pHead != null) {
                if (!maps.containsKey(pHead.val)) {
                    maps.put(pHead.val,1);
                }else{
                    maps.put(pHead.val,-1);
                }
                pHead = pHead.next;
            }
            LinkedList list2 = new LinkedList();
            for (Map.Entry<Integer,Integer> entry: maps.entrySet()) {
                if(entry.getValue()==1){
                    list2.add(entry.getKey());
                }
            }
            return list2;
        }
        return null;
    }
    public static void DeleteRepetitiveNode2(LinkedList list2) {
//       list2.print();
       LinkNode head = new LinkNode(-1);
       LinkNode p = head;
       LinkNode h2 =list2.head;
       while (h2!=null){
           p.next = h2;
           p = p.next;
           h2 = h2.next;
       }
//       while (head != null){
//           System.out.println(head.val);
//           head = head.next;
//       }
       LinkNode pre = head, cur = head.next;
       while (cur!=null){
           if (cur.next!=null&& cur.val==cur.next.val){
               cur = cur.next;
               while (cur.next!=null&&cur.val==cur.next.val){
                   cur = cur.next;
               }
               cur = cur.next;
               pre.next = cur;
           } else {
             pre = cur;
             cur = cur.next;
           }
       }
       while (head!= null){
           System.out.println(head.val);
           head = head.next;
       }
    }
}
