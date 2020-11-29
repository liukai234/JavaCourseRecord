class Solution26 {
    // public int removeDuplicates(int[] nums) {

    //     for(int i = 1; i < nums.length - count; i++) {
    //         int quantitySameKind = 0;
    //         int k = i;
    //         for(;k < nums.length - count; k++) {
    //             if(nums[k] == nums[k - 1]) quantitySameKind ++;
    //             else break;
    //         }
    //         if(quantitySameKind != 0) {
    //             count += quantitySameKind;
    //             for(int j = i; j < nums.length - count; j ++) {
    //                 nums[j] = nums[j + quantitySameKind];
    //             }
    //         }
    //     }
        


    //     return nums.length - count;
    // }
    // public int count = 0;
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        // when nums.length = 1, 1 !< nums.length; return 0 + 1 = 1;
        while(q < nums.length) {
            if(nums[p] == nums[q]) q ++;
            else{
                nums[p + 1] = nums[q]; 
                q ++;
                p ++;
            } 
        }
        return p + 1;
    }
}