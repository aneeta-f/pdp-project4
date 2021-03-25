package picture.editor.model.operations;

import picture.editor.model.EColorTransformation;
import picture.editor.model.EOperationType;
import picture.editor.model.Image;

import java.util.LinkedHashMap;
import java.util.Map;

public class ImageColorTransformation extends AImageOperation {
    private final Image inputImage;
    private final EColorTransformation eColorTransformation;
    private final Map<EColorTransformation, float[][]> mapColorTransformationMatrix;

    public ImageColorTransformation(Image inputImage, EColorTransformation eColorTransformation) {
        this.inputImage = inputImage;
        this.eColorTransformation = eColorTransformation;
        this.mapColorTransformationMatrix = new LinkedHashMap<>();
        initMapColorTransformationMatrix();
    }

    private void initMapColorTransformationMatrix(){
        float[][] greyScaleTransformation = {
                {0.2126f, 0.7152f, 0.0722f},
                {0.2126f, 0.7152f, 0.0722f},
                {0.2126f, 0.7152f, 0.0722f}
        };
        this.mapColorTransformationMatrix.put(EColorTransformation.GREY_SCALE, greyScaleTransformation);

        float[][] sepiaToneTransformation = {
                {0.393f, 0.769f, 0.189f},
                {0.349f, 0.686f, 0.168f},
                {0.272f, 0.534f, 0.131f}
        };
        this.mapColorTransformationMatrix.put(EColorTransformation.SEPIA_TONE, sepiaToneTransformation);
    }

    @Override
    public EOperationType getOperationType() {
        return EOperationType.COLOR_TRANSFORMATION;
    }


    @Override
    public void preProcessing() {
        float[][] transformationMatrix = this.mapColorTransformationMatrix.get(eColorTransformation);
        validateTransformationMatrix(transformationMatrix);
    }

    @Override
    public void executeOperation() {
        int[][][] rgbMatrix = this.inputImage.getRgbMatrix();
        for(int i=0; i<rgbMatrix.length; ++i){
            for(int j=0; j<rgbMatrix[0].length; ++j){
                mulTransformationMatrixWithRGB(i, j);
            }
        }
    }

    private void mulTransformationMatrixWithRGB(int pixelHeight, int pixelWidth){
        int[][][] rgbMatrix = this.inputImage.getRgbMatrix();
        float[][] transformationMatrix = this.mapColorTransformationMatrix.get(eColorTransformation);
        for(int i=0; i<transformationMatrix.length; ++i){
            float transformedResult = 0.0f;
            for(int j=0; j<transformationMatrix[0].length; ++j){
                transformedResult += rgbMatrix[pixelHeight][pixelWidth][j] * transformationMatrix[i][j] ;
            }
            rgbMatrix[pixelHeight][pixelWidth][i] = Math.round(transformedResult);
        }
    }

    @Override
    public void postProcessing() {
        performClamping(inputImage);
    }

    /**
     * This method is responsible for validating provided transformation matrix.
     * @param transformationMatrix      Input transformation matrix
     * @throws IllegalArgumentException Throws exception when either row/columns are not 3
     */
    protected void validateTransformationMatrix(float[][] transformationMatrix) throws IllegalArgumentException {
        int rows = transformationMatrix.length;
        int columns = transformationMatrix[0].length;

        if(rows!=3 || columns!=3){
            throw new IllegalArgumentException("Invalid transformation matrix provided.");
        }
    }
}
