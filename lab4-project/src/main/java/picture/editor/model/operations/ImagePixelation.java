package picture.editor.model.operations;

import picture.editor.algorithm.chunking.IChunkingStrategy;
import picture.editor.algorithm.chunking.Pixelation;
import picture.editor.model.EOperationType;
import picture.editor.model.Image;

/**
 * This class is responsible for generating pixelated image.
 */
public class ImagePixelation extends AImageOperation {
  private final Image inputImage;
  private final IChunkingStrategy chunkingStrategy;

  /**
   * Parameterized constructor that accepts following.
   * @param inputImage
   * @param squares
   */
  public ImagePixelation(Image inputImage, final int squares) {
    this.inputImage = inputImage;
    chunkingStrategy = new Pixelation(squares);
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
    return EOperationType.PIXELATION;
  }
}

