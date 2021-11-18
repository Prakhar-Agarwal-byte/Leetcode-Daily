import java.util.*;

class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    for (int i = 1; i <= nums.length; i++) {
      int idx = Math.abs(nums[i - 1]);
      if (nums[idx - 1] > 0) {
        nums[idx - 1] = -1 * nums[idx - 1];
      }
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= nums.length; i++) {
      if (nums[i - 1] > 0) {
        list.add(i);
      }
    }
    return list;
  }
}
