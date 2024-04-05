package org.example.сommands.all;

import org.example.functionsAndContants.constant.Constants;
import org.example.сommands.Command;

import java.util.Scanner;

public class SetConstantCommand implements Command {
    private final String name = "new_const {const}";
    private final String info = "a command creating a new const. \n" +
            "\t{const} - here you enter your const (for example 'g = 9.81')";
    Scanner in = new Scanner(System.in);
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
        Constants.putConstant(name, func);
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
