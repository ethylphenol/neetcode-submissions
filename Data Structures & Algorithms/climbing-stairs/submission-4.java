class Solution {
    public int climbStairs(int n) {
        // F(n) = F(n-1) + F(n-2)
        if (n == 2) return 2;
        if (n == 1) return 1;
        Map<Integer, Integer> memory = new HashMap<>();
        memory.put(1, 1);
        memory.put(2, 2);
        return memoStairs(n, memory);
    }

    private int memoStairs(int n, Map<Integer, Integer> memory) {
        if (memory.containsKey(n)) return memory.get(n);
        int fn_1 = memoStairs(n - 1, memory);
        int fn_2 = memoStairs(n - 2, memory);
        memory.put(n, fn_1 + fn_2);
        return fn_1 + fn_2;
    }
}
