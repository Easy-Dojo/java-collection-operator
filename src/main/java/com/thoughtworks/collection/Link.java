package com.thoughtworks.collection;

public class Link implements SingleLink<Node> {
    private int rootData;
    private Node rootNode;
    private int len;

    public Link(int rootData){
        this.rootData = rootData;
        this.rootNode = new Node(null, rootData, null);
        this.len = 1;
    }

    @Override
    public Node getHeaderData() {
        return this.rootNode;
    }

    @Override
    public Node getTailData() {
        Node result = this.rootNode;
        while (result.getNext()!=null){
            result = result.getNext();
        }
        return result;
    }

    @Override
    public int size() {
        return this.len;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean deleteFirst() {
        return false;
    }

    @Override
    public boolean deleteLast() {
        return false;
    }

    @Override
    public void addHeadPointer(Node item) {
        if(this.len==0){
            new Link(item.getData());
        }else {
            this.rootNode.setPre(item);
            this.rootNode = item;
        }
    }

    @Override
    public void addTailPointer(Node item) {
        if (this.len == 0) {
            new Link(item.getData());
        }else {

        }
    }

    @Override
    public Node getNode(int index) {
        Node result = null;
        Node cur = this.rootNode;
        for (int i = 0; i <= index; i++) {
            result = cur;
            cur = cur.getNext();
        }
        return result;
    }
}
