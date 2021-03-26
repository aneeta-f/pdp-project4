package picture.editor.model.operations;

import picture.editor.algorithm.chunking.IChunkingStrategy;
import picture.editor.algorithm.chunking.Mosaic;
import picture.editor.model.EOperationType;
import picture.editor.model.Image;

public class ImageMosaic extends AImageOperation{
    private final Image inputImage;
    private final IChunkingStrategy chunkingStrategy;

    public ImageMosaic(Image inputImage, final int seeds) {
        this.inputImage = inputImage;
        chunkingStrategy = new Mosaic(seeds);
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
        return EOperationType.MOSAIC;
    }
}
