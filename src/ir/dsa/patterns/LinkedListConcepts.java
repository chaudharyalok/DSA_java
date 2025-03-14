package ir.dsa.patterns;

public class LinkedListConcepts {
    public static void main(String args[]) {
        System.out.println("Hello in LinkedList world!");
        LinkedList list = new LinkedList();
        list.addFirst(2);
        list.addLast(4);
        list.addLast(6);
        list.addFirst(9);
        list.displayReverse();
        list.addItemAtIndex(1,3);
        list.getElementAtIndex(1);
        list.display();
        list.removeFirst();
        list.getElementAtIndex(1);
        list.size();
        list.display();
        list.removeFirst();
        list.addLast(1);
        list.addLast(7);
        list.display();
        list.getLast();
        list.removeFirst();
        list.display();
        list.getLast();
        list.display();
    }

    public static class LinkedList{
        Node head;
        Node tail;
        int size;

        void size(){
            System.out.println("size:"+size);
        }

        void addLast(int data){

            Node node = new Node();
            node.data = data;

            if(size == 0){
                head = tail = node;
            } else{
                tail.next = node;
                tail = node;
            }
            size++;
        }

         void removeFirst(){
            if(size ==0){
                System.out.println("empty list");
            }

            if(size==1){
                head = null;
                tail = null;
                System.out.println("list is empty now");
            } else {
                Node temp = head;
                head = head.next;
                System.out.println("first removed:"+temp.data);
            }
            size--;

        }

        void display(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " ");;
                temp = temp.next;
            }
            System.out.println();;
        }

        void getFirst(){
            if(size ==0){
                System.out.println("empty list");
            } else{
                System.out.println("first node:"+head.data);
            }
        }

        void getLast(){
            if(size ==0){
                System.out.println("empty list");
            } else if(size==1){
                System.out.println("last node:"+head.data);
            } else{
                Node temp = head;
                while(temp.next != null){
                    temp = temp.next;
                }
                System.out.println("last node:"+temp.data);
            }
        }

        void getElementAtIndex(int x){

            if(x>=size){
                System.out.println("invalid index");
                return;
            }

            Node temp = head;
            if(x==0){
                System.out.println("element at index:"+temp.data);
                return;
            }
            int i = 0;
            while(i<x){
                temp = temp.next;
                i++;
            }
            System.out.println("element at index:"+temp.data);
        }

        void addFirst(int item){
            Node node = new Node();
            node.data = item;
            if(size ==0){
                head = tail = node;
            } else{
                node.next = head;
                head = node;
            }
            size++;
        }

        void addItemAtIndex(int x, int data){
            if(x<0 || x>size-1){
                System.out.println("invalid index");
                return;
            }
            if(x==0){
                addFirst(data);
            }
            if(x == size-1){
                addLast(data);
            }
            Node node = new Node();
            node.data = data;

            Node temp = head;
            for(int i=0; i<x-1;i++){
             temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;

            size++;
        }

        void displayReverse(){
            System.out.print("display in reverse order: ");
            displayReverse(head);
            System.out.println();
        }

        void displayReverse(Node node){
            if(node == null){
                return;
            }
            Node temp = node;
            displayReverse(node.next);
            System.out.print(node.data+ " ");

        }
    }

    public static class Node{
        int data;
        Node next;
    }
}
