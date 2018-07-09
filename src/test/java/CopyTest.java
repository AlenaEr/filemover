import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.BlockingQueue;

//   @RunWith(MockitoJUnitRunner.class)
public class CopyTest {
   private String fileType = "docx";
   private String fileName = "test.txt";
   String rootDirectory = "E:\\рецепт\\";

   @Test
   public void createDirectoryForTypeTest() throws IOException
   {
      String dist = fileType;
      File file = new File(dist);
      if (!file.exists()) {
         file.mkdirs();
      }
      File f = new File(file.getAbsolutePath() + File.separator + fileName);
      f.createNewFile();
      System.out.println(f.getAbsolutePath());

      Assert.assertTrue(file.exists());
      System.out.println("file exist " + file.getAbsolutePath());
   }

   @Test
   public void rootDirectoryAfterCopy()
   {
      File f = new File(rootDirectory);
      File[] files = f.listFiles();
      System.out.println("rootDirectoryLength = " + files.length);
      Assert.assertTrue(files.length == 0);
   }
}
