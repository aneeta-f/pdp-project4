package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

public class SaveCommand extends ACommand{

    private final String imageFilePath;

    public SaveCommand(final IEnhancedImageBuilder enhancedImageBuilder, final String imageFilePath) {
        super(enhancedImageBuilder);
        this.imageFilePath = imageFilePath;
    }

    @Override
    public String execute() {
        try {
            enhancedImageBuilder.build();
            enhancedImageBuilder = enhancedImageBuilder.saveImage(imageFilePath);
        }catch (Exception e){
            return "Failed to save image: " + this.imageFilePath + "\n";
        }
        return "";
    }
}
