package picture.editor.algorithm.patterngen;

import picture.editor.model.EPatternGenStrategy;
import picture.editor.model.Image;

/**
 * This class represent the TextPattern that implements 
 * IPatternGenStrategy. A TextPattern is responsible for 
 * generating text pattern from the image.
 */
public class TextPattern implements IPatternGenStrategy {
  
  @Override
  public void execute(Image image) {
    System.out.println("Coming soon");
  }

  @Override
  public EPatternGenStrategy getPatternGenStrategy() {
    return EPatternGenStrategy.TEXT_PATTERN;
  }
}
