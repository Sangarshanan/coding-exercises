/*

https://www.codewars.com/kata/551dc350bf4e526099000ae5/train/scala

Polycarpus inserts a certain number of words "WUB" before the first word of the song 
(the number may be zero), after the last word (the number may be zero), 
and between words (at least one between any pair of neighbouring words), 
and then the boy glues together all the words, including "WUB", in one string

songDecoder("WUBWEWUBAREWUBWUBTHEWUBCHAMPIONSWUBMYWUBFRIENDWUB")
  // =>  WE ARE THE CHAMPIONS MY FRIEND


*/

object Wub {

  def songDecoder(song: String): String = song.replaceAll("WUB", " ").trim.replaceAll(" +", " ")
}

Wub.songDecoder("WUBWEWUBAREWUBWUBTHEWUBCHAMPIONSWUBMYWUBFRIENDWUB") == "WE ARE THE CHAMPIONS MY FRIEND"

// BEST SOLUTION

object Wub {

  def songDecoder(song: String): String =
    song.replaceAll("(WUB)+", " ").trim
}
