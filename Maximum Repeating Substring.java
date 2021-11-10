class Solution {
  public int maxRepeating(String sequence, String word) {
    StringBuilder sb = new StringBuilder(word);
    int max = 0;
    while (sequence.contains(sb)) {
      max++;
      sb.append(word);
    }
    return max;
  }
}
