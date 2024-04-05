package org.example.calculate.anyAlgos;

import lombok.ToString;
import org.example.calculate.IntegralCalc;
import org.example.calculate.Partitions;
import org.example.functionsAndContants.constant.Constants;
import org.example.functionsAndContants.func.Function;
import org.example.functionsAndContants.func.Functions;

@ToString
public class RectangleMethod extends Partitions implements IntegralCalc {
    public double method(String func){
        Function function = new Function(func);
        double S = 0;
        for (int i = 0; i < coordX.size(); i++) {
            S = S + Math.abs(function.f(coordX.get(i)) * dx); // Подумать по поводу верхней и нижней суммы Дарбу + случайный выбор точек
        }
        Constants.putConstant("Ik", String.valueOf(S));
        return S;
    }
}
