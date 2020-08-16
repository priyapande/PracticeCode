package main.design;

public class DLL {
    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(5);
        System.out.println(deque.insertLast(2));
        System.out.println(deque.insertLast(3));
        deque.isFull();
    }
}

class MyCircularDeque {

    int max_size;
    int curr_size;
    Node head;
    Node tail;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.head = null;
        this.tail = null;
        this.max_size = k;
        this.curr_size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) return false;
        Node n = new Node(value);
        if(isEmpty()) {
            head = n;
            tail = n;
            curr_size++;
            return true;
        }
        n.next = head;
        head.prev = n;
        head = n;
        curr_size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) return false;
        Node n = new Node(value);
        if(isEmpty()) {
            head = n;
            tail = n;
            curr_size++;
            return true;
        }
        n.prev = tail;
        tail.next = n;
        tail = n;
        curr_size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(curr_size==0) return false;
        if(curr_size==1) {
            head = null;
            tail = null;
            curr_size--;
            return true;
        }

        if(head.next!=null) head.next.prev = null;
        head = head.next;
        curr_size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(curr_size==0) return false;
        if(curr_size==1) {
            head = null;
            tail = null;
            curr_size--;
            return true;
        }
        if(tail.prev!=null) tail.prev.next = null;
        tail = tail.prev;
        curr_size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return head.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return tail.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return curr_size==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return curr_size==max_size;
    }
}

class Node {
    int value;
    Node prev;
    Node next;
    Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */