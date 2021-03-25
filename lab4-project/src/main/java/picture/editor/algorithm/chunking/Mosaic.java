package picture.editor.algorithm.chunking;

import picture.editor.algorithm.chunking.IChunkingStrategy;
import picture.editor.model.EChunkingStrategy;
import picture.editor.model.Image;

public class Mosaic implements IChunkingStrategy {
    private final int seeds;

    public Mosaic(int seeds) {
        this.seeds = seeds;
    }

    @Override
    public void execute(Image image) {

    }

    @Override
    public EChunkingStrategy getChunkingStrategy() {
        return EChunkingStrategy.MOSAIC;
    }
}
