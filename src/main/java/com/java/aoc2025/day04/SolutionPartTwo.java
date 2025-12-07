package com.java.aoc2025.day04;

import com.java.aoc2025.common.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class SolutionPartTwo {
    public static int n,m,ans;
    public static List<String> input;
    public static boolean[][] visited;
    public static boolean isValid(int i, int j){
        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;
        return true;
    }

    public static void traverse(int i, int j){
        if(! isValid(i,j) )
            return;

        if (input.get(i).charAt(j) == '.') return;
        int tot = 0;
        // conditions
        int p = i-1, q = j-1;
        if(isValid(p, q) && input.get(p).charAt(q) == '@') {
            tot++;

        }

        p = i+1;
        q = j+1;
        if(isValid(p, q) && input.get(p).charAt(q) == '@') {
            tot++;

        }
        p = i-1;
        q = j+1;
        if(isValid(p, q) && input.get(p).charAt(q) == '@') {
            tot++;

        }
        p = i+1;
        q = j-1;
        if(isValid(p, q) && input.get(p).charAt(q) == '@') {
            tot++;

        }
        p = i;
        q = j-1;
        if(isValid(p, q) && input.get(p).charAt(q) == '@') {
            tot++;

        }
        p = i;
        q = j+1;
        if(isValid(p, q) && input.get(p).charAt(q) == '@') {
            tot++;

        }
        p = i-1;
        q = j;
        if(isValid(p, q) && input.get(p).charAt(q) == '@') {
            tot++;

        }
        p = i+1;
        q = j;
        if(isValid(p, q) && input.get(p).charAt(q) == '@') {
            tot++;

        }
        if(tot < 4){
            ans ++ ;
            StringBuilder sb = new StringBuilder(input.get(i));
            sb.setCharAt(j, '.');
            input.set(i, sb.toString());

        }

    }
    public static void main(String [] args) throws java.lang.Exception {
        input = new ArrayList<>(FileUtils.readLines("day04.txt"));
        n = input.size();
        m = input.get(0).length();
        ans =0;
        boolean completed = false;
        while (! completed) {
            int prev_ans = ans;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (input.get(i).charAt(j) == '.')
                        continue;

                    traverse(i, j);

//                    for (String row : input) {
//                        System.out.println(row);
//                    }
//                    System.out.println();
//                    System.out.println();

                }
            }
            if(prev_ans == ans)
                completed = true;
        }
        System.out.println(ans);
    }
}
