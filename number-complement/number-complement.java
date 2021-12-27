class Solution {
  public int findComplement(int num) {
    String s = Integer.toString(num, 2);
    StringBuilder sb = new StringBuilder();
    for (char ch: s.toCharArray()) {
      if (ch == '0') {
        sb.append('1');
      } else {
        sb.append('0');
      }
    }
    return Integer.parseInt(sb.toString(), 2);
  }
}