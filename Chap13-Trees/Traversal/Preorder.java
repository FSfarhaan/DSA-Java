import java.util.ArrayList;
import java.util.List;

class TreeNode {
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

public class Preorder {

    static void traverse(TreeNode node, List<Integer> ans) {
        // Pre order -> Root Left Right
        if(node == null) return;

        ans.add(node.val);
        traverse(node.left, ans);
        traverse(node.right, ans);
    }

    static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        traverse(root, ans);

        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> ans = preorderTraversal(root);

        for(int it: ans) {
            System.out.print(it + " ");
        }
    }
}
