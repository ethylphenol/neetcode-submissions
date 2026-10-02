class Solution {
    private void dfsLetter(Map<Integer, List<String>> mapping, String digits, int k, List<String> combinations, StringBuilder combination) {
        if (k == digits.length()) {
            combinations.add(combination.toString());
            return;
        }
        int digit = digits.charAt(k) - '0';
        for (String letter : mapping.get(digit)) {
            combination.append(letter);
            dfsLetter(mapping, digits, k + 1, combinations, combination);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        List<String> combinations = new ArrayList<>();
        Map<Integer, List<String>> mapping = new HashMap<>();
        mapping.put(2, Arrays.asList("a", "b", "c"));
        mapping.put(3, Arrays.asList("d", "e", "f"));
        mapping.put(4, Arrays.asList("g", "h", "i"));
        mapping.put(5, Arrays.asList("j", "k", "l"));
        mapping.put(6, Arrays.asList("m", "n", "o"));
        mapping.put(7, Arrays.asList("p", "q", "r", "s"));
        mapping.put(8, Arrays.asList("t", "u", "v"));
        mapping.put(9, Arrays.asList("w", "x", "y", "z"));
        dfsLetter(mapping, digits, 0, combinations, new StringBuilder());
        return combinations;
    }
}
