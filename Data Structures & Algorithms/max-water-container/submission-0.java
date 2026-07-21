class Solution {
    public int maxArea(int[] heights) {
        // O(n) time and O(1) space,
        // brute force je nC2
        int maxVol = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i+1; j < heights.length; j++) {
                int vol = (j-i) * Math.min(heights[i],heights[j]);
                if (maxVol < vol) maxVol = vol;
            }
        }
        return maxVol;
    }
}
