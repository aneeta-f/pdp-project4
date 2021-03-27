package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This class implements 'save' command.
 */
public class SaveCommand extends ACommand {

  private final String imageFilePath;


  /**
   * Parameterized constructor that accepts enhancedImageBuilder and imageFilePath.
   * @param enhancedImageBuilder the enhancedImageBuilder given to this SaveCommand 
   * @param imageFilePath the imageFilePath given to this SaveCommand
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
