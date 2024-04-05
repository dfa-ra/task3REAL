package org.example.calculate.anyAlgos;

import org.example.calculate.IntegralCalc;
import org.example.calculate.Partitions;
import org.example.functionsAndContants.constant.Constants;
import org.example.functionsAndContants.func.Function;
import org.example.functionsAndContants.func.Functions;

public class SimpsonMethod extends Partitions implements IntegralCalc {
    public double method(String func) {
        Function function = new Function(func);
        double S = 0;
        for (int i = 1; i < coordX.size(); i++) {
            S = S + Math.abs((function.f(coordX.get(i - 1)) + 4 * function.f((coordX.get(i) + coordX.get(i - 1)) / 2) + function.f(coordX.get(i))) * dx / 6);
        }
        Constants.putConstant("Ik", String.valueOf(S));
        return S;
    }
}
