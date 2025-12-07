package com.java.aoc2025.day03;

import com.java.aoc2025.common.FileUtils;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String [] args) throws java.lang.Exception {
        List<String> input = FileUtils.readLines("day3.txt");

        //System.out.println(input) ;
        long max_joltage = 0;
        for(String s : input){
            int [] prefix = new int [s.length()];
            int [] suffix = new int [s.length()];
            int j = s.length() -1;
            //Pre computation
            for(int i=0 ; i<s.length() ; i++){
                if(i == 0){
                    prefix[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
                    suffix[j] = Integer.parseInt(String.valueOf(s.charAt(j)));
                    j--;
                    continue;
                }
                prefix[i] = Integer.max(prefix[i-1], Integer.parseInt(String.valueOf(s.charAt(i))));
                suffix[j] = Integer.max(suffix[j+1], Integer.parseInt(String.valueOf(s.charAt(j))));
                j--;
            }
//            System.out.println(Arrays.toString(prefix) );
//            System.out.println(Arrays.toString(suffix));
//            System.out.println("next");
            long curr_max_ans = Integer.MIN_VALUE;
            for(int i=0;i<s.length()-1 ; i++){
                String val = Integer.toString(prefix[i]) + Integer.toString(suffix[i+1]);
                //System.out.print("Num is  " + val + " ");
                curr_max_ans = Long.max(curr_max_ans , Long.parseLong(val));

            }

            max_joltage = max_joltage + curr_max_ans;
        }
        System.out.println("ans  " + max_joltage);
    }
}
