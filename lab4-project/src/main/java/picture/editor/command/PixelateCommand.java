package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This class implements 'pixelate' command.
 */
public class PixelateCommand extends ACommand {
  private final int squares;

  /**
   * Parameterized constrictor that accepts following.
   *
   * @param enhancedImageBuilder
   * @param squares
   */
  public PixelateCommand(IEnhancedImageBuilder enhancedImageBuilder, final int squares) {
    super(enhancedImageBuilder);
    this.squares = squares;
  }

  @Override
  public String execute() {
    enhancedImageBuilder.addPixelation(this.squares);
    return "";
  }
}
