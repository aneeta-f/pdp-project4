package picture.editor;

import picture.editor.model.EColorTransformation;
import picture.editor.model.EFilterType;
import picture.editor.model.Image;
import picture.editor.model.operations.*;
import picture.editor.utils.FileUtils;
import picture.editor.utils.ImageUtilities;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class EnhancedImageBuilder implements IEnhancedImageBuilder{
    private final List<AImageOperation> operations;
    private String imgFilePath;
    private Image image;

    public EnhancedImageBuilder() {
        this.operations = new LinkedList<>();
    }

    public EnhancedImageBuilder(final String imgFilePath) throws IOException {
        this.operations = new LinkedList<>();
        loadImage(imgFilePath);
    }

    private Image readImage(final String imgFilePath) throws IllegalArgumentException, IOException {
        if(!FileUtils.isFileExist(imgFilePath)){
            throw new IllegalArgumentException("Error: Provided file is not exist - " + imgFilePath);
        }
        return new Image(imgFilePath);
    }

    public IEnhancedImageBuilder loadImage(final String imgFilePath) throws IOException {
        this.imgFilePath = imgFilePath;
        this.image = readImage(imgFilePath);
        this.operations.clear();
        return this;
    }

    public IEnhancedImageBuilder addOperation(final AImageOperation imageOperation){
        this.operations.add(imageOperation);
        return this;
    }

    public IEnhancedImageBuilder addFilter(final EFilterType eFilterType){
        this.operations.add(new ImageFilter(image, eFilterType));
        return this;
    }

    public IEnhancedImageBuilder addColorTransformation(final EColorTransformation eColorTransformation){
        this.operations.add(new ImageColorTransformation(image, eColorTransformation));
        return this;
    }

    public IEnhancedImageBuilder addDither(final boolean isEssence, final int totalColors){

        this.operations.add(new ImageDither(image, isEssence, totalColors));
        return this;
    }

    public IEnhancedImageBuilder addMosaic(final int seeds){
        this.operations.add(new ImageMosaic(image, seeds));
        return this;
    }

    public IEnhancedImageBuilder addPixelation(final int square){
        this.operations.add(new ImagePixelation(image,square));
        return this;
    }

    public IEnhancedImageBuilder build(){
        for(AImageOperation imageOperation : this.operations){
            imageOperation.preProcessing();

            imageOperation.executeOperation();

            imageOperation.postProcessing();
        }
        return this;
    }

    public IEnhancedImageBuilder saveImage(String fileName) throws IllegalArgumentException, IOException {
        if(this.image == null){
            throw new IllegalArgumentException("Unable to save null image.");
        }
        ImageUtilities.writeImage(this.image.getRgbMatrix(), this.image.getImageWidth(), this.image.getImageHeight(), fileName);
        return this;
    }

}
