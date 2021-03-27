package picture.editor.algorithm.patterngen;

import picture.editor.algorithm.IAlgorithm;
import picture.editor.model.EChunkingStrategy;
import picture.editor.model.EPatternGenStrategy;
import picture.editor.model.Image;

/**
 * This class is responsible for providing pattern gen strategy.
 */
public interface IPatternGenStrategy extends IAlgorithm {
  /**
   * This method is responsible returning pattern gen type.
   * @return EPatternGenStrategy
   */
  EPatternGenStrategy getPatternGenStrategy();
}
