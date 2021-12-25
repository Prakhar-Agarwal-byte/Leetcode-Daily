class Solution {
  HashMap<Integer, Boolean> map = new HashMap<>();
  public boolean canReach(int[] arr, int i) {
    if (i < 0 || i >= arr.length)
      return false;
    if (map.containsKey(i)) {
      return false;
    }
    if (arr[i] == 0)
      return true;
    map.put(i, true);
    return canReach(arr, i + arr[i]) || canReach(arr, i - arr[i]);
  }
}
