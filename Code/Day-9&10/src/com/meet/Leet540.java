package com.meet;
//540. Single Element in a Sorted Array
//https://leetcode.com/problems/single-element-in-a-sorted-array/

public class Leet540 {
    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(nums));

    } public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        while (start < end){
            int mid = start + (end -start)/2;
            if (mid %2 != 0){
                mid--;
            }
            if (nums[mid] != nums[mid+1]){
                end = mid;
            }else {
                start = mid +2;
            }
        }
        return nums[start];
    }
}
