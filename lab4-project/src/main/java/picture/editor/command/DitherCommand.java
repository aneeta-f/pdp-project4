package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This class represent the DitherCommand that extends 
 * ACommand. A DitherCommand has a isEssence and totalColors.
 */
public class DitherCommand extends ACommand {
  final boolean isEssence;
  final int totalColors;

  /**
   * Construct a DitherCommand object that has the provided
   * isEssence and totalColors.
   *
   * @param enhancedImageBuilder The enhancedImageBuilder given to this DitherCommand.
   * @param totalColors the totalColors given to this DitherCommand.
   * @param isEssence The isEssence given to this DitherCommand.
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
