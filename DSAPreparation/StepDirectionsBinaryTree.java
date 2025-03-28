package DSAPreparation;

public class StepDirectionsBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode findLCA(TreeNode root, int source, int dest) {
        if (root == null || root.val == source || root.val == dest) return root;

        TreeNode left = findLCA(root.left, source, dest);
        TreeNode right = findLCA(root.right, source, dest);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public boolean findPath(TreeNode root, int searchNode, StringBuilder sb) {
        if (root == null) return false;

        if (root.val == searchNode) return true;

        sb.append('L');
        if(findPath(root.left, searchNode, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);

        sb.append('R');
        if(findPath(root.right, searchNode, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);
        
        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        // find lca of source and destination nodes first
        TreeNode lca = findLCA(root, startValue, destValue);

        // find path from lca to source node
        StringBuilder pathToSource = new StringBuilder(); // gonna store path we took to reach src
        findPath(lca, startValue, pathToSource);

        // find path from lca to destination node
        StringBuilder pathToDest = new StringBuilder(); // gonna store path we took to reach dest
        findPath(lca, destValue, pathToDest);

        // retun the path we took from source to destination
        // note: lca to source should be reversed since we traverse upwards
        return "U".repeat(pathToSource.length()) + pathToDest.toString();
    }
}
