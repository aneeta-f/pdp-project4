package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This class implements 'mosaic' command.
 */
public class MosaicCommand extends ACommand {

  private final int seeds;

  /**
   * Parameterized constructor that accepts enhancedImageBuilder and seeds.
   * 
   * @param enhancedImageBuilder the enhancedImageBuilder given to this MosaicCommand.
   * @param seeds the seeds given to this MosaicCommand.
   */
  public MosaicCommand(IEnhancedImageBuilder enhancedImageBuilder, final int seeds) {
    super(enhancedImageBuilder);
    this.seeds = seeds;
  }

  @Override
  public String execute() {
    try {
      enhancedImageBuilder.addMosaic(seeds);
    } catch (IllegalArgumentException e) {
      return e.getMessage();
    }
    return "";
  }
}
