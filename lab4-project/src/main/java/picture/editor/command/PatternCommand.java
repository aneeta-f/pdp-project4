package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This class represent the PatternCommand that extends 
 * ACommand. A PatternCommand determines 'pattern' command.
 */
public class PatternCommand extends ACommand {

  /**
   * Construct the PatternCommand object that accepts enhancedImageBuilder.
   * 
   * @param enhancedImageBuilder The enhancedImageBuilder given to this PatternCommand.
   */
  public PatternCommand(IEnhancedImageBuilder enhancedImageBuilder) {
    super(enhancedImageBuilder);
  }

  @Override
  public String execute() {
    return "";
  }
}
