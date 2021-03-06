/* 
https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/train/scala

Write a function that will return the count of distinct case-insensitive alphabetic 
characters and numeric digits that occur more than once in the input string. 
The input string can be assumed to contain only alphabets (both uppercase and lowercase) 
and numeric digits.

"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
*/

object Dups {

  def duplicateCount(str: String) : Int = {
    var list = str.split("").map(_.toLowerCase); list.diff(list.distinct).distinct.length
  }
}

println(Dups.duplicateCount("abcde") == 0)
println(Dups.duplicateCount("aA11") == 2)

// Best Solution
/*
object Dups {

  def duplicateCount(str: String): Int =
    str.groupBy(_.toLower).count(_._2.size > 1)
}
*/