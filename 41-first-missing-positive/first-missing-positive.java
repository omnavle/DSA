class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i<nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else i++;
        }
        return found(nums);
    }
    int[] swap(int[] nums , int f ,int s){
        int temp = nums[f];
        nums[f] = nums[s];
        nums[s] = temp;
        return nums;
    }
    int found(int[] nums){
        for(int i=0 ; i<nums.length ;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
}