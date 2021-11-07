class Solution {
  public int[] singleNumber(int[] nums) {
    int xor = 0;
    for (int i = 0; i < nums.length; i++) {
      xor ^= nums[i];
    }
    int pos = 0;
    while (true) {
      int isOne = (xor & (1 << pos));
      if (isOne != 0) {
        break;
      }
      pos++;
    }
    int num1 = 0;
    for (int i = 0; i < nums.length; i++) {
      if ((nums[i] & (1 << pos)) != 0) {
        num1 ^= nums[i];
      }
    }
    int num2 = xor ^ num1;
    return new int[] { num1, num2 };
  }
}
