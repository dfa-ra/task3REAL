package org.example.сommands.all;

import org.example.functionsAndContants.constant.Constant;
import org.example.сommands.Command;

public class CalculateConstCommand implements Command {
    private final String name = "print {example}";
    private final String info = "command responsible for outputting the result during the evaluation of an example.\n" +
            "\t {example} - your example (like '4 * 7 ^ (4/5*2) * sin(99)'), you can use constant for your ex.";

    @Override
    public void execute(String[] tokens) throws Exception {
        String str = "";
        for (int i = 1; i < tokens.length; i++) {
            str += tokens[i];
        }
        System.out.println(Constant.constF(str));
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
