package org.example.functionsAndContants.constant;

import org.example.expressionParser.ParseTreeBuilder;
import org.example.expressionParser.ParseTreeExample;
import org.example.expressionParser.polishNat.PolishNatation;
import org.example.myBinaryTree.Node;

public class Constant {
    static Node parseTreeConst = null;
    public static double constF(String str){
        parseTreeConst = ParseTreeBuilder.buildParseTree(PolishNatation.convert(PolishNatation.setStrToSlit(str)), PolishNatation.setStrToSlit(str));
        return Double.parseDouble(ParseTreeExample.evaluate(parseTreeConst, String.valueOf(1)));
    }
}
