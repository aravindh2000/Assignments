package assignments;

import java.util.Random;

public class ThreadsDemo {

    static int num = 0;

    public static void main(String[] args) {

        ThreadsDemo eo = new ThreadsDemo();

        A aob = eo.new A();
        B bob = eo.new B();

        aob.a = Lock.lock1;
        aob.b = Lock.lock2;

        bob.a = Lock.lock2;
        bob.b = Lock.lock1;

        Thread t1 = new Thread(aob);
        Thread t2 = new Thread(bob);

        t1.start();
        t2.start();
    }

    static class Lock {
        final static Object lock1 = new Object();
        final static Object lock2 = new Object();
    }

    class A implements Runnable {

        Object a;
        Object b;

        public void run() {
            while (true) {
                try {
                    num=(int)(Math.random()*10);


                    synchronized (a) {
                        a.notify();
                    }
                    synchronized (b) {
                        b.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class B implements Runnable {

        Object a;
        Object b;

        public void run() {
            while (true) {

                try {
                    synchronized (b) {
                        b.wait();
                         if(num%2==0)
                         {
                             System.out.println("Even"+num);

                         }
                         else {
                             System.out.println("odd"+num);
                         }
                    }
                    synchronized (a) {
                        a.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


