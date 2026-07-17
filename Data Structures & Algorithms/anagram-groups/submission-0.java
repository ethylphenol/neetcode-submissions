class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (groups.isEmpty()) {
                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                groups.add(group);
            } else {
                boolean unique = true;
                for (int j = 0; j < groups.size(); j++) {
                    String represent = groups.get(j).getFirst();
                    if (isAnagram(represent, strs[i])) {
                        groups.get(j).add(strs[i]);
                        unique = false;
                        break;
                    }
                }
                if (unique) {
                    List<String> group = new ArrayList<>();
                    group.add(strs[i]);
                    groups.add(group);
                }
            }
        }
        return groups;
    }
    public boolean isAnagram (String str1, String str2) {
        if (str1.length()!=str2.length()) return false;
        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            count1.merge(str1.charAt(i), 1, (oldVal, newVal)->oldVal+newVal);
            count2.compute(str2.charAt(i), ((character, integer) -> {
                if (integer==null) {
                    return 1;
                } else {
                    return integer + 1;
                }
            }));
        }
        return count1.equals(count2);
    }
}
