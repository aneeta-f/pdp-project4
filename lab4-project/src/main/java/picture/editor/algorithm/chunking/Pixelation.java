package picture.editor.algorithm.chunking;

import picture.editor.model.EChunkingStrategy;
import picture.editor.model.Image;

/**
 * This class is responsible for implementing pixelation chunking strategy.
 */
public class Pixelation implements IChunkingStrategy {
  private final int squares;

  /**
   * Parameterized constructor.
   * @param squares in total
   */
  public Pixelation(int squares) {
    this.squares = squares;
  }

  @Override
  public void execute(Image image) {

  }

  @Override
  public EChunkingStrategy getChunkingStrategy() {
    return EChunkingStrategy.PIXELATION;
  }
}
