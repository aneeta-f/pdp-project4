package picture.editor.algorithm.patterngen;

import picture.editor.algorithm.IAlgorithm;
import picture.editor.model.EChunkingStrategy;
import picture.editor.model.EPatternGenStrategy;
import picture.editor.model.Image;

public interface IPatternGenStrategy extends IAlgorithm {
    EPatternGenStrategy getPatternGenStrategy();
}
