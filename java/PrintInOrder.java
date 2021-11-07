/*
Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}

The same instance of Foo will be passed to three different threads.
    - Thread A will call first()
    - Thread B will call second()
    - Thread C will call third().

Design a mechanism and modify the program to ensure that second() is executed after first()
and third() is executed after second().

*/

import java.util.concurrent.* ;

class Foo {

    Semaphore semaphore1 = new Semaphore(0);
	Semaphore semaphore2 = new Semaphore(0);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first"
        printFirst.run();
        semaphore1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second"
        semaphore1.acquire();
        printSecond.run();
        semaphore2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third"
        semaphore2.acquire();
        printThird.run();
    }
}

/*

class Foo {
    private volatile int flag;

    public Foo() {
        flag = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        for(;;) {
        	if (flag==1) {
        		printFirst.run();
                flag = 2;
                break;
        	}
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
    	for(;;) {
    		if (flag==2) {
    			printSecond.run();
                flag=3;
                break;
    		}
    	}
    }

    public void third(Runnable printThird) throws InterruptedException {
    	for(;;) {
    		if (flag==3) {
    			printThird.run();
                flag = 1;
                break;
    		}
    	}
    }
}

*/