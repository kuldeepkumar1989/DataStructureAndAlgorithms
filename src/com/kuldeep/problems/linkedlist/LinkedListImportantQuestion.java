package com.kuldeep.problems.linkedlist;

public class LinkedListImportantQuestion {

    static Node head =null;

    public static void main(String args[]){
        LinkedListImportantQuestion linkedListImportantQuestion = new LinkedListImportantQuestion();

        linkedListImportantQuestion.addNode(1);
        linkedListImportantQuestion.addNode(2);
        linkedListImportantQuestion.addNode(3);
        linkedListImportantQuestion.addNode(4);
        linkedListImportantQuestion.addNode(5);
        linkedListImportantQuestion.addNode(6);
        linkedListImportantQuestion.addNode(7);
        linkedListImportantQuestion.addNode(8);
        linkedListImportantQuestion.addNode(9);

        linkedListImportantQuestion.printList(head);
        //swap in pairs
       Node root= linkedListImportantQuestion.reverseK(head, 3);

        linkedListImportantQuestion.printList(root);


      //  linkedListImportantQuestion.reverseList();

       // linkedListImportantQuestion.printList();
    }

    private Node reverseK(Node root, int n) {
        Node next=null;
        Node prev=null;
        Node curr=root;
        int count =0;
        while(curr!=null && count <n){
            next=curr.next;
            curr.next = prev;

            prev=curr;
            curr=next;
            count++;
        }

        if(next!=null){
            root.next = reverseK(next, n);
        }

        return prev;
    }

    private void reverseList() {
        Node next=null;
        Node prev=null;
        Node curr=head;
        while(curr !=null){
            next = curr.getNext();
            curr.setNext(prev);

            prev=curr;
            curr=next;
        }
        head=prev;
    }

    private void addNode(int val){
        Node tmpNode = new Node(val);
        if(head == null){
            head = tmpNode;
        } else {
            Node root = head;
            while(root.getNext() != null){
                root = root.getNext();
            }
            root.setNext(tmpNode);
        }

    }

    private void printList(Node root){
        Node tmp = root;
        while(tmp !=null){
            System.out.print(tmp.getData()+ " ");
            tmp =tmp.getNext();
        }
    }
}



class Node{
     int data;
     Node next;

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

    Node(int data){
        this.data = data;
        this.next = null;
    }

}
