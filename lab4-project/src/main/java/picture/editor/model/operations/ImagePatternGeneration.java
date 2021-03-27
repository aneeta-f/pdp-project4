package picture.editor.model.operations;

import picture.editor.model.EOperationType;
import picture.editor.model.Image;

/**
 * The class represents a ImagePatternGeneration that extends 
 * AImageOperation. A ImagePatternGeneration 
 * determines the pattern of the image.
 *
 */
public class ImagePatternGeneration extends AImageOperation {

  /**
   * Construct a ImageMosaic object that has the provided inputImage
   * and seeds..
   *
   * @param inputImage The inputImage given to this ImagePatternGeneration
   */
  public ImagePatternGeneration(Image inputImage) {
    super(inputImage);
  }

  @Override
  public void preProcessing() {
    System.out.println("Pre processing: Coming soon");
  }

  @Override
  public void executeOperation() {
    System.out.println("Execute: Coming soon");
  }

  @Override
  public void postProcessing() {
    System.out.println("Post processing: Coming soon");
  }

  @Override
  public EOperationType getOperationType() {
    return EOperationType.PATTERN_GEN;
  }
}
