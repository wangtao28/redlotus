package com.chinasofti.Multithreading;

import java.util.concurrent.LinkedBlockingQueue;

public class App {
    public static void main(String[] args) {
        Pool pool = new Pool();
        Producer p1 = new Producer("P1",pool);
        Producer p2 = new Producer("P2",pool);
        Consumer c1 = new Consumer("P2",pool);
        p1.start();
        p2.start();
        c1.start();
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
    }
}
