package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

public class UploadCommand extends ACommand{

    private final String imageFilePath;

    public UploadCommand(final IEnhancedImageBuilder enhancedImageBuilder, final String imageFilePath) {
        super(enhancedImageBuilder);
        this.imageFilePath = imageFilePath;
    }

    @Override
    public String execute() {
        try {
            this.enhancedImageBuilder.loadImage(this.imageFilePath);
        } catch (Exception exception) {
            return "Failed to load input image: " + this.imageFilePath + "\n";
        }
        return "";
    }
}
