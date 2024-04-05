package org.example.calculate.anyAlgos;

import org.example.calculate.IntegralCalc;
import org.example.calculate.Partitions;
import org.example.functionsAndContants.constant.Constants;
import org.example.functionsAndContants.func.Function;
import org.example.functionsAndContants.func.Functions;

public class TrapezoidMethod extends Partitions implements IntegralCalc {
    public double method(String func){
        Function function = new Function(func);
        double S = 0;
        for (int i = 1; i < coordX.size(); i++) {
            S = S + Math.abs((function.f(coordX.get(i-1)) + function.f(coordX.get(i))) * dx / 2);
        }
        Constants.putConstant("Ik", String.valueOf(S));
        return S;
    }
}
