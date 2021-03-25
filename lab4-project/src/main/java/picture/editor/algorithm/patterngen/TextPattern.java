package picture.editor.algorithm.patterngen;

import picture.editor.algorithm.patterngen.IPatternGenStrategy;
import picture.editor.model.EPatternGenStrategy;
import picture.editor.model.Image;

public class TextPattern implements IPatternGenStrategy {
    @Override
    public void execute(Image image) {

    }

    @Override
    public EPatternGenStrategy getPatternGenStrategy() {
        return EPatternGenStrategy.TEXT_PATTERN;
    }
}
