/*
There are two kinds of threads: oxygen and hydrogen.
Your goal is to group these threads to form water molecules.

- If an oxygen thread arrives at the barrier when no hydrogen threads are present, 
    it must wait for two hydrogen threads.
- If a hydrogen thread arrives at the barrier when no other threads are present, 
    it must wait for an oxygen thread and another hydrogen thread.

Write synchronization code for oxygen and hydrogen molecules that enforces these constraints.

*/

import java.util.concurrent.*;

class H2O {
    Semaphore h, o;

    public H2O() {
        this.h = new Semaphore(2);
        this.o = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
        h.acquire();
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
        o.acquire(2);
		releaseOxygen.run();
        h.release(2);
    }
}