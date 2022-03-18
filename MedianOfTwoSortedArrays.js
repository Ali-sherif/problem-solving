const findMedianSortedArrays = function(nums1, nums2) {
    nums1 =[...nums1,...nums2].sort((a, b)=> a - b);

    if(nums1.length%2!=0)
      return nums1[(nums1.length-1)/2]
    return (nums1[nums1.length/2]+nums1[(nums1.length/2)-1])/2
};