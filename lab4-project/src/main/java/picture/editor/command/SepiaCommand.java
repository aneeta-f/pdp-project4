package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;
import picture.editor.model.EColorTransformation;

/**
 * This class represent the SepiaCommand that extends 
 * ACommand. A SepiaCommand determines 'sepia' command.
 */
public class SepiaCommand extends ACommand {

  /**
   * Construct a SepiaCommand object that accepts enhancedImageBuilder.
   *
   * @param enhancedImageBuilder The enhancedImageBuilder given to this SepiaCommand
   */
  public SepiaCommand(IEnhancedImageBuilder enhancedImageBuilder) {
    super(enhancedImageBuilder);
  }

  @Override
  public String execute() {
    enhancedImageBuilder.addColorTransformation(EColorTransformation.SEPIA_TONE);
    return "";
  }
}
