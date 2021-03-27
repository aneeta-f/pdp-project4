package picture.editor.model.operations;

import picture.editor.model.EOperationType;
import picture.editor.model.Image;
import picture.editor.utils.ImageUtilities;

/**
 * This abstract class is responsible for performing image operation.
 */
public abstract class AImageOperation {

  /**
   * Performs pre processing operations.
   */
  public abstract void preProcessing();

  /**
   * Executes operations.
   */
  public abstract void executeOperation();

  /**
   * Performs post processing operations.
   */
  public abstract void postProcessing();

  /**
   * This method is responsible for return operation type.
   * @return EOperationType
   */
  public abstract EOperationType getOperationType();

  /**
   * This method is responsible for performing clamping.
   * @param image the image given to this AImageOperation.
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
   * @param matrix Provided input matrix
   * @return Total number of rows in a matrix
   */
  int getColumns(final double[][] matrix) {
    return matrix.length;
  }
  
  /**
   * This function is responsible for finding matrix total columns.
   *
   * @param matrix Provided input matrix
   * @return Total number of columns in a matrix
   */
  int getColumns(final int[][] matrix) {
    return matrix.length;
  }

  /**
   * This method is responsible for finding total number of columns in a matrix.
   *
   * @param matrix Provided input matrix
   * @return Total number of columns in a matrix
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
   * @param matrix Provided input matrix
   * @return Total number of rows in a matrix
   * @throws IllegalArgumentException Throws exception when provided matrix is empty
   */
  int getRows(final int[][] matrix) throws IllegalArgumentException {
    if (matrix.length < 1) {
      throw new IllegalArgumentException("Empty matrix is provided.");
    }
    return matrix[0].length;
  }
}
