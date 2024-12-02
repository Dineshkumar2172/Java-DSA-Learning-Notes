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
        System.out.println(root.data);
        
    }


    public void createBinarySearchNode(int data) {
        TreeNode rootNode = new TreeNode(data);
        root = rootNode;
    }
}
