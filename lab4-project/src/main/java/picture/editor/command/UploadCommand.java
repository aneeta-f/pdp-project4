package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This class represent the UploadCommand that extends 
 * ACommand. A UploadCommand determines 'upload' command.
 */
public class UploadCommand extends ACommand {

  private final String imageFilePath;

  /**
   * Construct a UploadCommand object that accepts enhancedImageBuilder.
   * 
   * @param enhancedImageBuilder The enhancedImageBuilder given to this UploadCommand
   */
  public UploadCommand(final IEnhancedImageBuilder enhancedImageBuilder, 
      final String imageFilePath) {
    super(enhancedImageBuilder);
    this.imageFilePath = imageFilePath;
  }

  @Override
  public String execute() {
    try {
      this.enhancedImageBuilder.loadImage(this.imageFilePath);
    } catch (Exception exception) {
      return "Failed to load input image: " + this.imageFilePath + "\n";
    }
    return "";
  }
}
