class Solution {
  int countPaths = 0;

  public int uniquePathsIII(int[][] grid) {
    int emptyCells = 0;
    Pair startIdx = null;
    Pair endIdx = null;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0)
          emptyCells++;
        if (grid[i][j] == 1)
          startIdx = new Pair(i, j);
        if (grid[i][j] == 2)
          endIdx = new Pair(i, j);
      }
    }
    dfs(startIdx.i, startIdx.j, endIdx, emptyCells, grid);
    return countPaths;
  }

  private void dfs(int i, int j, Pair endIdx, int emptyCells, int[][] grid) {
    if (i == endIdx.i && j == endIdx.j && emptyCells == -1) {
      countPaths++;
      return;
    }
    int temp = grid[i][j];
    grid[i][j] = -1;
    int[] rM = { -1, 0, 1, 0 };
    int[] cM = { 0, 1, 0, -1 };
    for (int k = 0; k < 4; k++) {
      int ii = i + rM[k];
      int jj = j + cM[k];
      if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length && grid[ii][jj] != -1) {
        dfs(ii, jj, endIdx, emptyCells - 1, grid);
      }
    }
    grid[i][j] = temp;
  }

}

class Pair {
  int i;
  int j;

  Pair(int i, int j) {
    this.i = i;
    this.j = j;
  }
}
