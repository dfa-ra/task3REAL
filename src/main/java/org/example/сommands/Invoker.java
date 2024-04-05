package org.example.сommands;

import lombok.Getter;
import lombok.Setter;
import org.example.сommands.all.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс реализующий взаимодействие с пользователем.
 */
@Getter
@Setter
public class Invoker {
    protected Map<String, Command> commands = new HashMap<>();

    Scanner in = new Scanner(System.in);
    public Invoker(){
        commands.put("help", new HelpCommmand());
        commands.put("calculate", new CalculateIntegralCommand());
        commands.put("print_all_func", new PrintAllFunctions());
        commands.put("print_all_const", new PrintAllConstants());
        commands.put("draw", new DrawFuncCommand());
        commands.put("new_func", new SetFunctionCommand());
        commands.put("new_const", new SetConstantCommand());
        commands.put("exit", new ExitComman());
        commands.put("execute_script", new ExecuteScriptCommand());
        commands.put("print", new CalculateConstCommand());
        commands.put("del_const", new DelConstantCommand());
    }
    protected String[] tokens;

    public void commandSelection() throws Exception {
        String str = "";
        Scanner in = new Scanner(System.in);
        while (true) {
            try{
                System.out.print("Input command(for help write 'help'): ");
                str = in.nextLine();
                commandSelectionByStr(str);
            } catch (NoSuchElementException e) {
                System.out.println("CTRL+D entered - program terminated");
                commandSelectionByStr("exit");
            }
        }
    }

    public void commandSelectionByStr(String str) throws Exception {
        String[] tokens = str.split(" ");
        if (commands.containsKey(tokens[0])){
            Command command = commands.get(tokens[0]);
            command.execute(tokens);
        }
        else {
            System.out.println("This command does not exist. Using the 'help' command you can see all available commands.");
        }
    }
}
