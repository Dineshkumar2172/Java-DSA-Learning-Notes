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
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(10);

        // snippet to check how comparing nodes with each other in java works.
        if (node1 == node2) {
            System.out.println("both are considered same");
        } else {
            System.out.println("Both are different though both have same data i.e. we are comparing their memeory address");
        }
    }
}
