class Solution27 {
    public int removeElement(int[] nums, int val) {
        exchange(nums, 0, nums.length - 1, val);
        return nums.length - count;
    }

    void exchange(int[] nums, int left, int right, int val) {
        while(right >= 0  && val == nums[right]) { count ++; right --;}
        while(left < nums.length && val != nums[left]) left ++;
        if(left >= right) return;

        count ++;
        nums[left++] = nums[right--];

        exchange(nums, left, right, val);
        
    }
    public int count = 0;
}