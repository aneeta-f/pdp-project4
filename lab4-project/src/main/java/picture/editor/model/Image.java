package picture.editor.model;

import picture.editor.utils.ImageUtilities;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The class represents a Image. A Image has a 3D rgbMatrix.
 *
 */
public class Image {
  private final int[][][] rgbMatrix;

  /**
   * Construct a Image object that has the provided 3D rgbMatrix..
   *
   * @param rgbMatrix  the 3D rgbMatrix to be given to this Image.
   */
  public Image(int[][][] rgbMatrix) {
    this.rgbMatrix = rgbMatrix;
  }

  /**
   * Construct another Image object that has the provided filename..
   *
   * @param filename  the 3D filename to be given to this Image.
   * @throws IOException if there is an error reading the file. 
   */
  public Image(String filename) throws IOException {
    this(ImageUtilities.readImage(filename));
  }

  /**
   * The getRgbMatrix function is responsible to get 3D matrix 
   * of red, green and blue. 
   *
   * @return the rgbMatrix of this Image.
   */
  public int[][][] getRgbMatrix() {
    return rgbMatrix;
  }

  /**
   * The method is responsible to return channel matrix.
   * 
   * @param channel The channel given to this image
   * @return the channel matrix
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
   * The convertImageInChannelMap function is responsible to 
   * convert 3D matrix of channel red, green and blue in a map. 
   *
   * @return the map of each channel of the image.
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
   * The width of the image in a file.
   * 
   * @return The width of the image contained in the file.
   */
  public int getImageWidth() {
    return this.rgbMatrix[0].length;
  }

  /**
   * The height of the image in a file.
   * 
   * @return The height of the image contained in the file.
   */
  public int getImageHeight() {
    return this.rgbMatrix.length;
  }

  /**
   * The convertChannelMap2Image converts the output image in map .
   * 
   * @param channelMap The channelMap of the image.
   * @param refOutputImage The output image.
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
