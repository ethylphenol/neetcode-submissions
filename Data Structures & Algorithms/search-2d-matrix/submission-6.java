class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // O(logm + logn) prvo bin search retka i onda unutar retka
        int begin = 0, end = matrix.length-1;
        int rowLen = matrix[0].length;
        while(begin<=end) {
            if (end-begin<=1) break;
            int half = (end+begin)/2;
            // [begin, half]; <half, end]
            if (matrix[half][rowLen-1] > target) {
                end = half;
            } else if (matrix[half][rowLen-1] < target) {
                begin = half;
            } else {
                return true;
            }
        }
        int row = target <= matrix[begin][rowLen-1] ? begin : end;
        System.out.println(row);
        begin = 0; end = rowLen-1;
        while(begin<=end) {
            int half = (end+begin)/2;
            if (matrix[row][half] > target) {
                end = half - 1;
            } else if (matrix[row][half] < target) {
                begin = half + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
