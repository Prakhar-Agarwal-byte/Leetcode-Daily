class Solution {
  public void sortColors(int[] nums) {
    int low = 0, mid = 0, high = nums.length - 1;
    while (mid <= high) {
      switch (nums[mid]) {
      case 0:
        swap(low, mid, nums);
        low++;
        mid++;
        break;
      case 1:
        mid++;
        break;
      case 2:
        swap(mid, high, nums);
        high--;
        break;
      }
    }
  }

  private void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
