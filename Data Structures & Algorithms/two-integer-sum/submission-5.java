class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] out = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                out[0] = map.get(num);
                out[1] = i;
                break;
            }
            map.put(target-num, i);
        }
        return out;
    }
}
