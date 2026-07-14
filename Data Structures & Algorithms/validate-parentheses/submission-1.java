class Solution {
    public boolean isValid(String s) {
        // { [] (()) }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            System.out.println(i+ " ,char:"+ c + " ,stack: "+stack);
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty())
                    return false;
                char opening = stack.peek();
                if (opening == '(' && c == ')'
                || opening == '[' && c == ']' ||
                opening == '{' && c=='}') {
                    stack.pop();
                } else {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
