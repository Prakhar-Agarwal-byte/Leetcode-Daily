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
  HashMap<TreeNode, Integer> dp = new HashMap<>();
  public int rob(TreeNode root) {
    if (root == null)
      return 0;
    if (dp.containsKey(root)) return dp.get(root);
    int l1 = 0;
    int l2 = 0;
    int r1 = 0;
    int r2 = 0;
    if (root.left != null) {
      l1 = rob(root.left.left);
      l2 = rob(root.left.right);
    }
    if (root.right != null) {
      r1 = rob(root.right.left);
      r2 = rob(root.right.right);
    }
    dp.put(root, Math.max(root.val+l1+l2+r1+r2, rob(root.left) + rob(root.right)));
    return dp.get(root);
  }
}
