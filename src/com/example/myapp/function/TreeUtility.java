package com.example.myapp.function;

/**
 * Created by zhangwanyu on 17-11-1.
 */
public class TreeUtility {

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
}
