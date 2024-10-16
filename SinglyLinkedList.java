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

        sll.searchElement(sll.head, 30);
        sll.searchElement(sll.head, 100);

        sll.head = sll.reverseLinkedList(sll.head);
        sll.printElements(sll.head);

        ListNode result = sll.findLastNthNode(sll.head, 2);
        System.out.println(result.data);

        sll.head = sll.deletePosition(sll.head, 3);
        sll.head = sll.reverseLinkedList(sll.head);
        sll.head = sll.insertEnd(sll.head, 5);
        sll.head = sll.insertEnd(sll.head, 6);
        sll.head = sll.insertEnd(sll.head, 7);
        sll.head = sll.insertEnd(sll.head, 7);
        sll.head = sll.insertEnd(sll.head, 8);
        sll.head = sll.insertEnd(sll.head, 9);

        sll.printElements(sll.head);
        sll.removeDuplicates(sll.head);
        sll.printElements(sll.head);

        sll.insertNodeSorted(sll.head, 4);
        sll.printElements(sll.head);
        

        sll.deleteKey(sll.head, 5);
        sll.printElements(sll.head);



        // creating a loop for testing loop methods
        ListNode first1 = new ListNode(1);
        ListNode second1 = new ListNode(2);
        ListNode third1 = new ListNode(3);
        ListNode fourth1 = new ListNode(4);
        ListNode fifth1 = new ListNode(5);
        ListNode sixth1 = new ListNode(6);

        ListNode head1 = first1;
        first1.next = second1;
        second1.next = third1;
        third1.next = fourth1;
        fourth1.next = fifth1;
        fifth1.next = sixth1;
        sixth1.next = third1;


        System.out.println(sll.doesContainLoop(head1)); // checking if our linkedlist contains loop
        Integer loopStart = sll.findLoopStartingNode(head1); // finding starting point of the linkedlist loop
        System.out.println(loopStart);
        sll.removeLoop(head1);
        sll.printElements(head1);
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


    public Integer searchElement(ListNode head, Integer searchInteger){
        ListNode currentNode = head;
        Integer locationIndex = 1;
        while (currentNode != null) {
            if (currentNode.data == searchInteger) {
                System.out.println("Search element " + searchInteger + " is found at position " + locationIndex);
                return currentNode.data;
            }
            currentNode = currentNode.next;
            locationIndex++;
        }
        System.out.println("Element " + searchInteger + " not found in the given linked list");
        return 0;
    }


    public ListNode reverseLinkedList(ListNode head){
        ListNode currentNode = head;
        ListNode previousNode = null;
        ListNode nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }


    public ListNode findLastNthNode(ListNode head, Integer n){
        ListNode currentNode = head;
        ListNode referenceNode = head;
        Integer currentIndex = 0;
        Integer referenceInteger = 0;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            currentIndex++;
            if (currentIndex >= n) {
                referenceNode = referenceNode.next;
                referenceInteger++;
            }
        }

        return referenceNode;
    }


    // limitation1 - this works only for sorted linked list
    // limitation2 - this doesn't handle if there are more than two duplicates
    public void removeDuplicates(ListNode head){
        ListNode currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            if (currentNode.data == currentNode.next.data) {
                currentNode.next = currentNode.next.next;
            }
            currentNode = currentNode.next;
        }
    }


    // method to insert a node in sorted linked list
    public void insertNodeSorted(ListNode head, Integer data){
        ListNode newNode = new ListNode(data);
        ListNode currentNode = head;
        ListNode temp = null;
        while (currentNode != null && currentNode.data < data) {
            temp = currentNode;
            currentNode = currentNode.next;
        }

        newNode.next = currentNode;
        temp.next = newNode;
    }


    // method that deletes node based on key (data) input from the user
    public void deleteKey(ListNode head, Integer data){
        ListNode currentNode = head;
        ListNode temp = null;
        while (currentNode != null) {
            if (currentNode.data == data) {
                temp.next = currentNode.next;
                return;
            }

            temp = currentNode;
            currentNode =  currentNode.next;
        }
    }


    // function to check if linkedlist contains loop or not.. - this algo is known as floyd cycle detection algorithm
    // i.e. final node will be pointing to some other nodes somwhere in the middle instead of null
    // this above scenario make us go in neve ending loop while traversing through linkedlist since
    // there's no null to stop the traversal.
    public boolean doesContainLoop(ListNode head){
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        // if the fast pointer meets null, then there are no loop in the given linkedlist
        while (fastPointer != null && slowPointer != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            // since faster pointer moves faster than slow pointer, it should meet null incase
            // if there are no loop in the linkedlist. Else it'll meet with the slow pointer at
            // some point since it'll move in loop along with slow pointer.
            if (fastPointer == slowPointer) {
                return true;
            }
        }
        return false;
    }


    // find start of loop in a singly linked list
    public Integer findLoopStartingNode(ListNode head){
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (slowPointer != null && fastPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                // if slowpointer and fastpointer meets, then there is loop
                // since there's a loop, then we are proceeding with finding
                // the strating point of a loop by keeping slow and fast pointer
                // meeting point as a reference starting point based on floyd cycle detection algorithm
                // move one step each from meeting point and head using two pointer with one pointing to
                // head and another pointing to meeting point.
                return getStartingNode(head, slowPointer).data;
            }
        }

        return null;
    }


    private ListNode getStartingNode(ListNode head, ListNode slowPointer){
        ListNode temp = head;
        while (slowPointer != temp) {
            slowPointer = slowPointer.next;
            temp = temp.next;
        }

        return temp;
    }

    /*
     * Why Floyd's cycle detection algorithm works? - https://youtu.be/2ZLl8GAk1X4?t=28698
     */


    // deleting loop from the given linkedlist
    public void removeLoop(ListNode head){
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                performRemoveLoop(head, slowPointer);
                return;
            }
        }
    }


    private void performRemoveLoop(ListNode head, ListNode slowPointer){
        ListNode temp = head;
        while (temp.next != slowPointer.next) {
            temp = temp.next;
            slowPointer.next = slowPointer.next;
        }
        slowPointer.next = null;
    }
    
}
