class Solution {
    public int characterReplacement(String s, int k) {
        int len = 0;
        // 5x 5y --> 4x 5y
        // 6x 5y --> 5x 5y
        // 7x 5y --> 6x 5y
        int left = 0; int right = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0)+1);

        while (true) {
            maxFreq = freq.values().stream().mapToInt(Integer::intValue).max().orElseGet(()->0);
            int toBeReplaced = right-left + 1 - maxFreq; // []
            if (toBeReplaced <= k) {
                len = Math.max(right-left+1, len);
               // System.out.println(len + s.substring(left, right+1));
                right++;
                if (right >= s.length()) break;
                Integer prev = freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0)+1);
            } else {
                freq.put(s.charAt(left), freq.get(s.charAt(left))-1);
                left++;
            }
        }
        return len;
    }
}
