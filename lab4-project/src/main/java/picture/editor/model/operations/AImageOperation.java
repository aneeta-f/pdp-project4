package picture.editor.model.operations;

import picture.editor.model.EOperationType;
import picture.editor.model.Image;
import picture.editor.utils.ImageUtilities;

/**
 * The AImageOperation represents the abstract class that 
 * determines the methods that performs in the image.
 *
 */
public abstract class AImageOperation {

  /**
   * This stage validates all inputs provided by user Validate image file path, 
   * output file location e.t.c.
   *
   * @throws IllegalArgumentException if the no of rows and no columns are not equal.
   * @throws IllegalArgumentException if the kernel dimensions are not in odd number.
   */
  public abstract void preProcessing();

  /**
   * This stage executes logic behind enhancement technique.
   *
   */
  public abstract void executeOperation();

  /**
   * This stage is responsible for any post processing steps i.e. Clamping e.t.c.
   *
   */
  public abstract void postProcessing();

  /**
   * Gets the type of operation that can be performed in the image.  
   *
   * @return EOperationType.
   */
  public abstract EOperationType getOperationType();

  /**
   * Performing clamping in the image.  
   *
   * @param image the input image. 
   */
  void performClamping(Image image) {
    int[][][] rgbMatrix = image.getRgbMatrix();
    for (int i = 0; i < rgbMatrix.length; ++i) {
      for (int j = 0; j < rgbMatrix[0].length; ++j) {
        for (int k = 0; k < ImageUtilities.Channel.values().length; ++k) {
          int value = rgbMatrix[i][j][k];
          if (value < 0) {
            value = 0;
          } else if (value > 255) {
            value = 255;
          }
          rgbMatrix[i][j][k] = value;
        }
      }
    }
  }

  /**
   * This function is responsible for finding matrix total rows.
   * 
   * @param matrix  Provided input matrix
   * @return        Total number of rows in a matrix
   */
  int getColumns(final double[][] matrix) {
    return matrix.length;
  }
  
  /**
   * This function is responsible for finding matrix total columns.
   * 
   * @param matrix  Provided input matrix
   * @return        Total number of columns in a matrix
   */
  int getColumns(final int[][] matrix) {
    return matrix.length;
  }

  /**
   * This method is responsible for finding total number of columns in a matrix.
   * 
   * @param matrix  Provided input matrix
   * @return        Total number of columns in a matrix
   * @throws IllegalArgumentException Throws exception when provided matrix is empty
   */
  int getRows(final double[][] matrix) throws IllegalArgumentException {
    if (matrix.length < 1) {
      throw new IllegalArgumentException("Empty matrix is provided.");
    }
    return matrix[0].length;
  }
  
  /**
   * This method is responsible for finding total number of rows in a matrix.
   * 
   * @param matrix  Provided input matrix
   * @return        Total number of rows in a matrix
   * @throws IllegalArgumentException Throws exception when provided matrix is empty
   */
  int getRows(final int[][] matrix) throws IllegalArgumentException {
    if (matrix.length < 1) {
      throw new IllegalArgumentException("Empty matrix is provided.");
    }
    return matrix[0].length;
  }
}
