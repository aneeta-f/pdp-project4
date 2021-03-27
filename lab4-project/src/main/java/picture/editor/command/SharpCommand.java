package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;
import picture.editor.model.EFilterType;

/**
 * This class represent the SharpCommand that extends 
 * ACommand. A SharpCommand determines 'sharp' command.
 */
public class SharpCommand extends ACommand {

  /**
   * Construct a SharpCommand object that accepts enhancedImageBuilder.
   * 
   * @param enhancedImageBuilder The enhancedImageBuilder given to this SharpCommand.
   */
  public SharpCommand(IEnhancedImageBuilder enhancedImageBuilder) {
    super(enhancedImageBuilder);
  }

  @Override
  public String execute() {
    enhancedImageBuilder.addFilter(EFilterType.SHARP_FILTER);
    return "";
  }
}
