import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

         System.out.print("pre order recursive traversal : ");
         binaryTree.preOrderTraversal(root);
         System.out.println();

         System.out.print("pre order iterative traversal : ");
         binaryTree.iterPreOrderTraversal(root);
         System.out.println();

         System.out.print("in order recursive traversal : ");
         binaryTree.inOrderTraversal(root);
         System.out.println();

         System.out.print("in order iterative traversal : ");
         binaryTree.iterInOrderTraversal(root);
         System.out.println();

         System.out.print("post order iterative traversal : ");
         binaryTree.postOrderTraversal(root);
         System.out.println();

         System.out.print("post order iterative traversal : ");
         binaryTree.iterPostOrderTraversal(root);
         System.out.println();

         System.out.print("level order traversal : ");
         binaryTree.levelOrderTraversal(root);
         System.out.println();

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
        System.out.print(rootNode.data + ", ");
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

    // iterative pre-order binary tree traversa; implementation
    public void iterPreOrderTraversal(TreeNode rootNode){
        if (rootNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(rootNode);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data + ", ");
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    // iterative in-order binary tree traversa; implementation
    public void iterInOrderTraversal(TreeNode rootNode){
        if (rootNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
           if (temp != null) {
                stack.push(temp);
                temp = temp.left;
           } else {
                temp = stack.pop();
                System.out.print(temp.data + ", ");
                temp = temp.right;
           }
        }
    }

    // iterative post-order binary tree traversa; implementation
    public void iterPostOrderTraversal(TreeNode rootNode){
        if (rootNode == null) {
            return;
        }
        
        TreeNode current = rootNode;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null | !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null ) {
                    temp = stack.pop();
                    System.out.print(temp.data + ", ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data + ", ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

    public void levelOrderTraversal(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }

        Queue<TreeNode> queue =  new LinkedList<>();
        queue.offer(rootNode);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + ", ");
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }


    public int findMax(TreeNode rootNode) {
        if (rootNode == null) {
            return Integer.MIN_VALUE;
        }
        
        int result = rootNode.data;
        int left = findMax(rootNode.left);
        int right = findMax(rootNode.right);
        if (left > result) {
            result = left;
        }
        if (right > result) {
            result = right;
        }
        
        return result;
    }
}
