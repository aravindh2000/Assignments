package employeedatabase;

import java.util.concurrent.ExecutionException;

class EvenOrOdd extends Thread{

    EvenOrOdd(){}
    final  EvenOrOdd obj=new EvenOrOdd();
    @Override
    public void run() {

        while (true) {

            if (Threads.num % 2 == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
            try {

                synchronized (obj) {
                    obj.join();
                }

            } catch (Exception e) {
                e.getMessage();

            }

        }
    }
        }


public class Threads extends Thread{
Threads(){}
  static int num;
    @Override
    public void run() {
        while (true) {
            num = (int)(Math.random()*10);
            System.out.println(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


    public static void main(String[] args) throws  Exception {
    new Threads().start();
    new EvenOrOdd().start();

    }
}
