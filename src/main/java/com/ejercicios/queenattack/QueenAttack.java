package com.ejercicios.queenattack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QueenAttack {

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int r_q = 4;
        int c_q = 3;
        List<List<Integer>> obstacles = new ArrayList<>();
        List<Integer> pos1 = new ArrayList<>();
        pos1.add(5);
        pos1.add(5);
        List<Integer> pos2 = new ArrayList<>();
        pos2.add(4);
        pos2.add(2);
        List<Integer> pos3 = new ArrayList<>();
        pos3.add(2);
        pos3.add(3);
        obstacles.add(pos1);
        obstacles.add(pos2);
        obstacles.add(pos3);
        System.out.println("Numero ataques posibles: " + QueenAttack.queensAttack(n, k, r_q, c_q, obstacles));

    }


    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here

        List<Integer> posObstaculos = new ArrayList<>();
        List<List<Integer>> movs = new ArrayList<>();

        obstacles.forEach(listPos -> {
            posObstaculos.add(Integer.parseInt(listPos.get(0).toString() + listPos.get(1).toString()));
        });

        posObstaculos.forEach(pos -> System.out.println("los obstaculos son " + pos));

        movs.add(calculeMovUp(r_q, c_q, n));
        movs.add(calculeMovDown(r_q, c_q, n));
        movs.add(calculeMovRight(r_q, c_q, n));
        movs.add(calculeMovLeft(r_q, c_q, n));
        movs.add(calculeMovDiaLeftDown(r_q, c_q, n));
        movs.add(calculeMovDiaLeftUp(r_q, c_q, n));
        movs.add(calculeMovDiaRightDown(r_q, c_q, n));
        movs.add(calculeMovDiaRightUp(r_q, c_q, n));
        movs.forEach(m -> {
            System.out.println("Eliminando movimientos...");
            removeMovWithObs(m, posObstaculos);
        });
        return movs.stream().mapToInt(List::size).sum();
    }

    private static List<Integer> removeMovWithObs(List<Integer> movs, List<Integer> obs) {

        obs.forEach(o -> {
            if (movs.contains(o)) {
                Set<Integer> toRemove = new HashSet<>();
                for (int i = movs.indexOf(o); i < movs.size(); i++) {
                    toRemove.add(movs.get(i));
                }
                movs.removeAll(toRemove);
            }
        });

        movs.forEach(pos -> System.out.println("removi movs y quedaron los siguientes " + pos));
        return movs;
    }

    private static Integer concatenateNumbers(int a, int b) {
        return Integer.parseInt(String.valueOf(a).concat(String.valueOf(b)));
    }

    public static List<Integer> calculeMovUp(int r_q, int c_q, int n) {
        List<Integer> result = new ArrayList<>();
        if (r_q < n) {
            int initPos = concatenateNumbers(r_q, c_q);
            result.add(initPos + 10);
            r_q += 1;
            for (int i = 1; r_q < n; i++) {
                result.add(result.get(i - 1) + 10);
                r_q += 1;
            }
        }

        result.forEach(pos -> System.out.println("los pos arriba son " + pos));

        return result;
    }

    public static List<Integer> calculeMovDown(int r_q, int c_q, int n) {
        List<Integer> result = new ArrayList<>();
        if (r_q > 1) {
            int initPos = concatenateNumbers(r_q, c_q);
            result.add(initPos - 10);
            r_q -= 1;
            for (int i = 1; r_q > 1; i++) {
                result.add(result.get(i - 1) - 10);
                r_q -= 1;
            }
        }
        result.forEach(pos -> System.out.println("los pos abajo son " + pos));

        return result;
    }

    public static List<Integer> calculeMovRight(int r_q, int c_q, int n) {
        List<Integer> result = new ArrayList<>();
        if (c_q < n) {
            int initPos = concatenateNumbers(r_q, c_q);
            result.add(initPos + 1);
            c_q += 1;
            for (int i = 1; c_q < n; i++) {
                result.add(result.get(i - 1) + 1);
                c_q += 1;
            }
        }
        result.forEach(pos -> System.out.println("los pos derecha son " + pos));

        return result;
    }

    public static List<Integer> calculeMovLeft(int r_q, int c_q, int n) {
        List<Integer> result = new ArrayList<>();
        if (c_q > 1) {
            int initPos = concatenateNumbers(r_q, c_q);
            result.add(initPos - 1);
            c_q -= 1;
            for (int i = 1; c_q > 1; i++) {
                result.add(result.get(i - 1) - 1);
                c_q -= 1;
            }
        }
        result.forEach(pos -> System.out.println("los pos izquierda son " + pos));

        return result;
    }

    public static List<Integer> calculeMovDiaLeftDown(int r_q, int c_q, int n) {
        List<Integer> result = new ArrayList<>();
        if (c_q > 1) {
            int initPos = concatenateNumbers(r_q, c_q);
            result.add(initPos - 11);
            c_q -= 1;
            for (int i = 1; c_q > 1; i++) {
                result.add(result.get(i - 1) - 11);
                c_q -= 1;
            }
        }
        result.forEach(pos -> System.out.println("los pos dia izq abajo " + pos));

        return result;
    }

    public static List<Integer> calculeMovDiaLeftUp(int r_q, int c_q, int n) {
        List<Integer> result = new ArrayList<>();
        if (r_q < n) {
            int initPos = concatenateNumbers(r_q, c_q);
            result.add(initPos + 9);
            r_q += 1;
            for (int i = 1; r_q < n; i++) {
                result.add(result.get(i - 1) + 9);
                r_q += 1;
            }
        }
        result.forEach(pos -> System.out.println("los pos dia izq arriba son " + pos));

        return result;
    }

    public static List<Integer> calculeMovDiaRightDown(int r_q, int c_q, int n) {
        List<Integer> result = new ArrayList<>();
        if (c_q < n) {
            int initPos = concatenateNumbers(r_q, c_q);
            result.add(initPos - 9);
            c_q += 1;
            for (int i = 1; c_q < n; i++) {
                result.add(result.get(i - 1) - 9);
                c_q += 1;
            }
        }
        result.forEach(pos -> System.out.println("los pos dia derecha abajo son " + pos));

        return result;
    }

    public static List<Integer> calculeMovDiaRightUp(int r_q, int c_q, int n) {
        List<Integer> result = new ArrayList<>();
        if (r_q < n) {
            int initPos = concatenateNumbers(r_q, c_q);
            result.add(initPos + 11);
            r_q += 1;
            for (int i = 1; r_q < n; i++) {
                result.add(result.get(i - 1) + 11);
                r_q += 1;
            }
        }
        result.forEach(pos -> System.out.println("los pos dia derecha arriba son " + pos));

        return result;
    }

}

