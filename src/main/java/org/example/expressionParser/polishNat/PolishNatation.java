package org.example.expressionParser.polishNat;

import org.example.expressionParser.operations.OperationManager;
import org.example.functionsAndContants.constant.Constants;
import org.example.functionsAndContants.func.Functions;

import java.util.Objects;
import java.util.Stack;

/**
 * Класс отвечающий за создание польской нотации
 */
public class PolishNatation {
    public static String setStrToSlit(String str){
        String strOld = str;
        char[] strC = strOld.toCharArray();
        str = "";
        for (int i = 0; i < strC.length; i++) {
            if (strC[i] == '(' || strC[i] == ')'
                    || OperationManager.isOperation(String.valueOf(strC[i]))) {
                str = str + " " + strC[i] + " ";
            }else {
                str = str + strC[i];
            }
        }
        return str;
    }
    public static String convert(String str){
        String[] tokens = str.split(" ");
        boolean flag = false;
        str = "";
        Stack<String> operationStack = new Stack<>();
        for (String token : tokens){
            if (Objects.equals(token, "")) continue;
            if (token.equals("(")) {
                operationStack.push(token);
            } else if (token.equals(")")) {
                while (!operationStack.peek().equals("(")) {
                    str = operationStack.pop() + " " + str;
                }
                operationStack.pop();
            } else if (OperationManager.isOperation(token)) {
                if (operationStack.isEmpty()) operationStack.push(token);
                else if (OperationManager.getOperations().get(operationStack.peek()).getPriority() >
                        OperationManager.getOperations().get(token).getPriority()) {
                    while (OperationManager.getOperations().get(operationStack.peek()).getPriority() >
                            OperationManager.getOperations().get(token).getPriority() ){
                        str = operationStack.pop() + " " + str;
                        if(operationStack.isEmpty()) break;
                    }
                    operationStack.push(token);
                }
                else operationStack.push(token);
            }else if(Constants.getConstants().containsKey(token)) {
                str = PolishNatation.convert(setStrToSlit(Constants.getConstants().get(token))) + " " + str;
            }else if(Functions.getFunctions().containsKey(token)) {
                str =  PolishNatation.convert(setStrToSlit(Functions.getFunctions().get(token))) + " " + str;
            }else {
                str = token + " " + str;
            }
        }
        while (!operationStack.isEmpty()) str = operationStack.pop() + " " + str;
        return str;
    }
}
