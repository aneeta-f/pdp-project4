package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This class implements 'pattern' command.
 */
public class PatternCommand extends ACommand {

  /**
   * Parameterized constructor that accepts enhancedImageBuilder.
   * @param enhancedImageBuilder the enhancedImageBuilder given to this PatternCommand.
   */
  public PatternCommand(IEnhancedImageBuilder enhancedImageBuilder) {
    super(enhancedImageBuilder);
  }

  @Override
  public String execute() {
    return "";
  }
}
