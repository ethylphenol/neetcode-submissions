class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        strs.forEach(str->{
            sb.append("#"+str.length()+"#"+str);
        });
        return sb.toString();
    }

    public List<String> decode(String str) {
        // #123#...#
        // #0##0#
        List<String> decoded = new ArrayList<>();
        while (!str.isEmpty()) {
            int beginNum = 0;
            int endNum = 0;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i)=='#') {
                    endNum = i;
                    break;
                }
            }
            // #...# beginNum = first #, endNum = last #
            int len = Integer.parseInt(str.substring(beginNum+1, endNum));
            decoded.add(str.substring(endNum+1, endNum+1+len));
            str = str.substring(endNum+len+1);
        }
        return decoded;
    }

}
