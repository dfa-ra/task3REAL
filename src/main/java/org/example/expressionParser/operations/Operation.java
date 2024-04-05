package org.example.expressionParser.operations;
@FunctionalInterface
public interface Operation {
    double result(String left, String right);
}
