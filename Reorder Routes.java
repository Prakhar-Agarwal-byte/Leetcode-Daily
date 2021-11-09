import java.util.*;

class Solution {
  int count = 0;

  public int minReorder(int n, int[][] connections) {
    ArrayList<ArrayList<Pair>> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new ArrayList<>());
    }
    for (int i = 0; i < connections.length; i++) {
      list.get(connections[i][0]).add(new Pair(connections[i][1], false));
      list.get(connections[i][1]).add(new Pair(connections[i][0], true));
    }
    boolean[] vis = new boolean[n];
    dfs(0, vis, list);
    return count;
  }

  private void dfs(int i, boolean[] vis, ArrayList<ArrayList<Pair>> list) {
    vis[i] = true;
    for (Pair e : list.get(i)) {
      if (!vis[e.node]) {
        if (!e.isFake)
          count++;
        dfs(e.node, vis, list);
      }
    }
  }
}

class Pair {
  int node;
  boolean isFake;

  Pair(int node, boolean isFake) {
    this.node = node;
    this.isFake = isFake;
  }
}
