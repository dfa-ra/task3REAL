package org.example.сommands.all;

import org.example.functionsAndContants.constant.Constant;
import org.example.сommands.Command;
import org.example.calculate.CalcMethodManager;

import java.util.ArrayList;
import java.util.List;

public class CalculateIntegralCommand implements Command {
    protected String name = "calculate {name} {a} {b} {type} {partition}";
    protected String info = "integral calculation command. \n" +
            "\t{name} - name your function \n" +
            "\t{a} {b} - integration interval \n" +
            "\t{type} - type of integration \n" +
            "\t\t(to choose from: rec - rectangle method, sim - Simpson method, trap - trapezoid method) \n" +
            "\t{partition} - number of partitions on the interval";
    @Override
    public void execute(String[] tokens) throws Exception {
        List<Double> param = new ArrayList<>();
        CalcMethodManager calcMethodManager = new CalcMethodManager();
        param.add(Constant.constF(tokens[2]));
        param.add(Constant.constF(tokens[3]));
        calcMethodManager.calcSelection(tokens[1], param.get(0), param.get(1), tokens[4], Integer.parseInt(tokens[5]));

    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public String getName() {
        return name;
    }
}
