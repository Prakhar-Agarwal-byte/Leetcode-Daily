import java.util.*;

class Solution {
  public int minOperations(int[][] grid, int x) {
    int n = grid.length, m = grid[0].length;
    int rem = grid[0][0] % x;
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] % x != rem)
          return -1;
        list.add(grid[i][j]);
      }
    }
    Collections.sort(list);
    int num = m * n;
    int mid = num / 2;
    int number = list.get(mid);
    int moves = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        moves += Math.abs(number - grid[i][j]) / x;
      }
    }
    return moves;
  }
}
