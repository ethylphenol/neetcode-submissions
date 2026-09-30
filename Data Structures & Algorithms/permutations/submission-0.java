class Solution {
    public void dfsPermute(List<List<Integer>> permutations, List<Integer> curr, Set<Integer> count, int[] nums) {
        if (curr.size() == nums.length) {
            permutations.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!count.contains(nums[i])) {
                curr.add(nums[i]);
                count.add(nums[i]);
                dfsPermute(permutations, curr, count, nums);
                count.remove(curr.getLast());
                curr.removeLast();
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        dfsPermute(permutations, new ArrayList<>(), new HashSet<>(), nums);
        return permutations;
    }
}
