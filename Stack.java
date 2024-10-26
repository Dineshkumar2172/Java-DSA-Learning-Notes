import java.util.EmptyStackException;

public class Stack{
    private ListNode top;
    private int length;
    
    public static class ListNode {
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        /**
         * What is Stack?
         * 
         * 1. It is a linear data structure used for storing the data.
         * 2. Its an ordered list in which insertion and deletion are done at one end, called as top
         * 3. The last element inserted is the first one to be deleted. Hence, it is called as Last In First Out (LIFO) list.
         * 
         * top --> 10 --> 8 --> 1 --> 11 --> 15 --> null
         */
        
        
        
        
    }


    public Stack(){
        top.next = null;
        length = 0;
    }


    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }


    public void pop(){
        if (isEmpty()) {
            throw new EmptyStackException();    
        }

        top = top.next;
        length--;
    }


    public int peek(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        return top.next.data;
    }


    public int length(){
        return length;
    }


    public boolean isEmpty(){
        if (length == 0) {
            return true;
        }
        return false;
    }
}
