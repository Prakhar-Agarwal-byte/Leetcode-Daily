import java.util.*;

class Solution {

  int[] oldNums;
  int[] shuffledNums;

  public Solution(int[] nums) {
    oldNums = Arrays.copyOf(nums, nums.length);
    shuffledNums = Arrays.copyOf(nums, nums.length);
  }

  public int[] reset() {
    shuffledNums = Arrays.copyOf(oldNums, oldNums.length);
    ;
    return shuffledNums;
  }

  public int[] shuffle() {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < shuffledNums.length; i++) {
      list.add(i, shuffledNums[i]);
    }
    Collections.shuffle(list);
    for (int i = 0; i < shuffledNums.length; i++) {
      shuffledNums[i] = list.get(i);
    }
    return shuffledNums;
  }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
 * obj.shuffle();
 */
