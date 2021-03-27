package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;
import picture.editor.model.EFilterType;

/**
 * This class implements 'blur' command.
 */
public class BlurCommand extends ACommand {

  /**
   * Parameterized constrictor that accepts IEnhancedImageBuilder interface.
   * @param enhancedImageBuilder
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
