/*
https://leetcode.com/problems/fizz-buzz-multithreaded/

For range of numbers
- "fizzbuzz" if i is divisible by 3 and 5
- "fizz" if i is divisible by 3 and not 5
- "buzz" if i is divisible by 5 and not 3
- i if i is not divisible by 3 or 5.

Implicit locks (Monitors)

We keep a shared currentNumber showing where we're up to.
Each thread has to then check whether or not it should take its turn.
If it's not the current thread's turn, it calls wait(), thus suspending and giving up the monitor. 
After each increment of currentNumber, we need to call notifyAll() 
so that the other threads are woken and can re-check the condition. They will all be given a chance to run
 */

class FizzBuzz {
    private int n;
    private int curr = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (curr <= n) {
            if (curr % 3 == 0 && curr % 5 != 0) {
                printFizz.run();
                curr++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (curr <= n) {
            if (curr % 3 != 0 && curr % 5 == 0) {
                printBuzz.run();
                curr++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (curr <= n) {
            if (curr % 15 == 0) {
                printFizzBuzz.run();
                curr++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (curr <= n) {
            if (curr % 3 != 0 && curr % 5 != 0) {
                printNumber.accept(curr);
                curr++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}
