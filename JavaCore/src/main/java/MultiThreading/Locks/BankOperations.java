package MultiThreading.Locks;

public class BankOperations {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        
        // Testing synchronized method
        Runnable  withdrawal = new Runnable() {
           @Override
           public void run() {
               try {
                   account.withdraw(5000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
       };
       Thread t1 = new Thread(withdrawal, "Thread1");
       Thread t2 = new Thread(withdrawal,"Thread2");
       Thread t3 = new Thread(withdrawal,"Thread3");

       // Start all threads concurrently
       t1.start();
       t2.start();
       t3.start();

       // Main thread waits for all worker threads to complete
       t1.join();
       t2.join();
       t3.join();
       System.out.println("Transactions complete");

        // Testing custom lock with timeout
        Runnable  customwithdrawal = new Runnable() {
            @Override
            public void run() {
                try {
                    account.customWithdrawal(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t4 = new Thread(customwithdrawal, "Thread4");
        Thread t5 = new Thread(customwithdrawal,"Thread5");
        Thread t6 = new Thread(customwithdrawal,"Thread6");

        // Start all threads concurrently
        t4.start();
        t5.start();
        t6.start();

        // Main thread waits for all worker threads to complete
        t4.join();
        t5.join();
        t6.join();
        System.out.println("Transactions complete");
    }
}
