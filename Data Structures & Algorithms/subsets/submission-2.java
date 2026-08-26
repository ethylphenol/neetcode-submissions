class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subset(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    public void subset(int[] nums, int i, List<Integer> l, List<List<Integer>> subsets) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[i]);
        subset(nums, i + 1, l, subsets);
        l.remove(l.size()-1);
        subset(nums, i + 1, l, subsets);
    }
}
