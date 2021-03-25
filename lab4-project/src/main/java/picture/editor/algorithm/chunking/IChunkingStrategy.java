package picture.editor.algorithm.chunking;

import picture.editor.algorithm.IAlgorithm;
import picture.editor.model.EChunkingStrategy;
import picture.editor.model.Image;

public interface IChunkingStrategy extends IAlgorithm {
    EChunkingStrategy getChunkingStrategy();
}
