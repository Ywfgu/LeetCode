package com.leetcode.thread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/**
 * 自制一个自旋锁
 */
public class MyLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock(){

        System.out.println(Thread.currentThread().getName()+" lock");
        // 第一次个线程可以成功修改，第二个线程在未解锁状态下就会一直无限循环，即cas
        while (!atomicReference.compareAndSet(null, Thread.currentThread())){
//            System.out.println("cas");
        }
    }

    public void unLock(){
        System.out.println(Thread.currentThread().getName()+" unlock");
        atomicReference.compareAndSet(Thread.currentThread(),null);
    }

    @Test
    public void test() throws InterruptedException {
        MyLock myLock = new MyLock();
//        myLock.unLock();

        new Thread(()->{

            myLock.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                myLock.unLock();
            }

        },"T1").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            myLock.lock();
            try {
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                myLock.unLock();
            }
        },"T2").start();

        LockSupport.park();
    }
}
