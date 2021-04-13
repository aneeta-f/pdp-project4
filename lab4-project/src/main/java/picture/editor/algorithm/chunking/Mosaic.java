package picture.editor.algorithm.chunking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import picture.editor.model.EChunkingStrategy;
import picture.editor.model.Image;
import picture.editor.utils.Pixel;


/**
 * The class represents a Mosaic that implements IChunkingStrategy. A Mosaic 
 * class has a seed.
 *
 */
public class Mosaic implements IChunkingStrategy {
  private final int seeds;

  /**
   * Construct a Mosaic object that has the provided seeds..
   *
   * @param seeds  The seeds to be given to this Mosaic.
   * 
   */
  public Mosaic(int seeds) {
    this.seeds = seeds; 
  }

  private double euclideanCalculator(int column, int row, Pixel centroid) {
    double x = Math.pow(column - centroid.getX(), 2);
    double y = Math.pow(row - centroid.getY(), 2);
    return Math.sqrt(x + y);
  }

  private List<Pixel> getCentroids(Image image, final int seeds) {
    List<Pixel> centroids = new ArrayList<>();
    Random rand = new Random();
    int randX = rand.nextInt(image.getImageWidth());
    int randY = rand.nextInt(image.getImageHeight());
    Pixel randomPixel = new Pixel(randX, randY, image.getRgbMatrix()[randY][randX]);
    centroids.add(randomPixel);
    while (centroids.size() != seeds) {
      randX = rand.nextInt(image.getImageWidth());
      randY = rand.nextInt(image.getImageHeight());
      randomPixel = new Pixel(randX, randY, image.getRgbMatrix()[randY][randX]);
      for (Pixel p : centroids) {
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
    List<Pixel> centroids = getCentroids(image, seeds);
    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        ArrayList<Double> distances = new ArrayList<>();
        for (int i = 0; i < seeds; i++) {
          distances.add(euclideanCalculator(column, row, centroids.get(i)));
        }
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
