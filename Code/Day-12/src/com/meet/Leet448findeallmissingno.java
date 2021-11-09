package com.meet;
//448. Find All Numbers Disappeared in an Array
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/


import java.util.ArrayList;
import java.util.List;

public class Leet448findeallmissingno {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        findDisappearedNumbers(arr);
    }public  static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] -1;
            if (nums[i] != nums[correct]) {
                swap(nums, i , correct);
            } else {
                i++;
            }
        }
        // search for first missing  number
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index +1) {
                res.add(index +1);
            }
        }
        // case 2
        return res;
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
