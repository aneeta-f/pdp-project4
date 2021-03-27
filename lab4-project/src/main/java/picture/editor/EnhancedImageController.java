package picture.editor;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import picture.editor.command.ACommand;
import picture.editor.command.BlurCommand;
import picture.editor.command.CommandType;
import picture.editor.command.DitherCommand;
import picture.editor.command.GreyCommand;
import picture.editor.command.MosaicCommand;
import picture.editor.command.PatternCommand;
import picture.editor.command.PixelateCommand;
import picture.editor.command.SaveCommand;
import picture.editor.command.SepiaCommand;
import picture.editor.command.SharpCommand;
import picture.editor.command.UploadCommand;

/**
 * The class represents a EnhancedImageController. A EnhancedImageController has a 
 * input to read and output to write the image.
 */
public class EnhancedImageController {
  private final Readable in;
  private final Appendable out;

  /**
   * Construct a EnhancedImageController object that has the provided input and output..
   *
   * @param in  in given to this EnhancedImageController
   * @param out out given to this EnhancedImageController
   */
  public EnhancedImageController(Readable in, Appendable out) {
    validate(in, out);
    this.in = in;
    this.out = out;
  }

  private void validate(Readable in, Appendable out) {
    if (in == null || out == null) {

      throw new IllegalArgumentException();
    }
  }

  /**
   * This method is responsible that gives control to the controller.
   *
   * @param model model given to this EnhancedImageController.
   * @throws IOException if something goes wrong appending to out.
   */
  public void start(IEnhancedImageBuilder model) throws IOException {

    if (model == null) {

      throw new IllegalArgumentException("Model cannot be null");
    }
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
        case UNKNOWN:
        default:
          //I am not throwing unsuported exception here because I don't want to exit my scan here.
          //want to give next try to user.
          this.out.append(String.format("'%s' is unsupported.\n", command));
      }

      if (aCommand != null) {
        String message = aCommand.execute();
        this.out.append(message);
      }
    }
  }

  /**
   * This represent the main body of the class.
   *
   * @param args the arguments.
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
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
