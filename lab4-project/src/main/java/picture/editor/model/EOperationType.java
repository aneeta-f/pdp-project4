package picture.editor.model;

public enum  EOperationType {
    FILTER ("Image Filter"),
    COLOR_TRANSFORMATION ("Color Transformation"),
    COLOR_DENSITY("Color Density"),
    CHUNKING("Image Chunking"),
    PATTERN_GEN("Pattern Generation");

    private final String value;

    private EOperationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
