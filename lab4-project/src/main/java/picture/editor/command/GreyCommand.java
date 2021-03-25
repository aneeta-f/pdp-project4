package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;
import picture.editor.model.EColorTransformation;

public class GreyCommand extends ACommand{
    public GreyCommand(IEnhancedImageBuilder enhancedImageBuilder) {
        super(enhancedImageBuilder);
    }

    @Override
    public String execute() {
        enhancedImageBuilder.addColorTransformation(EColorTransformation.GREY_SCALE);
        return "";
    }
}
