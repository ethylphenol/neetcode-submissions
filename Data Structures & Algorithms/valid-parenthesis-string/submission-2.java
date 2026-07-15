class Solution {
        public boolean checkValidString(String s) {
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='(')
                left.push(i);
            else if (c=='*')
                star.push(i);
            else {
                if (!left.isEmpty())
                    left.pop();
                else {
                    if (!star.isEmpty())
                        star.pop();
                    else return false;
                }
            }
        }
        while (!left.isEmpty()) {
            if (star.isEmpty()) return false;
            int starIndex = star.peek();
            int leftIndex = left.peek();
            if (starIndex > leftIndex) {
                star.pop();
                left.pop();
            } else {
                return false;
            }
        }
        return true;
    }
}
