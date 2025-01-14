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
}
