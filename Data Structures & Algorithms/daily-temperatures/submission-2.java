class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] warmerTempIn = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = temperatures.length-1; i >= 0; i--) {
            if (stack.isEmpty()) {
                warmerTempIn[i] = 0;
                stack.push(i);
            } else {
                int el = stack.peek();
                if (temperatures[el] > temperatures[i]) {
                    warmerTempIn[i] = el-i;
                    stack.push(i);
                } else {
                    warmerTempIn[i] = 0;
                    while(temperatures[stack.peek()] <= temperatures[i]) {
                        stack.pop();
                        if (stack.isEmpty()) break;
                    }
                    if (!stack.isEmpty()) {
                        el = stack.peek();
                        warmerTempIn[i] = el-i;
                    }
                    stack.push(i);
                }
            }
            System.out.println("Index: " + i + stack);
        }
        return warmerTempIn;
    }
}
