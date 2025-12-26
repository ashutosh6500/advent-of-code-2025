package com.java.aoc2025.day06;

import com.java.aoc2025.common.FileUtils;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {

        List<String> input = FileUtils.readLines("day06.txt");
        System.out.println(input);
        String [] operations = input.get(input.size()-1).trim().split("\\s+");
        int len = input.get(0).trim().split("\\s+").length;
        long ans = 0, addition = 0, multiplication = 1;

        for (int i = 0; i < len; i++) {
            addition = 0;
            multiplication = 1;

            for(int j =0 ; j < input.size()-1 ; j++){
                String [] array = input.get(j).trim().split("\\s+");
                long element = Long.parseLong(array[i].trim());
                if(operations[i].equals("+"))
                    addition+= element;
                else
                    multiplication*=element;

            }
            System.out.println(multiplication + addition);
            if(operations[i].equals("+"))
                ans+= addition;
            else
                ans+= multiplication;

        }
        System.out.println(ans);
    }
}
