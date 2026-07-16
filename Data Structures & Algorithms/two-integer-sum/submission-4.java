class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] out = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer prev = map.put(target-num, i);
            if (prev!=null) {
                out[0] = prev;
                out[1] = i;
                break;
            }
            if (map.containsKey(num)) {
                out[0] = map.get(num);
                out[1] = i;
                if (out[0]!=out[1])
                    break;
            }
            System.out.println(i+""+map+""+prev);
        }
        return out;
    }
}
