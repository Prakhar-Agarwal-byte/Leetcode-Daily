import java.util.*;

class Solution {
  int preIdx;
  HashMap<Integer, Integer> map;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return dfs(preorder, inorder, 0, preorder.length - 1);
  }

  private TreeNode dfs(int[] preorder, int[] inorder, int start, int end) {
    if (preIdx >= preorder.length || start > end) {
      return null;
    }
    int idx = map.get(preorder[preIdx]);
    TreeNode node = new TreeNode(preorder[preIdx++]);
    node.left = dfs(preorder, inorder, start, idx - 1);
    node.right = dfs(preorder, inorder, idx + 1, end);
    return node;
  }
}
