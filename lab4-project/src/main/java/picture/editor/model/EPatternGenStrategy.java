package picture.editor.model;

public enum EPatternGenStrategy {
    CLOSEST_COLOR ("Closest Color"),
    TEXT_PATTERN ("Text Pattern");

    private final String value;

    private EPatternGenStrategy(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
