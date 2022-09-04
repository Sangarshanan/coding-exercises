"""
https://www.codewars.com/kata/59b7571bbf10a48c75000070/python

Write a function that accepts msg string and returns local tops of string from 
the highest to the lowest.

test.assert_equals(tops(""),"")
test.assert_equals(tops("12"),"2")
test.assert_equals(tops("abcdefghijklmnopqrstuvwxyz12345"),"3pgb")
test.assert_equals(tops("abcdefghijklmnopqrstuvwxyz1236789ABCDEFGHIJKLMN"),"M3pgb")

"""

def tops(msg):
    i,d,s = 1,5, ''
    while i < len(msg):
        s += msg[i]
        i += d
        d += 4
    return s[::-1]
