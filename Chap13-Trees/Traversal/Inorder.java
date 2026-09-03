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

public class Inorder {

    static void traverse(TreeNode node, List<Integer> ans) {
        // Left, root, right
        if(node == null) return;
        traverse(node.left, ans);
        ans.add(node.val);
        traverse(node.right, ans);
    }
    
    static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        traverse(root, ans);

        return ans;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);


        List<Integer> ans = inorderTraversal(root);

        for(int k: ans) {
            System.out.print(k + " ");
        }
    }
}