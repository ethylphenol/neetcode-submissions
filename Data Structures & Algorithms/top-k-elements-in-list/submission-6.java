class Solution {
public int[] topKFrequent(int[] nums, int k) {
        // ans je uvijek unique tj buckete imamo
        //
        Map<Integer, Integer> counter = new HashMap<>();
        // ovo je O(n)
        for (int num : nums) {
            counter.merge(num, 1, Integer::sum);
        }
        // O(n)
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for (Map.Entry<Integer, Integer> e : counter.entrySet()) {
            if (buckets[e.getValue()]==null) {
                buckets[e.getValue()] = new ArrayList<Integer>();
            }
            buckets[e.getValue()].add(e.getKey());
        }
        int[] topK = new int[k];
        int j = 0;
        int cnt = k;
        for (int i = buckets.length-1; i >= 0 && cnt!=0; i--) {
            if (buckets[i]==null) continue;
            for (Integer el:buckets[i]) {
                topK[j++] = el;
                cnt--;
                if (cnt==0) break;
            }
        }
        return topK;
    }
}
