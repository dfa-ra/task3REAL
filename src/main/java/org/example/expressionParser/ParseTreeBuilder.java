package org.example.expressionParser;

import org.example.expressionParser.operations.OperationManager;
import org.example.expressionParser.polishNat.PolishNatation;
import org.example.myBinaryTree.Node;

import java.util.Stack;


/**
 * Класс перевода строки из польской нотации в дерево
 */
public class ParseTreeBuilder {
    public static Node buildParseTree(String str, String str_normal){
        String[] tokens = str.split(" ");
        Stack<Node> stack = new Stack<>();
        Node startNode = new Node();
        stack.push(startNode);
        Node nowNode = startNode;
        for (String token : tokens){
            if (token.isEmpty()) continue;

            if (OperationManager.isOperation(token)){
                    nowNode.setValue(token);
                    nowNode.setLeftChild(new Node());
                    nowNode.setRightChild(new Node());
                    stack.push(nowNode);
                    nowNode = nowNode.getLeftChild();
            }
            else {
                nowNode.setValue(token);
                nowNode = stack.pop();
                nowNode = nowNode.getRightChild();
            }
        }
        stack.clear();
        return startNode;
    }
}



