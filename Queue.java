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

        
        
    }


    public void insertElement(int data){
        ListNode node = new ListNode(data);
        if (isEmpty()) {
            front = node;
        } else {
            rear.next = node;
        }

        rear = node;
        length+; 
    }
}
