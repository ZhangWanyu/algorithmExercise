package com.example.myapp.function;

/**
 * Created by zhangwanyu on 17-11-1.
 */
public class TreeUtility {

    public static class Node {
        private int Data;// 数据域
        private Node mLeft = null;// 左子树
        private Node mRight = null;//右子树
        public Node() {

        }
        public Node(int Data) {
            this.Data = Data;
        }
        public int getData() {
            return Data;
        }
        public void setData(int Data) {
            this.Data = Data;
        }

        public Node getLeft() {
            return mLeft;
        }
        public void setLeft(Node Next) {
            this.mLeft = Next;
        }

        public Node getRight(){
            return  mRight;
        }
        public void setRight(Node special){
            this.mRight = special;
        }
    }

    private static Node initTree() {
        Node root = new Node(1);
        Node node2 = new Node(2);Node node3 = new Node(3);
        Node node4 = new Node(4);Node node5 = new Node(5);Node node6 = new Node(6);Node node7 = new Node(7);

        root.setLeft(node2); root.setRight(node3);
        node2.setLeft(node4);node2.setRight(node5);node3.setLeft(node6);node3.setRight(node7);

        return root;
    }
}
