package 算法.算法题;

import lombok.Data;

/**
 * @Classname Test7
 * @Description TODO
 * @Date 2020/8/18 16:51
 * @Author Danrbo
 */
public class Test7 {
    public static void main(String[] args) throws Exception {
        SingleLinkedList linkedList = new SingleLinkedList();
        for (int i = 0; i < 8; i++) {
            linkedList.add(new Node(i));
        }
        linkedList.list();
//        Node reverse = linkedList.reverse(linkedList.getHead());
        linkedList.removeNodeFromTail(2);
        linkedList.list();
    }
}

@Data
class SingleLinkedList {
    private Node head;

    public SingleLinkedList() {
        this.head = new Node(null);
    }

    public void add(Node node) {
        Node cur = head;
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        cur.setNext(node);
    }

    public void list() {
        Node next = head.getNext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        int count = 1;
        while (next != null) {
            if (count == size()) {
                stringBuilder.append(next.getNum()).append("]");
            } else {
                stringBuilder.append(next.getNum()).append(",");
            }
            count++;
            next = next.getNext();
        }
        System.out.println(stringBuilder);
    }

    public int size() {
        Node next = head.getNext();
        int count = 0;
        while (next != null) {
            count++;
            next = next.getNext();
        }
        return count;
    }

    public Node reverse(Node head) {
        Node next = null;
        Node pre = null;

        while (head != null) {
            // 保存要反转到头的那个节点
            next = head.getNext();
            // 要反转的那个节点指向已经反转的上一个节点(备注:第一次反转的时候会指向null)
            head.setNext(pre);
            // 上一个已经反转到头部的节点
            pre = head;
            // 一直向链表尾走
            head = next;
        }
        return pre;

    }

    public void insert(int index, Node node) {
        Node cur = head.getNext();
        Node pre = head;
        int count = 0;
        while (count < index) {
            pre = cur;
            cur = cur.getNext();
            count++;
        }
        pre.setNext(node);
        node.setNext(cur);
    }

    public Node poll(int index) {
        Node cur = head.getNext();
        Node pre = head;
        int count = 0;
        while (count < index) {
            count++;
            pre = cur;
            cur = cur.getNext();
        }
        pre.setNext(cur.getNext());
        cur.setNext(null);
        return cur;
    }

    public Node findNodeFromTail(int index) throws Exception {
        if (index > size() || index <= 0) {
            throw new Exception("index 超过链表长度或者小于 0 ");
        }
        int frontIndex = size() - index;
        return findNodeByIndex(frontIndex);
    }

    public Node findNodeByIndex(int index) {
        if (index < 0) {
            throw new RuntimeException("index 小于 0 ");
        }
        Node cur = head.getNext();
        int count = 0;
        while (count < index) {
            count++;
            cur = cur.getNext();
        }
        return cur;
    }

    public void removeNodeFromTail(int index) throws Exception {
        int frontIndex = size() - index;
        removeNodeFromHead(frontIndex);
    }

    public void removeNodeFromHead(int index) throws Exception {
        if (index < 0 || index >= size()) {
            throw new Exception("index 超过范围");
        }
        if (index == 0){
            Node next = head.getNext();
            head.setNext(next.getNext());
            next.setNext(null);
            return;
        }
        Node cur = head.getNext();
        Node pre = head;
        int count = 0;
        while (count < index) {
            count++;
            pre = cur;
            cur = cur.getNext();
        }
        pre.setNext(cur.getNext());
        cur.setNext(null);
    }




}
