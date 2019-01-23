package com.chinasofti.Multithreading;

import java.util.LinkedList;

public class Pool {

    private LinkedList<Integer> pool = new LinkedList<Integer>();
    private static final int MAX = 100;

    public synchronized int add(Integer i){
        while (pool.size() >= MAX){
            try {
                //等待结束后进入while
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        pool.add(i);
        notify();
        return i;
    }

    public synchronized int remove(){
        while (pool.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int n =  pool.removeFirst();
        notify();
        return n;
    }
}
