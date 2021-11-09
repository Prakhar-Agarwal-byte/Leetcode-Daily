class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int low = 1;
    int high = Integer.MAX_VALUE;
    while (low <high) {
      int mid = low + (high - low) / 2;
      int curH = 0;
      for (int i = 0; i < piles.length; i++) {
        curH += (int)Math.ceil((double)piles[i] / mid);
      }
      if (curH <= h) {
        high = mid;
      } else {
        low = mid+1;
      }
    }
    return low;
  }
}
