/*
Write a function that takes in a string of one or more words,
and returns the same string, but with all five or more letter words reversed

spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
spinWords( "This is a test") => returns "This is a test"
spinWords( "This is another test" )=> returns "This is rehtona test"

*/

package main

import (
	"fmt"
	"strings"
)

func SpinWords(str string) string {
	aTokens := strings.Split(str, " ")
	for i, word := range aTokens {
		if len([]rune(word)) > 4 {
			aTokens[i] = reverse(word)
		}
	}
	return strings.Join(aTokens, " ")
}

func reverse(s string) string {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

func main() {
	fmt.Println(SpinWords("my name is rajesh from tech support"))
}
