package com.zwb.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                ticket.sale();
            }
        },"张三").start();
        new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                ticket.sale();
            }
        } ,"李四").start();
        new Thread(() -> {
            for (int i = 0; i < 400; i++) {
                ticket.sale();
            }
        } ,"王五").start();

    }

}

class Ticket {
    private int num = 30;

   /* public synchronized void sale() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "买到了序号为" + num-- + "的票，还剩余" + num);
        }
    }*/
   Lock lock = new ReentrantLock();

    public  void sale() {
        lock.lock();
        boolean b = lock.tryLock();
        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "买到了序号为" + num-- + "的票，还剩余" + num);
            }
        } finally {
            lock.unlock();
        }
    }

}
