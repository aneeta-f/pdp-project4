package picture.editor;

import picture.editor.model.EColorTransformation;
import picture.editor.model.EFilterType;

import java.io.IOException;

/**
 * This class represent the mock class that implements 
 * IEnhancedImageBuilder. A MockEnhancedImageBuilder has a log and uniqueCode.
 */
public class MockEnhancedImageBuilder implements IEnhancedImageBuilder {
  private StringBuilder log;

  /**
   * Construct a MockEnhancedImageBuilder object that has the
   * provided log and uniqueCode..
   *
   * @param log String builder of the purpose of logs.
   */
  public MockEnhancedImageBuilder(StringBuilder log) {
    this.log = log;
  }

  @Override
  public IEnhancedImageBuilder loadImage(String imgFilePath) throws IOException {
    log.append("Input Image: " + imgFilePath + "\n");
    return this;
  }

  @Override
  public IEnhancedImageBuilder addFilter(EFilterType eFilterType) {
    log.append("Adding Filter: " + eFilterType.name() + "\n");
    return this;
  }

  @Override
  public IEnhancedImageBuilder addDither(boolean isEssence, int totalColors) {
    log.append("Adding Dither, total colors: " + totalColors + " essence: " + isEssence + "\n");
    return this;
  }

  @Override
  public IEnhancedImageBuilder addColorTransformation(EColorTransformation eColorTransformation) {
    log.append("Adding Color Transformation: " + eColorTransformation.name() + "\n");
    return this;
  }

  @Override
  public IEnhancedImageBuilder saveImage(String fileName) throws
          IllegalArgumentException, IOException {
    log.append("Saving image: " + fileName + "\n");
    return this;
  }

  @Override
  public IEnhancedImageBuilder addMosaic(int seeds) {
    log.append("Adding mosaic with seeds: " + seeds + "\n");
    return this;
  }

  @Override
  public IEnhancedImageBuilder addPixelation(int square) {
    log.append("Adding pixelation with squares: " + square + "\n");
    return this;
  }

  @Override
  public IEnhancedImageBuilder build() {
    log.append("Building enhanced image: " + "\n");
    return this;
  }
}
