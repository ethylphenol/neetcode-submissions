class Solution {
    public int search(int[] nums, int target) {
        int begin = 0, end = nums.length-1;
        while(begin<=end) {
            int half = (end+begin+1)/2;
            // [begin, half]; <half, end]
            if (nums[half] > target) {
                end = half - 1;
            } else if (nums[half] < target) {
                begin = half + 1;
            } else {
                return half;
            }
        }
        return -1;
    }
}
