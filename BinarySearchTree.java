public class BinarySearchTree {

    private static TreeNode root;

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        /**
         * 1. It is a type of Binary Tree in which data is organised in an ordered manner which helps
         *    in faster search and insertion of data. It satisfies following properties -
         * 2. The left subtree of a node contains only nodes with values lesser than the node's value.
         * 3. The right subtree of a node contains only nodes with values greater than the node's value.
         * 4. The left and right subtree each must also be a binary search tree.
         */
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.createBinarySearchNode(10);
        binarySearchTree.insertNode(root, 20);
        binarySearchTree.insertNode(root, 7);
        binarySearchTree.insertNode(root, 9);
        binarySearchTree.insertNode(root, 6);
        binarySearchTree.traverseBST(root);
        System.out.println();
        TreeNode result = binarySearchTree.search(root, 10);
        System.out.println(result.data);
        System.out.println("Is this valid binary search tree : " + binarySearchTree.validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }

 
    public void createBinarySearchNode(int data) {
        TreeNode rootNode = new TreeNode(data);
        root = rootNode;
    }


    public void traverseBST(TreeNode root){
        if (root == null) {
            return;
        }

        System.out.print(root.data + " --> ");
        traverseBST(root.left);
        traverseBST(root.right);
    }


    // In BST insertion always happens at the leaf node - it won't rearrange the tree during insertion
    // If it involves handling of duplicates values being inserted as node, best way is to maintain them as count keys in each node
    public TreeNode insertNode(TreeNode root, int data) {
        if (root == null) {
            // create new node with the user data and return it
            return new TreeNode(data);
        }

        // travese to left node if data is smaller and right node if its larger
        if (data < root.data) {
            // we call the same function but with next left node as root if data is smaller
            // update the left node of last leaf node if data is smaller
            root.left = insertNode(root.left, data);
        } else {
            // we call the function recursively with next right node as root
            // if the data is larger than the right node
            root.right = insertNode(root.right, data);
        }

        return root;        
    }


    // Function to search for an user input key
    public TreeNode search(TreeNode root, int key){
        if (root == null || root.data == key) {
            return root;
        }

        // if search key is less than current root key
        if (key < root.data) {
            // pass left node again inside recursive by ignoring right section
            return search(root.left, key);
        } else {
            // else pass right subtree as an input to the recursive function
            return search(root.right, key);
        }
    }


    // Given the root of a binary search tree, determine if it is a valid binary search tree
    // A valid BST is defined as follows:
    //      1. The left subtree of a node contains only nodes with keys less than the node's key
    //      2. The right subtree of a node contains only nodes with keys greater than the node's key
    //      3. Both the left and right subtree must also be a binary search trees.
    // for reference - https://youtu.be/2ZLl8GAk1X4?t=72020
    public Boolean validateBST(TreeNode root, long min, long max){
        // Use two set of values min and max to validate the tree
        //      1. If you go towards left subtree in remains same & max changes to parent value
        //      2. If you go towards right subtree max remains same & min changes to parent value
        if (root == null) { // base case
            return true;
        }

        if (root.data <= min || root.data >=  max) {
            return false;
        }

        boolean left = validateBST(root.left, min, root.data);
        if (left) {
            boolean right = validateBST(root.right, root.data, max);
            return right;
        }

        return false;
    }
}
