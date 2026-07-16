class Solution {
     public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> sums = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i+1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    // uvijek su sortirane tj. nums[i] < nums[left] < nums[right]
                    sums.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++; right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(sums);
    }
}

