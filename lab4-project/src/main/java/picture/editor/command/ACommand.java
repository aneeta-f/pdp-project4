package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This abstract class is used implement command pattern.
 */
public abstract class ACommand {
  protected IEnhancedImageBuilder enhancedImageBuilder;

  /**
   * Parameterized constrictor that accepts IEnhancedImageBuilder interface.
   * @param enhancedImageBuilder
   */
  public ACommand(IEnhancedImageBuilder enhancedImageBuilder) {
    this.enhancedImageBuilder = enhancedImageBuilder;
  }

  public abstract String execute();
}
