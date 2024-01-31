
class ThreadExample extends Thread{

    public void run(){
        for(int i=0;i<=5;i++){

            System.out.println(Thread.currentThread().getId() + " Value " + i);
        }
    }
}

public class MultiThreading {



    public static void main(String[] args) {

        ThreadExample thread1 = new ThreadExample();
        ThreadExample thread2 = new ThreadExample();
        thread1.start();
        thread2.start();

    }
}
