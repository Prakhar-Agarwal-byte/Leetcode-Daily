class Solution {
  int sum = 0;

  public int sumNumbers(TreeNode root) {
    dfs(root, 0);
    return sum;
  }

  private void dfs(TreeNode root, int num) {
    if (root == null)
      return;
    int newNum = num * 10 + root.val;
    if (root.left == null && root.right == null) {
      sum += newNum;
    }
    dfs(root.left, newNum);
    dfs(root.right, newNum);
  }
}
