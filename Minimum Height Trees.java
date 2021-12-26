import java.util.*;

class Solution {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<Integer> res = new ArrayList<>();
    if (n == 1) {
      res.add(0);
      return res;
    }
    int[] inorder = new int[n];
    LinkedList<Integer>[] adj = new LinkedList[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new LinkedList<>();
    }
    for (int i = 0; i < edges.length; i++) {
      adj[edges[i][0]].add(edges[i][1]);
      adj[edges[i][1]].add(edges[i][0]);
      inorder[edges[i][0]]++;
      inorder[edges[i][1]]++;
    }
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (inorder[i] == 1) {
        q.add(i);
      }
    }

    while (n > 2) {
      int size = q.size();
      n -= size;
      for (int i = 0; i < size; i++) {
        int cur = q.poll();
        for (int e : adj[cur]) {
          inorder[e]--;
          inorder[cur]--;
          if (inorder[e] == 1) {
            q.add(e);
          }
        }
      }
    }
    res.addAll(q);
    return res;
  }
}
