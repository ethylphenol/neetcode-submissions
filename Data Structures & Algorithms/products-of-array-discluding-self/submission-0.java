class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        // O(n) slozenost bez operatora dijeljenja
        // [a,b,c,d,e]
        // left product
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            products[i] = 1*left;
            left*=nums[i];
        }
        int right = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            products[i] *= right;
            right*=nums[i];
        }
        return products;
    }
}  
