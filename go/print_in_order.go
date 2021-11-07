/*
Design a mechanism to ensure that second() is executed after first()
and third() is executed after second().

Code should run: 
first() -> second() -> third() 
Even tho the functions are fired concurrently and in different orders

Input: nums = [1,3,2]
Output: "firstsecondthird"
Explanation: The input [1,3,2] means thread A calls first(), 
thread B calls third(), and thread C calls second().
"firstsecondthird" is the correct output.

*/

package main

import "fmt"

var oneDone = make(chan bool)
var twoDone = make(chan bool)

func first() {
	fmt.Println("one")
	oneDone <- true
}

func second() {
	<-oneDone
	fmt.Println("two")
	twoDone <- true
}

func third() {
	<-twoDone
	fmt.Println("three")
}

func main() {
	go second()
	go third()
	go first()

	fmt.Scanln()
}
