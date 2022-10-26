package com.ejercicios.testmeli;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TestMeliWithPilas {


    public static void main(String[] args) {
        List<String> listParenthesis = new ArrayList<>();
        listParenthesis.add("[]{}()");
        listParenthesis.add("{{{[[[]]]}}}");
        listParenthesis.add("{{{[[[]]]}}}(){}()");
        validateSecuence(listParenthesis).forEach(r -> System.out.println(r));
    }


    public static List<String> validateSecuence(List<String> listaParentesis) {
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        listaParentesis.forEach(l -> {
            List<String> secuence = convertStringToList(l);
            secuence.forEach(s -> {
                if (!getPar(s).isEmpty()) {
                    stack.push(s);
                } else {
                    stack.pop();
                }
            });
            if (stack.isEmpty()) {
                result.add("YES");
            } else {
                result.add("NO");
            }
        });


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
