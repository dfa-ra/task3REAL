package org.example.сommands.all;

import org.example.functionsAndContants.func.Functions;
import org.example.сommands.Command;

import java.util.Map;

public class PrintAllFunctions implements Command {
    private final String name = "print_all_func";
    private final String info = "enters the entered functions";
    @Override
    public void execute(String[] tokens) throws Exception {
        for (Map.Entry<String, String> entry : Functions.getFunctions().entrySet()) {
            String key = entry.getKey();
            String  value = entry.getValue();
            System.out.println(key + " = " + value);
        }
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
