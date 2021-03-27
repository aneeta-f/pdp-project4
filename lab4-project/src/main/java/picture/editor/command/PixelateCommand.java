package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This class implements 'pixelate' command.
 */
public class PixelateCommand extends ACommand {
  private final int squares;

  /**
   * Parameterized constructor that accepts following enhancedImageBuilder and squares.
   *
   * @param enhancedImageBuilder the enhancedImageBuilder given to this PixelateCommand
   * @param squares the squares given to this PixelateCommand
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
