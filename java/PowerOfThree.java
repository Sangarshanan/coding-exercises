/*
Given an integer n, return true if it is a power of three. Otherwise, return false.
An integer n is a power of three, if there exists an integer x such that n == 3x.

Example 1:
Input: n = 27
Output: true

Example 2:
Input: n = 0
Output: false
*/

class Solution {
    public boolean isPowerOfThree(int num) {
        int reminder=0;
        boolean isPowerOfThree=false;
        if(num!=0){
            while(reminder==0){
                if(num==1){
                    isPowerOfThree=true;
                    break;
                }
                reminder=num%3;
                num=num/3;
            }
        }
        return isPowerOfThree;
    }
}