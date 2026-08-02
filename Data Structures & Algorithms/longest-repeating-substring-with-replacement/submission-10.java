class Solution {
    public int characterReplacement(String s, int k) {
        int len = 0;
        int left = 0; int right = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int maxFreq = 1;
        freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0)+1);
        while (true) {
            int toBeReplaced = right-left + 1 - maxFreq; // []
            if (toBeReplaced <= k) {
                len = Math.max(right-left+1, len);
                right++;
                if (right >= s.length()) break;
                Integer prev = freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0)+1);
                // OPTIMIZACIJA: 
                // neka je winLen = right-left+1
                // winLen = maxFreq + k (ovako se postize maksimalni winLen)
                // u slucaju da se left++, dolazi do prihvacanja nevalidinih
                // prozora jer toBeReplaced bude manji nego sto treba ali taj winlen je manji...
                // u slucaju da se pronadje neki novi maxFreq veci od prethodnog onda ce se za eventualni maksimalan winLen vrijediti ponovno maxFreq + k.
                maxFreq = Math.max(maxFreq, prev==null?1:prev+1);
            } else {
                freq.put(s.charAt(left), freq.get(s.charAt(left))-1);
                left++;
            }
        }
        return len;
    }
}
