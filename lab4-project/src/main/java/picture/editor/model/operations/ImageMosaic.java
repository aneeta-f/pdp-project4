package picture.editor.model.operations;

import picture.editor.algorithm.chunking.IChunkingStrategy;
import picture.editor.algorithm.chunking.Mosaic;
import picture.editor.model.EOperationType;
import picture.editor.model.Image;

/**
 * This class is responsible for performing image mosaic.
 */
public class ImageMosaic extends AImageOperation {
  private final Image inputImage;
  private final IChunkingStrategy chunkingStrategy;

  /**
   * Parameterized constructor that accepts following.
   * @param inputImage the inputImage given to this ImageMosaic
   * @param seeds the seeds given to this ImageMosaic
   */
  public ImageMosaic(Image inputImage, final int seeds) {
    this.inputImage = inputImage;
    chunkingStrategy = new Mosaic(seeds);
  }

  @Override
  public void preProcessing() {

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
