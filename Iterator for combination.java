import java.util.*;

class CombinationIterator {
  int idx;
  List<String> list;

  public CombinationIterator(String characters, int combinationLength) {
    list = new ArrayList<String>();
    backtrack(0, characters, "", combinationLength, list);
  }

  private void backtrack(int start, String s, String temp, int n, List<String> list) {
    if (temp.length() >= n) {
      list.add(temp);
      return;
    }
    for (int i = start; i < s.length(); i++) {
      backtrack(i + 1, s, temp + s.charAt(i), n, list);
    }
  }

  public String next() {
    String val = list.get(idx);
    idx++;
    return val;
  }

  public boolean hasNext() {
    return idx < list.size();
  }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
