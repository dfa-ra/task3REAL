package org.example.сommands.all;

import org.example.сommands.Command;

public class ExitComman implements Command {
    private final String name = "exit";
    private final String info = "exit the program";
    @Override
    public void execute(String[] tokens) {
        System.exit(0);
    }

    @Override
    public String  getInfo() {
        return info;
    }

    @Override
    public String getName() {
        return name;
    }
}
