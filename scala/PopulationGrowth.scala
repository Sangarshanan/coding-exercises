/*

https://www.codewars.com/kata/563b662a59afc2b5120000c6/train/scala

In a small town the population is p0 = 1000 at the beginning of a year.
The population regularly increases by 2 percent per year and moreover 50 new inhabitants per year come to live in the town. 
How many years does the town need to see its population greater or equal to p = 1200 inhabitants?

Examples:
nbYear(1500, 5, 100, 5000) -> 15
nbYear(1500000, 2.5, 10000, 2000000) -> 10

*/

object Arge {

  def nbYear(p0: Int, percent: Double, aug: Int, p: Int): Int = {
  	var year = 0
  	var inhabitants: Int = p0
  	while (inhabitants < p){
  		inhabitants = inhabitants + math.floor(inhabitants * (percent/100)).toInt + aug
  		println(inhabitants)
  		year = year + 1
  	}
  	return year
  }
}

Arge.nbYear(1500, 5, 100, 5000)


// Best Solution

object Arge {

  def nbYear(p0: Int, percent: Double, aug: Int, p: Int): Int = {
    // your code
    if (p0 >= p) 0 else 1 + nbYear((p0+p0*percent/100+aug).toInt,percent,aug,p)
  }
}
