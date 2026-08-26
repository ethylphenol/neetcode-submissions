class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do { // znamo da postoji tocno jedan pa ne treba provjeravat rubni uvjet
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) { // trazimo sjeciste
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
