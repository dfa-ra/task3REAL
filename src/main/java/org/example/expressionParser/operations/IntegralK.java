package org.example.expressionParser.operations;

import org.example.calculate.CalcMethodManager;
import org.example.calculate.IntegralCalc;
import org.example.functionsAndContants.constant.Constant;
import org.example.functionsAndContants.constant.Constants;
import org.example.functionsAndContants.func.Function;

public class IntegralK implements Operation{
    @Override
    public double result(String left, String right) {
        double a = Constant.constF(Constants.getConstants().get("a"));
        double b = Constant.constF(Constants.getConstants().get("b"));
        String type = "sim";
        String func = "f";
        double partition = Double.parseDouble(left);
        CalcMethodManager cmm = new CalcMethodManager();
        IntegralCalc integralCalc = cmm.getIntegralM().get(type);
        integralCalc.setA(a);
        integralCalc.setB(b);
        integralCalc.setCoordSplittingUp(partition);
        return integralCalc.method(func);
    }
}
