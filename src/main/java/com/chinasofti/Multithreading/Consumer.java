package com.chinasofti.Multithreading;

public class Consumer extends Thread{
    private String name;
    private Pool pool;

    public Consumer(String name,Pool pool){
        super();
        this.name = name;
        this.pool = pool;
    }

    public void run(){
        while (true){
            int n = pool.remove();
            System.out.println(name+" ： "+ n);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
