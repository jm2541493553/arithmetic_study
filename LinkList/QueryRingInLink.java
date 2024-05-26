import java.util.HashSet;
import java.util.Scanner;

public class QueryRingInLink {
    public static void main(String[] args) {
        LinkNode head = new LinkNode(-1);
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        LinkNode node = QueryRingInLink2(head);
        System.out.println(node.val);
    }

    public static LinkNode QueryRingInLink1(LinkNode pHead){
        HashSet set = new HashSet();
        while(pHead!=null){
//            1 2 3 2
            if(set.contains(pHead)){
                return pHead;
            }else{
                set.add(pHead);
                pHead = pHead.next;
            }
        }
        return null;
    }

    public static LinkNode QueryRingInLink2(LinkNode pHead) {
//        定义快慢指针都指向头，快2，慢1
        LinkNode quick = pHead;
        LinkNode slow = pHead;
        while (quick != null && slow.next != null) {
//            快2慢1
            slow = slow.next;
            quick = quick.next.next;
            if (quick == slow) {
                quick = pHead;
                while (quick != slow) {
                    quick = quick.next;
                    slow = slow.next;
                }
                return quick;
            }
        }
        return null;
    }
}
