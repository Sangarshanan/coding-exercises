/* 
In this kata you are required to, given a string, replace every letter with its position in the alphabet.

If anything in the text isn't a letter, ignore it and don't return it.

"a" = 1, "b" = 2, etc.

Example
alphabetPosition("The sunset sets at twelve o' clock.")
Should return "20 8 5 19 21 14 19 5 20 19 5 20 19 1 20 20 23 5 12 22 5 15 3 12 15 3 11" (as a string)
*/

object Kata{
	val numbers = (1 to 26).toList
	val alphabets = ('a' to 'z').toList
	val number_alpha = (alphabets zip numbers).toMap
	def alphabetPosition(text: String): String = {
		var result = ""
		text.toLowerCase().toList.foreach {
			case character if alphabets.contains(character) => result = result.concat(number_alpha(character).toString + ' ')
			case _ => null
		}
		return result.trim() 
	}
}

// TESTCASES

assert(Kata.alphabetPosition("The sunset sets at twelve o' clock.")  == "20 8 5 19 21 14 19 5 20 19 5 20 19 1 20 20 23 5 12 22 5 15 3 12 15 3 11")
assert(Kata.alphabetPosition("The narwhal bacons at midnight.")  == "20 8 5 14 1 18 23 8 1 12 2 1 3 15 14 19 1 20 13 9 4 14 9 7 8 20")


// BETTER

object Kata {

  def alphabetPosition(text: String): String =
    text.filter(_.isLetter).map(_.toLower - 96).mkString(" ")
}
