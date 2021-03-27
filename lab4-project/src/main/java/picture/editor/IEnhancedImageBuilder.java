package picture.editor;

import picture.editor.model.EColorTransformation;
import picture.editor.model.EFilterType;

import java.io.IOException;

/**
 * Controller class talks to this interface for enhancing image.
 */
public interface IEnhancedImageBuilder {
  /**
   * This method is responsible for loading image from path
   *
   * @param imgFilePath Image file path
   * @return builder instance
   * @throws IOException
   */
  IEnhancedImageBuilder loadImage(final String imgFilePath) throws IOException;

  /**
   * This method is responsible for adding filter in image.
   *
   * @param eFilterType
   * @return
   */
  IEnhancedImageBuilder addFilter(final EFilterType eFilterType);

  /**
   * This method add dither
   *
   * @param isEssence   Add essence or no
   * @param totalColors Total number of colors
   * @return builder instance
   */
  IEnhancedImageBuilder addDither(final boolean isEssence, final int totalColors);

  /**
   * Add image color transformation
   *
   * @param eColorTransformation type of color transformation
   * @return builder instance
   */
  IEnhancedImageBuilder addColorTransformation(final EColorTransformation eColorTransformation);

  /**
   * Save image on disk
   *
   * @param fileName Image file name
   * @return builder instance
   * @throws IllegalArgumentException
   * @throws IOException
   */
  IEnhancedImageBuilder saveImage(String fileName) throws IllegalArgumentException, IOException;

  /**
   * Add mosaic effect w.r.t total number of seeds
   *
   * @param seeds Number of seed
   * @return builder instance
   */
  IEnhancedImageBuilder addMosaic(final int seeds);

  /**
   * Add pixelation on image w.r.t total number of squares provided
   *
   * @param square Total number of squares provided.
   * @return builder instance
   */
  IEnhancedImageBuilder addPixelation(final int square);

  /**
   * Build image, should be called before save
   *
   * @return builder instance
   */
  IEnhancedImageBuilder build();
}
