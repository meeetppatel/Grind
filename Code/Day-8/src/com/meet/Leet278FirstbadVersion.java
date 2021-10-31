package com.meet;
//https://leetcode.com/problems/first-bad-version/submissions/
//278. First Bad Version
public class Leet278FirstbadVersion {
    public static void main(String[] args) {
        int bad = 4;
        firstBadVersion(bad);
//main code::::::::::::::::::::::::::::::::::::::::::::::::/
    } public static int firstBadVersion(int n) {
        int start = 1;
        int end  = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid) == false) {
                start = mid+1;
            } else{
                end = mid-1;
            }
        }
        return start;
//::::::::::::::::::::::::::::::::::::::::::::::::::::::::: /
    }static boolean isBadVersion(int n){
        int bad =4;
        if(n == bad){
            return true;
        }else {
            return false;
        }
    }

}
