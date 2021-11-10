class Solution {
  public int findKthPositive(int[] arr, int k) {
    for (int i = 1, idx = 0; i <= 2000; i++) {
      if (idx < arr.length) {
        if (arr[idx] != i) {
          k--;
        } else {
          idx++;
        }
      } else {
        k--;
      }
      if (k == 0)
        return i;
    }
    return -1;
  }
}
