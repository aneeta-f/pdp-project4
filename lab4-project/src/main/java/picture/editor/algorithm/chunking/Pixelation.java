package picture.editor.algorithm.chunking;

import picture.editor.algorithm.chunking.IChunkingStrategy;
import picture.editor.model.EChunkingStrategy;
import picture.editor.model.Image;

public class Pixelation implements IChunkingStrategy {
    private final int square;

    public Pixelation(int square) {
        this.square = square;
    }

    @Override
    public void execute(Image image) {

    }

    @Override
    public EChunkingStrategy getChunkingStrategy() {
        return EChunkingStrategy.PIXELATION;
    }
}
