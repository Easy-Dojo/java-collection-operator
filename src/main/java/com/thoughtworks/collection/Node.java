package com.thoughtworks.collection;

public class Node {
    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    private Node pre;
    private int data;
    private Node next;

    public Node(Node pre, int data, Node next) {
        this.pre = pre;
        this.data = data;
        this.next = next;
    }

}
