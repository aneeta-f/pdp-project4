package picture.editor.model.operations;

import picture.editor.algorithm.chunking.IChunkingStrategy;
import picture.editor.algorithm.chunking.Mosaic;
import picture.editor.model.EOperationType;
import picture.editor.model.Image;

/**
 * The class represents a ImageMosaic that extends AImageOperation. A ImageMosaic 
 * has a inputImage and chunkingStrategy.
 *
 */
public class ImageMosaic extends AImageOperation {
  private final IChunkingStrategy chunkingStrategy;

  /**
   * Construct a ImageMosaic object that has the provided inputImage
   * and seeds..
   *
   * @param inputImage The inputImage given to this ImageMosaic
   * @param seeds      The seeds given to this ImageMosaic
   */
  public ImageMosaic(Image inputImage, final int seeds) {
    super(inputImage);

    if (seeds < 0) {
      throw new IllegalArgumentException("Seeds cannot be < 0");
    }
    chunkingStrategy = new Mosaic(seeds);
  }

  @Override
  public void preProcessing() {
    System.out.println("Performing pre processing");
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
    return EOperationType.MOSAIC;
  }
}