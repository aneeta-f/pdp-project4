package picture.editor.command;

/**
 * This enum class list all the acceptable commands.
 */
public enum CommandType {
  UPLOAD("upload"),
  SAVE("save"),

  BLUR("blur"),
  SHARP("sharp"),

  GREY("grey"),
  SEPIA("sepia"),

  DITHER("dither"),

  MOSAIC("mosaic"),
  PIXELATE("pixelate"),
  PATTERN("pattern"),

  QUIT("q"),
  UNKNOWN("unknown");

  private String value;

  private CommandType(String value) {
    this.value = value;
  }

  public final String getValue() {
    return value;
  }
}
