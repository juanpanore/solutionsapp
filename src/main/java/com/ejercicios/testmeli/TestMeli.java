package com.ejercicios.testmeli;

import java.util.ArrayList;
import java.util.List;

public class TestMeli {

    public static void main(String[] args) {

        List<String> listParenthesis = new ArrayList<>();
        listParenthesis.add("[]{}()");
        listParenthesis.add("{{{[[[]]]}}}");
        listParenthesis.add("{{{[[[]]]}}}(){}[]{{{((()))}}}");
        validateSecuence(listParenthesis).forEach(r -> System.out.println(r));
    }

    public static boolean validateOrden(List<String> pila) {
        List<String> right = new ArrayList<>();
        List<String> left = new ArrayList<>();
        int n = 1;
        for (int i = 0; i < pila.size(); i++) {
            if (getPar(pila.get(i)).isEmpty()) {
                left.add(pila.get(i));
                right.add(pila.get(i - n));
                n += 2;
            } else {
                n = 1;
            }
        }

        for (int i = 0; i < right.size(); i++) {
            right.set(i, right.get(i).concat(left.get(i)));
            if (!(right.get(i).equals("()") || right.get(i).equals("{}") || right.get(i).equals("[]"))) {
                return false;
            }


        }
        return true;
    }

    public static List<String> validateSecuence(List<String> listaParentesis) {
        List<String> result = new ArrayList<>();
        listaParentesis.forEach(l ->
                {
                    List<String> pila = new ArrayList<>();
                    List<String> secuence = convertStringToList(l);
                    secuence.forEach(s -> {
                        if (secuence.contains(getPar(s))) {
                            if (secuence.indexOf(s) < secuence.indexOf(getPar(s))) {
                                pila.add(s);
                                pila.add(getPar(s));
                            }
                        }


                    });

                    if (secuence.size() == pila.size() && validateOrden(secuence)) {
                        result.add("YES");
                    } else {
                        result.add("NO");
                    }
                }
        );

        return result;
    }

    public static String getPar(String par) {
        switch (par) {
            case "{":
                return "}";
            case "(":
                return ")";
            case "[":
                return "]";
        }
        return "";
    }

    public static List<String> convertStringToList(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add("" + str.charAt(i));
        }
        return list;
    }
}
