package picture.editor;

import picture.editor.command.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

/**
 * This class is controller class responsible for handling all the user provided commands.
 */
public class EnhancedImageController {
  private final Readable in;
  private final Appendable out;

  /**
   * Parameterized constructor to create class instance.
   *
   * @param in  from where read
   * @param out where to write
   */
  public EnhancedImageController(Readable in, Appendable out) {
    this.in = in;
    this.out = out;
  }

  /**
   * Method that gives control to the controller.
   *
   * @param model the model to use.
   * @throws IOException if something goes wrong appending to out
   */
  public void start(EnhancedImageBuilder model) throws IOException {
    Objects.requireNonNull(model);
    String imageFilePath;
    Scanner scan = new Scanner(this.in);
    while (true) {

      String command = scan.next();
      Optional<CommandType> optCommandType = Arrays.stream(
          CommandType.values()).filter(
              commandType -> commandType.getValue().equalsIgnoreCase(command)).findFirst();

      CommandType commandType = CommandType.UNKNOWN;
      if (optCommandType.isPresent()) {

        commandType = optCommandType.get();
      }

      ACommand aCommand = null;
      switch (commandType) {
        case UPLOAD:
          imageFilePath = scan.next();
          aCommand = new UploadCommand(model, imageFilePath);
          break;
        case SAVE:
          imageFilePath = scan.next();
          aCommand = new SaveCommand(model, imageFilePath);
          break;
        case BLUR:
          aCommand = new BlurCommand(model);
          break;
        case GREY:
          aCommand = new GreyCommand(model);
          break;
        case SEPIA:
          aCommand = new SepiaCommand(model);
          break;
        case SHARP:
          aCommand = new SharpCommand(model);
          break;
        case MOSAIC:
          final int seeds = scan.nextInt();
          aCommand = new MosaicCommand(model, seeds);
          break;
        case PIXELATE:
          final int squares = scan.nextInt();
          aCommand = new PixelateCommand(model, squares);
          break;
        case PATTERN:
          aCommand = new PatternCommand(model);
          break;
        case DITHER:
          final int totalColors = scan.nextInt();
          final String essence = scan.next();
          final boolean isEssence = essence.equalsIgnoreCase("essence");
          aCommand = new DitherCommand(model, totalColors, isEssence);
          break;
        case QUIT:
          scan.close();
          return;
        default:
          this.out.append(String.format("'%s' is unsupported.\n", command));
      }

      if (aCommand != null) {
        String message = aCommand.execute();
        this.out.append(message);
      }
    }
  }

  /**
   * Main method.
   *
   * @param args Input arguments
   */
  public static void main(String[] args) {
    try {
      String filePath = "";
      boolean isFileProvided = false;
      if (args.length > 0) {
        filePath = args[0];
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {

          isFileProvided = true;
        }
      }


      EnhancedImageBuilder enhancedImageBuilder = new EnhancedImageBuilder();

      // Create the controller
      Readable reader;

      if (isFileProvided) {

        reader = new InputStreamReader(new FileInputStream(filePath));
      } else {
        reader = new InputStreamReader(System.in);
      }

      EnhancedImageController enhancedImageController = new 
          EnhancedImageController(reader, System.out);

      // Start controller
      enhancedImageController.start(enhancedImageBuilder);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
