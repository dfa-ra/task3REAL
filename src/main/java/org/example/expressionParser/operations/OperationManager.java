package org.example.expressionParser.operations;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
@Getter
@Setter
public class OperationManager {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Operate {
        int priority;
        Operation result;
    }
    static private HashMap<String, Operate> operators = new HashMap<>();

    static {
        try {
            operators.put("Ikf", new Operate(10, new IntegralK()));
            operators.put("(", new Operate(-1, null));
            operators.put(")", new Operate(-1, null));
            operators.put("+", new Operate(1, (left, right) -> Double.parseDouble(left) + Double.parseDouble(right)));
            operators.put("-", new Operate(1, (left, right) -> Double.parseDouble(right) - Double.parseDouble(left)));
            operators.put("*", new Operate(2, (left, right) -> Double.parseDouble(left) * Double.parseDouble(right)));
            operators.put("/", new Operate(2, (left, right) -> Double.parseDouble(right) / Double.parseDouble(left)));
            operators.put("^", new Operate(3, (left, right) -> Math.pow(Double.parseDouble(right), Double.parseDouble(left))));
            operators.put("sin", new Operate(4, (left, right) -> Math.sin(Double.parseDouble(left))));
            operators.put("asin", new Operate(4, (left, right) -> Math.asin(Double.parseDouble(left))));
            operators.put("cos", new Operate(4, (left, right) -> Math.cos(Double.parseDouble(left))));
            operators.put("acos", new Operate(4, (left, right) -> Math.acos(Double.parseDouble(left))));
            operators.put("tan", new Operate(4, (left, right) -> Math.tan(Double.parseDouble(left))));
            operators.put("atan", new Operate(4, (left, right) -> Math.atan(Double.parseDouble(left))));
            operators.put("abs", new Operate(4, (left, right) -> Math.abs(Double.parseDouble(left))));
            operators.put("ln", new Operate(4, (left, right) -> Math.log(Double.parseDouble(left))));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static double operatorsExecute(String operator, String left){
        return operators.get(operator).getResult().result(left, "0");
    }
    public static double operatorsExecute(String operator, String left, String right){
        return operators.get(operator).getResult().result(left, right);
    }
    public static HashMap<String, Operate> getOperations(){
        return operators;
    }
    public static boolean isOperation(String op){
        return operators.containsKey(op);
    }
}
