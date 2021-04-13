package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This ACommand represent the abstract class that determines 
 * the command pattern. A ACommand has a enhancedImageBuilder.
 */
public abstract class ACommand {
  protected IEnhancedImageBuilder enhancedImageBuilder;

  /**
   * Construct a ACommand object that accepts IEnhancedImageBuilder interface.
   *
   * @param enhancedImageBuilder The enhancedImageBuilder given to this ACommand
   */
  public ACommand(IEnhancedImageBuilder enhancedImageBuilder) { 
    if (enhancedImageBuilder == null) {
      throw new IllegalArgumentException("Enhanced image builder instance cannot be null.");
    }
    this.enhancedImageBuilder = enhancedImageBuilder;
  }

  /**
   * This function is responsible to execute the image.
   */
  public abstract String execute();
}
