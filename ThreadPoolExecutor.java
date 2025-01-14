import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPoolExecutor {
    public static void main(String[] args) {
       ThreadPool pool = new ThreadPool(10, 5);
       for (int i=0; i<100; i++) {
           pool.submitTask("Task: " + i);
       }
    }
}


class ThreadPool {
    BlockingQueue<String> blockingQueue;

    public ThreadPool(int qSize, int numOfThreads) {
        blockingQueue = new LinkedBlockingQueue<>(qSize);
        for (int i=0; i<numOfThreads; i++) {
            TaskExecutor taskExecutor = new TaskExecutor(blockingQueue);
            Thread t1 = new Thread(taskExecutor);
            t1.start();
        }
    }

    public void submitTask(String msg) {
        try {
            this.blockingQueue.put(msg);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Items in blocking Q are: " + blockingQueue);
    }
}

class TaskExecutor implements Runnable {
    BlockingQueue<String> blockingQueue;

    public TaskExecutor(BlockingQueue q) {
        this.blockingQueue = q;
    }

    @Override
    public void run() {
        while(true) {
            try {
                String task = blockingQueue.take();
                System.out.println("Task: " + task + " is processed by thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

