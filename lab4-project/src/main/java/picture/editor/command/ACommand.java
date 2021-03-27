package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This abstract class is used implement command pattern.
 */
public abstract class ACommand {
  protected IEnhancedImageBuilder enhancedImageBuilder;

  /**
   * Parameterized constructor that accepts IEnhancedImageBuilder interface.
   * @param enhancedImageBuilder the enhancedImageBuilder given to this ACommand
   */
  public ACommand(IEnhancedImageBuilder enhancedImageBuilder) {
    this.enhancedImageBuilder = enhancedImageBuilder;
  }
  
  /**
   * This function is responsible to execute the image.
   */

  public abstract String execute();
}
