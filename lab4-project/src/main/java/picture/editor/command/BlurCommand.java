package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;
import picture.editor.model.EFilterType;

public class BlurCommand extends ACommand {
    public BlurCommand(IEnhancedImageBuilder enhancedImageBuilder) {
        super(enhancedImageBuilder);
    }

    @Override
    public String execute() {
        enhancedImageBuilder.addFilter(EFilterType.BLUR_FILTER);
        return "";
    }
}
