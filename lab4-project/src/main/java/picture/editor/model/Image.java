package picture.editor.model;

import picture.editor.utils.ImageUtilities;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class is represents image model.
 */
public class Image {
  private final int[][][] rgbMatrix;

  /**
   * Parameterized constructor that accepts rgbMatrix.
   * @param rgbMatrix the rgbMatrix given to this Image
   */
  public Image(int[][][] rgbMatrix) {
    this.rgbMatrix = rgbMatrix;
  }

  /**
   * Parameterized constructor that accepts image file.
   * @param filename the filename given to this Image
   */
  public Image(String filename) throws IOException {
    this(ImageUtilities.readImage(filename));
  }

  /**
   * Returns rgb matrix.
   * @return
   */
  public int[][][] getRgbMatrix() {
    return rgbMatrix;
  }

  /**
   * Return channel matrix.
   * @param channel the channel given to this image
   * @return
   */
  private int[][] getChannelMatrix(ImageUtilities.Channel channel) {
    int[][] channelMatrix = new int[rgbMatrix.length][rgbMatrix[0].length];
    for (int i = 0; i < rgbMatrix.length; ++i) {
      for (int j = 0; j < rgbMatrix[0].length; ++j) {
        channelMatrix[i][j] = rgbMatrix[i][j][channel.ordinal()];
      }
    }
    return channelMatrix;
  }

  /**
   * Returns image channel map.
   * @return
   */
  public Map<ImageUtilities.Channel, int[][]> convertImageInChannelMap() {
    final Map<ImageUtilities.Channel, int[][]> channelMap = new LinkedHashMap<>();
    int[][] redMatrix = getChannelMatrix(ImageUtilities.Channel.RED);
    channelMap.put(ImageUtilities.Channel.RED, redMatrix);
    int[][] greenMatrix = getChannelMatrix(ImageUtilities.Channel.GREEN);
    channelMap.put(ImageUtilities.Channel.GREEN, greenMatrix);
    int[][] blueMatrix = getChannelMatrix(ImageUtilities.Channel.BLUE);
    channelMap.put(ImageUtilities.Channel.BLUE, blueMatrix);
    return channelMap;
  }

  /**
   * Return image width.
   * @return
   */
  public int getImageWidth() {
    return this.rgbMatrix[0].length;
  }

  /**
   * Returns image height.
   * @return
   */
  public int getImageHeight() {
    return this.rgbMatrix.length;
  }

  /**
   * Convert channel map to image.
   * @param channelMap the channelMap given to this Image
   * @param refOutputImage the refOutputImage given to this Image
   */
  
  public static void convertChannelMap2Image(Map<ImageUtilities.Channel, int[][]> 
      channelMap, Image refOutputImage) {
    int[][][] image = refOutputImage.getRgbMatrix();
    for (Map.Entry<ImageUtilities.Channel, int[][]> entry : channelMap.entrySet()) {
      int[][] channelMatrix = entry.getValue();
      for (int i = 0; i < channelMatrix.length; ++i) {
        for (int j = 0; j < channelMatrix[0].length; ++j) {
          image[i][j][entry.getKey().ordinal()] = channelMatrix[i][j];
        }
      }
    }
  }
}
