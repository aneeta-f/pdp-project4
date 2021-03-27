package picture.editor;

import picture.editor.model.EColorTransformation;
import picture.editor.model.EFilterType;

import java.io.IOException;

/**
 * This class represents the old driver class main of project 3.
 */
public class OldMain {
  
  /**
   * This represent the main body of the class.
   * 
   * @param args the arguments.
   */
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Error: Please provide input image.");
      return;
    }
    try {
      String imageFilePath = args[0];
      EnhancedImageBuilder enhancedImageBuilder1 = new EnhancedImageBuilder(imageFilePath);
      enhancedImageBuilder1
              .addDither(true, 8)
              .build()
              .saveImage("8_values_per_channel_with_essence_");

      EnhancedImageBuilder enhancedImageBuilder2 = new EnhancedImageBuilder(imageFilePath);
      enhancedImageBuilder2
              .addDither(false, 8)
              .build()
              .saveImage("8_values_per_channel_");

      EnhancedImageBuilder enhancedImageBuilder3 = new EnhancedImageBuilder(imageFilePath);
      enhancedImageBuilder3
              .addDither(true, 2)
              .build()
              .saveImage("2_values_per_channel_with_essence_");

      EnhancedImageBuilder enhancedImageBuilder4 = new EnhancedImageBuilder(imageFilePath);
      enhancedImageBuilder4
              .addDither(false, 2)
              .build()
              .saveImage("2_values_per_channel_");

      EnhancedImageBuilder enhancedImageBuilder5 = new EnhancedImageBuilder(imageFilePath);
      enhancedImageBuilder5
              .addColorTransformation(EColorTransformation.GREY_SCALE)
              .build()
              .saveImage("grey_scale_");

      EnhancedImageBuilder enhancedImageBuilder6 = new EnhancedImageBuilder(imageFilePath);
      enhancedImageBuilder6
              .addColorTransformation(EColorTransformation.SEPIA_TONE)
              .build()
              .saveImage("sepia_tone_");

      EnhancedImageBuilder enhancedImageBuilder7 = new EnhancedImageBuilder(imageFilePath);
      enhancedImageBuilder7
              .addFilter(EFilterType.BLUR_FILTER)
              .build()
              .saveImage("blur_filter_");

      EnhancedImageBuilder enhancedImageBuilder8 = new EnhancedImageBuilder(imageFilePath);
      enhancedImageBuilder8
              .addFilter(EFilterType.SHARP_FILTER)
              .build()
              .saveImage("sharp_filter_");
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }
}
