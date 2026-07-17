class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        // ovo je O(n)
        for (int num : nums) {
            counter.merge(num, 1, Integer::sum);
        }
        // ovo je O(mlogm) -- sortiranje
        return counter.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getValue()+o2.getValue(); // padajuci
            }
        }).limit(k).mapToInt(e->e.getKey()).toArray();
        // ukupno O(nlogn) -- moze bolje
    }
}
