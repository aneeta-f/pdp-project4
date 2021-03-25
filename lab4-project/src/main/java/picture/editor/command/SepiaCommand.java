package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;
import picture.editor.model.EColorTransformation;

public class SepiaCommand extends ACommand{
    public SepiaCommand(IEnhancedImageBuilder enhancedImageBuilder) {
        super(enhancedImageBuilder);
    }

    @Override
    public String execute() {
        enhancedImageBuilder.addColorTransformation(EColorTransformation.SEPIA_TONE);
        return "";
    }
}
