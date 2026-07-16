class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> out = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> map = new HashMap<>(); // val:index
            int target = -nums[i];
            int[] outL = new int[2];
            boolean found = false;
            // target je -4. arr = [-1,-3, -2,-2]
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (map.containsKey(target - nums[j])) {
                    outL = new int[]{map.get(target - nums[j]), j};
                    out.add(Arrays.asList(nums[i], nums[outL[0]], nums[outL[1]]).stream().sorted().toList());
                }
                map.put(nums[j], j);
            }
        }
        return new ArrayList<>(out);
    }
}

