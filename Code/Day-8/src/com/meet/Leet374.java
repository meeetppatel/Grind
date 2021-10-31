package com.meet;
//https://leetcode.com/problems/guess-number-higher-or-lower/
//LeetCode 374. Guess Number Higher or Lower

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */
public class Leet374 {
    public static void main(String[] args) {
        int n = 10;
        int pick = 6;
        System.out.println(guessNumber(n, pick));
    }
        public static int guessNumber(int n ,int pick) {
            int start = 1;
            int end = n;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (guess(pick, mid) == -1) {
                    end = mid - 1;
                } else if (guess(pick, mid) == 1) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
        public static int guess(int pick,int n){

            if (pick > n){
                return 1;
            }
            if (pick < n){
                return -1;
            }
            if (pick == n){
                return 0;
            }
            return -1;
        }
}
