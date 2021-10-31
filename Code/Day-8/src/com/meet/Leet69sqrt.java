package com.meet;

public class Leet69sqrt {

    public static void main(String[] args) {
	// write your code here
        int x = 10;
        System.out.println(mySqrt(x));
    }
    public static int mySqrt(int x) {
        int start = 1;
        int end = Integer.MAX_VALUE;
        if (x == 0)
            return 0;

        while(start>0){
            int mid = start + (end -start)/2;
            if(mid> x/mid){
                end = mid -1;
            }else {
                if(mid+1 > x /(mid+1)){
                        return mid;
                }
                start = mid+1;
            }
        }
        return -1;
    }
}
