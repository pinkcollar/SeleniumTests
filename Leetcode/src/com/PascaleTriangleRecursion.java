package com;

import java.util.ArrayList;
import java.util.List;

public class PascaleTriangleRecursion {
    public static void main(String[] args) {
       System.out.println(generate(5));
       // generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<>();
        List<Integer> eachRow = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            eachRow.add(0, 1);
            for (int j = 1; j < i; j++) {
                if (i >=2) {
                    eachRow.set(j, eachRow.get(j) + eachRow.get(j + 1));
                }

            }
            allrows.add(new ArrayList<>(eachRow));



           // generate(numRows);

        }
        return allrows;

    }
}
