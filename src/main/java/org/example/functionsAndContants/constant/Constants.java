package org.example.functionsAndContants.constant;

import lombok.Getter;

import java.util.HashMap;

public class Constants {
    @Getter
    protected static HashMap<String, String> constants = new HashMap<>();
    static {
        constants.put("e", String.valueOf(Math.exp(1)));
        constants.put("pi", String.valueOf(Math.PI));
    }
    public static void putConstant(String name, String func){
        constants.put(name, String.valueOf(Constant.constF(func)));
    }

    public static void removeConstant(String name){
        constants.remove(name);
    }

}
