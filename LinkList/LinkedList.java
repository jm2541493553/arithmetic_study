class LinkNode {
     int val;
     LinkNode next = null;

     LinkNode(int val){
        this.val = val;
    }
}
public class LinkedList {
    LinkNode head;

    LinkedList() {
        this.head = null;
    }

    // 向链表中添加节点
    void add(int val) {
        LinkNode newNode = new LinkNode(val);
        if (head == null) {
            head = newNode;
        } else {
            LinkNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public void insertAtHead(int val) {
        LinkNode newNode = new LinkNode(val);
        newNode.next = head;
        head = newNode;
    }

    // 打印链表
    void print() {
        LinkNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

