#[ 

Help the bookseller !
https://www.codewars.com/kata/54dc6f5a224c26032800005c

A bookseller has lots of books classified in 26 categories labeled A, B, ... Z. Each book has a code c of 3, 4, 5 or more characters. The 1st character of a code is a capital letter which defines the book category.

In the bookseller's stocklist each code c is followed by a space and by a positive integer n (int n >= 0) which indicates the quantity of books of this code in stock.

For example an extract of a stocklist could be:

L = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"}.
or
L = ["ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"] or ....
You will be given a stocklist (e.g. : L) and a list of categories in capital letters e.g :

M = {"A", "B", "C", "W"} 
or
M = ["A", "B", "C", "W"] or ...
and your task is to find all the books of L with codes belonging to each category of M and to sum their quantity according to each category.

For the lists L and M of example you have to return the string (in Haskell/Clojure/Racket a list of pairs):

(A : 20) - (B : 114) - (C : 50) - (W : 0)

]#

import tables
import strutils
import strformat
import sequtils

proc stockList*(listArt, listCat: seq[string]): string =
    var category_count = initTable[string, seq[int]]()
    if listCat.len() > 0 and listArt.len() > 0:
        for cat in listCat:
            category_count[cat] = @[]
        for art in listArt:
            let cat = fmt"{art[0]}"
            if cat in listCat:
                category_count[cat].add(parseInt(art.split(' ')[1]))
        var output = ""
        for cat in listCat:
            if category_count[cat].len() == 0:
                output = output & fmt"({cat} : 0) - "
            else:
                output = output & fmt"({cat} : {category_count[cat].foldl(a + b)}) - "
        return output[0 .. ^4]
    else:
        return ""

var Art = @["BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 600"]
var Categories = @["A", "B", "C", "D"]

var output = "(A : 0) - (B : 1290) - (C : 515) - (D : 600)"

echo stockList(Art, Categories) == output
echo stockList(@[], @["B", "R", "D", "X"]) == ""