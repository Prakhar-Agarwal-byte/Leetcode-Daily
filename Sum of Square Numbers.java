class Solution {
  public boolean judgeSquareSum(int c) {
    long i = 0;
    long j = (long) Math.sqrt(c);
    while (i <= j) {
      long val = i * i + j * j;
      if (val == c)
        return true;
      if (val < c) {
        i++;
      }
      if (val > c) {
        j--;
      }
    }
    return false;
  }
}
