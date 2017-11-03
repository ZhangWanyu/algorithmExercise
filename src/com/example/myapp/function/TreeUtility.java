package com.example.myapp.function;

import java.util.ArrayList;
import java.util.List;

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

    /**
     *                1
     *              /   \
     *            2      3
     *           / \    / \
     *          4   5  6   7
     *         / \   \
     *        8  9   10
     * @return
     */
    private static Node initTree1() {
        Node root = new Node(1);
        Node node2 = new Node(2);Node node3 = new Node(3);
        Node node4 = new Node(4);Node node5 = new Node(5);Node node6 = new Node(6);Node node7 = new Node(7);
        Node node8 = new Node(8);Node node9 = new Node(9);Node node10 = new Node(10);

        root.setLeft(node2); root.setRight(node3);
        node2.setLeft(node4);node2.setRight(node5);node3.setLeft(node6);node3.setRight(node7);
        node4.setLeft(node8);node4.setRight(node9);node5.setRight(node10);
        return root;
    }

    /**
     *                1
     *              /   \
     *            2      3
     *           / \    /
     *          4   5  6
     *         / \   \
     *        8  9   10
     *            \
     *             7
     * @return
     */
    private static Node initTree2() {
        Node root = new Node(1);
        Node node2 = new Node(2);Node node3 = new Node(3);
        Node node4 = new Node(4);Node node5 = new Node(5);Node node6 = new Node(6);Node node7 = new Node(7);
        Node node8 = new Node(8);Node node9 = new Node(9);Node node10 = new Node(10);

        root.setLeft(node2); root.setRight(node3);
        node2.setLeft(node4);node2.setRight(node5);node3.setLeft(node6);
        node4.setLeft(node8);node4.setRight(node9);node5.setRight(node10);
        node9.setRight(node7);
        return root;
    }

    public static StringBuffer function() {
        Node root = initTree2();
        if(root == null) {
            return new StringBuffer("null");
        }
        StringBuffer sb = new StringBuffer();

        sb.append(balanceTree(root) + " ");

        return sb;
    }

    //平衡二插树
    private static int balanceTree(Node temp) {
        if (temp == null) {
            return 0;
        }

        int left = balanceTree(temp.getLeft());
        int right = balanceTree(temp.getRight());

        if (left == -1 || right == -1) {
            return -1;
        }
        if (Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left,right)+1;
    }

    //最小深度
    private static int minHeight(Node root) {
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<Integer> countList = new ArrayList<Integer>();
        nodeList.add(root); countList.add(1);
        int count=1; Node temp;

        while (nodeList.size() > 0) {
            temp = nodeList.remove(0);
            count = countList.remove(0);

            if (temp.getLeft() == null && temp.getRight() == null) {
                return count;
            }
            if (temp.getLeft() != null) {
                nodeList.add(temp.getLeft());
                countList.add(count+1);
            }
            if (temp.getRight() != null) {
                nodeList.add(temp.getRight());
                countList.add(count+1);
            }

        }

        return count;
    }

    //最大深度
    private static int maxHeight(Node temp) {
        if (temp == null) {
            return 0;
        }
        int left = maxHeight(temp.getLeft());
        int right = maxHeight(temp.getRight());

        return Math.max(left, right) + 1;
    }

    //前序遍历  根-左-右
    private static void showValueFront(Node temp, StringBuffer sb) {
        sb.append(temp.getData() + " , ");
        if (temp.getLeft() != null) {
            showValueFront(temp.getLeft(), sb);
        }
        if (temp.getRight() != null) {
            showValueFront(temp.getRight(), sb);
        }
    }
}
