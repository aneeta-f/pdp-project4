package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;
import picture.editor.model.EFilterType;

/**
 * This class implements 'sharp' command.
 */
public class SharpCommand extends ACommand{

  /**
   * Parameterized constrictor that accepts following.
   * @param enhancedImageBuilder
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
