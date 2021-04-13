package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;
import picture.editor.model.EFilterType;

/**
 * This class represent the blurCommand that extends ACommand . 
 * A blurCommand determines the blur effect.
 */
public class BlurCommand extends ACommand {

  /**
   * Construct the BlurCommand object that accepts IEnhancedImageBuilder interface.
   * 
   * @param enhancedImageBuilder The enhancedImageBuilder given to this BlurCommand.
   */
  public BlurCommand(IEnhancedImageBuilder enhancedImageBuilder) {
    super(enhancedImageBuilder);
  } 

  @Override
  public String execute() {
    enhancedImageBuilder.addFilter(EFilterType.BLUR_FILTER);
    return "";
  }
}
