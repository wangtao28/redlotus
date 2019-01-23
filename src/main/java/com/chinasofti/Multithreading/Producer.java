package com.chinasofti.Multithreading;

public class Producer extends Thread{
    private String name;
    private static  int index = 0;
    private Pool pool;

    public Producer(String name,Pool pool){
        super();
        this.name = name;
        this.pool = pool;
    }

    public void run(){
        while (true){
            int n = pool.add(index++);
            System.out.println(name+" add: "+ n);
        }
    }
}
