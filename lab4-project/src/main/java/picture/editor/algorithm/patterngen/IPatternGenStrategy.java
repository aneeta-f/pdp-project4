package picture.editor.algorithm.patterngen;

import picture.editor.algorithm.IAlgorithm;
import picture.editor.model.EPatternGenStrategy;

/**
 * The IPatternGenStrategy represents the interface that is responsible 
 * for providing pattern generation strategy.
 */
public interface IPatternGenStrategy extends IAlgorithm {
  
  /**
   * This method is responsible for returning pattern generation type.
   * 
   * @return EPatternGenStrategy The type of pattern generation
   */
  EPatternGenStrategy getPatternGenStrategy();
}
