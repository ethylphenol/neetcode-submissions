class Solution {
    // You should aim for a solution with O(m * n) time and O(m) space, where m is the number of strings and n is the length of the longest string.
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            String str = strs[i];
            groups.putIfAbsent(sortedStr, new ArrayList<>());
            groups.get(sortedStr).add(str);
        }
        return new ArrayList<>(groups.values());
    }
}
