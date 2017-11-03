package com.example.myapp.function;

import java.util.HashSet;

/**
 * Created by zhangwanyu on 17-10-24.
 */
public class ListUtility {
    private static final String ERROR = "error";

    private static Node mNode1;
    private static Node mNode2;

    public static class Node {
        private int Data;// 数据域
        private Node Next;// 指针域
        private Node Special;//特殊指向
        public Node() {

        }
        public Node(int Data) {
            // super();
            this.Data = Data;
        }
        public int getData() {
            return Data;
        }
        public void setData(int Data) {
            this.Data = Data;
        }

        public Node getNext() {
            return Next;
        }
        public void setNext(Node Next) {
            this.Next = Next;
        }

        public Node getSpecial(){
            return  Special;
        }
        public void setSpecial(Node special){
            this.Special = special;
        }
    }

    private static Node init() {
        Node head0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        head0.setNext(node1); node1.setNext(node2); node2.setNext(node3); node3.setNext(node4); node4.setNext(node5); node5.setNext(node2);
        mNode1 = head0;

        Node secondNode = new Node(-1);
        Node secondNode2 = new Node(-2);
        secondNode.setNext(secondNode2); secondNode2.setNext(node4);
        mNode2 = secondNode;


        /*head0.setSpecial(null); node2.setSpecial(node5); node4.setSpecial(node3);*/

        return head0;
    }

    public static StringBuffer cycleList() {
        init();
        if (mNode1 == null) {
            return new StringBuffer("null");
        }
        StringBuffer sb = new StringBuffer();
        Node man = mNode1;  Node kuai = mNode1;
        boolean have = false;
        while (kuai != null && kuai.getNext()!= null) {
            man = man.getNext();
            kuai = kuai.getNext().getNext();
            if (kuai == man) {
                have = true;
                break;
            }
        }
        if (have){
            sb.append("have \n ");
        } else {
            sb.append("no find");
        }
        return sb;
    }

    public static StringBuffer cycleList2() {
        init();
        if (mNode1 == null) {
            return new StringBuffer("null");
        }
        StringBuffer sb = new StringBuffer();
        Node temp = mNode1;
        HashSet<Node> set = new HashSet<Node>();
        boolean have = false;
        while (temp != null) {
            if (!set.contains(temp)) {
                set.add(temp);
                temp = temp.getNext();
            } else {
                have = true;
                break;
            }
        }

        if (have){
            sb.append("have \n node is " + temp.getData());
        } else {
            sb.append("no find");
        }
        return sb;
    }

    public static StringBuffer findTwoListFirstCommondNode() {
        init();
        if (mNode2 == null || mNode1 == null) {
            return new StringBuffer("null");
        }
        StringBuffer sb = new StringBuffer();

        int length1 = 0, length2=0;
        Node temp=mNode1;
        while (temp != null) {
            length1++;
            temp = temp.getNext();
        }
        temp = mNode2;
        while (temp!= null) {
            length2++;
            temp = temp.getNext();
        }
        int cha = length1 > length2 ? length1-length2 : length2-length1;
        while (cha > 0) {
            cha--;
            if (length1>length2) {
                mNode1 = mNode1.getNext();
            } else {
                mNode2 = mNode2.getNext();
            }
        }

        while (mNode1 != null) {
            if (mNode1 == mNode2) {
                return sb.append("node is " + mNode1.getData() );
            }
            mNode1 = mNode1.getNext();
            mNode2 = mNode2.getNext();
        }
        sb.append("don't have commit node");
        return sb;
    }

    public static StringBuffer copySpecialList() {
        Node haed = init();

        if (haed == null) {
            return new StringBuffer("null");
        }
        if (haed.getNext() == null) {
            return new StringBuffer("only one");
        }

        StringBuffer sb = new StringBuffer();
        sb.append("origini :\n");
        Node temp = haed;
        while (temp != null) {
            sb.append(temp.getData() + "  and  ");
            if (temp.getSpecial() == null) {
                sb.append("null  \n");
            } else {
                sb.append(temp.getSpecial().getData() + " \n");
            }
            temp = temp.getNext();
        }

        sb.append("\n\n\n");
        sb.append("copy: \n");
        copyNext(haed);
        copySpecial(haed);
        Node copyHead = deleteOriginList(haed);

        while (copyHead != null) {
            sb.append(copyHead.getData() + "  and  ");
            if (copyHead.getSpecial() == null) {
                sb.append("null  \n");
            } else {
                sb.append(copyHead.getSpecial().getData() + " \n");
            }
            copyHead = copyHead.getNext();
        }

        return sb;
    }

    private static void copyNext(Node temp) {
        while (temp != null) {
            Node node = new Node();
            node.setData(temp.getData());
            node.setNext(temp.getNext());
            node.setSpecial(null);
            temp.setNext(node);
            temp = node.getNext();
        }
    }

    private static void copySpecial(Node temp) {
        while (temp != null) {
            if (temp.getSpecial() != null) {
                temp.getNext().setSpecial(temp.getSpecial().getNext());
                temp = temp.getNext().getNext();
            } else {
                temp = temp.getNext().getNext();
            }
        }
    }
//  1 11 2 22 3 33
    private static Node deleteOriginList(Node temp) {
        Node copyHead = temp.getNext();
        Node originNode = temp;
        Node copyNode = temp.getNext();
        while (originNode != null) {
            if (copyNode.getNext() != null) {
                originNode = copyNode.getNext();
                copyNode.setNext(originNode.getNext());
                copyNode = copyNode.getNext();
            } else {
                originNode = null;
            }
        }

        return copyHead;
    }


    public static StringBuffer turnList() {

        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        if (head == null) {
            return new StringBuffer(ERROR);
        }

        if (head.getNext() == null) {
            return new StringBuffer("only one value");
        }
        Node temp = head;
        StringBuffer result = new StringBuffer();
        while (temp != null) {
            result.append(temp.getData() + " , ");
            temp = temp.getNext();
        }
        result.append("\n\n");

        /*Node pre = head, now = head.getNext(), next;
        while(now != null) {
            next = now.getNext();
            now.setNext(pre);

            pre=now;
            now=next;
        }
        head.setNext(null);*/

        Node pre = diguiTurnList(head);
        while (pre != null) {
            result.append(pre.getData() + " , ");
            pre = pre.getNext();
        }
        return result;
    }

    private static Node diguiTurnList(Node node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        Node head = diguiTurnList(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return head;
    }
}
