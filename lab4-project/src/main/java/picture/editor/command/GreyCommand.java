package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;
import picture.editor.model.EColorTransformation;

/**
 * This class implements 'grey' command.
 */
public class GreyCommand extends ACommand{

  /**
   * Parameterized constrictor that accepts IEnhancedImageBuilder interface.
   * @param enhancedImageBuilder
   */
  public GreyCommand(IEnhancedImageBuilder enhancedImageBuilder) {
    super(enhancedImageBuilder);
  }

  @Override
  public String execute() {
    enhancedImageBuilder.addColorTransformation(EColorTransformation.GREY_SCALE);
    return "";
  }
}
