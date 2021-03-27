package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This class implements 'mosaic' command.
 */
public class MosaicCommand extends ACommand {

  private final int seeds;

  /**
   * Parameterized constrictor that accepts following.
   * @param enhancedImageBuilder
   * @param seeds
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
