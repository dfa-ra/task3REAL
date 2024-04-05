package org.example.myBinaryTree;

import lombok.Getter;
import lombok.Setter;

/**
 * Класс узлов дерева.
 */
@Setter
@Getter
public class Node {
    private String value; // ключ узла
    private Node leftChild = null; // Левый узел потомок
    private Node rightChild = null; // Правый узел потомок

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
