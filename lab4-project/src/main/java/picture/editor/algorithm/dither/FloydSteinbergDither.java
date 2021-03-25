package picture.editor.algorithm.dither;

import picture.editor.model.Image;
import picture.editor.utils.ImageUtilities;

import java.util.Map;

public class FloydSteinbergDither implements IDither{
    private boolean isEssence;
    private int totalColors;

    public FloydSteinbergDither(boolean isEssence, int totalColors) {
        this.isEssence = isEssence;
        this.totalColors = totalColors;
    }

    private void increasePixelValueBy(int col, int row, int[][]channelMatrix, float value) {
        if (col < 0 || row < 0 || col >= channelMatrix.length || row >= channelMatrix[0].length) {
            return;
        }

        channelMatrix[col][row] = channelMatrix[col][row] + Math.round(value);
    }

    private float findClosesPaletteColor(final int oldPixel, final int totalColors){
        float maxColor = 255f;
        float rangeSize = maxColor/totalColors;

        if(oldPixel<=0)
            return 0;

        for(int i=0; i<totalColors; ++i){
            float min = i*rangeSize;
            float max = min + rangeSize;
            if(oldPixel>min && oldPixel<=max){
                return max;
            }
        }

        throw new IllegalArgumentException("Invalid pixel value.");
    }

    @Override
    public void execute(Image image) {
        final Map<ImageUtilities.Channel, int[][]> channelMap = image.convertImageInChannelMap();
        for(Map.Entry<ImageUtilities.Channel, int[][]> entry : channelMap.entrySet()){
            int[][] channelMatrix = entry.getValue();
            int height = channelMatrix.length;
            int width = channelMatrix[0].length;

            for(int y=0; y<height; ++y){
                for(int x=0; x<width; ++x){
                    int oldPixel = channelMatrix[y][x];
                    float newPixel = findClosesPaletteColor(oldPixel,totalColors);
                    channelMatrix[y][x] = Math.round(newPixel);

                    if(isEssence) {
                        float error = oldPixel - newPixel;
                        increasePixelValueBy(y + 1, x, channelMatrix, error * (7 / 16f));
                        increasePixelValueBy(y - 1, x + 1, channelMatrix, error * (3 / 16f));
                        increasePixelValueBy(y, x + 1, channelMatrix, error * (5 / 16f));
                        increasePixelValueBy(y + 1, x + 1, channelMatrix, error * (1 / 16f));
                    }
                }
            }
        }
        Image.convertChannelMap2Image(channelMap, image);
    }
}
