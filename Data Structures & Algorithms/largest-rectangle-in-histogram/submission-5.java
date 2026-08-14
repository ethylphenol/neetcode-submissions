class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;

        //larger rectangle in
        int[] smallerRectangleAfter = new int[heights.length];
        int[] smallerRectangleBefore = new int[heights.length];
        Deque<Integer> toBeProcessed = new ArrayDeque<>();
        // rastuci stog moramo
        for (int i = 0; i < heights.length; i++) {
            while (!toBeProcessed.isEmpty() && heights[toBeProcessed.peek()] > heights[i]) {
                int idx = toBeProcessed.pop();
                smallerRectangleAfter[idx] = i - idx;
            }
            toBeProcessed.push(i);
        }
        toBeProcessed = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!toBeProcessed.isEmpty() && heights[toBeProcessed.peek()] > heights[i]) {
                int idx = toBeProcessed.pop();
                smallerRectangleBefore[idx] = idx - i;
            }
            toBeProcessed.push(i);
        }
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int cnt = 0;
            int after = smallerRectangleAfter[i] == 0 ? heights.length - 1 - i : smallerRectangleAfter[i] - 1;
            int before = smallerRectangleBefore[i] == 0 ? i : smallerRectangleBefore[i] - 1;
            max = Math.max(h * (after + before + 1), max);
        }
        return max;
    }
}
