package org.example.calculate;

import lombok.Getter;
import org.example.calculate.anyAlgos.RectangleMethod;
import org.example.calculate.anyAlgos.SimpsonMethod;
import org.example.calculate.anyAlgos.TrapezoidMethod;
import org.example.functionsAndContants.constant.Constant;
import org.example.functionsAndContants.constant.Constants;

import java.util.HashMap;

/**
 * Класс отвечающий за работу с методами интегрирования.
 */
@Getter
public class CalcMethodManager {
    HashMap<String, IntegralCalc> integralM = new HashMap<>();

    public CalcMethodManager(){
        integralM.put("rec", new RectangleMethod());
        integralM.put("sim", new SimpsonMethod());
        integralM.put("trap", new TrapezoidMethod());
    }
    public void calcSelection(String func, double a, double b, String str, int n) throws Exception {
        if (integralM.containsKey(str)){
            IntegralCalc integralCalc = integralM.get(str);
            System.out.println("Число разбиений: " + n);
            System.out.println("Диапазон: ["+ a + ","+ b + "]");
            integralCalc.setA(a);
            integralCalc.setB(b);
            integralCalc.setCoordSplittingUp(n);
            long time = System.currentTimeMillis();
            Double res = integralCalc.method(func);
            System.out.println("Результат интегрирования: " + res);
            if (Constants.getConstants().containsKey("I")) {
                System.out.println(Constant.constF(Constants.getConstants().get("I")));
                System.out.println("Точность: " + (res / Constant.constF(Constants.getConstants().get("I"))));
            }else System.out.println("Точность узнать не возможно. В константах не задано реальное значение интеграла 'I'");
            System.out.println("Время выполнения: " + (System.currentTimeMillis() - time) + "мс");
        }
        else {
            System.out.println("Такого метода интегрирования, в данной программе, нет!");
        }
    }
}
