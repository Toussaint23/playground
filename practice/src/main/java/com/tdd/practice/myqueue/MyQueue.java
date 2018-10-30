package com.tdd.practice.myqueue;

public class MyQueue {
    private Node header;
    private int size = 0;


    public MyQueue(){
        header = new Node(null, null);
    }

    public int size(){
        return size;
    }

    public void add(Integer value) {
        if(value != null) {
            Node node = header;
            Node newNode = new Node(null, value);
            while (node.next != null){
                node = node.next;
            }
            node.next = newNode;
            size++;
        }
    }

    public boolean isEmpty(){
        return header.next == null;
    }

    public Integer remove(){
        if(!isEmpty()){
            Node temp = header.next;
            header.next = header.next.next;
            return temp.value;
        }
        return null;
    }





    private class Node{
        Node next;
        Integer value;

        public Node(Node next, Integer value) {
            this.next = next;
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
}
