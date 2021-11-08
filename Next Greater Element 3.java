import java.util.*;

class Solution {
  public int nextGreaterElement(int n) {
    ArrayList<Integer> list = new ArrayList<>();
    while (n > 0) {
      int dig = n % 10;
      list.add(0, dig);
      n /= 10;
    }
    boolean good = false;
    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i) < list.get(i + 1))
        good = true;
    }
    if (!good)
      return -1;
    int idx = 0;
    for (int i = list.size() - 2; i >= 0; i--) {
      if (list.get(i) < list.get(i + 1)) {
        idx = i;
        break;
      }
    }
    for (int i = list.size() - 1; i >= 0; i--) {
      if (list.get(i) > list.get(idx)) {
        swap(i, idx, list);
        break;
      }
    }
    reverse(idx + 1, list.size() - 1, list);
    long num = 0;
    for (int e : list) {
      num = num * 10 + e;
    }
    if (num > Integer.MAX_VALUE)
      return -1;
    return (int) num;
  }

  private void reverse(int i, int j, ArrayList<Integer> list) {
    while (i < j) {
      swap(i, j, list);
      i++;
      j--;
    }
  }

  private void swap(int i, int idx, ArrayList<Integer> list) {
    int temp = list.get(i);
    list.set(i, list.get(idx));
    list.set(idx, temp);
  }
}
