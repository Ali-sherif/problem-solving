class Solution {
    public int removeDuplicates(int[] nums) {
         int count =1;
    if (nums.length == 1)
      return 1;
    for(int i=0,j=1;j<=nums.length-1;j++){      
      
      if(nums[i]!=nums[j]) {
       nums[i+1]=nums[j];
       i++;
       count++;
      }      
    }
    return count;
        
    }
}
