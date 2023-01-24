/*
https://leetcode.com/problems/reverse-integer/description/

Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range then return 0

Input: x = 123
Output: 321

Reversing an integer can be done similarly to reversing a string.

We want to repeatedly "pop" the last digit off of x and "push" it to the back of the rev.
In the end, rev will be the reverse of x
*/
package main

import (
	"fmt"
	"math"
)

func reverse(x int) int {
	out := int(0)
	for x != 0 {
		if out > math.MaxInt32/10 || out < math.MinInt32/10 {
			return 0
		}
		fmt.Println(out*10, int(x%10))
		out = out*10 + int(x%10)
		x = int(x / 10)
	}
	return out
}

func main() {
	fmt.Println(reverse(123))
}
