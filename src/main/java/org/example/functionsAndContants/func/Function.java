package org.example.functionsAndContants.func;

import lombok.Getter;
import org.example.expressionParser.ParseTreeBuilder;
import org.example.expressionParser.ParseTreeExample;
import org.example.expressionParser.polishNat.PolishNatation;
import org.example.myBinaryTree.Node;

/**
 * Класс отвечающий за выставленную функцию
 */
@Getter
public class Function {
    public static String strNew;
    public static String strOld;
    protected static String str;
    private Node parseTreeFunc = null;

    public Function(String str) {
        Function.str = PolishNatation.setStrToSlit(Functions.getFunctions().get(str));
        strOld = strNew;
        strNew = PolishNatation.setStrToSlit(Functions.getFunctions().get(str));
        parseTreeFunc = ParseTreeBuilder.buildParseTree(PolishNatation.convert(PolishNatation.setStrToSlit(Functions.getFunctions().get(str))), PolishNatation.setStrToSlit(PolishNatation.setStrToSlit(Functions.getFunctions().get(str))));
    }

    public double f(double x){
        return Double.parseDouble(ParseTreeExample.evaluate(parseTreeFunc, String.valueOf(x)));
    }

}
