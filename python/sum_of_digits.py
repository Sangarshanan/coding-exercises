"""
https://www.codewars.com/kata/5877e7d568909e5ff90017e6/python

Implement a function which receives two arguments:

- the sum of digits (sum)
- the number of digits (count)

This function should return three values:

- the total number of values which have count digits that add up to sum and are in increasing order
- the lowest such value
- the greatest such value

Note: if there're no values which satisfy these constaints, you should return an empty value

find_all(10, 3)  =>  [8, 118, 334]
find_all(27, 3)  =>  [1, 999, 999]
find_all(84, 4)  =>  []

"""

def find_all(s, d):
    xs = [x for x in digs(d) if sum(x) == s]
    if not xs:
        return []
    else:
        reduce_int = lambda xs: int(''.join(map(str, xs)))
        min = reduce_int(xs[0])
        max = reduce_int(xs[-1])    
        return [len(xs), min, max]

def digs(d, start=1):
    """
    >>> list(digs(3, start=9))
    [[9, 9, 9]]
    >>> list(digs(2, start=8))
    [[8, 8], [8, 9], [9, 9]]
    """
    if d == 1:
        for x in range(start, 10):
            yield [x]
    else:
        for x in range(start, 10):
            for y in digs(d - 1, x):
                yield [x] + y
