package com.leetcode.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * 测试线程的6种状态
 * NEW -> RUNNABLE -> Terminated
 *        ↓     ↑
 *        TimeWaiting
 *        Waiting
 *        Blocked
 *
 */
public class ThreadState {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getState());//RUNNABLE
            //LockSupport.park();
            for(int i=0; i<10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        System.out.println(myThread.getState());//NEW
        myThread.start();
        myThread.sleep(500L);
        System.out.println(myThread.getState());
    }
}
