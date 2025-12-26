package com.java.aoc2025.day06;

import com.java.aoc2025.common.FileUtils;
import java.util.List;

public class SolutionPartTwo {

    public static void main(String[] args) throws Exception {

        List<String> input = FileUtils.readLines("day06.txt");

        String opsLine = input.get(input.size() - 1);
        int rows = input.size() - 1;
        int cols = opsLine.length();

        long ans = 0;

        for (int col = 0; col < cols; col++) {

            char op = opsLine.charAt(col);
            if (op != '+' && op != '*') continue;

            long result = (op == '+') ? 0 : 1;
            long number = 0;
            long multiplier = 1;

            // bottom → top
            for (int row = rows - 1; row >= 0; row--) {
                String line = input.get(row);

                if (col >= line.length()) continue;

                char ch = line.charAt(col);
                if (!Character.isDigit(ch)) continue;

                number += (ch - '0') * multiplier;
                multiplier *= 10;
            }

            if (op == '+') result += number;
            else result *= number;

            ans += result;
        }

        System.out.println(ans);
    }
}
