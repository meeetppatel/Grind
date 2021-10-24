package com.meet;
//You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
//Given the integer n, return the number of complete rows of the staircase you will build.
public class Leet441 {
    public static void main(String[] args) {
        int n = 3;
        int ans = arrangeCoins(n);
        System.out.println(ans);
    }static int arrangeCoins(int n){
        int count = 0;

        while(n > 0){
            count+=1;
            n-=count;
        }if (n==0){
            return count;
        }else {
            return count-1;
        }
    }


}
