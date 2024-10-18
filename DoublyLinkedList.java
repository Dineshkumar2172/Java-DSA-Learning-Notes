import java.util.List;

public class DoublyLinkedList {

    
    private static class ListNode {
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data){
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    public static void main(String[] args) {
        /*
         * 1. It is called two way linkedlist
         * 2. Given a node, we can navigate list in both forward and backward direction, which is
         *    not possible in singly linked list.
         * 3. A node in singly linked list can only be deleted if we have a pointer to its previous
         *    node. But in doubly linkedlist we can delete the node even if we don't have pointer to its
         *    previous node.
         * 4. ListNode in Doubly Linked List (link to previous node) <---- data ----> (link to next node)
         */
        DoublyLinkedList dll = new DoublyLinkedList();
        ListNode headNode = new ListNode(1);
        headNode.previous = null;
        headNode.next = new ListNode(10);


    }


    public boolean isEmpty(ListNode head){
        if (head == null) return false;

        return false;
    }


    // print all the elements from linkedlist
    public void printElements(ListNode head){
        ListNode currentListNode = head;
        while (currentListNode != null) {
            System.out.print(currentListNode.data + " --> ");
            currentListNode = currentListNode.next;
        }
        System.out.println("null");
    }
}
