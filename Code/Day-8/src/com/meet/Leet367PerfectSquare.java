package com.meet;
//367. Valid Perfect Square
//https://leetcode.com/problems/valid-perfect-square/
public class Leet367PerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }
    public static boolean isPerfectSquare(int num) {
        //TIME LIMIT EXCEED
//        int start = 1;
//        int end = num;
//
//        while(start<=end){
//            int mid = start + (end -start)/ 2;
//            if (mid == num/ mid ){
//                return true;
//            }
//            else if (mid < num /mid){
//                start = mid +1;
//            }else{
//                end = mid -1;
//            }
//        }
//        return false;

        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
