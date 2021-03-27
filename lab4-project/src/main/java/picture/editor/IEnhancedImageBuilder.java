package picture.editor;

import picture.editor.model.EColorTransformation;
import picture.editor.model.EFilterType;

import java.io.IOException;

/**
 * The IEnhancedImageBuilder represent the controller interface which 
 * determines the method for enhancing image.
 */
public interface IEnhancedImageBuilder {
  
  /**
   * This method is responsible for loading image from the path.
   *
   * @param imgFilePath Image file path given to this IEnhancedImageBuilder.
   * @return IEnhancedImageBuilder Builder instance of this IEnhancedImageBuilder.
   * @throws IOException null pointer exception
   */
  IEnhancedImageBuilder loadImage(final String imgFilePath) throws IOException;

  /**
   * This method is responsible for applying filter operation 
   * in the image.
   *
   * @param eFilterType The type of the filter given to this IEnhancedImageBuilder
   * @return IEnhancedImageBuilder Builder instance of this IEnhancedImageBuilder.
   */
  IEnhancedImageBuilder addFilter(final EFilterType eFilterType);

  /**
   * This method is responsible for applying dither operation 
   * in the image.
   *
   * @param isEssence   The isEssence to be given to this FloydSteinbergDither.
   * @param totalColors The totalColors to be given to this FloydSteinbergDither.
   * @return IEnhancedImageBuilder Builder instance of this IEnhancedImageBuilder.
   */
  IEnhancedImageBuilder addDither(final boolean isEssence, final int totalColors);

  /**
   * This method is responsible for applying color transformation 
   * operation in the image.
   *
   * @param eColorTransformation The eColorTransformation given to this IEnhancedImageBuilder. 
   * @return IEnhancedImageBuilder Builder instance of this IEnhancedImageBuilder.
   */
  IEnhancedImageBuilder addColorTransformation(final EColorTransformation eColorTransformation);

  /**
   * This method is responsible for saving the image in the disk.
   *
   * @param fileName The name of the Image file given to this IEnhancedImageBuilder 
   * @return IEnhancedImageBuilder Builder instance of this IEnhancedImageBuilder.
   * @throws IllegalArgumentException Throws exception if the file doesn't exist.
   * @throws IOException Null pointer exception.
   */
  IEnhancedImageBuilder saveImage(String fileName) throws IllegalArgumentException, IOException;

  /**
   * This method is responsible for applying mosaic effect w.r.t 
   * total number of seeds.
   *
   * @param seeds  Number of seeds given to this IEnhancedImageBuilder
   * @return IEnhancedImageBuilder Builder instance of this IEnhancedImageBuilder.
   */
  IEnhancedImageBuilder addMosaic(final int seeds);

  /**
   * This method is responsible for applying pixelation on image w.r.t 
   * total number of squares provided.
   *
   * @param square Total number of squares given to this IEnhancedImageBuilder.
   * @return IEnhancedImageBuilder Builder instance of this IEnhancedImageBuilder.
   */
  IEnhancedImageBuilder addPixelation(final int square);

  /**
   * Return the builder pattern of images, IEnhancedImageBuilder.
   *
   * @return IEnhancedImageBuilder Builder instance of this IEnhancedImageBuilder.
   */
  IEnhancedImageBuilder build();
}
