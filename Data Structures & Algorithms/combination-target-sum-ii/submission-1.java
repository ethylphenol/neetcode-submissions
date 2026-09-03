class Solution {
        private void dfsSum2(int[] candidates, int target, List<List<Integer>> combinations, List<Integer> combination, int sum, int start) {
        if (sum == target) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if (sum > target) return;
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue; //
            combination.add(candidates[i]);
            dfsSum2(candidates, target, combinations, combination, sum + candidates[i], i + 1);
            combination.removeLast();
        }
    }

    // 1 2 2 4 5 6 9
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        dfsSum2(candidates, target, combinations, new ArrayList<>(), 0, 0);
        return combinations;
    }
}
