package com.meet;
//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
//Find Smallest Letter Greater Than Target
public class Leet744 {
    public static void main(String[] args) {
        char[] arr = {'c','f','j'};
        char target = 'j';
        char ans = (char) SmallestLetter(arr,target);
        System.out.println(ans);



    }

    static int SmallestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length-1;
        while (start<= end){
            int mid = start + (end - start)/2;
            if (target < letters[mid]){
                end = mid-1;
            }else{
                start = mid +1;
            }
        }return letters[start % letters.length];
    }
}
