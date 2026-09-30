class Solution {
    public void dfsParenthesis(int open, int close, List<String> pars, StringBuilder curr) {
        if (close == 0) {
            pars.add(curr.toString());
            return;
        }
        if (open <= close && open > 0) {
            curr.append("(");
            dfsParenthesis(open - 1, close, pars, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (open < close && close > 0) {
            curr.append(")");
            dfsParenthesis(open, close - 1, pars, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> pars = new ArrayList<>();
        // npr n = 3. --> 5
        dfsParenthesis(n, n, pars, new StringBuilder());
        return pars;
    }
}
