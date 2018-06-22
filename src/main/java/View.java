import javax.swing.*;

public class View {
   JFileChooser fileopen = new JFileChooser();
   int ret = fileopen.showDialog(null, "Открыть файл");
}
