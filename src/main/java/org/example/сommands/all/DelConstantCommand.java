package org.example.сommands.all;

import org.example.functionsAndContants.constant.Constants;
import org.example.сommands.Command;

public class DelConstantCommand implements Command {
    private final String name = "del_const {name}";
    private final String info = "it's obvious what she's doing";
    @Override
    public void execute(String[] tokens) throws Exception {
        Constants.removeConstant(tokens[1]);
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public String getName() {
        return name;
    }
}
