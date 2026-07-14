class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            int i = 0;
            int j = s.length() - 1;
            while (i < j) {
                while (!Character.isDigit(s.charAt(i)) && !Character.isAlphabetic(s.charAt(i))
                && i < j) {
                    i++;
                }
                while (!Character.isDigit(s.charAt(j)) && !Character.isAlphabetic(s.charAt(j))
                && i < j) {
                    j--;
                }
                if (s.charAt(i++) != s.charAt(j--)) {
                    return false;
                }
            }
            return true;
        }
}
