package picture.editor.model.operations;

import picture.editor.algorithm.dither.IDither;
import picture.editor.model.EColorDensity;
import picture.editor.model.EOperationType;
import picture.editor.model.Image;

public class ImageColorDensity extends AImageOperation {
    protected final Image inputImage;

    private final IDither ditherAlgorithm;

    private final EColorDensity eColorDensity;

    public ImageColorDensity(Image inputImage, EColorDensity eColorDensity, IDither ditherAlgorithm) {
        this.inputImage = inputImage;
        this.eColorDensity = eColorDensity;
        this.ditherAlgorithm = ditherAlgorithm;
    }

    @Override
    public EOperationType getOperationType() {
        return EOperationType.COLOR_DENSITY;
    }

    public EColorDensity getColorDensity(){
        return this.eColorDensity;
    }

    @Override
    public void preProcessing() {

    }


    @Override
    public void executeOperation() {
        this.ditherAlgorithm.execute(this.inputImage);
    }

    @Override
    public void postProcessing() {
        performClamping(inputImage);
    }
}
