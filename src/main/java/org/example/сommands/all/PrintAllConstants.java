package org.example.сommands.all;

import org.example.functionsAndContants.constant.Constants;
import org.example.сommands.Command;

import java.util.Map;

public class PrintAllConstants implements Command {
    private final String name = "print_all_const";
    private final String info = "enters the entered constants";
    @Override
    public void execute(String[] tokens) throws Exception {
        for (Map.Entry<String, String> entry : Constants.getConstants().entrySet()) {
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
