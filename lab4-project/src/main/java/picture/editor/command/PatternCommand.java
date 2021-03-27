package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

/**
 * This class implements 'pattern' command.
 */
public class PatternCommand extends ACommand {

  /**
   * Parameterized constrictor that accepts enhancedImageBuilder.
   * @param enhancedImageBuilder
   */
  public PatternCommand(IEnhancedImageBuilder enhancedImageBuilder) {
      super(enhancedImageBuilder);
  }

  @Override
  public String execute() {
      return "";
  }
}
