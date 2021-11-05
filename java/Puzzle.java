/*

In this kata you're given 3 values: a: int, b: int, symbol: char
Your task is to return the max / min value of (a, b), depending on symbol:
If the symbol is > return the max value, if < return the min value.

Examples
solve(2, 1, '>') => 2
solve(2, 1, '<') => 1
*/

public class Puzzle {
    public static int solve(int a, int b, char c) {
        /*
        Since integers are 32 bits
        Doing an Right Bit Shift by 31
            - Negative values -> -1 
            - Positive values -> 0
        */
        // if a > b 0 else -1
        int value = (a-b) >> 31;
        // if `>` 0 else -1
        int operation = (c >> 1) - 31;
        // if a > b and ` >` return a else b
        int index = (value ^ operation) * -1;
        // Expression that gives us 0 or 1, which we can use to pick a or b.
        return new int[]{a, b}[index];

    }
    public static void main(String[] args) {
        // Should be all True
        System.out.println(1 == Puzzle.solve(0, 1, '>'));
        System.out.println(0 == Puzzle.solve(0, 1, '<'));
        System.out.println(0 == Puzzle.solve(0, -1, '>'));
        System.out.println(7 == Puzzle.solve(8, 7, '<'));
    }
}
