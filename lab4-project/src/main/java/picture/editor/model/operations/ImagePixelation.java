package picture.editor.model.operations;

import picture.editor.algorithm.chunking.IChunkingStrategy;
import picture.editor.algorithm.chunking.Pixelation;
import picture.editor.model.EOperationType;
import picture.editor.model.Image;

/**
 * The class represents a ImagePixelation that extends 
 * AImageOperation. A ImagePixelation has inputImage and 
 * chunkingStrategy.
 *
 */
public class ImagePixelation extends AImageOperation {
  private final IChunkingStrategy chunkingStrategy;

  /**
   * Construct a ImagePixelation object that has the provided inputImage
   * and squares..
   *
   * @param inputImage The inputImage given to this ImagePixelation
   * @param squares    The squares given to this ImagePixelation
   */
  public ImagePixelation(Image inputImage, final int squares) {
    super(inputImage);

    if (squares < 0) {
      throw new IllegalArgumentException("Square cannot be null.");
    }
    chunkingStrategy = new Pixelation(squares);
  }

  @Override
  public void preProcessing() {
    if (chunkingStrategy == null) {
      throw new IllegalArgumentException("Chunking strategy cannot be null.");
    }
  }

  @Override
  public void executeOperation() {
    chunkingStrategy.execute(this.inputImage);
  }

  @Override
  public void postProcessing() {
    performClamping(inputImage);
  }

  @Override
  public EOperationType getOperationType() {
    return EOperationType.PIXELATION;
  }
}
