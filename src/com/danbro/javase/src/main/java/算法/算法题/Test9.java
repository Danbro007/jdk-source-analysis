package 算法.算法题;

/**
 * @Classname Test9
 * @Description TODO
 *
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * @Date 2020/8/19 10:58
 * @Author Danrbo
 */
public class Test9 {
    public static void main(String[] args) {
        SingleLinkedList l1 = new SingleLinkedList();
        SingleLinkedList l2 = new SingleLinkedList();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0){
                l1.add(new Node(i));
            }else {
                l2.add(new Node(i));
            }
        }
        l1.list();
        l2.list();
        SingleLinkedList singleLinkedList = mergeLinkedList(l1, l2);
        singleLinkedList.list();
    }

    /**
     * 合并两个有序单调递增的链表，合并后的链表也是单调递增的。
     * @param l1 单调递增的链表
     * @param l2 单调递增的链表
     * @return 单调递增的链表
     */
    public static SingleLinkedList mergeLinkedList(SingleLinkedList l1,SingleLinkedList l2){
        int m = 0;
        int n = 0;
        SingleLinkedList list = new SingleLinkedList();
        while (m <l1.size() && n < l2.size()){
            if (l1.findNodeByIndex(m).getNum() < l2.findNodeByIndex(n).getNum() ){
                list.add(new Node(l1.findNodeByIndex(m).getNum()));
                m++;
            }else {
                list.add(new Node(l2.findNodeByIndex(n).getNum()));
                n++;
            }
        }
        while (m < l1.size() ){
            list.add(new Node(l1.findNodeByIndex(m).getNum()));
            m++;
        }
        while (n < l2.size()){
            list.add(new Node(l2.findNodeByIndex(n).getNum()));
            n++;
        }
        return list;
    }
}
