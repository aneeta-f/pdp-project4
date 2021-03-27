package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This class implements 'upload' command.
 */
public class UploadCommand extends ACommand {

  private final String imageFilePath;

  /**
   * Parameterized constrictor that accepts following.
   * @param enhancedImageBuilder
   */
  public UploadCommand(final IEnhancedImageBuilder enhancedImageBuilder, final String imageFilePath) {
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
