package com.meet;
//287. Find the Duplicate Number
//https://leetcode.com/problems/find-the-duplicate-number/
class Leet287findDuplicate {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[correct]) {
                swap(nums, i , correct);
            } else {
                i++;
            }
        }
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index) {
                return nums[index];
            }
        }
        return nums.length;
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}