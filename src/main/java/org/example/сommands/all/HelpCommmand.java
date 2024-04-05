package org.example.сommands.all;

import org.example.expressionParser.operations.OperationManager;
import org.example.functionsAndContants.constant.Constants;
import org.example.сommands.Command;
import org.example.сommands.Invoker;

import java.util.Map;

public class HelpCommmand implements Command {
    private final String name = "help";
    private final String info = "help";
    @Override
    public void execute(String[] tokens) throws Exception {
        Invoker invoker = new Invoker();

        System.out.println("===========================================");
        System.out.println("This wonderful program is designed for fun and performing IDZ \n" +
                "and perhaps other tasks in mathematical analysis. With its help,\n" +
                "you can draw graphs and calculate the integrals of various functions.\n" +
                "The program supports complex functions and function compositions.\n\n" +
                "The program supports such mathematical operations as: ");
        System.out.print("\t");
        for (Map.Entry<String, OperationManager.Operate> entry : OperationManager.getOperations().entrySet()){
            if (entry.getValue().getPriority() > 0)
                System.out.printf(entry.getKey() + ", ");
        }
        System.out.println();
        System.out.println("The program supports such constants as: ");
        System.out.print("\t");
        for (Map.Entry<String, String> entry : Constants.getConstants().entrySet()){
            System.out.printf(entry.getKey() + ", ");
        }
        System.out.println();
        System.out.println("Commands: ");

        for (Map.Entry<String, Command> entry : invoker.getCommands().entrySet()){
            System.out.println("-- " + entry.getValue().getName() + " - " + entry.getValue().getInfo());
        }
        System.out.println("===========================================");
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
