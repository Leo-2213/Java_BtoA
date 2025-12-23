package MultiThreading.InterThreadCommunication;

class SharedResource {
    int val;
    boolean hasData = false; // Explicit initialization

    public synchronized void produce(int i) throws InterruptedException {
        while(hasData){
            System.out.println("Producer is waiting..." + "for i :   " + i ); // Print before waiting
            wait();
        }
        val = i;
        System.out.println("Produced: " + val);
        hasData = true;
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while (!hasData){
            System.out.println("Consumer is waiting..."); // Print before waiting
            wait();
        }
        System.out.println("Consumed: " + this.val);
        hasData = false;
        notifyAll();
    }
}

class Producer extends Thread {
    SharedResource sharedResource;

    Producer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run(){
        for(int i = 1; i <= 5; i++){
            try {
                Thread.sleep(1000); // Add delay to observe coordination
                sharedResource.produce(i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupt status
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer extends Thread {
    SharedResource sharedResource;

    Consumer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run(){
        for(int i = 1; i <= 5; i++){
            try {
                Thread.sleep(1500); // Different delay to see coordination
                sharedResource.consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupt status
                throw new RuntimeException(e);
            }
        }
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);

        producer.start();
        consumer.start();
    }
}