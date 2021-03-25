package picture.editor.model;

import picture.editor.utils.ImageUtilities;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Image {
    private final int [][][] rgbMatrix;


    public Image(int[][][] rgbMatrix) {
        this.rgbMatrix = rgbMatrix;
    }

    public Image(String filename) throws IOException {
        this(ImageUtilities.readImage(filename));
    }

    public int[][][] getRgbMatrix() {
        return rgbMatrix;
    }

    private int[][] getChannelMatrix(ImageUtilities.Channel channel) {
        int[][] channelMatrix = new int[rgbMatrix.length][rgbMatrix[0].length];
        for (int i = 0; i < rgbMatrix.length; ++i) {
            for (int j = 0; j < rgbMatrix[0].length; ++j) {
                channelMatrix[i][j] = rgbMatrix[i][j][channel.ordinal()];
            }
        }
        return channelMatrix;
    }

    public Map<ImageUtilities.Channel, int[][]> convertImageInChannelMap(){
        final Map<ImageUtilities.Channel, int[][]> channelMap = new LinkedHashMap<>();

        int[][] redMatrix = getChannelMatrix(ImageUtilities.Channel.RED);
        channelMap.put(ImageUtilities.Channel.RED, redMatrix);

        int[][] greenMatrix = getChannelMatrix(ImageUtilities.Channel.GREEN);
        channelMap.put(ImageUtilities.Channel.GREEN, greenMatrix);

        int[][] blueMatrix = getChannelMatrix(ImageUtilities.Channel.BLUE);
        channelMap.put(ImageUtilities.Channel.BLUE, blueMatrix);

        return channelMap;
    }

    public int getImageWidth(){
        return this.rgbMatrix[0].length;
    }

    public int getImageHeight(){
        return this.rgbMatrix.length;
    }

    public static void convertChannelMap2Image(Map<ImageUtilities.Channel, int[][]> channelMap, Image refOutputImage){
        int [][][] image = refOutputImage.getRgbMatrix();
        for(Map.Entry<ImageUtilities.Channel, int[][]> entry : channelMap.entrySet()){
            int[][] channelMatrix = entry.getValue();
            for(int i=0; i<channelMatrix.length; ++i){
                for(int j=0; j<channelMatrix[0].length; ++j){
                    image[i][j][entry.getKey().ordinal()] = channelMatrix[i][j];
                }
            }
        }
    }
}
