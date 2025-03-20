package LinkedListPreparations;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Node head;

    // Insert at the end
    public void insert(int data) {
        // Implement logic here
    }

    // Insert at a specific position
    public void insertAtPosition(int data, int position) {
        // Implement logic here
    }

    // Delete a node with a given value
    public void delete(int data) {
        // Implement logic here
    }

    // Delete a node at a given position
    public void deleteAtPosition(int position) {
        // Implement logic here
    }

    // Search for a node
    public boolean search(int key) {
        // Implement logic here
        return false;
    }

    // Reverse the linked list
    public void reverse() {
        // Implement logic here
    }

    // Find the middle node
    public Node findMiddle() {
        // Implement logic here
        return null;
    }

    // Detect cycle
    public boolean hasCycle() {
        // Implement logic here
        return false;
    }

    // Merge two sorted lists
    public Node mergeTwoLists(Node l1, Node l2) {
        // Implement logic here
        return null;
    }

    // Remove nth node from end
    public void removeNthFromEnd(int n) {
        // Implement logic here
    }

    // Display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    // Getter for head (for testing purposes)
    public Node getHead() {
        return head;
    }

    // Setter for head (to create test cases for merge & cycle detection)
    public void setHead(Node head) {
        this.head = head;
    }
}

public class LinkedListSkeleton {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Insert elements
        System.out.println("Inserting elements: 1, 2, 3, 4, 5");
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.display(); // Expected: 1 -> 2 -> 3 -> 4 -> 5 -> NULL

        // Insert at specific position
        System.out.println("\nInserting 10 at position 2:");
        list.insertAtPosition(10, 2);
        list.display(); // Expected: 1 -> 10 -> 2 -> 3 -> 4 -> 5 -> NULL

        // Delete an element
        System.out.println("\nDeleting node with value 3:");
        list.delete(3);
        list.display(); // Expected: 1 -> 10 -> 2 -> 4 -> 5 -> NULL

        // Search for an element
        System.out.println("\nSearching for 4: " + list.search(4)); // Expected: true
        System.out.println("Searching for 7: " + list.search(7)); // Expected: false

        // Find the middle node
        System.out.println("\nFinding middle node:");
        Node middleNode = list.findMiddle();
        if (middleNode != null) {
            System.out.println("Middle Node: " + middleNode.data);
        }

        // Reverse the list
        System.out.println("\nReversing the linked list:");
        list.reverse();
        list.display(); // Expected: 5 -> 4 -> 2 -> 10 -> 1 -> NULL

        // Detect cycle (Initially, there should be no cycle)
        System.out.println("\nChecking for cycle: " + list.hasCycle()); // Expected: false

        // Creating two sorted lists for merging
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.insert(1);
        list1.insert(3);
        list1.insert(5);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insert(2);
        list2.insert(4);
        list2.insert(6);

        System.out.println("\nMerging two sorted lists:");
        SinglyLinkedList mergedList = new SinglyLinkedList();
        mergedList.setHead(mergedList.mergeTwoLists(list1.getHead(), list2.getHead()));
        mergedList.display(); // Expected: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL

        // Remove Nth node from end
        System.out.println("\nRemoving 2nd node from end:");
        list.removeNthFromEnd(2);
        list.display(); // Expected output after removing the correct node
    }
}

