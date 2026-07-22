class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (String token : tokens) {
            int op1, op2;
            switch (token) {
                case "+":
                    op2 = Integer.parseInt(stack.pop());
                    op1 = Integer.parseInt(stack.pop());
                    stack.push(Integer.toString(op1+op2));
                    break;
                case "-":
                    op2 = Integer.parseInt(stack.pop());
                    op1 = Integer.parseInt(stack.pop());
                    stack.push(Integer.toString(op1-op2));
                    break;
                case "*":
                    op2 = Integer.parseInt(stack.pop());
                    op1 = Integer.parseInt(stack.pop());
                    stack.push(Integer.toString(op1*op2));
                    break;
                case "/":
                    op2 = Integer.parseInt(stack.pop());
                    op1 = Integer.parseInt(stack.pop());
                    stack.push(Integer.toString(op1/op2));
                    break;
                default:
                    stack.push(token);
                    break;
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
