class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int left = 0; int right = 0;
        Set<Character> unique = new HashSet<>();
        while (right < s.length()) {
            if (unique.add(s.charAt(right))) {
                right++;
            } else {
                unique.remove(s.charAt(left));
                left++;
            }
            len = Math.max(len, right-left);
            // System.out.println(len + " " + s.substring(left, right));
        }
        return len;
    }
}
