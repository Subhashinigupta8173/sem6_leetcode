/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ll = new LinkedList<>();

        if (root == null) {
            return ll;
        }

        ll.addAll(inorderTraversal(root.left));
        ll.add(root.val);
        ll.addAll(inorderTraversal(root.right));

        return ll;
       
    }
}