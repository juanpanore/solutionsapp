package com.ejercicios.rectanglepartition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RectanglePartition {

    public static void main(String[] args) {

        int w = 200;
        int h = 100;
        int numberX = 20;
        int numberY = 10;
        int xaxis[] = {11, 25, 26, 29, 30, 40, 44, 56, 65, 71, 87, 98, 100, 108, 130, 149, 153, 161, 173, 179 };
        int yaxis[] = {1, 11, 16, 17, 19, 37, 38, 53, 65, 69 };
        ArrayList<Integer> xlist = convertToArrayList(xaxis);
        ArrayList<Integer> ylist = convertToArrayList(yaxis);
        xlist.add(w);
        ylist.add(h);
        System.out.println(countNumberSquare(xlist,ylist));
    }

    public static void drawRectangle(int w, int h, int numberX, int numberY, int xaxis[], int yaxis[]) {
        drawX(w);
        for (int j = 1; j <= h; j++) {
            for (int i = 0; i < numberY; i++) {
                if (j == yaxis[i]) {
                    drawX(w);
                }
            }
            drawY(xaxis, w, numberX);
        }
        drawX(w);

    }

    public static void drawX(int w) {
        String y = "";
        for (int i = 0; i < w; i++) {
            y = y + " _";
            if (i == w - 1)
                System.out.println(y);
        }
    }

    public static void drawY(int axisX[], int w, int numberX) {
        String x = "|";
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < numberX; j++) {
                if (i == axisX[j]) {
                    x += "|";
                } else {
                    x += " ";
                }
            }
            if (i == w - 1)
                System.out.println(x + "|");
        }
    }

    public static Integer countNumberSquare(ArrayList<Integer> xaxis , ArrayList<Integer> yaxis) {
        long numberSquare =0;
        xaxis = addCombinations(xaxis);
        yaxis = addCombinations(yaxis);
        for (Integer x: xaxis){
            numberSquare += yaxis.stream().filter( y -> y.equals(x)).count();
        }
        System.out.println("numero de cuadrados es " + numberSquare);
        return (int)numberSquare;
    }

    public static ArrayList<Integer> addCombinations(ArrayList<Integer> axis) {
        int size = axis.size();
        System.out.println("tamaño original" + axis.size());
        for (int i = 0; i < size - 1; i++) {
            axis.add(axis.get(i + 1) - axis.get(i));
            for (int j = i - 1; j >= 0; j--) {
                axis.add(axis.get(i + 1) - axis.get(j));
            }
        }
        axis.forEach(e -> System.out.println("Elemento " + e));
        System.out.println("tamaño combinaciones " + (axis.size() - size));
        return axis;
    }

    public static ArrayList<Integer> convertToArrayList(int array[]) {
        return new ArrayList<>(Arrays.stream(array).boxed().collect(Collectors.toList()));
    }

}
