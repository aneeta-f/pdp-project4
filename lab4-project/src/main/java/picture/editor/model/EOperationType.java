package picture.editor.model;

public enum  EOperationType {
    FILTER ("Image Filter"),
    COLOR_TRANSFORMATION ("Color Transformation"),
    DITHER("Image Dither"),
    MOSAIC("Image Mosaic"),
    PATTERN_GEN("Pattern Generation"),
    PIXELATION("Image Pixelation");

    private final String value;

    private EOperationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
