package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;
import picture.editor.model.EFilterType;

public class SharpCommand extends ACommand{

    public SharpCommand(IEnhancedImageBuilder enhancedImageBuilder) {
        super(enhancedImageBuilder);
    }

    @Override
    public String execute() {
        enhancedImageBuilder.addFilter(EFilterType.SHARP_FILTER);
        return "";
    }
}
