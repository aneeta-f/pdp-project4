package picture.editor.algorithm.patterngen;

import picture.editor.model.EPatternGenStrategy;
import picture.editor.model.Image;

/**
 * This class is responsible for implementing closest color.
 */
public class ClosestColor implements IPatternGenStrategy {
  @Override
  public void execute(Image image) {

  }

  @Override
  public EPatternGenStrategy getPatternGenStrategy() {
    return EPatternGenStrategy.CLOSEST_COLOR;
  }
}
