package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This class represents the PixelateCommand that extends ACommand. 
 * A PixelateCommand has squares.
 */
public class PixelateCommand extends ACommand {
  private final int squares;

  /**
   * Construct a PixelateCommand object that accepts 
   * enhancedImageBuilder and squares.
   *
   * @param enhancedImageBuilder The enhancedImageBuilder given to this PixelateCommand
   * @param squares The squares given to this PixelateCommand
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
