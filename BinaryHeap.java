public class BinaryHeap {
    private Integer[] heap;
    private int n;

    public static void main(String[] args) {
        /**
         * 
         *  What is Prioroty Queue?
         *          Priority queue is a data structure that allows us to find minimum/maximum element among a collection
         *      of elements in constant time. It supports following operations -
         *          1. insert(key) - Insert a key into the priority queue
         *          2. deleteMax() / deleteMin() - return and remove largest / smallest key
         *          3. getMax() / getMin() = return largest / smallest key
         * 
         * 
         *  What is Binary Heap? - https://youtu.be/2ZLl8GAk1X4?t=77139
         *          The binary heap is a data structure that helps us in implementing priority queue operations efficiently.
         *      A binary heap is a complete binary tree (A complete binary tree is a type of binary tree where all levels are 
         *      filled, except possibly the last level, which is filled from left to right) in which each node value 
         *      is >= (or <=) than the value of its children.
         *          1. Max heap - when each parent node value is >= child node
         *          2. Min heap - when each parent node value is <= child node
         * 
         * 
         *  What is Complete Binary Tree? - https://youtu.be/2ZLl8GAk1X4?t=77321
         *          A complete binary tree is a binary tree where all levels are completely filled except last level and
         *      last level has nodes in such a way that left side is never empty.
         * 
         */


        /*
         * Representation of a Binary Heap - https://youtu.be/2ZLl8GAk1X4?t=77560
         *      1. Binary heaps usually are implemented using arrays.
         *      2. The first entry of array is taken as empty. (0th index would always be empty)
         *      3. As binary heaps are complete binary tree, the values are stored in array
         *         by traversing tree level by level from left to right.
         * 
         * binary heap representation in array = heap[] = [null, 9, 3, 6, 2, 1, 5, 4]
         * 
         * Formular for finding children:
         *      Children of 1st index = 2, 3
         *      Children of 2nd index = 4, 5
         *      Children of 3rd index = 6, 7
         *      Children of kth index = 2*k, 2*k + !
         * 
         * Formula for finding parent:
         *      Parent of 7th index = 3
         *      Parent of 6th index = 3
         *      Parent of 5th index = 2
         *      Parent of kth index = k//2
         */

        // max binary heap implementation - https://youtu.be/2ZLl8GAk1X4?t=78253
        //      1. A max heap is a complete binary tree in which each node value is >= than the values of its children.
        //      2. The maximum value is at the top which is root of complete binary tree. For its array representation its at index 1 i.e. heap[1]
        BinaryHeap pq = new BinaryHeap(3);
        System.out.println(pq.size());
        System.out.println(pq.isEmpty());

    }

    public BinaryHeap(int capacity){
    // constructor takes initial capacity of the heap
        heap = new Integer[capacity + 1]; // initialising heap with capacity+1 since heap always starts with empty array
        n = 0;
    }

    public boolean isEmpty(){
        // returns if heap is empty or not
        return n == 0;
    }

    public int size(){
        // returns the size of max priority queue
        return n;
    }


    /**
     *      Bottom-up Reheapify Max  - https://youtu.be/2ZLl8GAk1X4?t=79027
     *  1. A max heap is a complete binary tree in which each node value is >= than the values of its children.
     *  2. After inserting an element into heap. It may not satisfy above heap property. Thus, we perform bottom-up reheapify
     *     technique, in which we adjust the locations of elements to satisfy heap property.
     */

}
