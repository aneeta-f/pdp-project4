package picture.editor.algorithm.chunking;

import picture.editor.model.EChunkingStrategy;
import picture.editor.model.Image;

/**
 * This class represent the Pixelation that implements 
 * IChunkingStrategy. A Pixelation class has a square.
 */
public class Pixelation implements IChunkingStrategy {
  private final int squares;

  /**
   * Construct a Pixelation object that has a provided squares.
   *
   * @param squares The total squares given to this Pixelation.
   */
  public Pixelation(int squares) {
    this.squares = squares;
  }

  @Override
  public EChunkingStrategy getChunkingStrategy() {
    return EChunkingStrategy.PIXELATION;
  }

  @Override
  public void execute(Image image) {
    if (image == null) {
      throw new IllegalArgumentException("Image cannot be null.");
    }
 
    if (this.squares < 0) {
      throw new IllegalArgumentException("Squares cannot be null.");
    }
  }
}
