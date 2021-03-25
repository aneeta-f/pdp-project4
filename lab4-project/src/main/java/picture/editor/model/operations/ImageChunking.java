package picture.editor.model.operations;

import picture.editor.algorithm.chunking.IChunkingStrategy;
import picture.editor.model.EOperationType;
import picture.editor.model.Image;

public class ImageChunking extends AImageOperation {

    private final Image inputImage;
    private final IChunkingStrategy chunkingStrategy;

    public ImageChunking(Image inputImage, IChunkingStrategy chunkingStrategy) {
        this.inputImage = inputImage;
        this.chunkingStrategy = chunkingStrategy;
    }

    @Override
    public void preProcessing() {

    }

    @Override
    public void executeOperation() {

    }

    @Override
    public void postProcessing() {

    }

    @Override
    public EOperationType getOperationType() {
        return EOperationType.CHUNKING;
    }
}
