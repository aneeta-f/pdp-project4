package picture.editor.algorithm.chunking;

import picture.editor.algorithm.IAlgorithm;
import picture.editor.model.EChunkingStrategy;

/**
 * This IChunkingStrategy represent the interface that determine the
 * chunking strategies for the mosaic and pixelation operations.
 */
public interface IChunkingStrategy extends IAlgorithm {
  
  /**
   * This method is responsible for getting the type of chunking 
   * strategy for the image.
   * 
   * @return EChunkingStrategy The type of chunking strategy given to this IChunkingStrategy.
   */
  EChunkingStrategy getChunkingStrategy();
}
