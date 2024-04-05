package org.example.сommands.all;

import org.example.functionsAndContants.func.Functions;
import org.example.сommands.Command;

import java.util.Scanner;


public class SetFunctionCommand implements Command {
    private final String name = "new_func {func}";
    private final String info = "a command creating a new function. \n" +
            "\t{func} - here you enter your function (for example 'f = x^2+sin(2^x)')";
    @Override
    public void execute(String[] tokens) throws Exception {
        boolean flag = false;
        String name = "";
        String func = "";
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i].equals("=")) {
                flag = true;
                continue;
            }

            if (!flag) name += tokens[i];
            else func += tokens[i];
        }
        Functions.putFunction(name, func);
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
