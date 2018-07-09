import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileMover extends Thread {
      private BlockingQueue<String> queue;
      private ExecutorService executor;
      private String targetDirectory;

      public FileMover(BlockingQueue queue, int amountOfParallelThreads, String targetDirectory) {
         this.queue = queue;
         executor = Executors.newFixedThreadPool(amountOfParallelThreads);
         this.targetDirectory = targetDirectory;
      }

      @Override
      public void run() {
         while (true) {
            try {
               String filePath = queue.take();
               // System.out.println("\tTAKE:" + filePath);
               //finish of searching
               if ("-1".equalsIgnoreCase(filePath)) {
                  //to notify other threads to stop (other FileMover). Because queue.take - remove item form Queue only 1 FileMover will got -1 from queue
                  queue.put("-1");
                  break;
               }
               executor.submit(new Copy(filePath, targetDirectory));
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }
         }
         executor.shutdown();
      }
   }

