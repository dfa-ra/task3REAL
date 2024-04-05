package org.example.functionsAndContants.func;

import lombok.Getter;

import java.util.HashMap;

/**
 * Класс отвечающий за хранение всех констант и функций
 */
public class Functions {
    @Getter
    protected static HashMap<String, String> functions = new HashMap<>();
    public static void putFunction(String name, String func){
        functions.put(name, func);
    }
}
