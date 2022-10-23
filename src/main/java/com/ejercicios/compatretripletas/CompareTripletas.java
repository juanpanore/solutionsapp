package com.ejercicios.compatretripletas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CompareTripletas {

    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>();
        a.add(17);
        a.add(28);
        a.add(30);
        List<Integer> b = new ArrayList<>();
        b.add(99);
        b.add(16);
        b.add(8);
        List<Integer> result = CompareTripletas.compareTriplets(a, b);
        result.forEach(e -> System.out.println("Puntaje:" + e));

    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> resultado = new ArrayList<>();
        resultado.add(0);
        resultado.add(0);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) resultado.set(0, resultado.get(0) + 1);
            if (a.get(i) < b.get(i)) resultado.set(1, resultado.get(1) + 1);
        }
        return resultado;
    }

}
