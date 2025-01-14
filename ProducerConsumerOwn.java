import java.util.*;



public class NewClass{
  public static void main(String[] args) {
    SharedQueue q = new SharedQueue(10);
    
    Producer p = new Producer(q);
    Consumer c = new Consumer(q);
    
    Thread producerThread1 = new Thread(p);
    Thread producerThread2 = new Thread(p);
    
    Thread consumeThread1 = new Thread(c);
    Thread consumeThread2 = new Thread(c);
    
    producerThread1.start();
    consumeThread1.start();
    producerThread2.start();
    consumeThread2.start();
  }
}

class SharedQueue {
  private Queue<Integer> q;
  private int bufferSize;
  Random random = new Random();
  public SharedQueue(int bufferSize) {
    this.bufferSize = bufferSize;
    q = new LinkedList<>();
  }
  
  public synchronized void produce() throws InterruptedException {
    if (q.size() == bufferSize ){
      System.out.println("Queue is full, waiting to consume");
      wait();
    }
    int item = random.nextInt(5, 500);
    q.add(item);
    System.out.println("Item: " + item + " is produced by thread: " + Thread.currentThread().getName());
    notify();
  }
  
  public synchronized void consume() throws InterruptedException {
    if (q.size() == 0) {
      System.out.println("Queue is empty, waiting to produce");
      wait();
    }
    int item = q.poll();
    System.out.println("Item: " + item + " is consumed by " + Thread.currentThread().getName());
    notify();
  }
}

class Producer implements Runnable {
  SharedQueue q;
  
  public Producer(SharedQueue q) {
    this.q = q;
  }
  
  @Override
  public void run() {
    for (int i=0; i<20; i++) {
      try{
      q.produce();
      } catch(Exception e) {
        
      }
    }
  }
}

class Consumer implements Runnable{
  SharedQueue q;
  public Consumer(SharedQueue q) {
    this.q = q;
  }
  
  @Override
  public void run() {
    for (int i=0; i<20; i++) {
       try{
      q.consume();
      } catch(Exception e) {
        
      }
    }
  }
}
