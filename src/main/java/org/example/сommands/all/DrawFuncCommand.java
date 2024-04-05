package org.example.сommands.all;

import org.example.functionsAndContants.func.Function;
import org.example.functionsAndContants.func.Functions;
import org.example.сommands.Command;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class DrawFuncCommand implements Command {
    protected String name = "draw {name} {a} {b} {partition}";
    protected String info = "draws a graph of the installed function. \n" +
            "\t{name} - name your function \n" +
            "\t{a} {b} - the range on which the graph will be draw \n" +
            "\t{partition} - number of partitions on the interval";
    @Override
    public void execute(String[] tokens) throws Exception {
        Function func = new Function(tokens[1]);
        XYSeries series_1 = new XYSeries("y = " + Function.strNew);
        for(float i = Integer.parseInt(tokens[2]); i <= Integer.parseInt(tokens[3]); i+= Float.parseFloat(tokens[4])){
            if (Math.abs(func.f(i)) >= (Integer.parseInt(tokens[3]) - Integer.parseInt(tokens[2]))) continue;
            series_1.add(i, func.f(i));
        }

        XYDataset xyDataset_1 = new XYSeriesCollection(series_1);

        JFreeChart chart = ChartFactory
                .createXYLineChart("IHW task3", "x", "y",
                        xyDataset_1,
                        PlotOrientation.VERTICAL,
                        true, true, true);
        JFrame f = new JFrame();
        // Помещаем график на фрейм
        f.getContentPane()
                .add(new ChartPanel(chart));
        f.setSize(600,600);
        f.show();
        f.setVisible(true);
        f.setResizable(false);
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
