import java.util.*;

class Solution {
  public boolean isCousins(TreeNode root, int x, int y) {
    Pair X = null;
    Pair Y = null;
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(root, null));
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Pair cur = q.remove();
        if (cur.node.val == x) {
          X = cur;
          if (Y != null && Y.parent != X.parent) {
            return true;
          }
        }
        if (cur.node.val == y) {
          Y = cur;
          if (X != null && Y.parent != X.parent) {
            return true;
          }
        }
        if (cur.node.left != null) {
            q.add(new Pair(cur.node.left, cur.node));
        }
        if (cur.node.right != null) {
            q.add(new Pair(cur.node.right, cur.node));
        }  
      }
      X = null;
      Y = null;
    }
    return false;
  }
}

class Pair {
  TreeNode node;
  TreeNode parent;

  Pair(TreeNode node, TreeNode parent) {
    this.node = node;
    this.parent = parent;
  }
}
