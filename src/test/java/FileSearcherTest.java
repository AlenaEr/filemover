import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;

//@RunWith(MockitoJUnitRunner.class)

public class FileSearcherTest {

   private String rootDir = "E:\\рецепт\\";

   @Test
   public void searchTest() throws Exception
   {
      File file = new File(rootDir);
      File[] files = file.listFiles();
      Assert.assertFalse("rootDirectory is empty = " + files.length, files.length == 0);
      for (File f : files) {
         System.out.println(f.getName());
         ;
      }
      System.out.println("dir length = " + files.length);
   }

}
