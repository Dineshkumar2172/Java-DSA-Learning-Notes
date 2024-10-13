import java.util.List;

public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        // creating singly linkedlist noded separately
        sll.head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        
        // connecting earlier created linkedlist nodes
        sll.head.next = second; // 1 --> 2
        second.next = third; // 1 --> 2 --> 3
        third.next = fourth; // 1 --> 2 --> 3 --> 4
        fourth.next = fifth; // 1 --> 2 --> 3 --> 4 --> 5 --> null


        sll.printElements(sll.head);
        sll.findLength(sll.head);
        sll.head = sll.insertFirst(sll.head, 10); // inserting element at first
        sll.printElements(sll.head);
        sll.head = sll.insertEnd(sll.head, 20);
        sll.printElements(sll.head);
        sll.head = sll.insertAtPosition(sll.head, 30, 4);
        sll.printElements(sll.head);
        sll.head = sll.deleteFirstNode(sll.head);
        sll.printElements(sll.head);
        sll.head = sll.deleteLastNode(sll.head);
        sll.printElements(sll.head);
        sll.head = sll.deletePosition(sll.head, 5);
        sll.printElements(sll.head);

    }


    public void printElements(ListNode head){
        ListNode current = head;
        while (current != null) {  // last node will always point to null, so we are using it as control statement
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println();
    }


    public Integer findLength(ListNode head){
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        System.out.println("The length of given singly linked list is : " + length);
        return length;
    }


    public ListNode insertFirst(ListNode head, int insertData){
        // create new node with the data that needs to be added
        ListNode newNode = new ListNode(insertData);
        newNode.next = head;
        head = newNode;
        return head;
    }


    public ListNode insertEnd(ListNode head, int insertData){
        ListNode newNode = new ListNode(insertData);
        if (head == null) { // incase if the linkedlist is empty
            head = newNode;
            return head;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    // Implement method to insert a node at a given position. Assuming position to be valid and starting from 1.
    public ListNode insertAtPosition(ListNode head, int insertData, int insertPosition){
        Integer startPosition = 1;
        if (insertPosition < startPosition) { // insert position should always be greater than first position.
            throw new IllegalArgumentException("Input position should be greater than 1");
        }

        ListNode newNode = new ListNode(insertData);
        ListNode currentNode = head;

        if (insertPosition == 1) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        while (currentNode != null) {
            // find the node present in the previous position of the insert position. assume head = 1 --> 2 --> 3 --> 4 --> 5
            if (startPosition == insertPosition-1) { // assume insertPosition is 3, we have to find 3-1 node i.e. second node
                ListNode tempNode = currentNode.next; // take a temp copy of all existing nodes that are present from insert position. tempNode = 3 --> 4 --> 5
                currentNode.next = newNode; // point the current node's next to new index i.e. we are pointing node from n-1 position to new node. 1 --> 2 --> 6
                currentNode.next.next = tempNode; // point all the nodes stored in temp to n+1+1 position i.e. to after newly inserted node. 1 --> 2 --> 6 --> 3 --> 4 --> 5
                return head;
            }
            startPosition++;
            currentNode = currentNode.next;
        }

        return head;

    }


    public ListNode deleteFirstNode(ListNode head){
        if (head == null) {
            return head;
        }
        head = head.next; // pointing 2nd node as head, hence first node will be broken from the chain and gets handled by garbage collection.
        return head;
    }


    public ListNode deleteLastNode(ListNode head){
        // we don't have to delete anything since the head is already null or is the last node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode currentNode = head;
        ListNode previousNode = null;
        while (currentNode.next != null) {
        // System.out.println(currentNode);
        // System.out.println(previousNode);
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        previousNode.next = null; // here we are setting the next node of last second node to null, basically updating the data from that memory address, hence it'll reflect in head's address as well

        return head;
    }


    // implement method to delete a node at a given position. Assuming position to be valid and starting from 1.
    public ListNode deletePosition(ListNode head, Integer position){
        if (head == null) {
            return head;
        }

        if (position > findLength(head) || position < 1) {
            throw new IllegalArgumentException("given position is not within than the length of the given linkedlist - " + findLength(head));
        }
        
        if (position == 1) {
            head = head.next;
            return head;
        }

        ListNode currentNode = head;
        Integer currentPosition = 1;
        while (currentNode.next != null) {
            if (currentPosition == position-1) {
                ListNode temp = currentNode.next.next;
                currentNode.next = temp;
                return head;
            }
            currentNode = currentNode.next;
            currentPosition++;
        }

        return head;
    }

}
