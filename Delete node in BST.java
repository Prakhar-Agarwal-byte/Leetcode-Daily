class Solution {
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null)
      return null;
    if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else {
      if (root.left == null) {
        return root.right;
      }
      if (root.right == null) {
        return root.left;
      }
      root.val = minRight(root.right, key).val;
      root.right = deleteNode(root.right, root.val);
    }
    return root;
  }

  private TreeNode minRight(TreeNode root, int key) {
    TreeNode cur = root;
    while (cur.left != null) {
      cur = cur.left;
    }
    return cur;
  }
}
