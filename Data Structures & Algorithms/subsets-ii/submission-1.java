class Solution {
    public void subsetOrder(List<List<Integer>> subsets, List<Integer> curr, int pos, int[] nums) {
        if (pos >= nums.length) {
            subsets.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[pos]);
        subsetOrder(subsets, curr, pos + 1, nums);
        curr.removeLast();
        int nextPos = pos + 1;
        while (nextPos < nums.length && nums[nextPos] == nums[nextPos - 1]) nextPos++;
        subsetOrder(subsets, curr, nextPos, nums);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsetOrder(subsets, new ArrayList<>(), 0, nums);
        return subsets;
    }
}
