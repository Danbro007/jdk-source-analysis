package 算法.算法题;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Classname SingleNode
 * @Description TODO
 * @Date 2020/8/18 16:51
 * @Author Danrbo
 */
@Data
@AllArgsConstructor
public class Node {
    private Integer num;
    private Node next;

    public Node(Integer num) {
        this.num = num;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                '}';
    }
}
