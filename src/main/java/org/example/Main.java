package org.example;

import org.example.сommands.Invoker;

public class Main {
    public static void main( String[] args ) throws Exception {
        System.out.println( "-----------------START-----------------" );
        Invoker inv = new Invoker();
        inv.commandSelection();
    }
}
