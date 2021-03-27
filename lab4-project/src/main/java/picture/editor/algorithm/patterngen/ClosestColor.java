package picture.editor.algorithm.patterngen;

import picture.editor.model.EPatternGenStrategy;
import picture.editor.model.Image;

/**
 * This class represents the ClosestColor that implements 
 * IPatternGenStrategy. 
 */
public class ClosestColor implements IPatternGenStrategy {
  
  @Override
  public void execute(Image image) {
    System.out.println("Coming soon" + image.getImageHeight());
  }

  @Override
  public EPatternGenStrategy getPatternGenStrategy() {
    return EPatternGenStrategy.CLOSEST_COLOR;
  }
}
