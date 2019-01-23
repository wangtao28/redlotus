package com.chinasofti.Multithreading;

public class Saler extends Thread{
    private String name;
    private TicketPool pool;
    public Saler(String name,TicketPool pool){
        super();
        this.name = name;
        this.pool = pool;
    }
    public void run(){
        while (true){
            int tno = pool.getTicket();
            if(tno==0){
                return;
            }
            System.out.println(name+" : "+tno);
        }
    }
}
