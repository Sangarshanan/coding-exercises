/*
https://leetcode.com/problems/toeplitz-matrix/

Given an m x n matrix
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: true
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.

Intuition:

We ask what feature makes two coordinates (r1, c1) and (r2, c2) belong to the same diagonal?
It turns out two coordinates are on the same diagonal if and only if "r1 - c1 == r2 - c2"
So we create a dictionary of Map[r-c] and if the key does not match then it's not Toeplitz

Every element belongs to some diagonal, and it's previous element (if it exists) is it's top-left neighbor.
Thus, for the square (r, c), we only need to
check r == 0 OR c == 0 (CORNER elements with no diagonal) OR matrix[r-1][c-1] == matrix[r][c].
*/

package main

import "fmt"

func isToeplitzMatrix(matrix [][]int) bool {
	for i, a := range matrix {
		for j, _ := range a {
			if i > 0 && j > 0 && matrix[i-1][j-1] != matrix[i][j] {
				return false
			}
		}
	}
	return true
}

func main() {
	x1 := [][]int{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}
	fmt.Println(isToeplitzMatrix(x1))
}
