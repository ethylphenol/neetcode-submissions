class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> out = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i]+nums[j]+nums[k]==0) {
                        out.add(Arrays.asList(nums[i], nums[j], nums[k]).stream().sorted().toList());
                    }
                }
            }
        }
        return out.stream().toList();
    }
}
