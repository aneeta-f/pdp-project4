package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This class implements 'dither' command.
 */
public class DitherCommand extends ACommand {
  final boolean isEssence;
  final int totalColors;

  /**
   * Parameterized constrictor that accepts following.
   *
   * @param enhancedImageBuilder
   * @param totalColors
   * @param isEssence
   */
  public DitherCommand(IEnhancedImageBuilder enhancedImageBuilder, final int totalColors, final boolean isEssence) {
    super(enhancedImageBuilder);
    this.isEssence = isEssence;
    this.totalColors = totalColors;
  }

  @Override
  public String execute() {
    enhancedImageBuilder.addDither(isEssence, totalColors);
    return "";
  }
}
