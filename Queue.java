import java.util.NoSuchElementException;

public class Queue {
    private ListNode front;
    private ListNode rear;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }


    public int length(){
        return length;
    }


    public boolean isEmpty(){
        // returns true if empty (0) and false if it has data in it
        return length == 0;
    }


    public static void main(String[] args) {
        /*
         * 1. It is a linear data structure used for storing the data.
         * 2. Its an ordered list in which insertion are done at one end,
         *    called as rear and deletion are done at other end called as
         *    front.
         * 3. The first element inserted is the first one to be deleted.
         *    Hence, its called as First In First Out (FIFO) list.
         * 
         *              front --> 10 --> 8 --> 1 --> 11 --> 15 --> rear
         */

        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(25);
        queue.enqueue(30);
        queue.enqueue(35);
        queue.print();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.print();
        System.out.println("first element : " + queue.first());
        System.out.println("last element : " + queue.last());
    }


    public void enqueue(int data){
        ListNode node = new ListNode(data);
        if (isEmpty()) {
            front = node;
        } else {
            rear.next = node;
        }

        rear = node;
        length++;
    }


    public void print(){
        if (isEmpty()) {
            return;
        }
        
        ListNode current = front;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println();
    }


    public int dequeue(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int dequeuedElement = front.data;
        ListNode temp = front.next;
        front.next = null;
        front = temp;

        if (front == null) {
            rear = null;
        }

        length--;
        return dequeuedElement;
    }


    public int first(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return front.data;
    }


    public int last(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return rear.data;
    }

}
