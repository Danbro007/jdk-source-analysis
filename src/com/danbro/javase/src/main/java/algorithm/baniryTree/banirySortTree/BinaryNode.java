package algorithm.baniryTree.banirySortTree;

import lombok.Data;

/**
 * @Classname BinaryNode
 * @Description TODO
 * @Date 2020/8/19 18:34
 * @Author Danrbo
 */
@Data

public class BinaryNode<T> {
    private T value;
    private BinaryNode<T> leftNode;
    private BinaryNode<T> rightNode;

    public BinaryNode(T value) {
        this.value = value;
    }
}
