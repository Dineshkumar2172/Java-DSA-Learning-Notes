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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(10);
        ListNode node3 = new ListNode(15);
        ListNode node4 = new ListNode(65);
        ListNode node5 = new ListNode(70);

        ListNode head = node1;
        node1.previous = null;
        node1.next = node2;
        node2.previous = node1;
        node2.next = node3;
        node3.previous = node2;
        node3.next = node4;
        node4.previous = node3;
        node4.next = node5;
        node5.previous = node4;
        node5.next = null;
        ListNode tail = node5;

        dll.printElements(head);
        dll.printElementsBackward(tail);
        head = dll.insertElementAtFirst(head, 100);
        dll.printElements(head);
        dll.insertElementAtLast(tail, 200);
        dll.insertElementAtLast(tail, 300);
        dll.printElements(head);
        head = dll.deleteFirstNode(head);
        dll.printElements(head);
        dll.printElementsBackward(tail);
        dll.deleteLastNode(tail);
        dll.printElements(head);
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


    // print all the elements from linkedlist backwards
    public void printElementsBackward(ListNode tail){
        ListNode currentNode = tail;
        System.out.print("null | tail <---");
        while (currentNode != null) {
            System.out.print(currentNode.data + " <--- ");
            currentNode = currentNode.previous;
        }
        System.out.println(" null | head");
    }


    // insert element at beginning of a doubly linked list
    public ListNode insertElementAtFirst(ListNode head, Integer data){
        ListNode newNode = new ListNode(data);
        if (head == null) {
            newNode.previous = null;
            newNode.next = null;
            head = newNode;
            return head;
        }

        newNode.previous = null;
        newNode.next = head;
        head.previous = newNode;
        head = newNode;

        return head;
    }


    // insert element at the end of doubly linked list
    public void insertElementAtLast(ListNode tail, Integer data){
        ListNode newNode = new ListNode(data);
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
    }


    // delete element at the beginning of doubly linked list
    public ListNode deleteFirstNode(ListNode head){
        head = head.next;
        head.previous = null;
        return head;
    }


    // delete element at the end of doubly linked list
    public void deleteLastNode(ListNode tail){
        ListNode temp = tail;
        tail = tail.previous;
        tail.next = null;
        temp.previous = null;
    }

}
