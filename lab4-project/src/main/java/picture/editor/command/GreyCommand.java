package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;
import picture.editor.model.EColorTransformation;

/**
 * This class represents the GreyCommand that extends 
 * ACommand. A GreyCommand determines 'grey' effect.
 */
public class GreyCommand extends ACommand {

  /**
   * Construct a GreyCommand object that accepts IEnhancedImageBuilder 
   * interface.
   * 
   * @param enhancedImageBuilder The enhancedImageBuilder given to this GreyCommand.
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
