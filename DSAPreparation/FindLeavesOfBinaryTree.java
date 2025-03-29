package DSAPreparation;
import java.util.*;



public class FindLeavesOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        FindLeavesOfBinaryTree solution = new FindLeavesOfBinaryTree();

        // Test Case 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println("Test Case 1 Output: " + solution.findLeaves(root1));

        // Test Case 2: Left Skewed Tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        System.out.println("Test Case 2 Output: " + solution.findLeaves(root2));

        // Test Case 3: Right Skewed Tree
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.right = new TreeNode(3);
        root3.right.right.right = new TreeNode(4);
        System.out.println("Test Case 3 Output: " + solution.findLeaves(root3));

        // Test Case 4: Single Node Tree
        TreeNode root4 = new TreeNode(1);
        System.out.println("Test Case 4 Output: " + solution.findLeaves(root4));

        // Test Case 5: Complete Binary Tree
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(3);
        root5.left.left = new TreeNode(4);
        root5.left.right = new TreeNode(5);
        root5.right.left = new TreeNode(6);
        root5.right.right = new TreeNode(7);
        System.out.println("Test Case 5 Output: " + solution.findLeaves(root5));
    }

    public void preOrderTraversal(TreeNode root, TreeNode parent, List<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            if (parent.left == root) parent.left = null;
            if (parent.right == root) parent.right = null;
            return;
        }

        preOrderTraversal(root.left, root, res);
        preOrderTraversal(root.right, root, res);
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return null;
        
        while (root != null) {
            List<Integer> localList = new ArrayList<>();
            preOrderTraversal(root, new TreeNode(0), localList);
            result.add(localList);
        }

        return result;
    }

}
