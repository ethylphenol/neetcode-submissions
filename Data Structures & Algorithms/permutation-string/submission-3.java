class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        Map<Character, Integer> counterS1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            counterS1.put(c, counterS1.getOrDefault(c, 0)+1);
        }
        int left = 0;
        int right = s1.length() - 1;

        Map<Character, Integer> counterS2 = new HashMap<>();
        for (char c : s2.substring(0, right+1).toCharArray()) {
            counterS2.put(c, counterS2.getOrDefault(c, 0)+1);
        }

        while (true) {
            if (counterS2.equals(counterS1)) return true;
            else {
                counterS2.compute(s2.charAt(left), (key, val)->{
                   int newVal = val-1;
                   if (newVal == 0) return null;
                   return newVal;
                });
                if (right + 1 >= s2.length()) break;
                counterS2.compute(s2.charAt(right+1), (key, val)->{
                    if (val == null) return 1;
                    return val + 1;
                });
                right++;
                left++;
            }
        }

        return false;
    }
}
