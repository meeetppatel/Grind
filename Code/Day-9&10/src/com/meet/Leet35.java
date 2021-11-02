package com.meet;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
//35. Search Insert Position
//https://leetcode.com/problems/search-insert-position/
public class Leet35 {

    public static void main(String[] args) {
	    int[] nums = {1,3,5,6};
        int target = 2;


        System.out.println(binarysearch(nums,target));
    }public static int binarysearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target){
                return mid;
            }else if (target> nums[mid]){
                start = mid +1;
            }else {
                end = mid-1;
            }
//
        }return start;
//           return target - nums[start -1] + start -1;
    }
}
