class Solution {
  public int monotoneIncreasingDigits(int n) {
    StringBuilder sb = new StringBuilder(String.valueOf(n));
    int idx = sb.length();
    for (int i = sb.length() - 1; i > 0; i--) {
      if (sb.charAt(i) < sb.charAt(i - 1)) {
        idx = i;
        sb.setCharAt(i - 1, (char) (sb.charAt(i - 1) - 1));
      }
    }
    for (int i = idx; i < sb.length(); i++) {
      sb.setCharAt(i, '9');
    }
    return Integer.parseInt(sb.toString());
  }
}
