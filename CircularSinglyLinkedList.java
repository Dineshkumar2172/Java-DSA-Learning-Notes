public class CircularSinglyLinkedList {
    
    private static class ListNode{
        private Integer data;
        private ListNode next;
        public ListNode(Integer data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        /*
         * 1. It's similar to singly linked list, with a difference that in circular
         *    linked list that last node points to first node and not null.
         * 2. Instead of head, we keep track of last node in circular singly linked list.
         */
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
    }
}
