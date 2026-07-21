class Solution {
    public int trap(int[] height) {
        int vol = 0;
        int max = Arrays.stream(height).max().getAsInt();
        for (int i = 0; i < max; i++) {
            // layer i
            int[] layer = new int[height.length];
            int cnt = 0;
            for (int j = 0; j < height.length; j++) {
                if (height[j] > 0) {
                    layer[j] = 1;
                    cnt++;
                    height[j]--;
                } else {
                    layer[j] = 0;
                }
            }
            if (cnt <= 1) break;
            // layer = [0101101111]
            int left = 0;
            int right = layer.length - 1;
            while (layer[left] == 0) left++;
            while (layer[right] == 0) right--;
            for (int j = left; j <= right; j++) {
                if (layer[j]==0) vol++;
            }
        }
        return vol;
    }
}
