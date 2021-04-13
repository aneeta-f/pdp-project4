package picture.editor.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import picture.editor.IEnhancedImageBuilder;
import picture.editor.command.UploadCommand;
import picture.editor.utils.ImageUtilities;
import picture.editor.view.View;

public class UploadListener implements ActionListener {
  private final View view;
  private final IEnhancedImageBuilder enhancedImageBuilder;
  
  public UploadListener(View view) {
    super();
    this.view = view;
    this.enhancedImageBuilder = this.view.getEnhancedImageBuilder();
  }

  private String openFileDialog() {
    JFileChooser fc = new JFileChooser();
    int result = fc.showOpenDialog(view);
    if (result == JFileChooser.APPROVE_OPTION) {
      File file = fc.getSelectedFile();
      String filePath = file.getAbsolutePath();
      return filePath;
    }
    return null;
  }
  
  @Override
  public void actionPerformed(ActionEvent event) {
    final String filePath = openFileDialog();
    UploadCommand uploadCommand = new UploadCommand(enhancedImageBuilder, filePath);
    System.out.print(filePath);
   
  }
}