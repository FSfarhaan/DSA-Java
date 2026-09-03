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

public class PostOrder {

    static void traverse(TreeNode node, List<Integer> ans) {
        // Left, Right, Root
        if(node == null) return;
        traverse(node.left, ans);
        traverse(node.right, ans);

        ans.add(node.val);
    }

    static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        traverse(root, ans);    

        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);  
        
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);

        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        List<Integer> ans = postorderTraversal(root);

        for(int k: ans) {
            System.out.print(k + " ");
        }
    }
}
