package 算法.算法题;

import lombok.Data;

/**
 * @Classname Test6
 * @Description TODO
 * @Date 2020/8/18 16:43
 * @Author Danrbo
 */
public class Test6 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node4.setNext(node5);
        node5.setNext(node6);
        ListNode head = new ListNode();
        ListNode cur = head;
        int count = 0;
        while (node1!= null && node4 != null) {
            Integer num1 = node1.getNum();
            Integer num2 = node4.getNum();
            int newNum = num1 + num2;
            ListNode node;
            if (newNum >= 10) {
                count++;
                node = new ListNode(newNum - 10);
            } else {
                if (count > 0) {
                    newNum += count;
                    count = 0;
                }
                node = new ListNode(newNum);
            }
            if (cur.getNext()!= null){
                cur = cur.getNext();
            }
            cur.setNext(node);
            node1 = node1.getNext();
            node4 = node4.getNext();
        }
        while (node1!= null){
            cur = cur.getNext();
            int newNum = node1.getNum();
            if (count > 0 ){
                newNum +=count;
                count = 0;
            }
            cur.setNext(new ListNode(newNum));
            node1 = node1.getNext();
        }

        while (node4!= null){
            cur = cur.getNext();
            int newNum = node4.getNum();
            if (count > 0 ){
                newNum +=count;
                count = 0;
            }
            cur.setNext(new ListNode(newNum));
            node4 = node4.getNext();

        }
        System.out.println(head);


    }
}

@Data
class ListNode {
    private Integer num;
    private ListNode next;

    public ListNode(Integer num) {
        this.num = num;
    }

    public ListNode() {
    }
}