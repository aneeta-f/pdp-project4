package picture.editor;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * This test enhanced image controller class.
 */
public class EnhancedImageControllerTest {

  private IEnhancedImageBuilder model;
  private StringBuilder log;
  private EnhancedImageController enhancedImageController;

  /**
   * This function is responsible for initializing class attributes.
   */
  @Before
  public void setup() {
    log = new StringBuilder();
    model = new MockEnhancedImageBuilder(log);
  }   
  
  /**
   * This function is responsible for testing validation of 
   * nullReaderTest.
   */
  @Test(expected = IllegalArgumentException.class)
  public void nullReaderTest() {
    StringBuilder out = new StringBuilder();
    enhancedImageController = new EnhancedImageController(null, out);
  }
  
  /**
   * This function is responsible for testing validation of nullOutputTest.
   */
  @Test(expected = IllegalArgumentException.class)
  public void nullOutputTest() {
    Reader in = new StringReader("load file1.png");
    enhancedImageController = new EnhancedImageController(in, null);
  }
  
  /**
   * This function is responsible for testing validation of
   *  bothNullReaderAndOutputTest.
   */
  @Test(expected = IllegalArgumentException.class)
  public void bothNullReaderAndOutputTest() {
    enhancedImageController = new EnhancedImageController(null, null);
  }
  
  /**
   * This function is responsible for testing validation of 
   * nullBuilderStartTest.
   */
  @Test(expected = IllegalArgumentException.class)
  public void nullBuilderStartTest() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("load file1.png");
    enhancedImageController = new EnhancedImageController(in, out);
    try {
      enhancedImageController.start(null);
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }
  
  /**
   * This function is responsible for testing uploadCommandTest().
   */
  @Test
  public void uploadCommandTest() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("upload file1.png q");
    enhancedImageController = new EnhancedImageController(in, out);
    try {
      enhancedImageController.start(model);
      String expected = "Input Image: file1.png\n";
      assertEquals(expected, log.toString());
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }

  /**
   * This function is responsible for testing unknownCommandTest.
   */
  @Test
  public void unknownCommandTest() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("abc q");
    enhancedImageController = new EnhancedImageController(in, out);
    try {
      enhancedImageController.start(model);

      String expected = "'abc' is unsupported.\n";
      assertEquals(expected, out.toString());
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }

  /**
   * This function is responsible for testing saveCommandTest.
   */
  @Test
  public void saveCommandTest() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("save filename.png q");
    enhancedImageController = new EnhancedImageController(in, out);
    try {
      enhancedImageController.start(model);
      String expected = "Building enhanced image: \n"
              + "Saving image: filename.png\n";
      assertEquals(expected, log.toString());
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }

  /**
   * This function is responsible for testing blurCommandTest.
   */
  @Test
  public void blurCommandTest() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("upload file.png blur save blur.png q");
    enhancedImageController = new EnhancedImageController(in, out);
    try {
      enhancedImageController.start(model);
      String expected = "Input Image: file.png\n" 
              + "Adding Filter: BLUR_FILTER\n" 
              + "Building enhanced image: \n" 
              + "Saving image: blur.png\n";
      assertEquals(expected, log.toString());
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }
  
  /**
   * This function is responsible for testing greyCommandTest.
   */
  @Test
  public void greyCommandTest() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("upload file.png grey save grey.png q");
    enhancedImageController = new EnhancedImageController(in, out);
    try {
      enhancedImageController.start(model);
      String expected = "Input Image: file.png\n"
              + "Adding Color Transformation: GREY_SCALE\n" 
              + "Building enhanced image: \n" 
              + "Saving image: grey.png\n";
      assertEquals(expected, log.toString());
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }

  /**
   * This function is responsible for testing sepiaCommandTest.
   */
  @Test
  public void sepiaCommandTest() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("upload file.png sepia save sepia.png q");
    enhancedImageController = new EnhancedImageController(in, out);
    try {
      enhancedImageController.start(model);
      String expected = "Input Image: file.png\n" 
              + "Adding Color Transformation: SEPIA_TONE\n"
              + "Building enhanced image: \n" 
              + "Saving image: sepia.png\n";
      assertEquals(expected, log.toString());
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }

  /**
   * This function is responsible for testing sharpCommandTest.
   */
  @Test
  public void sharpCommandTest() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("upload file.png sharp save sharp.png q");
    enhancedImageController = new EnhancedImageController(in, out);
    try {
      enhancedImageController.start(model);
      String expected = "Input Image: file.png\n"
              + "Adding Filter: SHARP_FILTER\n"
              + "Building enhanced image: \n" 
              + "Saving image: sharp.png\n";
      assertEquals(expected, log.toString());
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }

  /**
   * This function is responsible for testing mosaicCommandTest.
   */
  @Test
  public void mosaicCommandTest() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("upload file.png mosaic 1000 save mosaic.png q");
    enhancedImageController = new EnhancedImageController(in, out);
    try {
      enhancedImageController.start(model);
      String expected = "Input Image: file.png\n"
              + "Adding mosaic with seeds: 1000\n"
              + "Building enhanced image: \n"
              + "Saving image: mosaic.png\n";
      assertEquals(expected, log.toString());
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }

  /**
   * This function is responsible for testing pixelateCommandTest.
   */
  @Test
  public void pixelateCommandTest() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("upload file.png pixelate 1000 save pixelate.png q");
    enhancedImageController = new EnhancedImageController(in, out);
    try {
      enhancedImageController.start(model);
      String expected = "Input Image: file.png\n" 
             + "Adding pixelation with squares: 1000\n"
             + "Building enhanced image: \n" 
             + "Saving image: pixelate.png\n";
      assertEquals(expected, log.toString());
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }

  /**
   * This function is responsible for testing ditherWithEssenceCommandTest.
   */
  @Test
  public void ditherWithEssenceCommandTest() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("upload file.png dither 2 essence save dither.png q");
    enhancedImageController = new EnhancedImageController(in, out);
    try {
      enhancedImageController.start(model);
      String expected = "Input Image: file.png\n" 
              + "Adding Dither, total colors: 2 essence: true\n" 
              + "Building enhanced image: \n"
              + "Saving image: dither.png\n";
      assertEquals(expected, log.toString());
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }

  /**
   * This function is responsible for testing ditherWithoutEssenceCommandTest.
   */
  @Test
  public void ditherWithoutEssenceCommandTest() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("upload file.png dither 2 withoutessence save dither.png q");
    enhancedImageController = new EnhancedImageController(in, out);
    try {
      enhancedImageController.start(model);
      String expected = "Input Image: file.png\n" 
          + "Adding Dither, total colors: 2 essence: false\n" 
          + "Building enhanced image: \n" 
          + "Saving image: dither.png\n";
      assertEquals(expected, log.toString());
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }
}
