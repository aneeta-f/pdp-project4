package picture.editor.algorithm;

import picture.editor.model.Image;

/**
 * The IAlgorithm represents the interface that determine the 
 * image algorithms.
 */
public interface IAlgorithm {
  
  /**
   * Execute the image using algorithms.
   *
   * @param image The image to use for the operation.
   */
  void execute(Image image);
}
