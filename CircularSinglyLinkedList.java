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


        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        ListNode tail = fourth;

        csll.printElements(tail);

        // insert element at beginning
        csll.insertElementAtFirst(tail, 0);
        csll.printElements(tail);


        // insert element at last
        tail = csll.insertElementAtEnd(tail, 5);
        csll.printElements(tail);

    }


    // traverse and print all elements from a given linked list
    public void printElements(ListNode tail){
        ListNode currentNode = tail.next;
        while (currentNode != tail) {
            System.out.print(currentNode.data + " ---> ");
            currentNode = currentNode.next;
        }
        System.out.println(currentNode.data);
    }


    // insert node at the beginning of circular linked list
    public void insertElementAtFirst(ListNode tail, int data){
        ListNode firstNode = tail.next;
        ListNode newNode = new ListNode(data);
        newNode.next = firstNode;
        tail.next = newNode;
    }

    // insert node at the beginning of circular linked list
    public ListNode insertElementAtEnd(ListNode tail, int data){
        ListNode newNode = new ListNode(data);
        ListNode firstNode = tail.next;
        newNode.next = firstNode;
        tail.next = newNode;
        tail = newNode;
        return tail;
    }
}
