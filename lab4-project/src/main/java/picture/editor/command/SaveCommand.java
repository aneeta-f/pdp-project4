package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This class represent the SaveCommand that extends 
 * ACommand. A SaveCommand has a imageFilePath.
 */
public class SaveCommand extends ACommand {

  private final String imageFilePath;


  /**
   * Construct the SaveCommand object that accepts 
   * enhancedImageBuilder and imageFilePath.
   * 
   * @param enhancedImageBuilder The enhancedImageBuilder given to this SaveCommand 
   * @param imageFilePath The imageFilePath given to this SaveCommand
   */
  public SaveCommand(final IEnhancedImageBuilder enhancedImageBuilder, final String imageFilePath) {
    super(enhancedImageBuilder);
    this.imageFilePath = imageFilePath;
  }

  @Override
  public String execute() {
    try {
      enhancedImageBuilder.build();
      enhancedImageBuilder = enhancedImageBuilder.saveImage(imageFilePath);
    } 
    catch (Exception e) {
      return "Failed to save image: " + this.imageFilePath + "\n";
    }
    return "";
  }
}
