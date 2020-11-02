package org.Unit05.Exam;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.LockSupport;

public class MyLock {
    private Queue<Thread> queue = new LinkedList<>();

    private volatile int state = 0;

    protected final int getState() {
        return state;
    }

    protected final void setState(int newState) {
        state = newState;
    }

    protected final boolean compareAndSetState(int expect, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }

    public void lock() {
        while (!compareAndSetState(0, 1)) {
            queue.offer(Thread.currentThread());
            /*
                CAS
            Object o = new Object();
            try {
                o.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            LockSupport.park();
        }
    }

    public void unlock() {
        state = 0;
        LockSupport.unpark(queue.poll());
    }

    private static final Unsafe unsafe;
    private static final long stateOffset;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset
                    (MyLock.class.getDeclaredField("state"));
        } catch (Exception ex) { throw new Error(ex); }
    }
}
