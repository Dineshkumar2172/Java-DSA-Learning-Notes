public class BinaryTree {

    private static TreeNode root;

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;

        // constructor that initialized TreeNode with data taken fron user
        public TreeNode(int data){
            this.data = data;
        }   
    }

    public static void main(String[] args) {
        /*
         * What is a Tree?
         *      1. Its a non linear data structure used for storing data.
         *      2. It is made up of nodes and edges without having any cycle.
         *      3. Each node in a tree can point to n number of nodes in a tree.
         *  `   4. It is a way of representing hierarchical structure with a parent 
         *         node called as root and many levels of additional nodes.
         * 
         * 
         * What is a Binary Tree?
         *      1. A tree is called a Binary Tree, if each node has zero, one or two children.
         * 
         */

         BinaryTree binaryTree = new BinaryTree();
         binaryTree.createBinaryTree(); // create binary tree
         binaryTree.preOrderTraversal(root);
    }

    public void createBinaryTree(){
        TreeNode firstNode = new TreeNode(1);
        TreeNode secondNode = new TreeNode(2);
        TreeNode thirdNode = new TreeNode(3);
        TreeNode fourthNode = new TreeNode(4);
        TreeNode fifthNode = new TreeNode(5);
        TreeNode sixthNode = new TreeNode(6);
        TreeNode seventhNode = new TreeNode(7);
        
        
        root = firstNode;
        root.left = secondNode;
        root.right = thirdNode;
        // root.left.left = fourthNode;
        // root.left.right = fifthNode;
        // the above two lines can also be implemeneted in the following way
        secondNode.left = fourthNode; // we can directly update second node since it's already linked to root node
        secondNode.right = fifthNode;
        thirdNode.left = sixthNode;
        thirdNode.right = seventhNode;
    }

    // recursive pre-order traversal of a binary tree
    public void preOrderTraversal(TreeNode rootNode){
        /**
         * Pre order Binary Tree traversal
         *      1. Visit the root node.
         *      2. Traverse the left subtree in pre order fasion (root, left, right).
         *      3. Traverse the right subtree in pre order fasion (root, left, right).
         */
        if (rootNode == null) {
            return;
        }

        System.out.print(rootNode.data + ", ");
        preOrderTraversal(rootNode.left);
        preOrderTraversal(rootNode.right);
    }

    // recursive in-order traversal of a binary tree (left, root, right)
    public void inOrderTraversal(TreeNode rootNode){
        if (rootNode == null) {
            return;
        }

        inOrderTraversal(rootNode.left);
        System.out.print(rootNode.data);
        inOrderTraversal(rootNode.right);
    }

    // recursive post-order traversal of a binary tree (left, right, root)
    public void postOrderTraversal(TreeNode rootNode){
        if (rootNode == null) {
            return;
        }

        postOrderTraversal(rootNode.left);
        postOrderTraversal(rootNode.right);
        System.out.print(rootNode.data + ", ");   
    }

    // iterative pre-order traversal
    public void iterPreOrderTraversal(TreeNode rootNode){
        
    }
}
