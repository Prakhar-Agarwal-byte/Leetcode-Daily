class Solution {
  public String removeOccurrences(String s, String part) {
    while (true) {
      if (!s.contains(part))
        return s;
      s = s.replaceFirst(part, "");
    }
  }
}
