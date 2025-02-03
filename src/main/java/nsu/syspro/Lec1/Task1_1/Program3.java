package nsu.syspro.Lec1.Task1_1;

public class Program3 {
    public static void run() throws InterruptedException {
        Thread threadB = new Thread(() -> {
            System.out.println("Hello from thread B!");
            throw new RuntimeException("Runtime exception from thread B!");
        });
        Thread threadA = new Thread(() -> {
            System.out.println("Hello from thread A!");
//            System.out.println(Thread.currentThread().getName());
            threadB.start();
            try {
                threadB.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadD = new Thread(() -> {
           System.out.println("Hello from thread D!");
            try {
                threadA.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadA.start();
        threadD.start();

        threadA.join();
        threadD.join();
    }
}
