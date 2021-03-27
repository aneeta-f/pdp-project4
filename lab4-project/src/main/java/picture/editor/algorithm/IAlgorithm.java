package picture.editor.algorithm;

import picture.editor.model.Image;

/**
 * This class provide interface for implementing any algorithm.
 */
public interface IAlgorithm {
  /**
   * Method to execute algorithm.
   * @param image
   */
  void execute(Image image);
}
