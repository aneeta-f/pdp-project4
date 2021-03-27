package picture.editor.algorithm.chunking;

import picture.editor.algorithm.IAlgorithm;
import picture.editor.model.EChunkingStrategy;
import picture.editor.model.Image;

/**
 * This class provide interface for chunking strategies mosaic/pixelation.
 */
public interface IChunkingStrategy extends IAlgorithm {
  /**
   * Return chunking strategy type.
   * @return EChunkingStrategy
   */
  EChunkingStrategy getChunkingStrategy();
}
