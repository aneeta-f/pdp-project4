package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;
import picture.editor.model.EColorTransformation;

/**
 * This class implements 'sepia' command.
 */
public class SepiaCommand extends ACommand {

  /**
   * Parameterized constructor that accepts following enhancedImageBuilder.
   *
   * @param enhancedImageBuilder the enhancedImageBuilder given to this SepiaCommand
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
