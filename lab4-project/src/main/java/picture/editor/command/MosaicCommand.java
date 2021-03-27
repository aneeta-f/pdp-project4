package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This class represent the MosaicCommand that extends 
 * ACommand. A MosaicCommand has seeds.
 */
public class MosaicCommand extends ACommand {

  private final int seeds;

  /**
   * Construct a MosaicCommand object that has provided seeds and enhancedImageBuilder.
   * 
   * @param enhancedImageBuilder The enhancedImageBuilder given to this MosaicCommand.
   * @param seeds The seeds given to this MosaicCommand.
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
