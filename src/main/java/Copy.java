import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Copy implements Runnable {
   //this is file we need to copy
   private String filePath;
   //this is directory where to copy
   private String targetDirectory;
   public Copy(String filePath, String targetDirectory)
   {
      this.filePath = filePath;
      this.targetDirectory = targetDirectory;
   }

   @Override
   public void run()
   {
      try {
         //where to copy
         String dist = createDirectoryForType();
         System.out.println(dist);
         //name of file (without long Path)
         String fileName = getFileName();
         Path sourceDir = Paths.get(filePath);
         Path targetDir = Paths.get(dist + "\\" + fileName);
         Files.copy(sourceDir, targetDir);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   //calculate type of file: data.txt --> txt
   private String getFileType()
   {
      File afile = new File(filePath);
      int index = afile.getName().lastIndexOf(".");
      String type = afile.getName().substring(index + 1);
      return type;
   }

   //need to create new directory for file data.txt --> folder//txt
   private String createDirectoryForType()
   {
      String type = getFileType();
      String dist = targetDirectory + type;
      File file = new File(dist);
      if (!file.exists()) {
         file.mkdirs();
      }
      return dist;
   }

   private String getFileName()
   {
      File file = new File(filePath);
      String name = file.getName();
      return name;
   }
}
