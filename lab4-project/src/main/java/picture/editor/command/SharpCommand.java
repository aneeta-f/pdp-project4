package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;
import picture.editor.model.EFilterType;

/**
 * This class implements 'sharp' command.
 */
public class SharpCommand extends ACommand {

  /**
   * Parameterized constructor that accepts enhancedImageBuilder.
   * @param enhancedImageBuilder the enhancedImageBuilder given to this SharpCommand.
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
