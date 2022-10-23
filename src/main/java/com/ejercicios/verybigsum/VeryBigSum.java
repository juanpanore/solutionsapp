package com.ejercicios.verybigsum;

import java.util.ArrayList;
import java.util.List;

public class VeryBigSum {

    public static void main(String[] args) {
        Integer arCount = 5;
        List<Long> ar = new ArrayList<>();
        ar.add(1000000001L);
        ar.add(1000000002L);
        ar.add(1000000003L);
        ar.add(1000000004L);
        ar.add(1000000005L);
        long result =  aVeryBigSum(ar,arCount);
        System.out.println(result);
    }

    public static long aVeryBigSum(List<Long> ar , int arCount) {

        return ar.stream().mapToLong(Long::longValue).sum();

    }
}
