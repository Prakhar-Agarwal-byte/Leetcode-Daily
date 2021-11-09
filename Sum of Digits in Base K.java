class Solution {
  public int sumBase(int n, int k) {
    String s = Integer.toString(n, k);
    int sum = 0;
    for (char ch : s.toCharArray()) {
      sum += (ch - '0');
    }
    return sum;
  }
}
