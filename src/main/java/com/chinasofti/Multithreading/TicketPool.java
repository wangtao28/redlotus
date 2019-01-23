package com.chinasofti.Multithreading;

public class TicketPool {
    private int tickNo = 100;

    /**
     * 以当前对象为锁
     * @return
     */
    public synchronized int getTicket(){
        int tmp = tickNo;
        if(tmp==0){
            return 0;
        }
        tickNo--;
        return tmp;
    }
}
