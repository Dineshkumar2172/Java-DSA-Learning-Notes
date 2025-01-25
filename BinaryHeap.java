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
        pq.insertNode(4);
        pq.insertNode(5);
        pq.insertNode(2);
        pq.insertNode(6);
        pq.insertNode(1);
        pq.insertNode(3);
        System.out.println(pq.size());
        System.out.println(pq.isEmpty());
        pq.printMaxHeap();
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
    public void insertNode(int data){
        if (n == heap.length - 1) { // checking if heap array size can store new incoming element
            // increase the size of queue to support addition of new 
            resize(2*heap.length);
        }

        n++; // increment n as we need new elements to keep track of array size
        heap[n] = data; // we store elements from left side of the tree and then order it to follow max heap rule
        swim(n); // check and re-arrange the order if newly inserted element breaks the max heap rule
    }

    // function to resize the heap array incase of the capacity of the array exceeds
    private void resize(int newsize){
        Integer[] temp = new Integer[newsize];
        for (int i = 0; i < heap.length; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }


    private void swim(int n){
        // n > 1                    - rule check and rearrangement will happen only if there are more than one element in the queue
        // heap[n/2] < heap[n]      - heap[n/2] will give index of the parent element, if it's less than the newly inserted element, then swap them
        //                            process will continue again comparing the swapped parent with its parent and so on till it reached root element
        //                            to make sure the queue is properly arranged following max heap rules
        while (n > 1 && heap[n/2] < heap[n]) {
            int temp = heap[n];
            heap[n] = heap[n/2];
            heap[n/2] = temp;
            n = n/2; // because we need to continue shifting up till new value inserted is at correct position
        }
    }


    /* Function to print Max Heap from left to right */
    public void printMaxHeap(){
        for (int i = 1; i <= size(); i++) {
            System.out.print(heap[i] + " --> ");
        }
        System.out.println();
    }


    /* TOP DOWN REHEAPIFY (SINK) IN MAX HEAP */
    //
    //  After deleting an element from heap. It may not satisfy heap properties, Thus, we perform top-down
    //  reheapify technique, in which we adjust the locations of elements to satisfy heap properties.
    //  deleteMax() - from max binary heap
    //  deleteMin() - from min binary heap
    public int deleteMax(){
        int max = heap[0]; 
        // STEP 1: store max element in a variable perform deleting it as we need to return it back
        // STEP 2: then swap the first element (max) and last element and then delete the last element (current position of max element)
        // STEP 3: perform top-down reheapify on the heap array to arrange the array properly
        // STEP 4: return max element saved in a variable
        return 0;
    }

}
