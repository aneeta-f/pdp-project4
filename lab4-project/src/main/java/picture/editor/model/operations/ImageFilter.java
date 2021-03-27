package picture.editor.model.operations;

import picture.editor.model.EFilterType;
import picture.editor.model.EOperationType;
import picture.editor.model.Image;
import picture.editor.utils.ImageUtilities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The class represents a ImageFilter that extends AImageOperation. A ImageFilter 
 * has a inputImage, mapFilterTypeKernel and eFilterType.
 *
 */
public class ImageFilter extends AImageOperation {
  private final Image inputImage;
  private final Map<EFilterType, double[][]> mapFilterTypeKernel;
  private final EFilterType eFilterType;

  /**
   * Construct a ImageFilter object that has the provided inputImage 
   * and eFilterType..
   *
   * @param inputImage the inputImage to be given to this ImageFilter.
   * @param eFilterType the eFilterType to be given to this ImageFilter.
   * 
   */
  public ImageFilter(Image inputImage, EFilterType eFilterType) {
    this.inputImage = inputImage;
    this.eFilterType = eFilterType;
    this.mapFilterTypeKernel = new HashMap<>();
    this.initMapFilterTypeKernel();
  }

  private void initMapFilterTypeKernel() {
    double[][] sharpKernel = {
            {-1 / 8f, -1 / 8f, -1 / 8f, -1 / 8f, -1 / 8f},
            {-1 / 8f, 1 / 4f, 1 / 4f, 1 / 4f, -1 / 8f},
            {-1 / 8f, 1 / 4f, 1f, 1 / 4f, -1 / 8f},
            {-1 / 8f, 1 / 4f, 1 / 4f, 1 / 4f, -1 / 8f},
            {-1 / 8f, -1 / 8f, -1 / 8f, -1 / 8f, -1 / 8f}
    };
    this.mapFilterTypeKernel.put(EFilterType.SHARP_FILTER, sharpKernel);

    double[][] blurKernel = {
            {1 / 16f, 1 / 8f, 1 / 16f},
            {1 / 8f, 1 / 4f, 1 / 8f},
            {1 / 16f, 1 / 8f, 1 / 16f}
    };
    this.mapFilterTypeKernel.put(EFilterType.BLUR_FILTER, blurKernel);
  }

  @Override
  public EOperationType getOperationType() {
    return EOperationType.FILTER;
  }

  /**
   * Get the type of the filter.
   * 
   * @return the type of the filter
   */
  public EFilterType getFilterType() {
    return eFilterType;
  }

  @Override
  public void preProcessing() {
    validateKernelMatrix(mapFilterTypeKernel.get(this.eFilterType));
  }

  private int getPixelValue(final int pixelCol, final int pixelRow, final int[][] channelMatrix) {
    int channelMatrixRows = getRows(channelMatrix);
    int channelMatrixColumns = getColumns(channelMatrix);
    if (pixelCol < 0 || pixelRow < 0 || pixelRow >= channelMatrixRows 
        || pixelCol >= channelMatrixColumns) {
      return 0;
    } else {
      return channelMatrix[pixelCol][pixelRow];
    }
  }

  @Override
  public void executeOperation() {
    final Map<ImageUtilities.Channel, int[][]> channelMap = inputImage.convertImageInChannelMap();
    final Map<ImageUtilities.Channel, int[][]> filteredChannelMap = new LinkedHashMap<>();
    final double[][] kernel = this.mapFilterTypeKernel.get(eFilterType);
    final int kernelColumns = getColumns(kernel);
    final int kernelRow = getRows(kernel);
    for (Map.Entry<ImageUtilities.Channel, int[][]> entry : channelMap.entrySet()) {
      int[][] channelMatrix = entry.getValue();
      int imageColumns = getColumns(channelMatrix);
      int imageRows = getRows(channelMatrix);

      int[][] tempChannelMatrix = new int[imageColumns][imageRows];
      for (int i = 0; i < imageColumns; i++) {
        for (int j = 0; j < imageRows; j++) {
          int[][] pixelNeighbours = new int[kernelColumns][kernelRow];
          for (int k = 0; k < kernelColumns; ++k) {
            for (int l = 0; l < kernelRow; ++l) {
              pixelNeighbours[k][l] = getPixelValue(i + (k - 1), j + (l - 1), channelMatrix);
            }
          }
          tempChannelMatrix[i][j] = dotProduct(pixelNeighbours);
        }
      }
      filteredChannelMap.put(entry.getKey(), tempChannelMatrix);
    }
    Image.convertChannelMap2Image(filteredChannelMap, inputImage);
  }

  private int dotProduct(int[][] imagePortion) {
    final double[][] kernel = this.mapFilterTypeKernel.get(eFilterType);
    int columns = getColumns(kernel);
    int rows = getRows(kernel);
    float result = 0;
    for (int i = 0; i < columns; ++i) {
      for (int j = 0; j < rows; ++j) {
        result += imagePortion[i][j] * kernel[i][j];
      }
    }
    return Math.round(result);
  }

  @Override
  public void postProcessing() {
    performClamping(inputImage);
  }

  /**
   * This method is responsible for validating input kernel.
   * 
   * @param inputKernel The inputKernel given to this ImageFilter
   * @throws IllegalArgumentException Throws exception when matrix is not square
   */
  protected void validateKernelMatrix(double[][] inputKernel) throws IllegalArgumentException {

    int rows = getColumns(inputKernel);
    int columns = getRows(inputKernel);

    if (rows != columns) {
      throw new IllegalArgumentException("Kernel should be square matrix.");
    }

    if (rows % 2 != 1 || columns % 2 != 1) {
      throw new IllegalArgumentException("Kernel dimensions should in odd number.");
    }
  }
}
