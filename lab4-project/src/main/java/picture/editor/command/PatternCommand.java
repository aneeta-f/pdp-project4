package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

public class PatternCommand extends ACommand{
    public PatternCommand(IEnhancedImageBuilder enhancedImageBuilder) {
        super(enhancedImageBuilder);
    }

    @Override
    public String execute() {
        return "";
    }
}
