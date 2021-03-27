package picture.editor.command;

/**
 * This class represents enumeration CommandType. A enumeration CommandType
 * has a list of all the acceptable commands.
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
  
  /**
   * Return the value of this CommandType.
   *
   * @return the value of this CommandType.
   */
  public final String getValue() {
    return value;
  }
}
