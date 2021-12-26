class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
      int n = colsum.length;
      List<List<Integer>> ans = new ArrayList<>();
      int[][] res = new int[2][n];
      for (int i = 0; i < n; i++) {
        if (colsum[i] == 0) {
          res[0][i] = 0;
          res[1][i] = 0;
        } else if (colsum[i] == 2) {
          res[0][i] = 1;
          res[1][i] = 1;
          upper--;
          lower--;
        } else {
          if (upper >= lower) {
            res[0][i] = 1;
            res[1][i] = 0;
            upper--;
          } else {
            res[0][i] = 0;
            res[1][i] = 1;
            lower--;
          }
        }
      }
      if (upper != 0 || lower != 0) return ans;
      for (int i = 0; i < 2; i ++) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int j = 0; j < n; j++) {
          temp.add(res[i][j]);
        }
        ans.add(temp);
      }
      return ans;
    }
}