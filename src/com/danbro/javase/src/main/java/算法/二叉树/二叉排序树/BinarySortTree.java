package 算法.二叉树.二叉排序树;

import lombok.Data;

/**
 * @Classname BinarySortTree
 * @Description TODO
 * @Date 2020/8/19 18:35
 * @Author Danrbo
 */
@Data
public class BinarySortTree {
    private BinaryNode<Integer> root;


    public static void main(String[] args) throws Exception {
        int[] array = {4, 1, 7, 10, 3, 5, 20, 0};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < array.length; i++) {
            binarySortTree.addNode(new BinaryNode<>(array[i]));
        }
        System.out.println("前序遍历");
        binarySortTree.preOrder();
        System.out.println("中序遍历");
        binarySortTree.infixOrder();
        System.out.println("后序遍历");
        binarySortTree.postOrder();
    }

    public void addNode(BinaryNode<Integer> node) throws Exception {
        if (node == null) {
            throw new Exception("添加的节点为 null");
        }
        if (root == null) {
            root = node;
        } else {
            doAddNode(node, root);
        }
    }

    private void doAddNode(BinaryNode<Integer> node, BinaryNode<Integer> curNode) {
        if (node.getValue() < curNode.getValue()) {
            if (curNode.getLeftNode() == null) {
                curNode.setLeftNode(node);
            } else {
                doAddNode(node, curNode.getLeftNode());
            }
        } else {
            if (curNode.getRightNode() == null) {
                curNode.setRightNode(node);
            } else {
                doAddNode(node, curNode.getRightNode());
            }
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (root == null) {
            System.out.println("此树为空树，无法遍历。");
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[");
            doPreOrder(root, stringBuffer);
            stringBuffer.append("]");
            stringBuffer.replace(stringBuffer.length() - 2, stringBuffer.length() - 1, "");
            System.out.println(stringBuffer);
        }
    }

    /**
     * 真正执行前序遍历的方法
     *
     * @param node
     * @param stringBuffer
     */
    private void doPreOrder(BinaryNode<Integer> node, StringBuffer stringBuffer) {
        stringBuffer.append(node.getValue()).append(",");
        if (node.getLeftNode() != null) {
            doPreOrder(node.getLeftNode(), stringBuffer);
        }
        if (node.getRightNode() != null) {
            doPreOrder(node.getRightNode(), stringBuffer);
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root == null) {
            System.out.println("此树为空树，无法遍历。");
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[");
            doInfixOrder(root, stringBuffer);
            stringBuffer.append("]");
            stringBuffer.replace(stringBuffer.length() - 2, stringBuffer.length() - 1, "");
            System.out.println(stringBuffer);
        }
    }

    private void doInfixOrder(BinaryNode<Integer> node, StringBuffer stringBuffer) {
        if (node.getLeftNode() != null) {
            doInfixOrder(node.getLeftNode(), stringBuffer);
        }
        stringBuffer.append(node.getValue()).append(",");
        if (node.getRightNode() != null) {
            doInfixOrder(node.getRightNode(), stringBuffer);
        }
    }


    /**
     * 后序遍历
     */
    public void postOrder() {
        if (root == null) {
            System.out.println("此树为空树，无法遍历。");
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[");
            doPostOrder(root, stringBuffer);
            stringBuffer.append("]");
            stringBuffer.replace(stringBuffer.length() - 2, stringBuffer.length() - 1, "");
            System.out.println(stringBuffer);
        }
    }

    private void doPostOrder(BinaryNode<Integer> node, StringBuffer stringBuffer) {
        if (node.getLeftNode() != null) {
            doPostOrder(node.getLeftNode(), stringBuffer);
        }
        if (node.getRightNode() != null) {
            doPostOrder(node.getRightNode(), stringBuffer);
        }
        stringBuffer.append(node.getValue()).append(",");
    }


    public void delNode(int value) {
        if (root.getValue() == value) {
            root = null;
        }else {
            if (root.getValue() > value){
                doDelNode(root.getLeftNode(),value);
            }else {
                doDelNode(root.getRightNode(),value);
            }
        }
    }

    private void doDelNode(BinaryNode<Integer> node,int value) {
        if (node.getValue() == value) {

        }else {
            if (root.getValue() > value){
                doDelNode(root.getLeftNode(),value);
            }else {
                doDelNode(root.getRightNode(),value);
            }
        }
    }

}
