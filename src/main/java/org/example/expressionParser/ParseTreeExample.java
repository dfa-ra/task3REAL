package org.example.expressionParser;

import org.example.expressionParser.operations.OperationManager;
import org.example.myBinaryTree.Node;

/**
 * Класс отвечающий за анализ дерева и подсчёт результатов
 */
public class ParseTreeExample {
    public static String  evaluate(Node startNode, String x){
        Node left = startNode.getLeftChild();
        Node right = startNode.getRightChild();

        if (left != null && right != null && left.getValue() == null){
            String operator = startNode.getValue();
            String rightOper = evaluate(right, x);
            return String.valueOf(OperationManager.operatorsExecute(operator, rightOper));
        } else if (left != null && right != null && right.getValue() == null){
            String operator = startNode.getValue();
            String leftOper = evaluate(left, x);
            return String.valueOf(OperationManager.operatorsExecute(operator, leftOper));
        } else if (left != null && right != null){
            String operator = startNode.getValue();
            String leftOper = evaluate(left, x);
            String rightOper = evaluate(right, x);
            return String.valueOf(OperationManager.operatorsExecute(operator, leftOper, rightOper));
        } else {
            if (startNode.getValue().equals("x")) return x;
            return startNode.getValue();
        }
    }
}
