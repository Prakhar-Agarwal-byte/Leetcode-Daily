class Solution {
  public int singleNonDuplicate(int[] nums) {
    int low = 0, high = nums.length - 1;
    int ans = 0;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if ((mid > 0 && mid % 2 != 0 && nums[mid - 1] == nums[mid]) || (mid < nums.length - 1 && mid % 2 == 0 && nums[mid] == nums[mid+1])) {
        low = mid + 1;
      } else {
        ans = mid;
        high = mid - 1;
      }
    }
    return nums[ans];
  }
}
