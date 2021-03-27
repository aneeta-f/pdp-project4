package picture.editor.algorithm.patterngen;

import picture.editor.model.EPatternGenStrategy;
import picture.editor.model.Image;

/**
 * This class is responsible for generating text pattern from image.
 */
public class TextPattern implements IPatternGenStrategy {
  @Override
  public void execute(Image image) {

  }

  @Override
  public EPatternGenStrategy getPatternGenStrategy() {
    return EPatternGenStrategy.TEXT_PATTERN;
  }
}
