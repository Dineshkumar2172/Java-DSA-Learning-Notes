package LinkedListPreparations;

public class LinkedListPractice {

    static class Node {
        int data;
        Node next;
    
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    static class SinglyLinkedList {
        private Node head;
    
    
        // Insert at the end
        public void insert(int data) {
            Node newNode = new Node(data);
            if (head  == null) {
                head = newNode;
                return;
            }

            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }
    
        // Insert at a specific position
        public void insertAtPosition(int data, int position) {
            Node newNode = new Node(data);
            if (position == 0 ) {
                newNode.next = head;
                head = newNode;
            }

            Node currentNode = head;
            int counter = 1;
            while (currentNode != null && counter < position - 1) {
                currentNode = currentNode.next;
                counter++;
            }

            if (currentNode == null) {
                System.out.println("index out of bounds");
                return;
            }

            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    
        // Delete a node with a given value
        public void delete(int data) {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            if ( head.data == data) {
                head = head.next;
                return;
            }
            
            // Implement logic here
            Node current = head;
            while (current.next != null && current.next.data != data) {
                current = current.next;
            }

            if (current.next == null) {
                System.out.println("No node present with the data");
                return;
            }

            current.next = current.next.next;
        }
    
        // Delete a node at a given position
        public void deleteAtPosition(int position) {
            // Implement logic here
            if (head == null) {
                System.out.println("list is empty");
                return;
            }

            if (position == 0) {
                head = head.next;
                return;
            }

            Node currentNode = head;
            int counter = 1;
            while (currentNode.next != null && counter < position - 1) {
                currentNode = currentNode.next;
                counter++;
            }

            if (currentNode.next == null) {
                System.out.println("Index out of bounds");
                return;
            }

            currentNode.next = currentNode.next.next;
        }
    
        // Search for a node
        public boolean search(int key) {
            // Implement logic here
            Node currentNode = head;
        
            while (currentNode != null) {

                if (currentNode.data == key) return true;

                currentNode = currentNode.next;
            }

            return false;
        }
    
        // Reverse the linked list
        public void reverse() {
            if (head == null) {
                System.out.println("list is empty");
                return;
            }

            // Implement logic here
            Node currentNode = head;
            Node previouNode = null;
            Node nextNode = null;
            while (currentNode != null) {
                nextNode = currentNode.next;
                currentNode.next = previouNode;
                previouNode = currentNode;
                currentNode = nextNode;
            }

            head = previouNode;
        }
    
        // Find the middle node
        public Node findMiddle() {
            // Implement logic here
            Node slowPointer = head;
            Node fastPointer = head;
            while (fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }

            return slowPointer;
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

        System.out.println("\nDeleting node at position 2:");
        list.deleteAtPosition(2);
        list.display();

        // // Search for an element
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

        // // Detect cycle (Initially, there should be no cycle)
        // System.out.println("\nChecking for cycle: " + list.hasCycle()); // Expected: false

        // // Creating two sorted lists for merging
        // SinglyLinkedList list1 = new SinglyLinkedList();
        // list1.insert(1);
        // list1.insert(3);
        // list1.insert(5);

        // SinglyLinkedList list2 = new SinglyLinkedList();
        // list2.insert(2);
        // list2.insert(4);
        // list2.insert(6);

        // System.out.println("\nMerging two sorted lists:");
        // SinglyLinkedList mergedList = new SinglyLinkedList();
        // mergedList.setHead(mergedList.mergeTwoLists(list1.getHead(), list2.getHead()));
        // mergedList.display(); // Expected: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL

        // // Remove Nth node from end
        // System.out.println("\nRemoving 2nd node from end:");
        // list.removeNthFromEnd(2);
        // list.display(); // Expected output after removing the correct node
    }
}

