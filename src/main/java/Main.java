import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
   public static void main(String[] args) throws InterruptedException {
      BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10, true);
      String toDirectory = "E:\\Test\\";
      FileSearcher fileSearcher = new FileSearcher(queue);
      FileMover[] fileMovers = new FileMover[10];
      for (int i = 0; i < fileMovers.length; i++) {
         fileMovers[i] = new FileMover(queue, 1, toDirectory);
         fileMovers[i].start();
      }
      String fromDirectory = "E:\\рецепт\\";
      fileSearcher.findFile(fromDirectory);
   }
}

