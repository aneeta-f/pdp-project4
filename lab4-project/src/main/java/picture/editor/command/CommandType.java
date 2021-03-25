package picture.editor.command;

public enum CommandType {
    LOAD("load"),
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
