package picture.editor.algorithm;

import picture.editor.model.Image;

/**
 * This class provide interface for implementing any algorithm.
 */
public interface IAlgorithm {
  /**
   * Method to execute algorithms.
   * @param image the image file.
   */
  void execute(Image image);
}
