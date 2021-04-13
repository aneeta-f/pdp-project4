package picture.editor;

import picture.editor.model.EColorTransformation;
import picture.editor.model.EFilterType;
import picture.editor.model.Image;
import picture.editor.model.operations.AImageOperation;
import picture.editor.model.operations.ImageColorTransformation;
import picture.editor.model.operations.ImageDither;
import picture.editor.model.operations.ImageFilter;
import picture.editor.model.operations.ImageMosaic;
import picture.editor.model.operations.ImagePixelation;
import picture.editor.utils.FileUtils;
import picture.editor.utils.ImageUtilities;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * The class represents a EnhancedImageBuilder. A EnhancedImageBuilder has a 
 * list of image operations, imgeFilePath and a image.
 *
 */
public class EnhancedImageBuilder implements IEnhancedImageBuilder {
  private final List<AImageOperation> operations;
  private Image image;

  /**
   * Construct a default EnhancedImageBuilder object..
   */
  public EnhancedImageBuilder() {
    this.operations = new LinkedList<>();
  }

  /**
   * Construct a EnhancedImageBuilder object that has the provided imgFilePath..
   *
   * @param imgFilePath Image path given to this EnhancedImageBuilder
   */
  public EnhancedImageBuilder(final String imgFilePath) throws IOException {
    if (imgFilePath == null || imgFilePath.trim().isEmpty()) {
      throw new IllegalArgumentException("Image file path cannot be null or empty.");
    }
    this.operations = new LinkedList<>();
    loadImage(imgFilePath);
  }

  private Image readImage(final String imgFilePath)
          throws IllegalArgumentException, IOException {

    if (!FileUtils.isFileExist(imgFilePath)) {
      throw new IllegalArgumentException("Error: Provided file is not exist - " + imgFilePath);
    }
    return new Image(imgFilePath);
  }

  @Override
  public IEnhancedImageBuilder loadImage(final String imgFilePath) throws IOException {
    this.image = readImage(imgFilePath);
    this.operations.clear();
    return this;
  }

  /**
   * The addOperation is basically provide the Operations that can be performed in this
   * EnhancedImageBuilder.
   *
   * @param imageOperation that can be performed in this EnhancedImageBuilder.
   * @return the IEnhancedImageBuilder of this EnhancedImageBuilder.
   */
  public IEnhancedImageBuilder addOperation(final AImageOperation imageOperation) {
    if (imageOperation == null) {
      throw new IllegalArgumentException("Image operation instance cannot be null.");
    }
    this.operations.add(imageOperation);
    return this;
  }

  @Override
  public IEnhancedImageBuilder addFilter(final EFilterType eFilterType) {
    if (eFilterType == null) {
      throw new IllegalArgumentException("For image filter eFilterType cannot be null.");
    }
    this.operations.add(new ImageFilter(image, eFilterType));
    return this;
  }

  @Override
  public IEnhancedImageBuilder addColorTransformation(
          final EColorTransformation eColorTransformation) {
    if (eColorTransformation == null) {
      throw new IllegalArgumentException("For color transformation eFilterType cannot be null.");
    }
    this.operations.add(new ImageColorTransformation(image, eColorTransformation));
    return this;
  }

  @Override
  public IEnhancedImageBuilder addDither(final boolean isEssence, final int totalColors) {
    if (totalColors < 1) {
      throw new IllegalArgumentException("For image dither, total colors cannot be < 1.");
    }
    this.operations.add(new ImageDither(image, isEssence, totalColors));
    return this;
  }

  @Override
  public IEnhancedImageBuilder addMosaic(final int seeds) {
    if (seeds < 0) {
      throw new IllegalArgumentException("For image mosaic, number of seeds cannot be < 0.");
    }
    this.operations.add(new ImageMosaic(image, seeds));
    return this;
  }

  @Override
  public IEnhancedImageBuilder addPixelation(final int squares) {
    if (squares < 0) {
      throw new IllegalArgumentException("For image pixelation number of squares cannot be < 0.");
    }
    this.operations.add(new ImagePixelation(image, squares));
    return this;
  }

  @Override
  public IEnhancedImageBuilder build() {
    for (AImageOperation imageOperation : this.operations) {
      imageOperation.preProcessing();

      imageOperation.executeOperation();

      imageOperation.postProcessing();
    }
    return this;
  }

  @Override
  public IEnhancedImageBuilder saveImage(String fileName) throws IllegalArgumentException,
          IOException {
    if (fileName == null || fileName.trim().isEmpty()) {
      throw new IllegalArgumentException("Image file name cannot be null or empty.");
    }
    if (this.image == null) {
      throw new IllegalArgumentException("Unable to save null image.");
    }
    ImageUtilities.writeImage(this.image.getRgbMatrix(), this.image.getImageWidth(),
            this.image.getImageHeight(), fileName);
    return this;
  }
}
