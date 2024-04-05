package org.example.calculate;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактный класс разбиений.
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor

public abstract class Partitions {
    protected double a;
    protected double b;

    protected double dx;
    protected List<Double> coordX = new ArrayList<>();

    public void setCoordSplittingUp(double n){
        coordX.add(a);
        for (int i = 1; i <= n; i++) {
            coordX.add(a + (b - a) * ((double) i / n)); //Разбиение на равные части
        }
        double i = 2;
        dx = a + (b - a) * (i / n) - (a + (b - a) * ((i - 1) / n));
    }
}
