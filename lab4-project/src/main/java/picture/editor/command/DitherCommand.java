package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This class implements 'dither' command.
 */
public class DitherCommand extends ACommand {
  final boolean isEssence;
  final int totalColors;

  /**
   * Parameterized constructor that accepts following.
   *
   * @param enhancedImageBuilder the enhancedImageBuilder given to this DitherCommand.
   * @param totalColors the totalColors given to this DitherCommand.
   * @param isEssence the isEssence given to this DitherCommand.
   */
  
  public DitherCommand(IEnhancedImageBuilder enhancedImageBuilder, 
      final int totalColors, final boolean isEssence) {
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
