package assignments;

public class ThreadDemoWithRunnable implements Runnable{

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("Thread "+Thread.currentThread().getName()+" started...");
                Thread.sleep(500);
            } catch (Exception e) {
                e.getMessage();

            }
        }
    }

    public static void main(String[] args)  {
        Thread t1=new Thread(new ThreadDemoWithRunnable());
        Thread t2=new Thread(new ThreadDemoWithRunnable());
        t1.start();
        t2.start();
    }
}
