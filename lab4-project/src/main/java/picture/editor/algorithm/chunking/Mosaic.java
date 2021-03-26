package picture.editor.algorithm.chunking;

import picture.editor.model.EChunkingStrategy;
import picture.editor.model.Image;
import picture.editor.utils.PixelImpl;

import java.util.*;

public class Mosaic implements IChunkingStrategy {
    private final int seeds;

    public Mosaic(int seeds) {
        this.seeds = seeds;
    }

    private double euclideanCalculator(int column, int row, PixelImpl centroid) {
        double x = Math.pow(column - centroid.getX(), 2);
        double y = Math.pow(row - centroid.getY(), 2);
        return Math.sqrt(x + y);
    }

    private List<PixelImpl> getCentroids(Image image, final int seeds) {
        List<PixelImpl> centroids = new ArrayList<>();
        Random rand = new Random();
        int randX = rand.nextInt(image.getImageWidth());
        int randY = rand.nextInt(image.getImageHeight());
        PixelImpl randomPixel = new PixelImpl(randX, randY, image.getRgbMatrix()[randY][randX]);
        centroids.add(randomPixel);
        while (centroids.size() != seeds) {
            randX = rand.nextInt(image.getImageWidth());
            randY = rand.nextInt(image.getImageHeight());
            randomPixel = new PixelImpl(randX, randY, image.getRgbMatrix()[randY][randX]);
            for (PixelImpl p : centroids) {
                if (!(randomPixel.getX() == p.getX() && randomPixel.getY() == p.getY())) {
                    centroids.add(randomPixel);
                    break;
                }
            }
        }
        return centroids;
    }

    @Override
    public void execute(Image image) {
        int[][][] imageDeepCopy = image.getRgbMatrix();
        int height = image.getImageHeight();
        int width = image.getImageWidth();
        if (seeds > width * height || seeds < 1) {
            throw new IllegalArgumentException("Error: seed number too great or less than 1");
        } else if (seeds == width * height) {
            return;
        }
        List<PixelImpl> centroids = getCentroids(image, seeds);
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                ArrayList<Double> distances = new ArrayList<>();
                for (int i = 0; i < seeds; i++) {
                    distances.add(euclideanCalculator(column, row, centroids.get(i)));
                }
                int min = distances.indexOf(Collections.min(distances));
                centroids.get(min).giveNewColor(imageDeepCopy[row][column]);
            }
        }
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                ArrayList<Double> distances = new ArrayList<>();
                for (int i = 0; i < seeds; i++) {
                    distances.add(euclideanCalculator(column, row, centroids.get(i)));
                }
                int min = distances.indexOf(Collections.min(distances));
                imageDeepCopy[row][column] = centroids.get(min).getAverageColor();
            }
        }
    }

    @Override
    public EChunkingStrategy getChunkingStrategy() {
        return EChunkingStrategy.MOSAIC;
    }
}
